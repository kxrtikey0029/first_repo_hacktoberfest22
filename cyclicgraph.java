import java.util.LinkedList;

public class Ques_7 {

    static class Graph{
        int vertices;
        LinkedList<Integer> [] adjList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int x = 0; x <vertices ; x++) {
                adjList[i] = new LinkedList<>();
            }
        }
        public void addEdge(int source, int destination){
            
            adjList[source].addFirst(destination);

            
            adjList[destination].addFirst(source);
        }

        public boolean isCycle() {
            boolean result = false;

            
            boolean[] visited = new boolean[vertices];
            
            for (int x = 0; x <vertices ; x++) {
                if(visited[x]==false){
                    if(isCycleUtil(i, visited, -1)){
                        return true;
                    }
                }
            }
            return result;
        }

        boolean isCycleUtil(int currVertex, boolean [] visited, int parent){

            
            visited[currVertex] = true;

           
            for (int x = 0; x <adjList[currVertex].size() ; x++) {
                int vertex = adjList[currVertex].get(x);
                
                if(vertex!=parent) {
                    
                    if(visited[vertex]){
                        
                        return true;
                    }
                    else{
                        
                        if (isCycleUtil(vertex, visited, currVertex)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 2);
        boolean result = graph.isCycle();
        System.out.print("Cycle present: " + result);
    }
}
