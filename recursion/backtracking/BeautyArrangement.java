
public class BeautyArrangement {
    private int count;
    public int countArrangement(int N) {
        count = 0;
        if (N <= 0) {
            return count;
        }
        countArrangement(N, 1, new boolean[N + 1]);
        return count;
    }

    private void countArrangement(int N, int candidateNum, boolean[] visited) {
        if (candidateNum > N) {
            count++;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (candidateNum % i == 0 || i % candidateNum == 0)) {
                visited[i] = true;
                countArrangement(N, candidateNum + 1, visited);
                visited[i] = false;
            }
        }
    }
}
