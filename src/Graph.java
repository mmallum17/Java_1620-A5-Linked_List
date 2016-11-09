import java.util.LinkedList;

/**
 * Created by Marcus on 7/14/2016.
 */
public class Graph
{
    private LinkedList<GraphVertex> vertices;

    public Graph() {
        vertices = new LinkedList<GraphVertex>();
    }

    public void addVertex() {
        if (vertices.isEmpty()) {
            vertices.add(new GraphVertex(GraphVertex.START_VERTEX));
        } else {
            vertices.add(new GraphVertex(GraphVertex.INTERIOR_VERTEX));
        }
    }

    // Adds an edge to a vertex
    public void addEdge(int vertex1, int vertex2, int distance) {
        if (vertex1 >= vertices.size() || vertex1 < 0)
        {
            throw new NoSuchVertexException(vertex1);
        }
        else if (vertex2 >= vertices.size() || vertex2 < 0)
        {
            throw new NoSuchVertexException(vertex2);
        }
        else
        {
            vertices.get(vertex1).addEdge(vertex2, distance);
        }
    }

    public void setVertexDistanceFromStart(int vertex, int distance)
    {
        vertices.get(vertex).setDistanceFromStart(distance);
    }

    public int Dijkstra()
    {
        boolean[] visited = new boolean[vertices.size()];
        GraphVertex graphVertex;
        // Initialize all elements to false
        for (int position = 0; position < visited.length; position++)
        {
            visited[position] = false;
        }

        // While vertices are unprocessed
        do
        {
            // Get minimum vertex
            graphVertex = extractMinVertex(visited);
            // Relax edges of that vertex
            if(graphVertex != null)
            {
                graphVertex.relaxEdges(this);

            }
        }while(graphVertex != null);

        return vertices.getLast().getDistanceFromStart();
    }

    public GraphVertex extractMinVertex(boolean[] visited)
    {
        GraphVertex smallest;
        int smallPosition = 0;
        // Find first element in array that is false
        while(smallPosition < visited.length && visited[smallPosition])
        {
            smallPosition++;
        }
        // If all vertices have been processed
        if (smallPosition == visited.length)
        {
            return null;
        }
        else
        {
            smallest = vertices.get(smallPosition);
            // Get smallest unprocessed vertex
            for (int position = smallPosition + 1; position < visited.length; position++)
            {
                if ((!visited[position]) && smallest.compareTo(vertices.get(position)) > 0)
                {
                    smallest = vertices.get(position);
                    smallPosition = position;
                }
            }
            visited[smallPosition] = true;
            return smallest;
        }
    }
}
