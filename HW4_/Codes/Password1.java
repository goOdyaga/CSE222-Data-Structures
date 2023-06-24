import java.util.Stack;;

/**
 * This class represent for check Pasword1 validity
 * @author HAMZA KONAÇ
 * @since 15.04.23
 * @version 1.1
 */
public class Password1 {

    /*represent for check open paharantesis*/
    private static final String OPEN="([{";

    /*represent for check open paharantesis*/
    private static final String CLOSE=")]}";
    /**
     * Represent for check password contain username's least one letter 
     * @param username usrname
     * @param password1 user password
     * @return if password contain least one letter from username it will return true
     */
    public boolean containsUserNameSpirit(String username, String password1)
    {
        int []name_array={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int []pass_array={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        String new_username=username.toLowerCase();
        String new_pass=password1.toLowerCase();
        Stack<Character> user=new Stack<Character>();
        Stack<Character> pass=new Stack<Character>();

        //take each character one time for username
        for(int i=0;i<new_username.length();i++)
            if(name_array[(int)(new_username.charAt(i))-97]==0)
                name_array[(int)(new_username.charAt(i))-97]+=1;
        //take each character one time for password        
        for(int i=0;i<new_pass.length();i++)
            if(Character.isLetter(new_pass.charAt(i))&&pass_array[(int)(new_pass.charAt(i))-97]==0)
                pass_array[(int)(new_pass.charAt(i))-97]+=1;
        //add charecter of username to stack by alphabetical order
        for(int i=0;i<name_array.length;i++)
            if(name_array[i]==1)
                user.add((char)(i+97));
        //add charecter of username to stack by alphabetical order
        for(int i=0;i<pass_array.length;i++)
            if(pass_array[i]==1)
                pass.add((char)(i+97));
        
        while(!user.empty()&&!pass.empty())
        {
            //if top element of the stack's is equal return true
            if(user.peek().compareTo(pass.peek())==0)
                return true;
            //if pass satck's top element's alphabetical order come before  of the user stack 
            //code pop the top elemnet of the pass stack
            else if(user.peek().compareTo(pass.peek())<0)
            pass.pop();

            //if user satck's top element's alphabetical order come after  of the user stack 
            //code pop the top elemnet of the user stack
            else if(user.peek().compareTo(pass.peek())>0)
                user.pop();
        }
        return false;

    }

    /* 
     *represent for check parameter is close paharantesise or not 
     */
    private boolean isClose(char value)
    {
        return value==')'||value=='}'||value==']';
    }

    
    /* 
     *represent for check parameter is open paharantesise or not 
     */
    private boolean isOpen(char value)
    {
        return value=='('||value=='{'||value=='[';
    }
    /**
     * represent for check pasword's pharantesis are blanced or not
     * @param password1 passwoed for check
     * @return true if pharantesis are balanced
     */
    public boolean isBalancedPassword(String password1)
    {
        // System.out.println(password1);
        Stack<Character> pHar=new Stack<Character>();
        boolean balanced=true;
        try {
            for(int i=0;i<password1.length()&&balanced;i++)
            {
                char nextch=password1.charAt(i);
                if(isOpen(nextch))
                    pHar.add(nextch);
                else if(isClose(nextch))
                {
                    char topCh=pHar.pop();
                    balanced=OPEN.indexOf(topCh)==CLOSE.indexOf(nextch);
                }
            }
        
        }
        catch (Exception e) {
            return false;
        }
        return balanced && pHar.empty();
    }


    /**
     * methode represent for check the strinc can convert palindrome form or not
     * @param password1 The parameter that will checked
     * @return true if palindrome for is possible for parameter
     */
    public boolean isPalindromePossible(String password1)
    {
        int []pass_array={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};  

        //take freaquency of the letter in the string        
        for(int i=0;i<password1.length();i++)
            if(Character.isLetter(password1.charAt(i)))
                pass_array[(int)(password1.charAt(i))-97]+=1;
        //methode chech is palindrome is possible to by recurrence
        return PalindromePossible(pass_array, 0)<=1;
    }

    /**
     * this methode represent fotr check the is frequency of the element are even or odd
     * if frequency is odd for an element counter will increase one by one
     * @param frequency frequency array 
     * @param index index of the that check element in the frequency array
     * @return number of element number that has odd frequency
     */
    private int PalindromePossible(int [] frequency,int index)
    {
        if(index==frequency.length)
            return 0;
        else if(!(frequency[index]%2==0))
            return 1+PalindromePossible(frequency, index+1);
        return PalindromePossible(frequency, index+1);
    }
}
