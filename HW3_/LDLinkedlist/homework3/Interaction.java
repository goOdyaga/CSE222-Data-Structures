package homework3;

/**
 * This interaction  class represent for the like or comment a post
 * @author HAMZA KONAÇ
 * @since 10.03.2023
 * @version V 1.2
 */
public class Interaction {
    private String Operation_have_done;
    private int interaction_Id;
    private int account_Id;
    private int post_ID;
    private String USer_name;
    
    /**
     * 
     * @param interaction_Id
     * @param account_Id
     * @param post_ID
     * @param comment_
     */

    /**
     * constructer od ınteraction
     * @param USER_NAME user name has performed this interaction
     * @param interaction_Id interacction ıd
     * @param account_Id account ıd
     * @param post_ID post ıd
     */
    public Interaction( String USER_NAME,int interaction_Id, int account_Id, int post_ID)
    {
        this.USer_name=USER_NAME;
        this.interaction_Id = interaction_Id;
        this.account_Id = account_Id;
        this.post_ID = post_ID;    
    }
    
    /**
     * This function represent for  return user name that has performed this interaction
     * @return user name
     */
    public String getUSer_name() 
    {
        return USer_name;
    }

    /**
     * This function represent for  reset user name that has performed this interaction
     * @param uSer_name new  user name
     */
    public void setUSer_name(String uSer_name) {
        USer_name = uSer_name;
    }

    /**
     * @return Interaction ID
     */
    public int getInteraction_Id() 
    {
        return interaction_Id;
    }

    /**
     * set Interaction ID
     */
    public void setInteraction_Id(int interaction_Id) {
        this.interaction_Id = interaction_Id;
    }
    
    /**
     * @return Account ID
     */
    public int getAccount_Id() {
        return account_Id;
    }
    
    /**
     * Set Account ID
     */
    public void setAccount_Id(int account_Id) {
        this.account_Id = account_Id;
    }
    
    /**
     * @return Post Id
     */
    public int getPost_ID() {
        return post_ID;
    }
    
    /**
     * set post ID
     */
    public void setPost_ID(int post_ID) {
        this.post_ID = post_ID;
    }

    /**
     * This function represent for set the interaction message
     * @param message operaiton have done "username have liked/commneted post"
     */
    protected void set_interaction_message(String message)
    {
        Operation_have_done=new String(message);
    }
    
    @Override
    /**
     * 
     */
    public String toString() {
        return  Operation_have_done ;
    }


    
}
