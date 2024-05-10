import java.util.ArrayList;

class AdjancencyList{

   static class Edge{
        int s,d;
        Edge(int s,int d){
            this.s=s;
            this.d=d;
        }
    }
    static void AddEdge(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(1, 2));
        graph[0].add(new Edge(1, 3));
        graph[1].add(new Edge(2, 1));
        graph[1].add(new Edge(2, 3));
        graph[1].add(new Edge(1, 4));
        graph[2].add(new Edge(3, 1));
        graph[2].add(new Edge(3, 2));
        graph[2].add(new Edge(3, 4));
        graph[3].add(new Edge(4, 2));
        graph[3].add(new Edge(4, 3));


    }
    public static void main(String[] args) {
        ArrayList<Edge> graph[]=new ArrayList[4];
        for(int i=0;i<graph[1].size();i++){
            Edge e=graph[2].get(i);
            System.out.print(" "+e.d);
        }
    }
}