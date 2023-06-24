
/**
 * This class represent for the check password2 validity
 * @author HAMZA KONAÇ
 * @since 14.04.23
 * @version 1.1
 */
public class Password2 {

    /**
     * This ethode represent for check number has exact divition from denominitons list
     * @param password2 pasword for checking
     * @param denominations list of the denominations
     * @return true if password has exact divisions
     */
    public  boolean isExactDivision(int password2, int [] denominations)
    {
        // Base case: if the password is 0, it can always be obtained by summing 0 denominations
        if (password2 == 0) {
            return true;
        }

        // Recursive case: try subtracting each denomination from the password and recursively checking if the remainder can be obtained
        for (int i = 0; i < denominations.length; i++) {
        int denom = denominations[i];
        if (denom <= password2) {
            if (isExactDivision(password2-denom,denominations)) {
                return true;
            }
        }
        
        }
        
        // If none of the recursive calls returned true, the password cannot be obtained
        return false;
    }
}
