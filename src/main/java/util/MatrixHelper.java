package util;

import lombok.Data;

import java.util.Arrays;

@Data(staticConstructor = "of")
public class MatrixHelper {
    void print(int[][] matrix) {
        Arrays.stream(matrix).forEach(ints -> System.out.println(Arrays.toString(ints)));
    }
}
