class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int mod = 12345;

        int[][] ans = new int[n][m];

        long total = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                total = (total * (grid[i][j] % mod)) % mod;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                long product = 1;

            }
        }

        long[] prefix = new long[n * m];
        long[] suffix = new long[n * m];

        int index = 0;

        long curr = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefix[index] = curr;
                curr = (curr * (grid[i][j] % mod)) % mod;
                index++;
            }
        }

        curr = 1;
        index = n * m - 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                suffix[index] = curr;
                curr = (curr * (grid[i][j] % mod)) % mod;
                index--;
            }
        }

        index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = (int)((prefix[index] * suffix[index]) % mod);
                index++;
            }
        }

        return ans;
    }
}