import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class represent for the read map file and convert it to matrix
 */
public class Map {
    private int startX;
    private int startY;
    private int destX;
    private int destY;
    private int[][] matrix;
    private String stringfilename;

    /**
     * Constructer that take file name and create matrix
     * @param Filename
     */
    public Map(String Filename) {


        File file = new File(Filename);
        String fileName = file.getName();

        this.stringfilename = fileName;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String linea=reader.readLine();
            String a[]=linea.split(",");
            startX=Integer.parseInt(a[0]);
            startY=Integer.parseInt(a[1]);
            linea=reader.readLine();
            a=linea.split(",");
            destX=Integer.parseInt(a[0]);
            destY=Integer.parseInt(a[1]);
            // Read the remaining lines and create the matrix
            String line;
           
            int rowCount = 0;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (matrix == null) {
                    matrix = new int[values.length][values.length];
                }
                for (int i = 0; i < values.length; i++) {
                    matrix[rowCount][i] = Integer.parseInt(values[i]);
                }
                rowCount++;
            }

            // Close the reader
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * this method return matrix of the graph
     * @return
     */
    public int[][] getMatrix() {
        return matrix;
    }

    /**
     * this method return matrix size
     * @return
     */
    public int getSize()
    {
        return matrix[0].length;
    }

    /**
     * this method return start node's X location
     * @return
     */
    public int getStartX() {
        return startX;
    }


  
        /**
     * this method return start node's Y location
     * @return
     */
    public int getStartY() {
        return startY;
    }

    /**
     * This method return destination
     * @return
     */
    public int getDestX() {
        return destX;
    }


    /**
     * this method return destinaiton node's Y location
     * @return
     */
    public int getDestY() {
        return destY;
    }



   /**
    * this method retun file that is source of the map
    * @return
    */
    public String getfilename()
    {
        return stringfilename;
    }
    
    
}
