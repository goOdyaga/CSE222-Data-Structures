package homework3;


/**
 * This Class Represent for share post like or comment post or send message to other user 
 * @author HAMZA KONAÇ
 * @since 10.03.2023
 * @version V 1.2
 */
public class Account {
    
    private Post[] Posts= new Post[0];
    private String[] follower= new String[0];
    private String[] following= new String[0];
    private String[] Ban= new String[0];
    private Message[] Inbox= new Message[0];
    private Message[] out_BOX= new Message[0];
    private Interaction[] interactions=new Interaction[0];
    private String USER_NAME;
    private String location;
    private String Birthday;
    private boolean is_loge;
    private int Account_ID;
    
    /**
     * This funcciton represent for show user profile
     */
    @Override
    public String toString() {
        String followerr="";
        for(int i=0;i<follower.length;i++)
        followerr+=follower[i]+" ";
        String followingg="";
        for(int i=0;i<following.length;i++)
        followingg+=following[i]+" ";
        return "User ID: "+Account_ID+"\n"+
        "Username: "+USER_NAME+"\n"+
        "Location: "+location+"\n"+
        "Birth Date: "+Birthday+"\n"+
        USER_NAME+" is following "+following.length+" Account(s) and has "+follower.length+" follower\n"+
        USER_NAME+" is following "+followingg+" \n"+
        USER_NAME+" has followed by "+followerr+" \n"+
        USER_NAME+" has "+Posts.length+" post \n";
        
        
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
    private Post[] getPosts() {
        return Posts;
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
        return follower.length;
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
        return following.length;
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
        return Inbox.length;
        // return "There is/are "+Inbox.length+" message in Inbox";
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
        return out_BOX.length;
        // return "There is/are "+out_BOX.length+" message in outbox";

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
        return Ban.length;
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
        return Posts.length;
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
                for(int i=0;i<follower.length;i++)
                {
                    if(follower[i].equals(temp.getUSER_NAME()))
                       throw new Already_exist("This Account has already been in followers");
                    if(temp.is_banned(USER_NAME))
                        throw new BLOCKED("There is no user has this name...");
                }
                String [] new_follower=new String[follower.length+1];
                int i;
                for( i=0;i<follower.length;i++)
                    new_follower[i]=follower[i];
                new_follower[i]=temp.getUSER_NAME();
                follower=new_follower;
                temp.logout();
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
                for(int i=0;i<follower.length;i++)
                {
                    if(temp.getUSER_NAME().equals(follower[i]))
                    {
                        String [] new_follower=new String[follower.length-1];
                        int counter=-1;
                        for(int j=0;j<follower.length;j++)
                        {
                            if(i!=j)
                                new_follower[++counter]=follower[j];
                        }
                        follower=new_follower;
                        if(delete_following(temp))
                        {
                            temp.logout();
                            return true;
                        }
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
        try {
            if(temp!=null)
            {
                temp.login();
                if(temp.is_banned(USER_NAME))
                    throw new BLOCKED("There is no user such this name");
                for(int i=0;i<following.length;i++)
                {
                    if(following[i].equals(temp.getUSER_NAME()))
                       throw new Already_exist("This Account has already followed");
                }
                String [] new_following=new String[following.length+1];
                int i;
                for( i=0;i<following.length;i++)
                    new_following[i]=following[i];
                new_following[i]=temp.getUSER_NAME();
                following=new_following;
                if(temp.add_follower(this))
                {
                    temp.logout();
                    this.login();
                    return true;
                }
            }
            throw new NOT_exist("There is no Account that has this user_name");
        } catch (EXCEPTIONS e) {
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
                for(int i=0;i<following.length;i++)
                {
                    if(temp.getUSER_NAME().equals(following[i]))
                    {
                        String [] new_following=new String[following.length-1];
                        int counter=-1;
                        for(int j=0;j<following.length;j++)
                        {
                            if(i!=j)
                                new_following[++counter]=follower[j];
                        }
                        following=new_following;
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
        Post [] new_posts=new Post[Posts.length+1];
        for(int i=0;i<Posts.length;i++)
            new_posts[i]=Posts[i];
        new_posts[Posts.length]=new_post;
        Posts=new_posts;
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
            for(int i=0;i<Posts.length;i++)
            {
                if(delete_post.equals(Posts[i]))
                {
                    Post [] new_posts=new Post[Posts.length-1];
                    int counter=-1;
                    for(int j=0;j<Posts.length;j++)
                        if(j!=i)
                            new_posts[++counter]=Posts[j];
                    Posts=new_posts;
                    return true;   
                }
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
                if(temp.is_banned(USER_NAME))
                    throw new BLOCKED();
                for(int i=0;i<Ban.length;i++)
                    if(Ban[i].equals(temp.getUSER_NAME()))
                        throw new Already_exist("This Account has already Banned");
                String [] new_ban=new String[Ban.length+1];
                int i;
                for( i=0;i<Ban.length;i++)
                    new_ban[i]=Ban[i];
                new_ban[i]=temp.getUSER_NAME();
                Ban=new_ban;
                delete_follower(temp);/*remove user from follower list and following list */
                temp.logout();
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
                for(int i=0;i<Ban.length;i++)
                {
                    if(Ban[i].equals(temp.getUSER_NAME()))
                    {
                        String [] new_banned=new String[Ban.length-1];
                        int counter=-1;
                        for( int j=0;j<Ban.length;j++)
                            if(i!=j)
                                new_banned[++counter]=Ban[j];
                        Ban=new_banned;
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
                if(temp.is_banned(USER_NAME))
                        throw new BLOCKED();
                for(int j=0;j<following.length;j++)
                {
                    if(temp.getUSER_NAME().equals(following[j]))
                    {
                        Message [] new_out_box = new Message[out_BOX.length+1];
                        for(int i=0;i<out_BOX.length;i++)
                            new_out_box[i]=out_BOX[i];
                        new_out_box[out_BOX.length]=out_message;
                        out_BOX=new_out_box;
                        if(temp.add_inbox( out_message))
                        {
                            temp.logout();
                            return true;
                        }
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
                for(int i=0;i<out_BOX.length;i++)
                {
                    if(out_message.equals(out_BOX[i]))
                    {
                        Message [] new_out_box = new Message[out_BOX.length-1];
                        int counter=-1;
                        for(int j=0;j<out_BOX.length;j++)
                        {
                            if(j!=i)
                                new_out_box[++counter]=out_BOX[i];
                        }
                        out_BOX=new_out_box;
                        return true;

                    }
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
        
            
                Message [] new_in_box = new Message[Inbox.length+1];
                for(int i=0;i<Inbox.length;i++)
                    new_in_box[i]=Inbox[i];
                new_in_box[Inbox.length]=get_message;
                Inbox=new_in_box;
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
             
                for(int i=0;i<Inbox.length;i++)
                {
                    if(delete_message.equals(Inbox[i]))
                    {
                        Message [] new_in_box = new Message[Inbox.length-1];
                        int counter=-1;
                        for(int j=0;j<out_BOX.length;j++)
                        {
                            if(j!=i)
                                new_in_box[++counter]=out_BOX[i];
                        }
                        Inbox=new_in_box;
                        return true;

                    }
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
                    Post temp_post=temp.getPosts()[post_ID];
                    temp_post.increase_like(USER_NAME);
                    temp.add_interaction(temp_post.getLike_array(temp_post.get_like_number()-1));
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
                if(post_ID>0&&post_ID<temp.get_post_number())
                {
                    Post temp_post=temp.getPosts()[post_ID];
                    temp_post.delete_like(USER_NAME);
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
                            Post temp_post=temp.getPosts()[post_ID];
                            temp_post.insert_comment(USER_NAME, Content, post_ID);
                            temp.add_interaction(temp_post.getComments(temp_post.getCommnet_number()-1));
                           
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
                for(int i=0;i<temp.Posts.length;i++)
                {
                    System.out.println("Post ID :"+i+" "+USER_NAME+": " +temp.Posts[i].get_content_of_post()+" \n ");
                }
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
                boolean no_interaction=true;
                for(int j=0;j<temp.get_post_number();j++)
                {
                    System.out.println("(Post ID) : " +(j)+" :"+temp.getPosts()[j].get_content_of_post());
                    for(int i=0;i<temp.interactions.length;i++)
                    {
                        if(j==temp.interactions[i].getPost_ID())
                        {
                            no_interaction=false;
                            System.out.println(temp.interactions[i].toString());
                            if(temp.Posts[j].get_like_number()==0)
                                System.out.println("There isn't any like for this post");
                            if(temp.Posts[j].getCommnet_number()==0)
                                System.out.println("There isn't any commnet for this post");
                        }
                    }
                    if(no_interaction)
                    {
                        System.out.println("There isn't any like for this post");
                        System.out.println("There isn't any commnet for this post");

                    }
                    no_interaction=true;
                }
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
                System.out.println(temp.toString());
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
        for(int i=0;i<Inbox.length;i++)
            Messages+="Message ID: "+Inbox[i].getMesage_id()+"\n"+
            "From: "+Inbox[i].getSenderName()+"\n"+
            "To : "+Inbox[i].getReceiverName()+"\n"+
            "Message: "+Inbox[i].getContent()+"\n\n";
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
        for(int i=0;i<Inbox.length;i++)
            if(Inbox[i].getSenderName().equals(username))
                Messages+="Message ID: "+Inbox[i].getMesage_id()+"\n"+
                "From: "+Inbox[i].getSenderName()+"\n"+
                "To : "+Inbox[i].getReceiverName()+"\n"+
                "Message: "+Inbox[i].getContent()+"\n\n";
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
        for(int i=0;i<out_BOX.length;i++)
            Messages+="Message ID: "+out_BOX[i].getMesage_id()+"\n"+
            "From: "+out_BOX[i].getSenderName()+"\n"+
            "To : "+out_BOX[i].getReceiverName()+"\n"+
            "Message: "+out_BOX[i].getContent()+"\n\n";
        return Messages;
    }

    /**
     * This function represent for add new interaction
     * @param obj interaction to add
     */
    private void add_interaction(Interaction obj)
    {
        Interaction []new_Interaction=new Interaction[interactions.length+1];
        for(int i=0;i<interactions.length;i++)
            new_Interaction[i]=interactions[i];
        new_Interaction[interactions.length]=obj;
        interactions=new_Interaction; 

    }
    
    /**
     * for login 
     */
    public void login()
    {
        is_loge=true;
    }

    /**
     * for logou
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
        for(int i=0;i<Ban.length;i++)
            if(Ban[i].equals(user_name))
                return true;
        return false;
    }

}
