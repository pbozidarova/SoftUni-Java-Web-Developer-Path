package OOP07_ReflectionAndAnnotations.blackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

@SuppressWarnings("All")

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        BlackBoxInt blackBoxInt = null;

        Field innerValue = null;

        try {
            Constructor ctor = BlackBoxInt.class.getDeclaredConstructor();
            ctor.setAccessible(true);

            blackBoxInt = (BlackBoxInt) ctor.newInstance();

            innerValue = BlackBoxInt.class.getDeclaredField("innerValue");
            innerValue.setAccessible(true);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException |NoSuchFieldException e) {
            e.printStackTrace();
        }

        String input = reader.readLine();

        Method[] methods = BlackBoxInt.class.getDeclaredMethods();

        while (!input.equals("END")){
            String command = input.substring(0, input.indexOf("_"));
            int value = Integer.parseInt(input.substring(input.indexOf("_") + 1 ));

            Method method = Arrays.stream(methods)
                    .filter(m -> m.getName().equals(command))
                    .findFirst()
                    .orElse(null);

            method.setAccessible(true);
            try {

                Class[] parameterTypes = method.getParameterTypes();
                Object[] params = new Object[]{value};

                for (Class parameterType : parameterTypes) {
                    for (Object param : params) {
                        if(param.getClass().getSimpleName().toLowerCase().contains(parameterType.getName())){
                            method.invoke(blackBoxInt, param);
                        }
                    }
                }

            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

            try {
                System.out.println(innerValue.getInt(blackBoxInt));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            input = reader.readLine();
        }

    }
}
