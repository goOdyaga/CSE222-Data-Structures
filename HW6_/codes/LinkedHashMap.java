import java.util.HashMap;
import java.util.Map;
import java.util.*;


/**
 * This class has overriden for the map creation. 
 * put funcitın has overrşden for the add new word to ınfo class instead of the change th all values the new word
 * Then add new method for the use this class effiecently
 * 
 * @author Hamza KONAÇ
 * @since 14.05.23
 */
public class LinkedHashMap<K, V extends info> extends HashMap<K, V> {
    private Entry<K, V> head;
    private Entry<K, V> tail;
    private int size;

    /**
     * Default constructer of the class
     */
    public LinkedHashMap()
    {
        head=null;
        tail=null;
        size=0;
    }

    /**
     * copy constructer of the class
     * @param inputMap
     */
    public LinkedHashMap(LinkedHashMap<K, V> inputMap) {
        this.head =inputMap.head;
        this.tail=inputMap.tail;
        this.size=inputMap.size;
    }

    /**
     * Take key and value and add it to map . if key is exist in the map put method add new word to value arraay .
     * 
     */
    @Override
    public V put(K key, V value) {
        if (containsKey(key)) {
            // Key already exists, update the value
            Entry<K, V> entry = getEntry(key);
            entry.value.addvalue(value.getword());
            return value;
        } else {
            size++;
            // Key does not exist, create a new entry
            Entry<K, V> newEntry = new Entry<K,V>(key, value);

            if (head == null) {
                // The linked list is empty, set the new entry as both head and tail
                head = newEntry;
                tail = newEntry;
            } else {
                // Append the new entry at the end of the linked list
                tail.next = newEntry;
                newEntry.previous = tail;
                tail = newEntry;
            }

            // Insert the new entry into the HashMap
            super.put(key, value);

            return null;
        }
    }

    /**
     * Take node of the entry class and inserrt it to map
     * @param entry node of the map
     */
    public void put(Entry<K, V> entry) {
        if(entry !=null)
        {
            put(entry.getKey(),entry.getValue());
        }
    }
    
    /**
     * take kay and return key's node
     * @param key
     * @return
     */
    private Entry<K, V> getEntry(K key) {
        for (Entry<K, V> entry = head; entry != null; entry = entry.next) {
            if (entry.key.equals(key)) {
                return entry;
            }
        }
        return null;
    }

    /**
     * take frequency of the node's as arraylist and. create new map. arraylist contain sorted frequency by ascending order
     * @param aux arraylist that contain number of the words
     * @return new linkedhashmap object
     */
    public LinkedHashMap<K,V> returnnewmap(ArrayList<Integer> aux)
    {
        Entry<K,V> temp=head;
        LinkedHashMap<K,V> new_=new LinkedHashMap<K,V>();
        for(int j=0;j<aux.size();j++)
        {
            temp=head;

            while(temp!=null)
            {
                
                if(aux.get(j)==temp.getvaluecount())
                {
                    // System.out.println(aux[j]);
                    new_.put(temp);
                
                }
                temp=temp.next;
            }
            // temp2=temp2.next;
        }

        return new_;

    }

    /**
     * print entries by inserting order
     */
    public void printEntries()
    {
        Entry<K,V> temp=head;
        while(temp!=null)
        {
            info inf=temp.getValue();
            String [] a=inf.getarray();
            System.out.print("Letter: "+temp.getKey()+" - Count: "+inf.getcount() +" Words: [" );
            for(int i=0;i<a.length;i++)
            {
                if(i!=a.length-1)
                System.out.print(a[i]+",");
                else
                System.out.print(a[i]);
            }
    System.out.println("]");
            temp=temp.next;
        }
    }



    /**
     * return number of words in the each node
     * @return array of the word number 
     */
    public int[] returnfrequency()
    {
        int[] freq=new int[size];
        Entry<K,V> temp=head;
        int counter=-1;
        while(temp!=null)
        {
            info inf=temp.getValue();
            freq[++counter]=inf.getcount();
            temp=temp.next;
        }
        return freq;


    }
    // Other methods and customizations for your custom LinkedHashMap class

    /**
     * return node number in the entry
     *
     */
    @Override
    public int  size()
    {
        // System.out.println("SIZEEEE");
        return size;
    }


    // Entry class representing a linked list node
    private static class Entry<K, V extends info> implements Map.Entry<K, V> {
        K key;
        V value;
        Entry<K, V> previous;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.previous = null;
            this.next = null;
        }

        /**
         * return number word in the node
         * @return
         */
        public int getvaluecount()
        {
            return value.getcount();
        }
        
        /**
         * return key
         */
        @Override
        public K getKey() {
            return key;
        }

        /**
         * return value
         */
        @Override
        public V getValue() {
            return value;
            // TODO Auto-generated method stub
        }

        /** 
         * set new value to node
         */
        @Override
        public V setValue(V value) {
            V oldvalue=this.value;
            this.value=value;
            return oldvalue;
            // TODO Auto-generated method stub
        }

        // Implement the methods of the Map.Entry interface
        // ...
    }
}
