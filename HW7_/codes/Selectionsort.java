
import java.util.ArrayList;

/**
 * This class represent for the sort the mymap keys 
 * @author Hamza KONAÇ
 * @since 19.05.23
 * 
 */
public class Selectionsort {
   
    private myMap originalMap;
    
    private myMap sortedMap;
    private String [] aux;
    
    /**
     * consrtucter of the mersort class
     * @param originalMap take mymap class's instance variable
     * @param aux take aux of the key's 
     */
    public Selectionsort(myMap originalMap, String[] aux) 
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
        Selectsort(aux,integerArray);
       
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
    private  void Selectsort(String[] keys, Integer[] frequencies) 
    {
        int fill=0;
        for(;fill<frequencies.length-1;fill++)
        {
            int index=refinement(frequencies, fill);
            //exchanging is costly operation.Therefore if smallest value in the subarray equal to
            //value at the index fill, we dont perform exhange values
            if(frequencies[index]!=frequencies[fill])
            {
                swap(frequencies,fill,index);
                swap(keys,fill,index);
            }
        }
    }

    /**
     * swap the values for the selcetion sort
     * @param <T> generic type of the method
     * @param  x first argument for the swapping
     * @param  y second argument for the swapping
     */
    private  <T> void swap(T[] x,int index1, int index2) {
        T temp = x[index1];
        x[index1] = x[index2];
        x[index2] = temp;
    }

    /**
     * 
     * @param frequencies
     * @param fill
     * @return
     */
    private   int refinement(Integer [] frequencies,int fill) 
    {
        
        int posmin=frequencies[fill];
        int index=fill;
        for(int i=fill+1;i<frequencies.length;i++)
        {
            if(posmin>frequencies[i])
            {
                posmin=frequencies[i];
                index=i;
            }
        }
        return index;
    }

    
}

