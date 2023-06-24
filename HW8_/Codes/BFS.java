import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.ArrayList;


/**
 * This class represent for apply Bfs algorithm on the graph
 * @author Hamza konaç
 */
public class BFS {
    private Graph graph;
    private int length;

    /**
     * constructer of BFS.Take a graph object
     * @param graph
     */
    public BFS(Graph graph)
    {
        this.graph=graph;
    }

    /**
     * this method find shortest path to destination and create png with path txt
     */
    public void findPath()
    {
        Queue<Integer> theQueue = new LinkedList<Integer>();
        // Declare array parent and initialize its elements to –1.
        int[] parent = new int[graph.getnumV()];
        for (int i = 0; i < graph.getnumV(); i++) {
            parent[i] = -1;
        }
        // Declare array identified and
        // initialize its elements to false.
        boolean[] identified = new boolean[graph.getnumV()];
        identified[graph.returnStart()] = true;
        theQueue.offer(graph.returnStart());
        while (!theQueue.isEmpty()) {
            int current = theQueue.remove();
            
            Iterator<Edge> itr = graph.edgeIterator(current);
            while (itr.hasNext()) {
                Edge edge = itr.next();
                int neighbor = edge.getDest();
                // If neighbor has not been identified
                if (!identified[neighbor]) {
                    // Mark it identified. 
                    identified[neighbor] = true;
                    // Place it into the queue.
                    theQueue.offer(neighbor);
                    parent[neighbor] = current;
                }
            }
        // Finished visiting current.
        }

        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<Edge> pathedge = new ArrayList<>();
        int vertex = graph.ReturnDest();
        while (vertex != -1) {
            path.add(vertex);
            Iterator<Edge> itr = graph.edgeIterator(vertex);
            pathedge.add(itr.next());
            vertex = parent[vertex];
        }

        Collections.reverse(path);
        Collections.reverse(pathedge);
        // for(int i=0;i<pathedge.size();i++)
        // System.out.println(pathedge.get(i).getX()+" "+pathedge.get(i).getY());
        writeLine(pathedge);
        length=pathedge.size();
       
        // return path;
    }
    /**
     * this methpd create png file
     * @param a
     */
    public void writeLine(ArrayList<Edge> a) {
        int[][] graphMatrix = graph.getGraphMatrix();
        String fileName = graph.getFileName();
        String fileNameWithoutExtension = "";
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex >= 0) {
            fileNameWithoutExtension = fileName.substring(0, dotIndex);
        } else {
            fileNameWithoutExtension = fileName;
        }
    
        // Specify the path for saving the text file
        String textFilePath = "txtfiles/" + fileNameWithoutExtension + "_path_BFS.txt";
    
        try (FileWriter fileWriter = new FileWriter(textFilePath)) {
            System.out.println("FOR " + fileName + " optimum path coordinate has been written on " +
                    fileNameWithoutExtension + "_path.txt\n");
            for (int i = 0; i < a.size(); i++) {
                for (int j = 0; j < graphMatrix.length; j++) {
                    for (int h = 0; h < graphMatrix.length; h++) {
                        if (graphMatrix[j][h] == a.get(i).getSource()) {
                            graphMatrix[j][h] = -3;
                            fileWriter.write(j + " " + h + "\n");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        int[][] matrix = graph.getMatrix();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int cellSize = 2;
    
        int width = cols * cellSize;
        int height = rows * cellSize;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
    
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.BLUE);
    
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 1) {
                    int xPos = row * cellSize;
                    int yPos = col * cellSize;
                    g.fillRect(xPos, yPos, cellSize, cellSize);
                } else if (graphMatrix[row][col] == -3) {
                    int xPos = row * cellSize;
                    int yPos = col * cellSize;
                    g.setColor(Color.RED);
                    g.fillRect(xPos, yPos, cellSize, cellSize);
                    g.setColor(Color.CYAN);
                }
            }
        }
    
        // Specify the path for saving the PNG file
        String pngFilePath = "pngfiles/" + fileNameWithoutExtension + "_BFS.png";
    
        try {
            ImageIO.write(image, "png", new File(pngFilePath));
            System.out.println("Map image saved successfully on " + fileNameWithoutExtension + ".png\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * create length of shortest path
     * @return
     */
    public int getLength()
    {
        return length;
    }
}
