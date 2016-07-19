import java.util.LinkedList;
import java.awt.Point;

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
            distanceFromStart = 0;
        }
        else
        {
            distanceFromStart = Integer.MAX_VALUE;
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
        int size  = edges.size();
        Point point;
        for(int position = 0; position < size; position++)
        {
            point = edges.get(position);
            g.setVertexDistanceFromStart(point.x, point.y + this.getDistanceFromStart());
        }
    }

    @Override
    public int compareTo(GraphVertex gv)
    {
        return this.getDistanceFromStart() - gv.getDistanceFromStart();
    }
}
