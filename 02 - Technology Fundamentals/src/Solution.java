import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );

        String input = reader.readLine();
        String[] tokens = removeFirstAndLastSymbol(input).split(",\\s+\\[");

        int N = Integer.parseInt(tokens[0]);
        int[] A = Arrays.stream(tokens[1].split(",\\s*"))
                .map(el -> el.replace(']', ' ').trim())
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] B = Arrays.stream(tokens[2].split(",\\s*"))
                .map(el -> el.replace(']', ' ').trim())
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(solution(N, A, B));
    }

    public static boolean solution(int N, int[] A, int[] B) {
        // write your code in Java SE 8
        Graph graph = new Graph(A.length * 2);

        for (int i = 0; i < A.length; i++) {
            graph.addEdge(A[i], B[i]);
        }

        return graph.isReachable(A[0], N);
    }

    private static String removeFirstAndLastSymbol(String word) {
        return word.substring(1, word.length() - 1);
    }

    // Java program to check if there is exist a path between
    // two vertices of an undirected graph.
    static class Graph {
        // This class represents an undirected graph
        // using adjacency list representation
        private int V; // No. of vertices

        // Pointer to an array containing adjacency lists
        ArrayList<ArrayList<Integer>> adj;

        Graph(int V){
            this.V = V;
            adj = new ArrayList<>();
            for(int i=0;i<V;i++)
                adj.add(new ArrayList<>());
        }

        // function to add an edge to graph
        void addEdge(int v, int w)
        {
            adj.get(v).add(w);
            adj.get(w).add(v);
        }


        // A BFS based function to check whether d is reachable from s.
        boolean isReachable(int s, int d)
        {
            // Base case
            if (s == d)
                return true;

            // Mark all the vertices as not visited
            boolean[] visited = new boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            // Create a queue for BFS
            Queue<Integer> queue = new LinkedList<>();

            // Mark the current node as visited and enqueue it
            visited[s] = true;
            queue.add(s);

            while (!queue.isEmpty()) {
                // Dequeue a vertex from queue and print it
                s = queue.remove();

                // Get all adjacent vertices of the dequeued vertex s
                // If a adjacent has not been visited, then mark it
                // visited  and enqueue it
                for (int i=0; i<adj.get(s).size();i++) {

                    // If this adjacent node is the destination node,
                    // then return true
                    if (adj.get(s).get(i) == d)
                        return true;

                    // Else, continue to do BFS
                    if (!visited[adj.get(s).get(i)]) {
                        visited[adj.get(s).get(i)] = true;
                        queue.add(adj.get(s).get(i));
                    }
                }
            }

            // If BFS is complete without visiting d
            return false;
        }
    }
}


