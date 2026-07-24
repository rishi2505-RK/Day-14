import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        int[][] robots = new int[n][3];

        for (int i = 0; i < n; i++) {
            robots[i][0] = positions[i];
            robots[i][1] = healths[i];
            robots[i][2] = i;
        }

        Arrays.sort(robots, (a, b) -> Integer.compare(a[0], b[0]));

        Stack<Integer> stack = new Stack<>();
        int[] health = healths.clone();
        boolean[] alive = new boolean[n];

        Arrays.fill(alive, true);

        for (int i = 0; i < n; i++) {
            int idx = robots[i][2];

            if (directions.charAt(idx) == 'R') {
                stack.push(idx);
            } else {

                while (!stack.isEmpty() && health[idx] > 0) {
                    int right = stack.peek();

                    if (health[right] < health[idx]) {

                        health[idx]--;
                        alive[right] = false;
                        stack.pop();
                    } else if (health[right] > health[idx]) {

                        health[right]--;
                        alive[idx] = false;
                        health[idx] = 0;
                    } else {

                        alive[right] = false;
                        alive[idx] = false;
                        health[right] = 0;
                        health[idx] = 0;
                        stack.pop();
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (alive[i] && health[i] > 0) {
                ans.add(health[i]);
            }
        }

        return ans;
    }
}