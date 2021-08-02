package OOP09_Workshop.core.system;

import L10_Workshop.core.model.hardware.Hardware;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class DumpExtension extends SystemSplit {

    private Map<String, Hardware> dumpHardwareCollection;
    private Map<String, Hardware> sharedHardware;

    public DumpExtension() {
        this.dumpHardwareCollection = new LinkedHashMap<>();
        this.initialSharedHardware();
    }

    private void initialSharedHardware() {
        Class<?> systemSplitClass = this.getClass().getSuperclass();

        try {
            Field hardwareComponents = systemSplitClass.getDeclaredField("hardwareComponents");
            hardwareComponents.setAccessible(true);

            Field sharedHardware = this.getClass().getDeclaredField("sharedHardware");
            sharedHardware.setAccessible(true);
            sharedHardware.set(this, hardwareComponents.get(this));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        };
    }
}
