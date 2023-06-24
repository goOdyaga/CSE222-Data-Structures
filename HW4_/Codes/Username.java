/**
 * This class represent for chech user name validity
 * @author HAMZA KONAÇ
 * @version 1.1
 * @since 15.04.23
 */
public class Username {

    /**
     * This methode represent for check user name validity
     * @param username user that that will checked
     * @return true if user name is valid
     */
    public boolean  checkIfValidUsername(String username)
    {
        try {
            //directly control first character of the string 
            //if string is empty cach block catch the code and return the false 
            if(!(Character.isLetter(username.charAt(0))))/*if user name contain character that is notletter funciton return false */
                return false;
        } catch (Exception e) {
            return false;
        }
        if(1==username.length())
            return true;
        return  checkIfValidUsername(username.substring( 1));
    }
}
