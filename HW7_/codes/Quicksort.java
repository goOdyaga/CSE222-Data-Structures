
import java.util.ArrayList;

/**
 * This class represent for the sort the mymap keys 
 * @author Hamza KONAÇ
 * @since 19.05.23
 * 
 */
public class Quicksort {
   
    private myMap originalMap;
    
    private myMap sortedMap;
    private String [] aux;
    
    /**
     * consrtucter of the mersort class
     * @param originalMap take mymap class's instance variable
     * @param aux take aux of the key's 
     */
    public Quicksort(myMap originalMap, String[] aux) 
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

        quicksort(aux,integerArray,0,aux.length-1);
       
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
    private  void quicksort(String[] keys, Integer[] frequencies,int first ,int last) 
    {
        if (first < last)
        {
            int p = partition(keys, frequencies, first, last);
            quicksort(keys, frequencies, first, p - 1);
            quicksort(keys, frequencies, p + 1, last);
        }
    }
    /**
     * swap the values for the selcetion sort
     * @param <T> generic type of the method
     * @param  x first argument for the swapping
     * @param  y second argument for the swapping
     */
    private  <T> void swap(T[] x,int index1,int index2) {
        T temp = x[index1];
        x[index1] = x[index2];
        x[index2] = temp;
    }

   /**
    * 
    * @param keys
    * @param frequencies
    * @param first
    * @param last
    * @return
    */
    private int partition(String [] keys , Integer [] frequencies, int first ,int last )
    {
        int up = first;
        int down = last;
        int pivot = frequencies[first];
        do
        {
            while (up<down && frequencies[down] > pivot)
                down--;
            while (up < down && frequencies[up] <= pivot)
                up++;
                
            if (up < down)
            {
                swap(keys, up, down);
                swap(frequencies, up, down);
            }
        }while (up < down);
    
        swap(frequencies, first, up);
        swap(keys, first, up);
        return down;
    }
}

