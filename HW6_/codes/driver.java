import java.util.Scanner;

public class driver {
    public static void main(String[] args) {
        boolean flag=true;

        Scanner scan=new Scanner(System.in);
        String input;
        while (flag) 
        {
            System.out.print("ENTER THE STRING(For exit press -1): ");
            input=scan.nextLine();
            if(input.equals("-1"))
                flag =false;
            else
            {
                System.out.println( "Original String : "+input);
                myMap mapp=new myMap();
                System.out.println( "Preprocessed String: "+mapp.buildstring(input));
                mapp.createmap();
                System.out.println("\n\nThe original (unsorted) map:");
                mapp.printmap();
                System.out.println("\n\nThe sorted map:");
                mapp.sortlist();
            }

        }
    }
}
