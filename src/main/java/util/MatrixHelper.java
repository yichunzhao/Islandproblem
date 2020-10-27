package util;

import java.util.Arrays;

public class MatrixHelper {

    public static <T> String to2DString(T[][] matrix) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(matrix).forEach(row -> sb.append(Arrays.toString(row)).append("\n"));
        return sb.toString();
    }

    public static String to2DString(boolean[][] matrix) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(matrix).forEach(row -> sb.append(Arrays.toString(row)).append("\n"));
        return sb.toString();
    }

    public static void print(Integer[][] matrix) {
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void print(int[][] matrix) {
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void print(short[][] matrix) {
        System.out.println(Arrays.deepToString(matrix));
    }

}
