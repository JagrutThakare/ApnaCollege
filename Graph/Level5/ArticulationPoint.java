package Graph.Level5;

import java.util.ArrayList;

public class ArticulationPoint {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        getAp(graph);
    }

    static void getAp(ArrayList<Edge> graph[]) {
        int dt[] = new int[graph.length];
        int ldt[] = new int[graph.length];
        int time = 0;
        boolean vis[] = new boolean[graph.length];
        boolean ap[] =  new boolean[graph.length];
        
        for(int i = 0; i < graph.length; i++) {
            if(!vis[i]) dfs(graph, i, -1, dt, ldt, vis, time, ap);
        }
        
        for(int i = 0; i < graph.length; i++) {
            if(ap[i]) System.out.println("Articulation point : " + i);
        }
    }

    static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int ldt[], boolean vis[], int time, boolean ap[]) {

        vis[curr] = true;
        dt[curr] = ldt[curr] = ++time;
        int children = 0;

        for(int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if(neigh == par) {
                continue;
            } else if(vis[neigh]) {
                ldt[curr] = Math.min(ldt[curr], ldt[neigh]);
            } else {
                dfs(graph, neigh, curr, dt, ldt, vis, time, ap);
                ldt[curr] = Math.min(ldt[curr], ldt[neigh]);
                if(par != -1 && dt[curr] <= ldt[neigh]) {
                    ap[curr] = true;
                }
                children++;
            }
        }

        if(par == -1 && children > 1) {
            ap[curr] = true;
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
        // graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));
    }
    
    static class Edge {
        int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest; 
        }
    }
}
