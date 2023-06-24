import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;  
import javax.swing.tree.DefaultMutableTreeNode;  

public class driver {

    public static <T> T[] push(T [] array,T element)
    {
        
        T[] newarray=Arrays.copyOf(array,array.length+1);
        newarray[array.length]=element;
        return newarray;
    }

    public static <T> T[] remove(T[] inputArray, int indexToRemove) {
        int newArrayLength = inputArray.length - 1;
        T[] newArray = Arrays.copyOf(inputArray, newArrayLength);
        System.arraycopy(inputArray, indexToRemove + 1, newArray, indexToRemove, newArrayLength - indexToRemove);
        return newArray;
    }
    public static void main(String[] args) {

        String[][] elements=new String[0][];
        TreeExample tree= new TreeExample();  
        TreeExample tree1= new TreeExample();  

        try {
            Scanner scanner = new Scanner(new File("tree.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] arr = line.split(";");
                elements=push(elements, arr);
                
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(int i=0;i<elements.length;i++)
        {
            tree1.addchild(elements[i]);        
            tree.addchild(elements[i]);        
        }
        System.out.println("FILE HAS BEEN READED AND TREE CREATED");
        Scanner scan=new Scanner(System.in);
        tree.displaytree();
        System.out.println("ENTER A NODE FOR BFS");
        String bfs=scan.nextLine();
        System.out.println("Using BFS to find '"+bfs+"' in the tree ...");
        // String userinput1=scan.nextLine();
        if(!(tree.searchBFS(bfs)))
            System.out.println("Not found!");
        System.out.println("ENTER A NODE FOR DFS");
        String dfs=scan.nextLine();
        System.out.println("Using BFS to find '"+dfs+"' in the tree ...");
        if(!tree.searchDFS(dfs))
            System.out.println("Not found!");
        System.out.println("ENTER A NODE FOR Post-Order Search ");
        String post=scan.nextLine();
        System.out.println("Using Post-Order traversal to find '"+bfs+"' in the tree ...");
        if(!tree.searchpostorder(post))
            System.out.println("Not found!");
        System.out.println("ENTER MOVE PATH (  2023;CSE232  !!sample input.input format must this format)");
        String userinput=scan.nextLine();
        System.out.println("ENTER YEAR TO MOVE");
        String usermove=scan.nextLine();
        String [] move=userinput.split(";");
        TreeExample movetree=new TreeExample();
        movetree.addchild(move);
        tree.closewindow();;
        // movetree.displaytree();
        if(tree.movepath(move, usermove))
            tree.displaytree();
        else
            tree.displaytree();
        tree1.displaytree();
        
        // tree.tryreturn(move);

    }
}
