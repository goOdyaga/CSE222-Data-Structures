import java.util.ArrayList;
import java.util.Iterator;


/**
 * This class represent for the create grap
 * @author Hamza konaç
 */
@SuppressWarnings("unchecked")
public class Graph {
    private ArrayList<Edge> [] edgelist;
    private int [][] graphmatrix;
    private int [][] matrix;
    private int numberOfNode;
    private int startX;
    private int startY;
    private int destX;
    private int destY;
    private String filename;

    /**
     * Constructer that take map object and create graph
     * @param map
     */
    public Graph(Map map)
    {
        filename=map.getfilename();
        startX=map.getStartX();
        startY=map.getStartY();
        destX=map.getDestX();
        destY=map.getDestY();
        matrix =map.getMatrix();
        graphmatrix=new int[matrix.length][matrix.length];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
                graphmatrix[i][j]=matrix[i][j];
        }
        // graphmatrix=matrix;
        updateNode();
        // numberOfNode=0;
        
    //    edges = new Edge[matrix.length][matrix.length];
    // System.out.println(numberOfNode);
        edgelist = new ArrayList[numberOfNode];
            for(int i=0;i<numberOfNode;i++)
                edgelist[i]=new ArrayList<Edge>();

        for (int i = 0; i < matrix.length; i++) 
        {
            for (int j = 0; j < matrix.length; j++) 
            {
                if(matrix[i][j]==0)
                {
                    // System.out.println("CHECK");
                    if(checkLocation(i, j+1))
                    {
                        // tempArray.add(i, null);
                        edgelist[graphmatrix[i][j]].add( new Edge(graphmatrix[i][j],graphmatrix[i][j+1],i,j));
                        // System.out.println(graphmatrix[i][j]);
                    }
                    if(checkLocation(i, j-1))
                    {
                        edgelist[graphmatrix[i][j]].add(new Edge(graphmatrix[i][j],graphmatrix[i][j-1],i,j));
                        // System.out.println(graphmatrix[i][j]);
                    }
                    if(checkLocation(i-1, j))
                    {
                        edgelist[graphmatrix[i][j]].add( new Edge(graphmatrix[i][j],graphmatrix[i-1][j],i,j));
                        // System.out.println(graphmatrix[i][j]);
                    }
                    if(checkLocation(i+1, j))
                    {
                        edgelist[graphmatrix[i][j]].add( new Edge(graphmatrix[i][j],graphmatrix[i+1][j],i,j));
                        // System.out.println(graphmatrix[i][j]);
                    }
                    if(checkLocation(i-1, j-1))
                    {
                        edgelist[graphmatrix[i][j]].add( new Edge(graphmatrix[i][j],graphmatrix[i-1][j-1],i,j));
                        // System.out.println(graphmatrix[i][j]);
                    }
                    if(checkLocation(i+1, j+1))
                    {
                        edgelist[graphmatrix[i][j]].add( new Edge(graphmatrix[i][j],graphmatrix[i+1][j+1],i,j));
                        // System.out.println(graphmatrix[i][j]);
                    }
                    if(checkLocation(i+1, j-1))
                    {
                        edgelist[graphmatrix[i][j]].add( new Edge(graphmatrix[i][j],graphmatrix[i+1][j-1],i,j));
                        // System.out.println(graphmatrix[i][j]);
                    }
                    if(checkLocation(i-1, j+1))
                    {
                        edgelist[graphmatrix[i][j]].add( new Edge(graphmatrix[i][j],graphmatrix[i-1][j+1],i,j));
                        // System.out.println(graphmatrix[i][j]);
                    }
                }  
            }
            // createAdjancelist();
        }
    } 

    /**
     * class that check lgiven location for adjency
     * @param x
     * @param y
     * @return
     */
    private boolean checkLocation(int x,int y)
    {
        if(x>=0&&x<matrix.length&&y>=0&&y<matrix.length)
            return matrix[x][y]==0;
        return false;    
    }

    

    /**
     * This method give node number for each 0 in the matrix
     */
    private void updateNode()
    {
        int counter=0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                if(matrix[i][j]==0)
                {
                    graphmatrix[i][j]=counter++;
                }
                else
                    graphmatrix[i][j]=-1;
            }
        }
        numberOfNode=counter;
    }

    /**
     * this method retun nuber of the node in the graph
     * @return
     */
    public  int getnumV()
    {
        return numberOfNode;
    }

    /**
     * this method return iterator in the vector in the adjency list
     * @param current
     * @return
     */
    public Iterator<Edge> edgeIterator(int current)
    {
        return edgelist[current].iterator();
    }

    /**
     * this method return startin node in the map
     * @return
     */
    public int returnStart()
    {
        return graphmatrix[startX][startY];
    }

    /**
     * this method return the destination node in the graph
     * @return
     */
    public int ReturnDest()
    {
        return graphmatrix[destX][destY];
    }

    public int [][] getMatrix()
    {
        return matrix;
    } 
    public int [][] getGraphMatrix()
    {
        return graphmatrix;
    } 
   
    /**
     * this function return file name that source of the graph
     * @return
     */
    public String getFileName()
    {
        return filename;
    }
    
}
