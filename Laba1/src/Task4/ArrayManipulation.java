package Task4;

import java.lang.reflect.Array;

public class ArrayManipulation {

    // Method to create a one-dimensional array of a specific type and size
    public static Object createArray(Class<?> type, int size) {
        return Array.newInstance(type, size);
    }

    // Method to create a matrix of a specific type and size
    public static Object createMatrix(Class<?> type, int rows, int cols) {
        return Array.newInstance(type, rows, cols);
    }

    // Method to resize a one-dimensional array
    public static Object resizeArray(Object array, int newSize) {
        Class<?> type = array.getClass().getComponentType();
        Object newArray = Array.newInstance(type, newSize);
        int length = Math.min(Array.getLength(array), newSize);
        System.arraycopy(array, 0, newArray, 0, length);
        return newArray;
    }

    // Method to resize a matrix
    public static Object resizeMatrix(Object matrix, int newRows, int newCols) {
        Class<?> type = matrix.getClass().getComponentType().getComponentType();
        Object newMatrix = Array.newInstance(type, newRows, newCols);
        int rows = Math.min(Array.getLength(matrix), newRows);
        int cols = Math.min(Array.getLength(Array.get(matrix, 0)), newCols);
        for (int i = 0; i < rows; i++) {
            Object row = Array.get(matrix, i);
            System.arraycopy(row, 0, Array.get(newMatrix, i), 0, cols);
        }
        return newMatrix;
    }

    // Method to convert an array or matrix to a string
    // Method to convert an array or matrix to a string
    public static String arrayToString(Object array) {
        StringBuilder sb = new StringBuilder();
        if (array.getClass().isArray() && array.getClass().getComponentType().isArray()) {
            sb.append(array.getClass().getComponentType().getComponentType().getName());
            sb.append("[");
            sb.append(Array.getLength(array)).append("][");
            sb.append(Array.getLength(Array.get(array, 0))).append("] = {");
            for (int i = 0; i < Array.getLength(array); i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append("{");
                Object row = Array.get(array, i);
                for (int j = 0; j < Array.getLength(row); j++) {
                    if (j > 0) {
                        sb.append(", ");
                    }
                    sb.append(Array.get(row, j));
                }
                sb.append("}");
            }
            sb.append("}");
        } else {
            sb.append(array.getClass().getComponentType().getName());
            sb.append("[").append(Array.getLength(array)).append("] = {");
            for (int i = 0; i < Array.getLength(array); i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(Array.get(array, i));
            }
            sb.append("}");
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        int[] intArray = (int[]) createArray(int.class, 2);
        System.out.println(arrayToString(intArray));

        String[] stringArray = (String[]) createArray(String.class, 3);
        System.out.println(arrayToString(stringArray));

        Double[] doubleArray = (Double[]) createArray(Double.class, 5);
        System.out.println(arrayToString(doubleArray));

        int[][] intMatrix = (int[][]) createMatrix(int.class, 3, 5);
        for (int i = 0; i < intMatrix.length; i++) {
            for (int j = 0; j < intMatrix[i].length; j++) {
                intMatrix[i][j] = i * intMatrix[i].length + j;
            }
        }
        System.out.println(arrayToString(intMatrix));

        intMatrix = (int[][]) resizeMatrix(intMatrix, 4, 6);
        System.out.println(arrayToString(intMatrix));

        intMatrix = (int[][]) resizeMatrix(intMatrix, 3, 7);
        System.out.println(arrayToString(intMatrix));

        int[][] intMatrix2 = { {0, 1}, {10, 11} };
        System.out.println(arrayToString(intMatrix2));
    }
}