package Task2;

import java.lang.reflect.*;

public class ClassInspector {

    public static void inspectObject(Object object) {
        // Виведення реального типу об'єкту
        System.out.println("Реальний тип об'єкту: " + object.getClass().getName());

        // Отримання і виведення стану об'єкту - список полів з поточними значеннями
        System.out.println("Стан об'єкту:");
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true); // Дозволяємо доступ до приватних полів
            try {
                System.out.println(field.getType().getSimpleName() + " " + field.getName() + " = " + field.get(object));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Виклик методу...");

        // Формування та виведення списку відкритих методів
        System.out.println("\nСписок відкритих методів:");
        Method[] methods = object.getClass().getDeclaredMethods();
        int index = 1;
        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers()) && method.getParameterCount() == 0) {
                System.out.println(index + "). " + method.toString());
                index++;
            }
        }

        // Введення номера методу користувачем і виклик методу за вказаним номером
        System.out.print("\nВведіть порядковий номер методу [1, " + (index - 1) + "]: ");
    }
}