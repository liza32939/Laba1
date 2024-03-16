package Task2;

import java.lang.reflect.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Створення об'єкту класу Check з відомими полями
        System.out.println("Створення об'єкту...");
        Check check = new Check(3.0, 4.0);

        // Виведення реального типу об'єкту та стану
        ClassInspector.inspectObject(check);

        // Виклик методу на об'єкті
        Scanner scanner = new Scanner(System.in);
        System.out.print("-> ");
        int methodIndex = scanner.nextInt();

        // Виклик обраного методу
        try {
            Method[] methods = check.getClass().getDeclaredMethods();
            for (int i = 0; i < methods.length; i++) {
                if (Modifier.isPublic(methods[i].getModifiers()) && methods[i].getParameterCount() == 0) {
                    if (methodIndex == i + 1) {
                        Object result = methods[i].invoke(check);
                        System.out.println("Результат виклику методу: " + result);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
