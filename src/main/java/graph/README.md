Here’s a simple and detailed explanation of how **Depth-First Search (DFS)** works, along with a **Java implementation**.

### What is DFS?
**Depth-First Search (DFS)** is an algorithm for traversing or searching tree or graph data structures. Starting from a source node, it explores as far as possible along each branch before backtracking. DFS is often used to explore **connected components** of a graph or to find a path between nodes.

### How DFS Works:
1. Start from the root or source node.
2. Visit the node and mark it as visited.
3. Explore each unvisited neighbor recursively.
4. Backtrack when all neighbors are visited.

### DFS Implementation in Java (Using Recursion)

We will represent the graph using an **Adjacency List**, which is efficient for sparse graphs.

#### Step-by-Step Code:

```java
import java.util.*;

// Class representing a Graph
public class Graph {
    private int numVertices;  // Number of vertices
    private List<List<Integer>> adjList;  // Adjacency list to store graph edges

    // Constructor to initialize the graph with a specific number of vertices
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList<>(numVertices);
        
        // Initialize the adjacency list for each vertex
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Method to add an edge between two vertices (undirected graph)
    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);  // Add edge from source to destination
        adjList.get(destination).add(source);  // For undirected graph, add edge back
    }

    // DFS recursive function
    private void dfsUtil(int vertex, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[vertex] = true;
        System.out.print(vertex + " ");

        // Recur for all the vertices adjacent to the current vertex
        for (int neighbor : adjList.get(vertex)) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited);  // Recursive DFS call for unvisited neighbors
            }
        }
    }

    // DFS function to start traversal from a given vertex
    public void dfs(int startVertex) {
        // Create a visited array to mark which vertices have been visited
        boolean[] visited = new boolean[numVertices];

        // Call the recursive DFS function
        System.out.println("DFS starting from vertex " + startVertex + ":");
        dfsUtil(startVertex, visited);
    }

    public static void main(String[] args) {
        // Create a graph with 5 vertices
        Graph graph = new Graph(5);

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

        // Perform DFS traversal starting from vertex 0
        graph.dfs(0);
    }
}
```

### Explanation of the Code:

1. **Graph Representation**:
   - The graph is represented using an **adjacency list**, where each vertex has a list of neighboring vertices. This is more space-efficient for sparse graphs compared to an adjacency matrix.
   - The `Graph` class contains a constructor that initializes the adjacency list and a method `addEdge()` to add edges to the graph.

2. **DFS Recursive Function (`dfsUtil`)**:
   - This is the core of the DFS algorithm. It marks the current vertex as visited, prints it, and then recursively visits all of its unvisited neighbors.
   - The function keeps track of visited vertices using a **boolean array** `visited[]`.

3. **DFS Driver Function (`dfs`)**:
   - This function initializes the visited array and starts the DFS traversal from the specified start vertex.

4. **Example**:
   - In the `main` method, we create a graph with 5 vertices and add edges. The DFS starts from vertex 0 and explores the graph recursively.

### Example Graph:
```
    0
   / \
  1   2
 / \
3   4
```

### Output:

```
DFS starting from vertex 0:
0 1 3 4 2 
```

### How the DFS Traversal Works:
- The traversal starts at vertex `0`.
- From `0`, it moves to vertex `1`.
- From `1`, it moves to vertex `3`, marks it as visited, and then backtracks to `1`.
- From `1`, it then visits vertex `4`, and after backtracking to `1`, returns to vertex `0`.
- The traversal continues to vertex `2`, marking it as visited.

### Time Complexity:
- **O(V + E)** where V is the number of vertices and E is the number of edges.
  - This is because each vertex and each edge is visited once during the traversal.

### Space Complexity:
- **O(V)** due to the recursion stack and the visited array, where V is the number of vertices.

### DFS Applications:
1. **Connected Components**: DFS can help find all connected components in a graph.
2. **Cycle Detection**: DFS can detect cycles in an undirected graph.
3. **Topological Sorting**: DFS is used in topological sorting of directed acyclic graphs (DAGs).
4. **Solving Mazes/Puzzles**: DFS can explore all possible paths in a maze or puzzle.

DFS is an important algorithm in both theory and practice, used in many real-world applications such as web crawling, pathfinding, and network traversal.
