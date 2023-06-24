
/**
 * This class represent for collect the ınfos of the values
 */
public class info {
    private int count;
    private String [] words;
    
    /**
     * constructer of the info class
      */
    public info()
    {
        count=0;
        words=new String[0];
    }

    /**
     * take word and add it to info array
     * @param word
     */
    public info(String word)
    {
        count=0;
        words=new String[0];
        addvalue(word);
    }

    /**
     * add  new word to inf array
     * @param word
     */
    public void  addvalue(String word)
    {
        String []new_words=new String[count+1];
        for(int i=0;i<count;i++)
            new_words[i]=words[i];
        new_words[count]=word;
        words=new_words;
        count++;
    }

    /**
     * return fisrt word of the array
     * @return first elemnt of the array
     */
    public String getword()
    {
        return words[0];
    }

    /**
     * return ınfo array
     * @return array of the strings
     */
    public String[] getarray()
    {
        return words;
    }

    /** 
     * return ttoalt element of the word number
     */
    public int getcount()
    {
        return count;
    }
}
