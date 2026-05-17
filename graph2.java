import java.util.*;

public class prac{

    static List<List<Integer>> graph;
    static int V;

    static Queue<Integer> q = new LinkedList<>();

    public prac(int v){

        V = v;

        graph = new ArrayList<>();

        for(int i=0;i<V;i++){

            graph.add(new ArrayList<>());
        }
    }

    static void addEdge(int u,int v){

        graph.get(u).add(v);

        graph.get(v).add(u);
    }

    static void dfs(boolean[] vis,int node){

        vis[node] = true;

        System.out.println(node);

        for(int neigh : graph.get(node)){

            if(!vis[neigh]){

                dfs(vis,neigh);
            }
        }
    }

    static void bfs(int node){

        boolean[] vis = new boolean[V];

        Queue<Integer> q = new LinkedList<>();

        q.add(node);

        vis[node] = true;

        while(!q.isEmpty()){

            int curr = q.poll();

            System.out.println(curr);

            for(int neigh : graph.get(curr)){

                if(!vis[neigh]){

                    q.add(neigh);

                    vis[neigh] = true;
                }
            }
        }
    }

    static void bfsRecursive(boolean[] vis){

        if(q.isEmpty()) return;

        int curr = q.poll();

        System.out.println(curr);

        for(int neigh : graph.get(curr)){

            if(!vis[neigh]){

                vis[neigh] = true;

                q.add(neigh);
            }
        }

        bfsRecursive(vis);
    }

    public static void main(String[] args){

        prac g = new prac(5);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(1,4);

        System.out.println("DFS:");

        g.dfs(new boolean[5],0);

        System.out.println("---");

        System.out.println("Iterative BFS:");

        g.bfs(0);

        System.out.println("---");

        System.out.println("Recursive BFS:");

        boolean[] vis = new boolean[5];

        q.add(0);

        vis[0] = true;

        g.bfsRecursive(vis);
    }
}
