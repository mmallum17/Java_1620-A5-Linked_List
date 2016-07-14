import java.util.NoSuchElementException;

/**
 * Created by Marcus on 7/14/2016.
 */
public class NoSuchVertexException extends RuntimeException
{
    public NoSuchVertexException(int vert)
    {
        super("Vertex does not exist: " + vert);
    }
}
