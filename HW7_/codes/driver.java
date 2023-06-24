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
                
                
                double exetimemerge1=System.nanoTime();
                mapp.sortlistbymerge();
                double exetimemerge2=System.nanoTime();
                System.out.println( "Time taken to sort map  MERGE: "+(exetimemerge2-exetimemerge1)/1000000000);
                
                
                
                double exetiselect1=System.nanoTime();
                mapp.sortlistbyselection();
                double exetiselect2=System.nanoTime();
                System.out.println( "Time taken to sort map SELECTION: "+(exetiselect2-exetiselect1)/1000000000);
                
                
                double exetimeinsert1=System.nanoTime();
                mapp.sortlistbyinsertion();
                double exetimeinsert2=System.nanoTime();
                System.out.println( "Time taken to sort map INSERTION: "+(exetimeinsert2-exetimeinsert1)/1000000000);
                
                double exetimebuble1=System.nanoTime();
                mapp.sortlistbybubble();
                double exetimebuble2=System.nanoTime();
                System.out.println( "Time taken to sort map BUBBLE: "+(exetimebuble2-exetimebuble1)/1000000000);



                double exetimequick1=System.nanoTime();
                mapp.sortlistbyquick();
                double exetimequick2=System.nanoTime();
                System.out.println( "Time taken to sort map QUICK: "+(exetimequick2-exetimequick1)/1000000000);
            }

        }
    }
}
