package OOP09_Workshop.core.system;

import OOP09_Workshop.core.model.hardware.Hardware;
import OOP09_Workshop.core.model.software.Software;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.ToIntFunction;

public class SystemSplit {
    private Map<String, Hardware> hardwareComponents;

    public SystemSplit() {
        this.hardwareComponents = new LinkedHashMap<>();
    }

    public void addHardwareComponent(Hardware hardware) {
        this.hardwareComponents.put(hardware.getName(), hardware);
    }

    public void addSoftwareToHardware(String hardwareName, Software software) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            Hardware hardware = this.hardwareComponents.get(hardwareName);
            hardware.addSoftware(software);

        }
    }

    public void releaseToSoftware(String hardwareName, String softwareName) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            Hardware hardware = this.hardwareComponents.get(hardwareName);
            hardware.removeSoftware(softwareName);

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.hardwareComponents.values()
                .stream()
                .sorted((h1, h2) -> {
                    if (h1.getType().equalsIgnoreCase("Power")) {
                        return -1;
                    } else {
                        return 1;
                    }
                })
                .forEach(e -> {
                    sb.append(e.toString());
                    sb.append(System.lineSeparator());
                });
        return sb.toString().trim();
    }

    public int getHardwareComponentsSize() {
        return this.hardwareComponents.size();
    }

    public int getSoftwareComponentsSize() {
        return this.getSumValue(h -> h.getSoftwareCount());
    }

    public int getTotalOperationalMemoryInUse() {
        return this.getSumValue(h -> h.getUsedMemory());
    }

    public int getTotalCapacityTaken() {
        return this.getSumValue(h -> h.getUsedCapacity());
    }

    public int getMaximumMemory() {
        return this.getSumValue(h -> h.getMaximumMemory());
    }

    public int getMaximumCapacity() {
        return this.getSumValue(h -> h.getMaximumCapacity());
    }


    private int getSumValue(ToIntFunction<Hardware> func) {
        return this.hardwareComponents.values()
                .stream()
                .mapToInt(func)
                .sum();
    }



}
