import java.util.*;

class Solution {

    Set<Integer> set = new HashSet<>();
    boolean[] visited;

    public int solution(String numbers) {

        visited = new boolean[numbers.length()];

        dfs(numbers, "");

        int answer = 0;

        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    private void dfs(String numbers, String current) {

        for (int i = 0; i < numbers.length(); i++) {

            if (visited[i]) {
                continue;
            }

            visited[i] = true;

            String next = current + numbers.charAt(i);

            set.add(Integer.parseInt(next));

            dfs(numbers, next);

            visited[i] = false;
        }
    }

    private boolean isPrime(int num) {

        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {

            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}