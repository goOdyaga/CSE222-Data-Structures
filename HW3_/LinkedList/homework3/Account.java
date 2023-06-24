package homework3;

import java.util.LinkedList;
import java.util.ListIterator;
/**
 * This Class Represent for share post like or comment post or send message to other user 
 * @author HAMZA KONAÇ
 * @since 10.03.2023
 * @version V 1.2
 */
public class Account {
    
    private LinkedList<Post> Posts= new LinkedList<Post>();
    private LinkedList<String> follower= new LinkedList<String>();
    private LinkedList<String> following= new LinkedList<String>();
    private LinkedList<String> Ban= new LinkedList<String>();
    private LinkedList<Message> Inbox= new LinkedList<Message>();
    private LinkedList<Message> out_BOX= new LinkedList<Message>();
    private LinkedList<Interaction> interactions=new LinkedList<Interaction>();
    private String USER_NAME;
    private String location;
    private String Birthday;
    private boolean is_loge;
    private int Account_ID;
    private String history="";
    
    @Override
    /**
     * This funcciton represent for show user profile
     */
    public String toString() {
        String followerr="";
        String followingg="";
        ListIterator<String> iter_follower=follower.listIterator();
        ListIterator<String> iter_following=following.listIterator();

        while(iter_follower.hasNext())
            followerr+=iter_follower.next()+" ";

        while(iter_following.hasNext())
            followingg+=iter_following.next()+" ";
            
        return "User ID: "+Account_ID+"\n"+
        "Username: "+USER_NAME+"\n"+
        "Location: "+location+"\n"+
        "Birth Date: "+Birthday+"\n"+
        USER_NAME+" is following "+following.size()+" Account(s) and has "+follower.size()+" follower\n"+
        USER_NAME+" is following "+followingg+" \n"+
        USER_NAME+" has followed by "+followerr+" \n"+
        USER_NAME+" has "+Posts.size()+" post \n";
        
        
    }

