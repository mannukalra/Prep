package prep.eop;

import java.util.Arrays;
import java.util.List;

public class RotateMatrix {

    public static void rotateMatrix(List<List<Integer>> squareMatrix) {
        final int matrixSize = squareMatrix.size() - 1;
        for (int i = 0; i < (squareMatrix.size() / 2); ++i) {
            for (int j = i; j < matrixSize - i; ++j) {
            // Perform a 4-way exchange.
                int tempi = squareMatrix.get(matrixSize - j).get(i);
                int temp2 = squareMatrix.get(matrixSize - i).get(matrixSize - j);
                int temp3 = squareMatrix.get(j).get(matrixSize - i);
                int temp4 = squareMatrix.get(i).get(j);
                squareMatrix.get(i).set(j, tempi);
                squareMatrix.get(matrixSize - j).set(i, temp2);
                squareMatrix.get(matrixSize - i).set(matrixSize - j, temp3);
                squareMatrix.get(j).set(matrixSize - i, temp4);
            }
        }
    }

    public static void main(String[] args) {
//        List<List<Integer>> l = Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(4,5,6), Arrays.asList(7,8,9));
//        System.out.println(l);
//        rotateMatrix(l);
//        System.out.println(l);
        StringBuilder s = new StringBuilder("a");
        String s1 = "ab";
//        s1.re
//        s.appendCodePoint()
        System.out.println(""+(char)(20022));
    }
}
