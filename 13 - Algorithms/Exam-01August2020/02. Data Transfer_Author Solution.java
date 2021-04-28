import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DataTransfer {
    public static int[][] graph;
    public static int[] parents;
    public static int[] emitterAndReceiver;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(reader.readLine());
        int edges = Integer.parseInt(reader.readLine());
        emitterAndReceiver = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        graph = new int[nodes][nodes];

        for (int i = 0; i < edges; i++) {
            int[] tokens = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            graph[tokens[0]][tokens[1]] = tokens[2];
        }

        parents = new int[graph.length];

        Arrays.fill(parents, -1);

        int maxFlow = 0;

        while (bfs()) {
            int node = emitterAndReceiver[1];
            int flow = Integer.MAX_VALUE;
            while (node != emitterAndReceiver[0]) {
                flow = Math.min(flow, graph[parents[node]][node]);
                node = parents[node];
            }

            maxFlow += flow;

            node = emitterAndReceiver[1];

            while (node != emitterAndReceiver[0]) {
                graph[parents[node]][node] -= flow;
                graph[node][parents[node]] += flow;
                node = parents[node];
            }
        }

        System.out.println(maxFlow);
    }

    private static boolean bfs() {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];

        Arrays.fill(parents, -1);

        queue.offer(emitterAndReceiver[0]);
        visited[emitterAndReceiver[0]] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int child = 0; child < graph.length; child++) {
                if (graph[node][child] > 0 && !visited[child]) {
                    visited[child] = true;
                    parents[child] = node;
                    queue.offer(child);
                }
            }
        }

        return visited[emitterAndReceiver[1]];
    }
}
