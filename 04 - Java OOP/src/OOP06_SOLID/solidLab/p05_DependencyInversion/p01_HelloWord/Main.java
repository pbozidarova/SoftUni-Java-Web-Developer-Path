package OOP06_SOLID.solidLab.p05_DependencyInversion.p01_HelloWord;

public class Main {
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();

        System.out.println(helloWorld.greeting("Ivan"));
    }
}
