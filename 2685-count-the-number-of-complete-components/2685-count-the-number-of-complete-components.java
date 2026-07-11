import java.util.*;

class Solution {

    List<Integer>[] graph;
    boolean[] visited;

    public int countCompleteComponents(int n, int[][] edges) {

        graph = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        int complete = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] result = dfs(i);

                int nodes = result[0];
                int edgesCount = result[1] / 2; // Each edge counted twice

                if (edgesCount == nodes * (nodes - 1) / 2) {
                    complete++;
                }
            }
        }

        return complete;
    }

    private int[] dfs(int node) {
        visited[node] = true;

        int nodes = 1;
        int edges = graph[node].size();

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                int[] res = dfs(neighbor);
                nodes += res[0];
                edges += res[1];
            }
        }

        return new int[]{nodes, edges};
    }
}