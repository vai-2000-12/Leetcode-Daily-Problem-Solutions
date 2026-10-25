import java.util.Arrays;

class Solution {
    public boolean checkValid(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] arr = getNumberFrom1ToN(m);

        for (int i = 0; i < m; i++) {
            int[] row = matrix[i].clone();
            Arrays.sort(row);

            if (!Arrays.equals(row, arr)) {
                return false;
            }

            int[] col = new int[m];

            for (int j = 0; j < m; j++) {
                col[j] = matrix[j][i];
            }

            Arrays.sort(col);

            if (!Arrays.equals(col, arr)) {
                return false;
            }
        }

        return true;
    }

    public int[] getNumberFrom1ToN(int n) {
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        return nums;
    }
}