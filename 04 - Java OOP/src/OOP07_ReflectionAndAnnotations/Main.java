package OOP07_ReflectionAndAnnotations;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Reflection reflection = new Reflection();

        Class someClass = reflection.getClass();

        System.out.println(someClass.getSimpleName());
        System.out.println(someClass.getSuperclass().getName());

        Class[] interfaces = someClass.getInterfaces();

        Arrays.stream(interfaces)
                .forEach(e -> System.out.println(e.getName()));

        Constructor[] declaredConstructors = someClass.getDeclaredConstructors();

        Reflection o = (Reflection) someClass.getConstructor().newInstance();

//        for (Constructor declaredConstructor : declaredConstructors) {
//            declaredConstructor.newInstance()
//        }

        System.out.println();


    }
}
