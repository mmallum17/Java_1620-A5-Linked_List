import java.util.LinkedList;

/**
 * Created by Marcus on 7/14/2016.
 */
public class GraphVertex implements Comparable<GraphVertex>
{
    private int distanceFromStart;
    private LinkedList<Point> edges;
    public static final boolean START_VERTEX = true;
    public static final boolean INTERIOR_VERTEX = false;

    public GraphVertex(boolean vertexType)
    {
        edges = new LinkedList<Point>();
        if(vertexType == START_VERTEX)
        {
            setDistanceFromStart(0);
        }
        else
        {
            setDistanceFromStart(Integer.MAX_VALUE);
        }
    }

    public void addEdge(int vertex, int distance)
    {
        edges.add(new Point(vertex, distance));
    }

    public int getDistanceFromStart()
    {
        return distanceFromStart;
    }

    public void setDistanceFromStart(int distance)
    {
        distanceFromStart = Math.min(distanceFromStart, distance);
    }

    public void relaxEdges(Graph g)
    {

    }

    @Override
    public int compareTo(GraphVertex gv)
    {
        return this.getDistanceFromStart() - gv.getDistanceFromStart();
    }
}
