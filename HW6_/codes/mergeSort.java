
import java.util.ArrayList;

/**
 * This class represent for the sort the mymap keys 
 * @author Hamza KONAÇ
 * @since 14.05.23
 * 
 */
public class mergeSort {
   
    private myMap originalMap;
    
    private myMap sortedMap;
    private String [] aux;
    
    /**
     * consrtucter of the mersort class
     * @param originalMap take mymap class's instance variable
     * @param aux take aux of the key's 
     */
    public mergeSort(myMap originalMap, String[] aux) 
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
    
        int a[]=originalMap.getmap().returnfrequency();
        mergeSort(aux,a);
       
        ArrayList<Integer> newfreq=new ArrayList<>();
        int last=0;
        for(int i=0;i<a.length;i++)
        {
            if(last!=a[i])
            {
                newfreq.add(a[i]);
                last=a[i];
            }
       }
        LinkedHashMap<String ,info> mapp=originalMap.getmap().returnnewmap(newfreq);
        sortedMap=new myMap(mapp);
        sortedMap.printmap();

    }

    /**
     * take keys and it's freaquenssy . Then sort them
     * @param keys 
     * @param frequencies
     */
    private void mergeSort(String[] keys, int[] frequencies) {
        if (keys.length <= 1) {
            return;
        }

        int mid = keys.length / 2;
        String[] leftKeys = new String[mid];
        String[] rightKeys = new String[keys.length - mid];
        int[] leftFreqs = new int[mid];
        int[] rightFreqs = new int[keys.length - mid];

        // Splitting keys and frequencies into left and right arrays
        for (int i = 0; i < mid; i++) {
            leftKeys[i] = keys[i];
            leftFreqs[i] = frequencies[i];
        }
        for (int i = mid; i < keys.length; i++) {
            rightKeys[i - mid] = keys[i];
            rightFreqs[i - mid] = frequencies[i];
        }

        mergeSort(leftKeys, leftFreqs);  // Recursively sort the left half
        mergeSort(rightKeys, rightFreqs);  // Recursively sort the right half

        merge(keys, leftKeys, rightKeys, frequencies, leftFreqs, rightFreqs);  // Merge the sorted halves
    }

    /**
     * Take left and right array than merge them
     * @param keys
     * @param leftKeys
     * @param rightKeys
     * @param frequencies
     * @param leftFreqs
     * @param rightFreqs
     */
    private  void merge(String[] keys, String[] leftKeys, String[] rightKeys,
                             int[] frequencies, int[] leftFreqs, int[] rightFreqs) {
        int leftLength = leftKeys.length;
        int rightLength = rightKeys.length;
        int i = 0, j = 0, k = 0;

        while (i < leftLength && j < rightLength) {
            if (leftFreqs[i] < rightFreqs[j]) {
                keys[k] = leftKeys[i];
                frequencies[k] = leftFreqs[i];
                i++;
            } else {
                keys[k] = rightKeys[j];
                frequencies[k] = rightFreqs[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the left subarray
        while (i < leftLength) {
            keys[k] = leftKeys[i];
            frequencies[k] = leftFreqs[i];
            i++;
            k++;
        }

        // Copy any remaining elements from the right subarray
        while (j < rightLength) {
            keys[k] = rightKeys[j];
            frequencies[k] = rightFreqs[j];
            j++;
            k++;
        }
    }
}

