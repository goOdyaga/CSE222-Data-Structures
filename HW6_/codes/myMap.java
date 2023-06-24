import java.util.ArrayList;

/**
 * This class represent for create new map.map's key is the string ad value is the info class object
 * @author Hamza konaç 
 * @since 14.05.23
 */
public class myMap {
    private LinkedHashMap <String, info> map;
    private int mapSize;
    private  String str;
    private String []aux; 


    /**
     * constructer of the my map class.
     * It take an string . Then build it for the map creation
     */
    public myMap() {
        map=new LinkedHashMap<String,info>();
    }

    /**
     * take linkedhashmap structure and crete instance variable
     * @param inputMap
     */
    public myMap(LinkedHashMap<String, info> inputMap) {
        this.map = new LinkedHashMap<String,info>(inputMap);
    }

    /** 
     * take string and build it it
     */
    public String buildstring(String str)
    {
        this.str = buildString(str);
        return this.str;
    }
    /**
     * by use builded string create map
     */
    public void createmap()
    {
        String[] arr = str.split(" ");
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length();j++)
                map.put(Character.toString( arr[i].charAt(j)),new info(arr[i]));
        }
    }

    /**
     * print map
     */
    public void printmap()
    {
     
        map.printEntries();
    }
    
    /**
     * teken non-build string and build it
     * @param str_
     * @return return builded string 
     */
    private String buildString(String str_)
    {
        str_=str_.toLowerCase();
        int []array=new int[26];
        int numberunique=0;
        String strr="";
        int spaces=0;
        ArrayList<String >auxX=new ArrayList<>();
        // aux=new String[numberunique];
        for(int i=0;i<str_.length();i++)
        {
            if(Character.isLetter(str_.charAt(i))||Character.isWhitespace (str_.charAt(i)))
            {
                strr+=str_.charAt(i);
                if(!Character.isWhitespace (str_.charAt(i))&&array[((int)str_.charAt(i))-97]==0)
                {
                    array[((int)str_.charAt(i))-97]+=1;
                    auxX.add(Character.toString( str_.charAt(i)));
                    numberunique+=1;
                }
                if(Character.isWhitespace (str_.charAt(i)))
                {
                    spaces++;
                }
            }
        }
        mapSize=numberunique+spaces;
        
        aux=new String[auxX.size()];
        for(int i=0;i<auxX.size();i++)
        {
            aux[i]=auxX.get(i);
        }   
        return strr;

    }

    /**
     * return linkedhashmap  object of the  class
     * @return
     */
   public LinkedHashMap <String, info> getmap()
   {
        return map;
   }

   /**
    * using merge sort create new map
    */
   public void sortlist()
   {
        mergeSort merge=new mergeSort(this, aux);
        // System.out.println("Flag1");
        merge.sortthemap();
   }
}
