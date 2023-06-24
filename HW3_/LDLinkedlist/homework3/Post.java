package homework3;

import java.util.ListIterator;

// import java.util.LDLinkedlist;
/**
 * This post class represent for the insert post for an account or display post for interaction
 * @author HAMZA KONAÇ
 * @since 10.03.2023
 * @version V 1.2
 */
public class Post
{
    private String User_name;
    private int post_id;
    private int account_Id;
    private  LDLinkedlist<Like> like_array=new LDLinkedlist<Like>() ;
    private LDLinkedlist<Comment> comments=new LDLinkedlist<Comment>();
    private String content;
    private int like_number;
    private int commnet_number;
    

    /**
     * construecter for initialize post object
     * @param user_name user name that has this post
     * @param post_id ıd of post
     * @param account_id account ıd has shared this post
     * @param Content content of post
     */
    public Post(String user_name,int post_id,int account_id,String Content)
    {
        User_name=new String(user_name);
        this.post_id=post_id;
        this.account_Id=account_id;
        content=new String(Content);
        like_number=0;
    }
    
    /**
     * This function represent for returnlike array
     * @param index index of array
     * @return like at index a
     */
    public Like getLike_array(int index) {
        try {
            if(index>=like_array.size())
                throw new IndexOutOfBoundsException();
            // if(like_array.get(index)!=null)
            return like_array.get(index);
            
        } catch (Exception e) {
            System.out.println(e.toString());
                return null;
        }
    }


    /**
     * This function represent for return like arran
     * @param a index of array
     * @return commnet at index a
     */
    public Comment getComments(int index) {
        try {
            if(index>=comments.size())
                throw new IndexOutOfBoundsException();
            return comments.get(index);
            
        } catch (Exception e) {
            System.out.println(e.toString());
                return null;
        }
    }

    /**
     * 
     * @return
     */
    public int getCommnet_number() {
        return comments.size();
    }

    /**
     * This function represent for return post ıd
     * @return post Id
     */
    public int get_post_id()
    {
        return post_id;
    }

    /**
     * This function represent for reteurn user name that owner of this post
     * @return user name that has been shared this post
     */
    public String get_user_name()
    {
        return User_name;
    }

    /**
     * This function represent for return ıd of account
     * @return Account Id that has been shared this post
     */
    public int get_account_Id()
    {
        return account_Id;
    }

    /**
     * This function represent for return content of post
     * @return content of post
     */
    public String get_content_of_post()
    {
        return content;
    }

    /**
     * reset post Id
     * @param post_Id post ıd
     */
    public void set_post_Id(int post_Id,int hash_code)
    {
        post_id=post_Id;
    }
    /**
     * reset Account_Id
     * @param post_Id post ıd
     */
    public void set_Account_Id(int Account_Id)
    {
        account_Id=Account_Id;
    }
    /**
     * reset User name
     * @param post_Id post ıd
     */
    public void set_user_name(String userName)
    {

        User_name=userName;
    }

    /**
     * reset content of the post
     * @param Account_ID account ıd
     * @param PostId post ıd
     * @param new_content new content of post
     */
    public void set_content_of_post(int Account_ID,int PostId,String new_content)
    {
        try {
            if((Account_ID==account_Id)&&(PostId==post_id))
            {
                account_Id=Account_ID;
                post_id=PostId;
                content=new_content;
            }
            throw new NOT_SAME("Account Id or Post Id don't match with post id and account ID");
            
        } catch (EXCEPTIONS e) {
            System.out.println(e.toString());
        }
    }
    
    /* */
    /**
     * function for incrase like number a of a related post
     * @param user_name owner of like
     * @return true if function can incease like number of relaited post else return false
     */
    public boolean increase_like(String user_name)
    {
        
        try {
            for(int i=0;i<like_number;i++)
                if(user_name.equals(like_array.get(i).getUSer_name()))/*if user like this post he/she couldn't like again this post */
                    throw new Already_exist("\""+user_name+"\""+" has ALready like this post");
            Like new_like=new Like(user_name, like_array.size()+comments.size(), account_Id, post_id, like_array.size()+1);
            // like new_like= new like(user_name,like_number);
            // Like [] new_like_array= new Like[like_number+1];
            // for(int i=0;i<like_number;i++)
            //     new_like_array[i]=like_array[i];/*copy old values to new array for increasing */
            // new_like_array[like_number]=new_like;
            // like_array=new_like_array;
            // like_number+=1;
            like_array.add(new_like);
        } catch (EXCEPTIONS e) {
                System.out.println(e.toString());
                return false;
        }
        return true;

    }

    /**
     * funciton for remove like for specified post
     * in this method lazy deletion has been used
     * @param user_name owner of like
     * @return true if specified like can removed else return false
     */
    public boolean delete_like(String user_name)
    {
        try {
            for(int i=0;i<like_array.size();i++)
            {
                if(user_name.equals(like_array.get(i).getUSer_name()))/*founded like that wanted remove */
                {
                    //remove node at i'th index from linked list
                    like_array.remove(i);

                    //printed linked list situation because of lazy deletion
                    like_array.ToString();
                    return true;
                }
            }
            throw new NOT_exist("There is not account that name is "+user_name+" or This account has not like this post");
            
        } catch (EXCEPTIONS e) {
            System.out.println(e.toString());
            return false;
        }
    }

    /**
     * This function represent for retrun post's like number
     * @return like number for specified post
     */
    public int get_like_number()
    {
        return like_array.size();
    }

    /**
     * funciton for insert a new comment at the post
     * @param UserName user name owner of comment
     * @param content_of content of commnet
     * @param post_ID post Id
     * @return true if comment can insert the post
     */
    public void insert_comment(String UserName,String content_of,int interaction_ID)
    {

        Comment new_commnets=new Comment(UserName, content_of, interaction_ID, account_Id, post_id, comments.size()+1);
        comments.add(new_commnets);
    }

     /**
      * This function represent for  for edit comment
      * @param UserName user name owner of commnet
      * @param new_content new content
      * @param commend_ID commnend Id
      * @param post_ID post ID
      * @return true if commend can edited
      */
    public boolean edit_comment(String UserName,String new_content,int commend_ID,int post_ID)
    {
        try {
            
            if(post_ID==post_id)
            {
                for(int i=0;i<commnet_number;i++)
                {

                    if(commend_ID==(comments.get(i).get_commnet_ID()))
                    {
                        comments.get(i).Set_Comment(new_content, post_ID);
                        return true;       
                    }
                }
                throw new NOT_SAME("There is not commnet that you want to edit");
            }
            throw new NOT_SAME("POST ID's are not same for insert a new commnet");
        } catch (EXCEPTIONS e) {
            System.out.println(e.toString());
            return false;
        }
    }
     /**
       * this class represent for the delete from the post
       * @param content content of the post
       * @param post_ID id of the post
       * @param user owner of the commnet
       * @return return true if comment can removed
       */
    public boolean delete_comment(String content,int post_ID,String user)
    {
        try {
            
            if(post_ID==post_id)
            {

                for(int i=0;i<comments.size();i++)
                {
                    Comment temp_Comment=comments.get(i);
                    if(temp_Comment!=null&&temp_Comment.get_Comment().equals(content)&&temp_Comment.getUSer_name().equals(user))
                    {
                        comments.remove(i);
                        return true;
                    }
                }
              
            }
            throw new NOT_SAME("POST ID's are not same for insert a new commnet");
        } catch (EXCEPTIONS e) {
            System.out.println(e.toString());
            return false;
        }
    }
}







