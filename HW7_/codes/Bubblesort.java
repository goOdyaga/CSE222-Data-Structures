
import java.util.ArrayList;

/**
 * This class represent for the sort the mymap keys 
 * @author Hamza KONAÇ
 * @since 19.05.23
 * 
 */
public class Bubblesort {
   
    private myMap originalMap;
    
    private myMap sortedMap;
    private String [] aux;
    
    /**
     * consrtucter of the mersort class
     * @param originalMap take mymap class's instance variable
     * @param aux take aux of the key's 
     */
    public Bubblesort(myMap originalMap, String[] aux) 
    {
        this.originalMap = originalMap;
        this.aux = aux;
        // sortedMap=this.originalMap;
    }

    /**
     * sort the map
     */
    public void sortthemap()
    {
    
        int intArray[]=originalMap.getmap().returnfrequency();
        Integer[] integerArray = new Integer[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            integerArray[i] = (Integer) intArray[i];
        }
        bublesort(aux,integerArray);
       
        ArrayList<Integer> newfreq=new ArrayList<>();
        int last=0;
        for(int i=0;i<integerArray.length;i++)
        {
            if(last!=integerArray[i])
            {
                newfreq.add(integerArray[i]);
                last=integerArray[i];
            }
       }
        LinkedHashMap<String ,info> mapp=originalMap.getmap().returnnewmap(newfreq);
        sortedMap=new myMap(mapp);
        // sortedMap.printmap();

    }

    /**
     * take keys and it's freaquenssy . Then sort them
     * @param keys 
     * @param frequencies
     */
    private  void bublesort(String[] keys, Integer[] frequencies) 
    {
        boolean check=false;
        int i=1;
        while(!check)
        {
            check=true;
            for(int j=0;j<frequencies.length-i;j++)
            {
                if(frequencies[j]>frequencies[j+1])
                {
                    check=false;
                    swap(frequencies, j, frequencies, j+1);
                    swap(keys, j, keys, j+1);
                }
            }
            i++;
        }
    }

    /**
     * swap the values for the selcetion sort
     * @param <T> generic type of the method
     * @param  x first argument for the swapping
     * @param  y second argument for the swapping
     */
    private  <T> void swap(T[] x,int index1, T[] y,int index2) {
        T temp = x[index1];
        x[index1] = y[index2];
        y[index2] = temp;
    }

    
}

