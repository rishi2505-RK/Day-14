class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        k %= n;

        for (int i = 0; i < m; i++) {
            int shift;

            if (i % 2 == 0) {
                shift = k;
            } else {
                shift = n - k;
            }

            for (int j = 0; j < n; j++) {
                int newIndex = (j + shift) % n;

                if (mat[i][j] != mat[i][newIndex]) {
                    return false;
                }
            }
        }

        return true;
    }
}