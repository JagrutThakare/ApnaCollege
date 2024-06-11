package Graph.Level3;

// Cycle detection in undirected graph using bfs

import java.util.*;

public class BFSCycleDetection {

    public static void addEdge(ArrayList<Integer>[] adj, int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    public static boolean isCyclicConnected(ArrayList<Integer>[] adj, int s, int V, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        while (!q.isEmpty()) {
            int v = q.poll();

            if (visited[v]) {
                return true; // Cycle detected
            }

            visited[v] = true; // Mark as visited

            for (int it : adj[v]) {
                if (!visited[it]) {
                    q.add(it);
                }
            }
        }
        return false;
    }

    public static boolean isCyclicDisconnected(ArrayList<Integer>[] adj, int V) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicConnected(adj, i, V, visited)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 0);
        addEdge(adj, 2, 3);

        if (isCyclicDisconnected(adj, V))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}


    

    

