public class deneme {
    /**
     * take keys and it's freaquenssy . Then sort them
     * @param keys 
     * @param frequencies
     */
    public static void Selectionsort( Integer[] frequencies) 
    {
        int fill=0;
        for(;fill<frequencies.length-1;fill++)
        {
            int index=refinement(frequencies, fill);
            swap(frequencies,fill,frequencies,index);
        }
    }

    /**
     * 
     * @param <T>
     * @param  x
     * @param  y
     */
    public static <T> void swap(T[] x,int index1, T[] y,int index2) {
        T temp = x[index1];
        x[index1] = y[index2];
        y[index2] = temp;
    }

    /**
     * 
     * @param frequencies
     * @param fill
     * @return
     */
    public static  int refinement(Integer [] frequencies,int fill) 
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

    public static void main(String[] args) {
        // TODO code application logic here
        Integer[] intArray = { 5, 1, 2, 6, -1, 3, 4, 61, 73, 10 };

        Integer[] integerArray = new Integer[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            integerArray[i] = (Integer) intArray[i];
        }

        for(int i=0;i<integerArray.length;i++)
        {
            System.out.println(integerArray[i]);
       }
        // System.out.println(frequencies);
        // for(int i=0;i<frequencies.length;i++)
        // {
        //     System.out.print(frequencies[i]+" ");
        // }
        // System.out.println();
        // Selectionsort(frequencies);
        // for(int i=0;i<frequencies.length;i++)
        // {
        //     System.out.print(frequencies[i]+" ");
        // }
        // System.out.println();
        // System.out.println(frequencies);
    }
}
