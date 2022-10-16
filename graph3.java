import java.util.LinkedList;

public class graph3 {
    static class Graph{
        int vertices;
        LinkedList<Integer>[] adjList;

        Graph(int vertices){
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int x = 0; x <vertices ; x++) {
                adjList[i] = new LinkedList<>();
            }
        }
        public void addEgde(int source, int destination){
            adjList[source].addFirst(destination);

            adjList[destination].addFirst(source);
        }

        public int calculateVertices(int vertex){
            boolean [] visited = new boolean[vertices];
           
            dfs(vertex, visited);

            
            int count = 0;
            for (int x = 0; x <visited.length ; x++) {
                if(visited[x] == false)
                    count++;
            }
            return count;
        }

          public void dfs(int start, boolean [] visited){
            visited[start] = true;
            for (int x = 0; x <adjList[start].size() ; x++) {
                int vertex = adjList[start].get(x);
                if(!visited[vertex])
                    dfs(vertex,visited);
            }
        }
    }
      

    public static void main(String[] args) {
        int vertices = 8;
        Graph graph = new Graph(vertices);
        graph.addEgde(0, 1);
        graph.addEgde(1, 2);
        graph.addEgde(2, 3);
        graph.addEgde(3, 1);
        graph.addEgde(4, 5);
        graph.addEgde(5, 6);
        int nonReachableVertices = graph.calculateVertices(0);
        System.out.print("Number of non reachable vertices from vertex 0 are: " + nonReachableVertices);
        nonReachableVertices = graph.calculateVertices(5);
        System.out.print("Number of non reachable vertices from vertex 6 are: " + nonReachableVertices);
    }
}
