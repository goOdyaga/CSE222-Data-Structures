
import java.util.ArrayList;

/**
 * This class represent for the sort the mymap keys 
 * @author Hamza KONAÇ
 * @since 19.05.23
 * 
 */
public class InsertionSort {
   
    private myMap originalMap;
    
    private myMap sortedMap;
    private String [] aux;
    
    /**
     * consrtucter of the mersort class
     * @param originalMap take mymap class's instance variable
     * @param aux take aux of the key's 
     */
    public InsertionSort(myMap originalMap, String[] aux) 
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
        InsertionSorting(aux,integerArray);
       
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
    private void InsertionSorting(String[] keys, Integer[] frequencies) 
    {
        int fill=1;
        for(;fill<frequencies.length;fill++)
        {
            refinement(frequencies, fill,keys);
        }
    }

    /**
     * take next value and for right place shift it
     * @param frequencies
     * @param fill
     * @return
     */
    private  void refinement(Integer [] frequencies,int fill,String [] keys) 
    {
        int nextpos=frequencies[fill];
        String nextpos2=keys[fill];
        while(fill>0&&nextpos<frequencies[fill-1])
        {
            frequencies[fill]=frequencies[fill-1];
            keys[fill]=keys[fill-1];
            fill--;
        }
        frequencies[fill]=nextpos;
        keys[fill]=nextpos2;
    }
}

