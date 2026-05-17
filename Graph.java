import java.util.*;

public class Graph{
    int vertices;
    List<List<Integer>> graph=new ArrayList<>();
    Graph(int v){
        vertices=v;
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int u,int v){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public void DFS(boolean[] vis,int node){
        vis[node]=true;
        System.out.println("Vertex : " + node);

        for(int n:graph.get(node)){
            if(!vis[n]){
                DFS(vis,n);
            }
        }
    }

    public void BFS(int node){
        Queue<Integer> q=new LinkedList<>();
        boolean[] vis=new boolean[vertices];
        vis[node]=true;
        q.add(node);
        while(!q.isEmpty()){
            int curr=q.poll();
            System.out.println("Vertex : " + curr);
            for(int n : graph.get(curr)){
                if(!vis[n]){
                    q.add(n);
                    vis[n]=true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Graph graph=new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        graph.DFS(new boolean[5], 0);
        System.out.println(" -- ");
        graph.BFS(0);
    }
}