package OOP09_Workshop.core.model.hardware;


public class PowerHardware extends Hardware {

    public PowerHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, Type.POWER, maximumCapacity, maximumMemory);

    }

    @Override
    public int getMaximumCapacity() {
        int baseCapacity = super.getMaximumCapacity();
        baseCapacity -= (baseCapacity * 3) / 4;

        return baseCapacity - super.getUsedCapacity();
    }

    @Override
    public int getMaximumMemory() {
        int baseMemory = super.getMaximumMemory();
        baseMemory += (baseMemory * 3)/4;

        return baseMemory - super.getUsedMemory();
    }

    @Override
    public String toString() {
        long expressSoftwareCount = this.getSoftwares()
                .stream()
                .filter(s -> s.getClass().getSimpleName()
                        .equals("ExpressSoftware"))
                .count();

        return  String.format("Hardware Component - %s%n" +
                        "Express Software Components - %d%n" +
                        "Light Software Components - %d%n" +
                        "Memory Usage: %d / %d%n" +
                        "Capacity Usage: %d / %d%n" +
                        "Type: %s%n" +
                        "Software Components: %s",
                this.getName(),
                expressSoftwareCount,
                this.getSoftwares().size() - expressSoftwareCount,
                this.getUsedMemory(), this.getMaximumMemory() + this.getUsedMemory(),
                this.getUsedCapacity(), this.getMaximumCapacity() + this.getUsedCapacity(),
                this.getType().compareTo(Type.HEAVY.name()) == 0 ? "Heavy" : "Power",
                super.toString()
        );
    }
}
