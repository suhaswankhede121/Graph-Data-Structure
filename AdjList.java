
import java.util.*;

class Edge{
    int s,d,w;
    Edge(int s,int d,int w){
        this.s=s;
        this.d=d;
        this.w=w;
    }
}
public class AdjList {

    static void bfs(ArrayList<Edge> []graph){
        boolean [] vis=new boolean[graph.length];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        while (q.size()>0) {
            int cur=q.remove();
            if(!vis[cur]){
                System.out.println(" "+cur);
                vis[cur]=true;
                // to getting a dest
                for(int i=0;i<graph[cur].size();i++){
                    Edge e=graph[cur].get(i);
                    q.add(e.d); 
                }
            }
        }
    }

    static void dfs(ArrayList<Edge> []graph,int cur,boolean[] vis){
        System.out.println(" "+cur);
        vis[cur]=true;

        for(int i=0;i<graph[cur].size();i++){
            Edge e=graph[cur].get(i);
            if(!vis[e.d]){
                dfs(graph, e.d, vis);
            }
        }
    }

    static boolean hasPaths(ArrayList<Edge> []graph,int src,int dest,boolean[] vis){
        if(src==dest){
            return true;
        }

        vis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[i].get(i);
            if(!vis[e.d]){
                if(hasPaths(graph, e.d, dest, vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V=4;
        ArrayList<Edge>[]graph=new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 5));
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // for(int i=0;i<graph[2].size();i++){
        //     Edge e=graph[2].get(i);
        //     System.out.print(" "+e.w);
        // }

        //bfs(graph);
        //dfs(graph, 0, new boolean[V]);
        System.out.println(hasPaths(graph, 0, 2, new boolean[V]));
    }
}
