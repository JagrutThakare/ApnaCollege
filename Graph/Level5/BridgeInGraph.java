package Graph.Level5;

import java.util.ArrayList;

class BridgeInGraph {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        
        createGraph(graph);

        tarjanBridge(graph, V);
    }

    static void tarjanBridge(ArrayList<Edge> graph[], int V) {

        int dt[] = new int[V],
            ldt[] = new int[V],
            time = 0;
        
        boolean vis[] = new boolean[V];

        for(int i = 0; i < V; i++) {
            if(!vis[i]) dfs(graph, i, -1, dt, ldt, vis, time);
        }
    }

    static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int ldt[], boolean vis[], int time) {

        vis[curr] = true;
        dt[curr] = ldt[curr] = ++time;

        for(int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if(neigh == par) {
                continue;
            } else if(!vis[neigh]) {
                dfs(graph, neigh, curr, dt, ldt, vis, time);
                ldt[curr] = Math.min(ldt[curr], ldt[neigh]);

                if(dt[curr] < ldt[neigh]) {
                    System.out.println("Bridge : " + curr + " --> " + neigh);
                }
            } else {
                ldt[curr] = Math.min(ldt[curr], dt[neigh]);
            }
        }

    }
    static void createGraph(ArrayList<Edge> graph[]) {
        
        for(int i = 0 ; i< graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }
    
    static class Edge {
        int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest; 
        }
    }
}