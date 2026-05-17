import java.util.*;

class Pair{
    int node,dist;

    Pair(int n,int d){
        node=n;
        dist=d;
    }
}

public class Dijkstras{

    static void dijkstra(List<List<Pair>> graph,int src,int V){

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a,b)->a.dist-b.dist);

        int[] dist = new int[V];

        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[src]=0;

        pq.add(new Pair(src,0));

        while(!pq.isEmpty()){

            Pair curr=pq.poll();

            int u=curr.node;

            for(Pair nei:graph.get(u)){

                int v=nei.node;
                int wt=nei.dist;

                if(dist[u]+wt < dist[v]){

                    dist[v]=dist[u]+wt;

                    pq.add(new Pair(v,dist[v]));
                }
            }
        }

        System.out.println("Vertex\tDistance");

        for(int i=0;i<V;i++)
            System.out.println(i+"\t"+dist[i]);
    }

    public static void main(String[] args){

        int V=5;

        List<List<Pair>> graph =
            new ArrayList<>();

        for(int i=0;i<V;i++)
            graph.add(new ArrayList<>());

        graph.get(0).add(new Pair(1,10));
        graph.get(0).add(new Pair(3,30));
        graph.get(0).add(new Pair(4,100));

        graph.get(1).add(new Pair(2,50));

        graph.get(3).add(new Pair(2,20));
        graph.get(3).add(new Pair(4,60));

        graph.get(2).add(new Pair(4,10));

        dijkstra(graph,0,V);
    }
}