class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] ans = new char[n];

        int charId = 0;
        for (int i = 0; i < n; i++) {
            if (ans[i] == 0) {
                if (charId >= 26) return "";

                char c = (char) ('a' + charId++);
                for (int j = i; j < n; j++) {
                    if (lcp[i][j] > 0) {
                        ans[j] = c;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int common = 0;

                while (i + common < n && 
                       j + common < n && 
                       ans[i + common] == ans[j + common]) {
                    common++;
                }

                if (common != lcp[i][j]) {
                    return "";
                }
            }
        }

        return new String(ans);
    }
}