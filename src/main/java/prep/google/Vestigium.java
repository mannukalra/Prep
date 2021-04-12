package prep.google;

import java.util.*;

public class Vestigium{

    public static void main(String[] ar){
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for(int i = 0; i < cases; i++) {
            int size = scanner.nextInt();
            List<Integer>[] matrix = new List[size];
            int dupRow = 0, diagonalSum = 0;
            Set<Integer> colDupSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                boolean rowDup = false;
                List<Integer> currRow = new ArrayList<>();
                for (int k = 0; k < size; k++) {
                    int curr = scanner.nextInt();
                    if(!rowDup && currRow.contains(curr))
                        rowDup = true;
                    currRow.add(k, curr);
                    if(j == k)
                        diagonalSum += curr;

                    if(!colDupSet.contains(k))
                        for(int l = 0; l < j; l++) {
                            int prevColVal = matrix[l].get(k);
                            if (prevColVal == curr) {
                                colDupSet.add(k);
                                break;
                            }
                        }
                }
                if(rowDup)
                    dupRow++;
                matrix[j] = currRow;
            }
            System.out.println(" "+diagonalSum+" "+dupRow+" "+colDupSet.size());
        }
    }
}