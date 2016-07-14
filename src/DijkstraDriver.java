import java.util.Scanner;

public class DijkstraDriver
{
   public static void main(String args[])
   {
      Scanner input = new Scanner(System.in);
      Graph g = new Graph();
      int numVertices;
      int destVertex, distance;
      do
      {
         System.out.print("Enter number of vertices: ");
         numVertices = input.nextInt();
      }while(numVertices <= 1);

      for(int vertex = 0; vertex < numVertices; vertex++)
         g.addVertex();

      System.out.println("Enter edges for each Vertex, destination Vertex then weight\nEnter an invalid Vertex to continue to next Vertex\nExample: -1 -1");

      for(int vertex = 0; vertex < numVertices; vertex++)
      {
         System.out.printf("Edges for Vertex %d\n", vertex);
         try
         {
            do
            {
               System.out.printf("Edge for Vertex %d: ", vertex);
               destVertex = input.nextInt();
               distance = input.nextInt();
               g.addEdge(vertex, destVertex, distance);
            }while(true);
         }catch(NoSuchVertexException NSVE)
         {
            System.out.printf("Edges for Vertex %d entered\n", vertex);
         }
      }

      System.out.printf("Shortest path from first to last Vertex is %d\n", g.Dijkstra());
   }
}
