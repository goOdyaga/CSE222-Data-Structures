package homework3;

/**
 * this class represent for send or receive message to other user
 * @author HAMZA KONAÇ
 * @since 10.03.2023
 * @version V 1.2
 */
public class Comment extends Interaction {

    private String comment;
    private int CommentId;

    /**
     * constructer for create commnet object
     * @param USER_NAME comment's owner
     * @param content_commnet content of commnet
     * @param interaction_Id interaction ıd of this comment
     * @param account_Id post's owner's  account ID
     * @param post_ID post ıd
     * @param commnetId commnet ıd
     */
    public Comment(String USER_NAME,String content_commnet,int interaction_Id, int account_Id, int post_ID ,int commnetId)
    {
        super(USER_NAME,interaction_Id,account_Id,post_ID);
        comment=new String(content_commnet);
        set_interaction_message(USER_NAME+" has Commented this postS.Commented post that number is "+post_ID+" and it is belong to account that number is "+ account_Id+"\nComment content is : "+content_commnet+"\n");
        // User_name=new String(user_name);
        CommentId=commnetId; 
    }

    /**
     * This function represent for  return content of comment
     * @return content of message
     */
    public String get_Comment()
    {
        return comment;
    }

    /**
     * This function represent for  return commnet ID
     * @return ıf of commnet
     */
    public int get_commnet_ID()
    {
        return CommentId;
    }
    
    /**
     * reset commnet ıD
     * @param ID_ new ıd of comment
     */
    public void Set_commnet_ID(int ID_)
    {
        CommentId=ID_;
    }

    /**
     * This function represent for reset comment's content
     * @param new_commend new content
     * @param id ıd of commnet
     * @return true if content reset
     */
    public boolean Set_Comment(String new_commend,int id) 
    {
        try {
            if(id==CommentId)
            {
                comment=new String(new_commend);
                return true;
            }
            throw new NOT_SAME("Comment's Id are not same for reset Comment's Content's");
        } catch (EXCEPTIONS e) {
            System.out.println(e.toString());
        }
        return false;
    }
}
