package Task1;

import java.lang.reflect.*;

public class ClassAnalyzer {

    public static String getClassDescription(String className) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(className);
        return getClassDescription(clazz);
    }

    public static String getClassDescription(Class<?> clazz) {
        StringBuilder sb = new StringBuilder();

        // Package
        Package pkg = clazz.getPackage();
        String packageName = pkg != null ? pkg.getName() : "Default Package";
        sb.append("Package: ").append(pkg.getName()).append(", ").append(pkg.getSpecificationTitle());
        sb.append(", version ").append(pkg.getSpecificationVersion()).append("\n");

        // Class modifiers and name
        sb.append(Modifier.toString(clazz.getModifiers())).append(" ");
        sb.append(clazz.isInterface() ? "interface" : "class").append(" ").append(clazz.getSimpleName());

        // Superclass
        if (clazz.getSuperclass() != null) {
            sb.append(" extends ").append(clazz.getSuperclass().getSimpleName());
        }

        // Implemented interfaces
        Class<?>[] interfaces = clazz.getInterfaces();
        if (interfaces.length > 0) {
            sb.append(" implements ");
            for (int i = 0; i < interfaces.length; i++) {
                sb.append(interfaces[i].getSimpleName());
                if (i < interfaces.length - 1) {
                    sb.append(", ");
                }
            }
        }

        sb.append(" {\n");

        // Fields
        sb.append("\n// Fields\n");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            sb.append("\t").append(Modifier.toString(field.getModifiers())).append(" ");
            sb.append(field.getType().getSimpleName()).append(" ").append(field.getName()).append(";\n");
        }

        // Constructors
        sb.append("\n// Constructors\n");
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            sb.append("\t").append(Modifier.toString(constructor.getModifiers())).append(" ");
            sb.append(constructor.getName()).append("(");
            Class<?>[] paramTypes = constructor.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                sb.append(paramTypes[i].getSimpleName());
                if (i < paramTypes.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append(");\n");
        }

        // Methods
        sb.append("\n// Methods\n");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            sb.append("\t").append(Modifier.toString(method.getModifiers())).append(" ");
            sb.append(method.getReturnType().getSimpleName()).append(" ");
            sb.append(method.getName()).append("(");
            Class<?>[] paramTypes = method.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                sb.append(paramTypes[i].getSimpleName());
                if (i < paramTypes.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append(");\n");
        }

        sb.append("}\n");

        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            String classDescription = getClassDescription("java.lang.String");
            System.out.println(classDescription);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}