    /**
     * This function represent for set Birthday again
     * @param birthday new birthday of user
     */
    public void setBirthday(String birthday) 
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return ;
        }
        Birthday = birthday;
    }
    
    /**
     * This function represent for get user birthday
     * @return Birthday
     */
    public String getBirthday() {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return null;
        }
        return Birthday;
    }
    
    
    /**
     * This function represent for get user locaiton
     * @return Location
     */
    public String getLocation() {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return null;
        }
        return location;
    }
    

    /**
     * This function represent for set location again
     * @param location new location
     */
    public void setLocation(String location) {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return ;
        }
        this.location = location;
    }


    /**
     * This function represent for get account ID
     * @return Account Id
     */
    public int getAccount_ID() {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return -1;
        }
        return Account_ID;
    }


    /**
     * Constructer that take name of the  Account with user location ,Bİrthday and account ID  
     * @param uSER_NAME user name of new user
     * @param location location of user
     * @param Birthday birthday of user
     * @param Account_ID Id of account
     */
    public Account(String uSER_NAME,String location,String Birthday,int Account_ID) 
    {
                this.Birthday=Birthday;
                this.location=location;
                this.Account_ID=Account_ID;
                USER_NAME = uSER_NAME;
                is_loge=false;
                return;
    }
    
    /**
     * This function represent for get user name
     * @return User name
     */
    public String getUSER_NAME() {
        if(!is_loge)
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
        return USER_NAME;
    }

   
    /**
     * This function represent for reset user name
     * @param uSER_NAME new username
     */
    public void setUSER_NAME(String uSER_NAME) {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return ;
        }
        USER_NAME = uSER_NAME;
    }

    /**
     * This function represent for return post array
     * @return []Post
     */
    private Post getPosts(int a) {
        return Posts.get(a);
    }
    
    /**
     * This function represent for return follower number
     * @return number of follower
     */
    public int get_follower_number()
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return -1;
        }
        return follower.size();
    }

   /**
    * This function represent for get following number
    * @return number of following
    */
    public int get_following_number()
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return -1;
        }
        return following.size();
    }
   
    /**
     * This function represent for get number of message in Inbox
     * @return number of message or -1(if not login)
     */
    public int get_inbox_number()
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return -1;
        }
        return Inbox.size();
        // return "There is/are "+Inbox.size()+" message in Inbox";
    }
   

    /**
     * This function represent for get numner of message in outbox
     * @return number of message or -1(if not login)
     */
    public int get_outbox_number()
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return -1;
        }
        return out_BOX.size();
        // return "There is/are "+out_BOX.size()+" message in outbox";

    }

    /**
     * This function represent for get number of user has blocked
     * @return number has blocked or -1(if not login)
     */
    public int get_ban_number()
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return -1;
        }
        return Ban.size();
    }

    /**
     * This function represent for get number of post
     * @return post number or -1(if not login)
     */
    public int get_post_number()
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return -1;
        }
        return Posts.size();
    }
    
    
    /**
     * This function represent for add new follower in follower list
     * @param temp account that have already follow this account
     * @return true or false
     */
    private boolean add_follower(Account temp)
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return false;
        }
        try {
            if(temp!=null)
            {
                
                if(temp.is_banned(USER_NAME))
                    throw new BLOCKED("There is no user has this name...");

                if(follower.indexOf(temp.USER_NAME)!=-1)
                    throw new Already_exist("This Account has already been in followers");
                
                    //add account's user name that has been follow this account in follower list 
                follower.addLast(temp.getUSER_NAME());
                // follower.add(temp.getUSER_NAME());
                history+=temp.USER_NAME+" has followed you\n";
                return true;

            }
            throw new NOT_exist("There is no Account that has this user_name");
        } catch (EXCEPTIONS e) {
                System.out.println(e.toString());
                return false;
        }
    }
   
    /**
     * This function represent for remove user from follower list
     * @param temp account that have already unfollow this account
     * @return true or false(if not login or couldn't remove)
     */
    private boolean delete_follower(Account temp)
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return false;
        }
        try {
            if(temp!=null)
            {
                temp.login();
                ListIterator<String> iter=follower.listIterator();
                boolean has_removed=false;

                while(iter.hasNext())
                {
                    String temp_follower=iter.next();
                    if(temp_follower.equals(temp.getUSER_NAME()))//find temp's userName in follower list
                    {
                        iter.remove();//remove temp's user name from follower list
                        if(temp.delete_following(this))//remove owner of account's user name Temp's following list
                        { 
                            has_removed=true;
                            break;
                        }
                            
                    }
                }

                temp.logout();
                if(has_removed)
                {
                    history+="You have removed "+temp.USER_NAME+" from you follower list\n";
                    return true;
                }
                
                throw new NOT_exist("There is no Account  follow you that has this user_name");

            }
            throw new NOT_exist("There is no Account that has this user_name");
        } catch (EXCEPTIONS e) {
            System.out.println(e.toString());
            return false;
        }
    }
   
   /**
    * This function represent for follow new user.
    * @param temp account that have already followed by this account
    * @return true or false
    */
    public boolean new_following(Account temp)
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return false;
        }
        try 
        {
            if(temp!=null)
            {
                temp.login();//for use temp user acccout's method we need to login
                if(temp.is_banned(USER_NAME))//control temp's blocked list
                    throw new BLOCKED("There is no user such this name");
                if(!following.contains(temp.getUSER_NAME()));//control User following list 
                {
                    following.addLast(temp.getUSER_NAME());
                    if(temp.add_follower(this))
                    {
                        temp.logout();
                        this.login();
                        history+="You have followed "+temp.USER_NAME+"\n";
                        return true;
                    }
                }
                    throw new Already_exist("This Account has already followed");
            }
            else
                throw new NOT_exist("There is no Account that has this user_name");
        }
        catch (EXCEPTIONS e) {
                System.out.println(e.toString());
                return false;
        }
        
    }

    /**
     * This function represent for remove user from following list
     * @param temp account that have already unfollow this account that is argumnet of method
     * @return true ıf user can removed
     */
    public boolean delete_following(Account temp)
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return false;
        }
        try {
            if(temp!=null)
            {
                temp.login();
                ListIterator<String> iter=following.listIterator() ;
                
                while(iter.hasNext())
                {
                    String temp_following=iter.next();

                    if(temp_following.equals(temp.getUSER_NAME()))//find temp's user name in following list
                    {
                        long lazy_start=System.nanoTime();
                        iter.remove();//remove it from following list
                        long lazy_finish=System.nanoTime();
                        long totalTime_lazy = lazy_finish - lazy_start;
                        // System.out.println( "lazy deletion affect on remove :"+"\u001B[32m"+totalTime_lazy+"\u001B[0m");
                        history+="You have unfollowed "+temp.getUSER_NAME()+"\n";
                        temp.logout();
                        return true;
                    }
                }
                    throw new NOT_exist("There is no Account  follow you that has this user_name");
            }
            throw new NOT_exist("There is no Account that has this user_name");
        } catch (EXCEPTIONS e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    /**
     * This function represent for share new post
     * @param new_post post will  be shared
     */
    public void new_post(Post new_post)
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return ;
        }
        history+="You have shared new post\n";
        Posts.addLast(new_post);//add new post to post list
    }

    /**
     * delete post from Account
     * @param delete_post post will be removed
     * @return true or false
     */
    public boolean delete_post(Post delete_post)
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return false;
        }
        try {
            if(Posts.indexOf(delete_post)!=-1)
            {
                history+="You have removed new post\n";
                Posts.remove(delete_post.get_post_id());
                return true;
            }
            throw new NOT_exist("THERE IS NO POST SUCH THIS");
            
        } catch (EXCEPTIONS e) {
            System.out.println(e.toString());
            return false;
        }
    }

    /**
     * block user that name is username
     * @param username will blocked has this name
     * @return true if user can blocked
     */
    public boolean add_ban(Account temp)
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return false;
        }
        try {
            if(temp!=null)
            {
                temp.login();
                //to check that it has banned by the account it wants to banned
                if(temp.is_banned(USER_NAME))
                    throw new BLOCKED();
                //to check that  user has already banned or not
                if(Ban.indexOf(temp.getUSER_NAME())!=-1)
                    throw new Already_exist("This Account has already Banned");
                
                //add user to Banned user list
                Ban.addLast(temp.getUSER_NAME());


                /*remove user from follower list and following list */
                delete_follower(temp);
                history+="YOu have blocked "+temp.USER_NAME+"\n";
                temp.logout();
                this.login();
                return true;
            }
            throw new NOT_exist("There is no Account that has this user_name");
        } catch (EXCEPTIONS e) {
            System.out.println(e.toString());
            return false;
        }
    }
    /**
     * remove username from banned list
     * @param username username of will removed from ban list
     * @return true user can remove from ban lisst
     */
    public boolean delete_ban(Account temp)
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return false;
        }
        try {
            if(temp!=null)
            {
                temp.login();
                ListIterator<String> iter=Ban.listIterator();

                while(iter.hasNext())
                {
                    String temp_ban=iter.next();
                    if(temp_ban.equals(temp.getUSER_NAME()))
                    {
                        iter.remove();
                        history+="You have unblocked "+temp.USER_NAME+"\n";
                        temp.logout();
                        return true;
                    }
                }
                throw new Already_exist("This Account has not Banned");
            }
            throw new NOT_exist("There is no Account that has this user_name");
        } catch (EXCEPTIONS e) {
            System.out.println(e.toString());
            return false;
        }
        
    }

     /**
      * This function represent for send a message to another account
      * @param temp  that is receiver of message
      * @param out_message mesage to send
      * @return true if user can send message
      */
    public boolean add_outboux(Account temp ,Message out_message)
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return false;
        }
        try {
            if(temp!=null)
            {   
                temp.login();
                
                //check the user want sending message is banned account that receiver of the message
                if(temp.is_banned(USER_NAME))
                        throw new BLOCKED();
                //to check following list for the receiver of the message
                if(following.contains(temp.getUSER_NAME()))
                {
                    out_BOX.addLast(out_message);
                    if(temp.add_inbox( out_message))
                    {
                        history+="You have send message to "+temp.USER_NAME+"\n";
                        temp.logout();
                        return true;
                    }
                }
                throw new EXCEPTIONS("You don's follow this Account so that you can't send message to this profile");
                
            }
            throw new NOT_exist("There is no Account such this user name.You cant send message!");
        } catch (EXCEPTIONS e) {
            System.out.println(e.toString());
            return false;
        }
    }
 
     /**
      * This function represent for remove a message to in outbox
      * @param temp that is receiver of message
      * @param out_message message to remove
      * @return true if user can remove message
      */
    public boolean delete_outboux(Account temp ,Message out_message)
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return false;
        }
        try {
            if(temp!=null)
            {   
                if(out_BOX.indexOf(out_message)!=-1)
                {
                    history+="You have removed an message from outbox\n";
                    out_BOX.remove(out_message.getMesage_id());
                    return true;
                }
                throw new NOT_exist("There is no Account such this user name.You cant deletee message!");
            }
            throw new NOT_exist("There is no Account such this user name.You cant deletee message!");
        } catch (EXCEPTIONS e) {
            System.out.println(e.toString());
            return false;
        }
    }

     /**
      * This function represent for add mesge in inbox a
      * @param get_message message to add inbox
      * @return true if user message can added
      */
    private boolean add_inbox(Message get_message)
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return false;
        }
        history+=get_message.getSenderName()+" has send message to you\n";
        Inbox.addLast(get_message);
        return true;
            
        
    }
    

    /**
     * This function represent for remove message from inbox
     * @param delete_message message that will be removed from inbox
     * @return true is message can removed
     */
    public boolean delete_inbox(Message delete_message)
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return false;
        }
        try {
            if(Inbox.indexOf(delete_message)!=-1)
            {
                Inbox.remove(delete_message.getMesage_id());
                history+="You have removed message from inbox\n";
                return true;
            }    
            throw new NOT_exist("There is no Account such this user name.You cant deletee message!");
        } catch (EXCEPTIONS e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
     /**
      * This function represent for  like a post
      * @param temp post's owner
      * @param post_ID ıd of post
      * @return true if post can liked
      */
    public boolean like_post(Account temp,int post_ID)
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return false;
        }
        try {
            if(temp!=null)
            {
                temp.login();
                if(post_ID>=0&&post_ID<=temp.get_post_number())
                {
                    Post temp_post=temp.getPosts(post_ID);
                    temp_post.increase_like(USER_NAME);
                    temp.add_interaction(temp_post.getLike_array(temp_post.get_like_number()-1));
                    history+="You has liked "+temp.USER_NAME+"'s post\n";
                    temp.logout();
                    return true;
                }
                throw new EXCEPTIONS("post ID is INVALID");
            }
            throw new NOT_exist("There is no Account such this user name.You cant like this post!");

        } catch (EXCEPTIONS e) {
            System.out.println(e.toString());
            return false;
        }
    }

    /**
     * This function represent for  remove like
     * @param temp owner of post
     * @param post_ID ıd of post
     * @return true if like can removed
     */
    public boolean delete_like(Account temp,int post_ID)
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return false;
        }
        try {
            if(temp!=null)
            {
                temp.login();
                if(post_ID>=0&&post_ID<temp.get_post_number())
                {
                    Post temp_post=temp.getPosts(post_ID);
                    temp_post.delete_like(USER_NAME);
                    history+="You has unliked "+temp.USER_NAME+"'s post\n";
                    temp.logout();
                    return true;
                }
                throw new EXCEPTIONS("post ID is INVALID");
            }
            throw new NOT_exist("There is no Account such this user name.You cant like this post!");
            
        } catch (EXCEPTIONS e) {
            System.out.println(e.toString());
            return false;
        }
    }

    /**
     * This function represent for add comment in a post
     * @param temp owner of post
     * @param post_ID id of post
     * @param Content content of comment
     * @return true if commented
     */
    public boolean add_comment(Account temp,int post_ID,String Content)
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return false;
        }
        try {
            if(temp!=null)
            {
                temp.login();
                if(post_ID>=0&&post_ID<=temp.get_post_number())
                {
                    Post temp_post=temp.getPosts(post_ID);
                    temp_post.insert_comment(USER_NAME, Content, post_ID);
                    temp.add_interaction(temp_post.getComments(temp_post.getCommnet_number()-1));
                    history+="You has comment to "+temp.USER_NAME+"'s post\n";
                    temp.logout();
                    return true;
                }
                throw new EXCEPTIONS("post ID is INVALID");
            }
            throw new NOT_exist("There is no Account such this user name.You cant like this post!");
            
        } catch (EXCEPTIONS e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
     /**
     * this class represent for the delete comment from post
     * @param temp owner of the post
     * @param post_id id of tbe post
     * @param content content of the comment
     */
    public void delete_comment(Account temp,int post_id,String content)
    {
        try {
            if(temp!=null)
            {
                temp.login();
                if(temp.get_post_number()<post_id||post_id<0)
                    throw new IndexOutOfBoundsException();
                Post temp_Post=temp.Posts.get(post_id);
                temp_Post.delete_comment(content, post_id,USER_NAME);
                history+="You uncomment "+temp.USER_NAME+"'s post\n";
                temp.logout();

                return;
            }
            throw new EXCEPTIONS();
        } catch (EXCEPTIONS e) {
            // TODO: handle exception
        }
        catch(Exception e)
        {

        }
    }

    /**
     * This function represent for get post's informations
     * @param temp owner of viewed posts'
     */
    public void get_post_information(Account temp)
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return ;
        }
            if(temp!=null)
            {
                temp.login();
                ListIterator<Post> iter=temp.Posts.listIterator();
                int counter=0;
                while(iter.hasNext())
                {
                    Post temp_post=iter.next();
                    System.out.println("Post ID :"+(++counter)+" "+USER_NAME+": " +temp_post.get_content_of_post()+" \n ");

                }
                history+="You have viewed post information of the "+temp.USER_NAME+"\n";
                temp.logout();
                return;
            }
    }

    /**
     * This function represent for get interactions' of a user
     * @param temp account of interactions' owner
     */
    public void get_interaction_information(Account temp)
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return ;
        }
        try {
            
                if(temp!=null)
                {
                    temp.login();
                    int counter=0;
                    ListIterator<Post> iter=temp.Posts.listIterator();
                    while(iter.hasNext())
                    {
                        Post temp_post=iter.next();
                        System.out.println("---------------------------------------");
                        System.out.println("(Post ID) : " +(++counter)+" :"+temp_post.get_content_of_post());
                        if(temp_post.get_like_number()==0)
                                    System.out.println("There isn't any like for this post");
                        else
                        {
                            System.out.print("The post was liked by the following account(s): ");
                            for(int i=0;i<temp_post.get_like_number();i++)
                            {
                                // if(temp.)
                                Like temp_Like=temp_post.getLike_array(i);
                                if(temp_Like!=null)
                                    System.out.print(temp_post.getLike_array(i).getUSer_name()+", ");
                            }
                            System.out.println();
                        }
                        if(temp_post. getCommnet_number()==0)
                            System.out.println("There isn't any commnet for this post");
                        else
                        {
                            System.out.println("\nThe post has " +temp_post.getCommnet_number()+ " comment(s)...");
                            for(int i=0;i<temp_post.getCommnet_number();i++)
                            {
                                System.out.println("Comment "+i+": "+temp_post.getComments(i).getUSer_name()+" said "+"\""+temp_post.getComments(i).get_Comment()+"\"");
                            }
                            System.out.println();
                        }
                        System.out.println("---------------------------------------");
                    }
                        history+="You has looked "+temp.getUSER_NAME()+"'s interactions\n";
                        temp.logout();
                        return;
                    }
                    throw new NOT_exist("There is no Account such this user name.You cant view profile!");
        
                
        } catch (EXCEPTIONS e) {
            System.out.println(e.toString());
        }

    }
    
    /**
     * This function represent for view an user profile
     * @param temp account of will be viewed
     */
    public void visit_profile(Account temp)
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return ;
        }
        try {
            if(temp!=null)
            {
                temp.login();
                if(temp.is_banned(USER_NAME))
                    throw new BLOCKED();
                    System.out.println("-----------------------");
                System.out.println(temp.toString());
                System.out.println("-----------------------");
                history+="You have visited "+temp.USER_NAME+"'s profile\n";
                if(!temp.USER_NAME.equals(USER_NAME))
                    temp.logout();
                return;
            }
            throw new NOT_exist("There is no Account such this user name.You cant view profile!");
            
        } catch (EXCEPTIONS e) {
            System.out.println(e.toString());
        }
    }

    /**
     * get inbox message
     * @return messages
     */
    public String get_In_messages()
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return null;
        }
        String Messages="";
        ListIterator<Message> iter=Inbox.listIterator();
        while(iter.hasNext())
        {
            Message tempMessage=iter.next();
            Messages+="Message ID: "+tempMessage.getMesage_id()+"\n"+
            "From: "+tempMessage.getSenderName()+"\n"+
            "To : "+tempMessage.getReceiverName()+"\n"+
            "Message: "+tempMessage.getContent()+"\n\n";

        }
        history+="You have display inbox\n";
        return Messages;
    }

    /**
     * This function represent for get in messages for speciifed user
     * @param username user to view messages
     * @return messages
     */
    public String get_In_messages(String username)
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return null;
        }
        String Messages="";
        ListIterator<Message> iter=Inbox.listIterator();
        while(iter.hasNext())
        {
            
            Message tempMessage=iter.next();
            if(tempMessage.getSenderName().equals(username))
            Messages+="Message ID: "+tempMessage.getMesage_id()+"\n"+
            "From: "+tempMessage.getSenderName()+"\n"+
            "To : "+tempMessage.getReceiverName()+"\n"+
            "Message: "+tempMessage.getContent()+"\n\n";

        }
        history+="You have display "+username+"'s message\n";
        return Messages;
    }

    /**
     * This function represent for get outbox message
     * @return messages
     */
    public String get_out_messages()
    {
        if(!is_loge)
        {
            System.out.println("\""+USER_NAME+"\""+" NOT LOGGED");
            return null;
        }
        String Messages="";
        ListIterator<Message> iter=out_BOX.listIterator();
        while(iter.hasNext())
        {
            Message theMessage=iter.next();
            Messages+="Message ID: "+theMessage.getMesage_id()+"\n"+
            "From: "+theMessage.getSenderName()+"\n"+
            "To : "+theMessage.getReceiverName()+"\n"+
            "Message: "+theMessage.getContent()+"\n\n";

        }
        history+="You have display inbox\n";
        return Messages;
    }

    /**
     * This function represent for add new interaction
     * @param obj interaction to add
     */
    private void add_interaction(Interaction obj)
    {
        interactions.addLast(obj);
    }
    
    /**
     * for login 
     */
    public void login()
    {
        is_loge=true;
    }

    /**
     * for logout
     */
    public void logout()
    {
        is_loge=false;
    }

    /**
     * This function represent for control is user blocked or not
     * @param user_name
     * @return true if user has banned
     */
    private boolean is_banned(String user_name)
    {
        ListIterator<String> temPBanned=Ban.listIterator();
        while(temPBanned.hasNext())
        {
            String user=temPBanned.next();
            if(user.equals(user_name))
                return true;
        }
        return false;
    }

    /**
     * this methode represent for the return hisstory of the account
     * @return history of the account
     */
    public String getHistory()
    {
        return history;
    }

}
