package Task3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodInvoker {
    // Метод для виклику методу за його ім'ям та параметрами
    public static void callMethod(Object object, String methodName, Object... parameters) throws FunctionNotFoundException {
        Class<?>[] parameterTypes = new Class<?>[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            parameterTypes[i] = parameters[i].getClass();
        }

        try {
            Method method = object.getClass().getMethod(methodName, parameterTypes);
            Object result = method.invoke(object, parameters);
            System.out.println("Типи: " + Arrays.toString(parameterTypes) + ", значення: " + Arrays.toString(parameters));
            System.out.println("Результат виклику: " + result);
        } catch (NoSuchMethodException e) {
            throw new FunctionNotFoundException("Метод " + methodName + " не знайдено");
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestClass testObj = new TestClass();
        double a = 1.0;
        int x = 1;

        try {
            callMethod(testObj, "myMethod", a);
            callMethod(testObj, "myMethod", a, x);
        } catch (FunctionNotFoundException e) {
            e.printStackTrace();
        }
    }
}