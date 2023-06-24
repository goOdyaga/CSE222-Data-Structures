package homework1;

/**
 * This EXCEPTION class represent for SOCIAL MEDIA DEMO ASSIGNMENT. This class is base class and has multiple derived class.This class's objects include genereal ERROR massage
 * @author HAMZA KONAÇ
 * @since 10.03.2023
 * @version V 1.2
 */
public class EXCEPTIONS  extends Exception{   
    private String Message;

    /**
     * Default constructer
     */
    public EXCEPTIONS()
    {
        Message=new String("There is ERORR!");
    }

    /**
     * Default constructer
     */
    public EXCEPTIONS(String Message)
    {
        this.Message=new String(Message);
    }

    public String toString()
    {
        return String.format("%s",Message);
    }

}

/**
 * This class derived from ECXEPTION class . If an operation have done previously this class's object should create
 * 
 * @author HAMZA KONAÇ
 * @since 10.03.2023
 * @version V 1.2
 */
class Already_exist extends EXCEPTIONS
{
    public Already_exist()
    {
        super("This operation Has Already DONE!!");
    }

    public Already_exist(String message)
    {
        super(message);
    }
}

/**
 * This class derived from ECXEPTION class . If an operation is not EXIST this class's object should create
 * 
 * @author HAMZA KONAÇ
 * @since 10.03.2023
 * @version V 1.2
 */
class NOT_exist extends EXCEPTIONS
{
    public NOT_exist()
    {
        super("This operation is not EXIST!!");
    }

    public NOT_exist(String message)
    {
        super(message);
    }
}

/**
 * This class derived from ECXEPTION class . If ITEMS ARE NOT SAME this class's object should create
 * 
 * @author HAMZA KONAÇ
 * @since 10.03.2023
 * @version V 1.2
 */
class NOT_SAME extends EXCEPTIONS
{
    public NOT_SAME()
    {
        super("COMPARING ITEMS NOT SAME!!");
    }

    public NOT_SAME(String message)
    {
        super(message);
    }
}

/**
 * This class derived from ECXEPTION class . If an item couldn't found this class's object should create
 * 
 * @author HAMZA KONAÇ
 * @since 10.03.2023
 * @version V 1.2
 */
class Not_FOUND extends EXCEPTIONS
{
    public Not_FOUND()
    {
        super("Couldn'f found searching items!!");
    }

    public Not_FOUND(String message)
    {
        super(message);
    }
}

/**
 * This class derived from ECXEPTION class . IF an account is blocked by another account .Blocky account couldnt found account thas have blocked .
 * if there is a situation like this, this Class object should create
 * 
 * @author HAMZA KONAÇ
 * @since 10.03.2023
 * @version V 1.2
 */
class BLOCKED extends EXCEPTIONS
{
    public BLOCKED()
    {
        super("THIS ACCOUNT HAS NOT ALREADY EXIST!!");
    }

    public BLOCKED(String message)
    {
        super(message);
    }
}
