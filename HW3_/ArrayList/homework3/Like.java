package homework3;

/**
 * This Like reperesent for add like to posts
 * @author HAMZA KONAÇ
 * @since 10.03.2023
 * @version V 1.2
 */
public class Like extends Interaction{

    private int like_id;

    /**
     * constructer for create like object for a specified user account
     * @param user_name
     * @param post_id
     */

    /**
     * constructer for create like object for a specified user account
     * @param USER_NAME user name that has like post
     * @param interaction_Id interaction ıs
     * @param account_Id account ıd that like photo
     * @param post_ID post id
     * @param likeId like ıd
     */
    public Like(String USER_NAME,int interaction_Id, int account_Id, int post_ID ,int likeId)
    {
        super(USER_NAME,interaction_Id,account_Id,post_ID);
        set_interaction_message(USER_NAME+" has liked this post.Liked post number ID is "+post_ID+" and it is belong to account that ID is "+ account_Id);
        like_id=likeId;   
    }

    /**
     * This function represent for return like Id
     * @return like ID
     */
    public int get_like_id()
    {
        return like_id;
    }

    /**
     * rest like ID
     * @param like_id new like ıD
     */
    public void set_like_id(int like_id)
    {
        this.like_id=like_id;
    }    
}
