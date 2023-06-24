import java.util.Iterator;
import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;

import javax.imageio.ImageIO;

/**
 * This class represent for find shortest path to find destination by using Dijkstra algorithm
 * @author Hamza konaç
 */
public class Dijkstra {
    private Graph graph;
    private int length; 

    /**
     * Constructer of Dijkstra class.It take graph object
     * @param graph
     */
    public Dijkstra(Graph graph)
    {
        this.graph=graph;
    }

    /**
     * this function find shortest path from start position to destination
     */
    public void findPath() {
        int[] distances = new int[graph.getnumV()];
        boolean[] visited = new boolean[graph.getnumV()];
        int[] parent = new int[graph.getnumV()];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        distances[graph.returnStart()] = 0;

        for (int i = 0; i < graph.getnumV() - 1; i++) {
            int minVertex = findMinDistanceVertex(distances, visited);
            visited[minVertex] = true;

            Iterator<Edge> itr = graph.edgeIterator(minVertex);
            while (itr.hasNext()) {
                Edge edge=itr.next();
                int adjacentVertex = edge.getDest();
                int weight = 1;

                if (!visited[adjacentVertex] && distances[minVertex] != Integer.MAX_VALUE &&
                        distances[minVertex] + weight < distances[adjacentVertex]) {
                    distances[adjacentVertex] = distances[minVertex] + weight;
                    parent[adjacentVertex] = minVertex;
                }
            }
        }

        if (parent[graph.ReturnDest()] == -1)
            return;

        ArrayList<Integer> path = new ArrayList<>();
        int vertex = graph.ReturnDest();
        ArrayList<Edge> pathedge = new ArrayList<>();
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
        Collections.reverse(path);
        length=path.size();
        writeLine(pathedge);

        
    }

    /**
     * This funciton create png file and txt file for shortest path
     * @param a
     */
    private void writeLine(ArrayList<Edge> a) {
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
        String textFilePath = "txtFiles/" + fileNameWithoutExtension + "_path_Dijkstra.txt";
    
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
        String pngFilePath = "pngfiles/" + fileNameWithoutExtension + "_Dijkstra.png";
    
        try {
            ImageIO.write(image, "png", new File(pngFilePath));
            System.out.println("Map image saved successfully on " + fileNameWithoutExtension + ".png\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private int findMinDistanceVertex(int[] distances, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int minVertex = -1;
    
        for (int i = 0; i < graph.getnumV(); i++) {
            if (!visited[i] && distances[i] <= minDistance) {
                minDistance = distances[i];
                minVertex = i;
            }
        }
    
        return minVertex;
    }
    /**
     * this method return shortest path length
     * @return
     */
    public int getLength()
    {
        return length;
    }
    

    
}
