
import java.io.InputStream;
import java.util.*;

// TODO : Incidence Matrix

public class Graph {
    public int V;				//# Vertices
    public int E;			        // # Edges
    public LinkedList<Integer>[] adj;	// Adjacency List
    public int[][] adjMat;


    Graph(int vertex, int edges)
    {
        V = vertex;
        E = edges;
        adj = new LinkedList[V];
        adjMat = new int[V][V];
        for (int i =0; i < V; i++)
        {
            adj[i] = new LinkedList<Integer>();          // Initializing Adjacency List
        }

        for (int j = 0; j < V; j++)
        {
            for (int k = 0; k < V; k++)
            {
                adjMat[j][k] = 0;               // Adjacency Matrix Initialization
            }
        }
    }
    Graph(Scanner in){
        this(in.nextInt(), in.nextInt());

        for (int i =0; i < E; i++)
        {
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            addEdge(v1, v2);
        }
    }

    void addEdge(int v1, int v2)
    {
        adj[v1].add(v2);
        adjMat[v1][v2] = 1;
    }

    Iterable<Integer> adj(int v){
        return adj[v];				// Returns adjacent vertices to vertex(v)
    }


    public String toString(){
        String s = "";
        for (int v = 0; v < V; v++)
        {
            s += v + ": ";
            for (int j : this.adj(v))			// Utility Function
            {
                s+= j + " ";
            }
            s+= "\n";
        }

        return s;
    }

    static public void main(String...args)
    {
        Scanner scn = new Scanner (System.in);
        Graph g = new Graph(scn);
        System.out.println(g);
        System.out.println(Arrays.deepToString(g.adjMat));
    }
}
