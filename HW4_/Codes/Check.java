/**
 * This class represent for check user name and pasword2 for enter the system
 */
public class Check {
    private static Username username=new Username();
    private static Password1 password1=new Password1();
    private static Password2 password2=new Password2();

    /**
     * This method represent for the check user information
     * @param _username name of the user
     * @param _password1    first password of the user
     * @param _password2    second password of the user
     * @param denominations denominations list of the password2 
     * @return
     */
    public static boolean CheckInformation(String _username,String _password1,int _password2,int [] denominations)
    {
        if( username.checkIfValidUsername(_username))
        {
            if(password1.containsUserNameSpirit(_username, _password1))
            {
                if(password1.isBalancedPassword(_password1))
                {
                    if(password1.isPalindromePossible(_password1))
                    {
                        if(password2.isExactDivision(_password2,denominations))
                            return true;
                        else
                            System.out.print("!!\"password2 must to has exact divison variety of given demoninations\"!!");
                    }
                    else
                        System.out.print("!!\"password1 must has possible palindrom string\"!!");
                }
                else    
                    System.out.print("!!\"password1 must contain balanced parathesis\"!!");
            }
            else
                System.out.print("!!\"password1 must contain least one letter from user name\"!!");

        }
        else
            System.out.print("!!\"user name must contain only letter\"!!");
        return false;

    }
    
}
