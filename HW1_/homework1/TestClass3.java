package homework1;


// import homework1.Account.*;
public class TestClass3 {
    public static void main(String []args)
    {
        System.out.println("SCENARIO 1\n");
        System.out.println("Step 1... Creating accounts...\nAn account with username gizemsungu has been created.\nAn account with username sibelgulmez has been created.\nAn account with username gokhankaya has been created.\n\n");
        Account account1=new Account("gizemsungu", "van", "10.03.2001",0);
        Account account2=new Account("sibelgulmez", "bitlis", "10.03.2002",1);
        Account account3=new Account("gokhankaya", "adana", "10.03.2003",2);
        System.out.println("Step 2... Logging into an account (username: sibelgulmez)...\n");
        account2.login();
        System.out.println("Step 3... Sharing two post...\n");
        account2.new_post(new Post("sibelgulmez", 0, 1, "WORK HARD"));
        account2.new_post(new Post("sibelgulmez", 1, 1, "WORK too HARD"));
        System.out.println("--> \"gokhankaya\" share post(programe give error message)\n");
        account3.new_post(new Post("gokhankaya", 0, 3, "new post"));
        System.out.println("Step 4... Following gizemsungu and gokhankaya...\n");
        account2.new_following(account1);
        account2.new_following(account3);
        System.out.println("Step 5... Logging out from account 'sibelgulmez'...\n");
        account2.logout();
        System.out.println("Step 6... Logging into another account (username: gokhankaya)\n");
        account3.login();
        System.out.println("Step 7... Viewing sibelgulmez's profile...\n");
        account3.visit_profile(account2);
        System.out.println("Step 8... Viewing sibelgulmez'posts...\n");
        account3.get_post_information(account2);
        System.out.println("Step 9... Liking a post of sibelgulmez...\n");
        account3.like_post(account2, 0);
        System.out.println("Step 10... Adding a comment on a post of sibelgulmez...\n");
        account3.add_comment(account2, 0, "java nice data easy");
        System.out.println("-->\"gokhankaya\" send message to \"sibelgulmez\" (program give error message)\n");
        account3.add_outboux(account2, new Message("sibelgulmez", "gokhankaya", "java easy", 0));
        System.out.println("Step 11... Following sibelgulmez and gizemsungu...        \n");
        account3.new_following(account2);
        account3.new_following(account1);
        System.out.println("Step 12... Sending a message to gizemsungu...\n");
        account3.add_outboux(account1,new Message("gizemsungu", "gokhankaya", "slm", 0) );
        System.out.println("Step 13... Logging out from account 'gokhankaya'..        \n");
        account3.logout();
        System.out.println("Step 14... Logging into another account (username: gizemsungu)       \n");
        account1.login();
        System.out.println("Step 15... Checking outbox...        \n");
        System.out.println("There is/are "+account1.get_outbox_number()+" message in outbox");
        System.out.println("-->\"gokhankaya\"  view  \"sibelgulmez\" post(programe give error message)\n");
        account3.visit_profile(account2);
        System.out.println("Step 16... Checking inbox...        \n");
        System.out.println("There is/are "+account1.get_inbox_number()+" message in outbox");
        System.out.println("Step 17... Viewing inbox...\n");
        System.out.println(account1.get_In_messages());
        System.out.println("Step 18... Viewing sibelgulmez's profile...        \n");
        account1.visit_profile(account2);
        System.out.println("Step 19... Viewing sibelgulmez's posts...\n");
        account1.get_post_information(account2);
        System.out.println("Step 20... Viewing sibelgulmez's posts' interactions...        \n");
        account1.get_interaction_information(account2);
        System.out.println("Step 21... Liking sibelgulmez's posts...\n");
        account1.like_post(account2, 0);
        System.out.println("Step 22... Viewing sibelgulmez's posts' interactions..\n");
        account1.get_interaction_information(account2);
        account1.logout();



        System.out.println("\n\n\nSCENARIO 2\n");
        System.out.println("1. \"gizemsungu\" logs in.        \n");
        account1.login();
        System.out.println("\ta. shares a post (let's call it Post1).        \n");
        account1.new_post(new Post("gizemsungu", 0, 0, "post1"));
        System.out.println("\tb. shares another post (let's call it Post2).\n");
        account1.new_post(new Post("gizemsungu", 1, 0, "post2"));
        System.out.println("\tc. logs out.\n");
        account1.logout();
        System.out.println("2. \"sibelgulmez\" logs in.\n");
        account2.login();
        System.out.println("\ta. views the profile of \"gizemsungu\".\n");
        account2.visit_profile(account1);
        System.out.println("\tb. likes Post1.\n");
        account2.like_post(account1, 0);
        System.out.println("\tc. log out.\n");
        account2.logout();
        System.out.println("3. \"gokhankaya\" logs in.\n");
        account3.login();
        System.out.println("\ta. views the profile of \"gizemsungu\".\n");
        account3.visit_profile(account1);
        System.out.println("\tb. comments on Post2.\n");
        account3.add_comment(account1, 1, "NICE:)");
        System.out.println("\tc. sends a message to \"gizemsungu\"\n");
        account3.add_outboux(account1,new Message("gizemsungu", "gokhankaya", "Hello!", 1));
        System.out.println("\td. log out.\n");
        account3.logout();
        System.out.println("1. \"gizemsungu\" logs in.        \n");
        account1.login();
        System.out.println("\ta. views her own profile.\n");
        account1.visit_profile(account1);
        System.out.println("\tb. reads the message from \"gokhankaya\"\n");
        System.out.println(account1.get_In_messages("gokhankaya"));


        System.out.println("\n\n\nSCENARIO 3\n");
        System.out.println("1. \"gizemsungu\" logs in.        \n");
        account1.login();
        System.out.println("\ta.blocks \"sibelgulmez\". \n");
        account1.add_ban(account2);
        System.out.println("\tb. logs out.\n");
        account1.logout();
        System.out.println("2. \"sibelgulmez\" logs in.\n");
        account2.login();
        System.out.println("\ta. tries to view the profile of \"gizemsungu\".\n");
        account2.visit_profile(account1);
        System.out.println("\tb. tries to send a message to \"gizemsungu\".\n");
        account2.add_outboux(account1,new Message("gizemsungu", "sibelgulmez", "HI!!", 2));
        System.out.println("\tc. logs out.\n");
        account2.logout();
        System.out.println("3. \"gizemsungu\" logs in.        \n");
        account1.login();
        System.out.println("\ta. \"sibelgulmez\" remove \"gizemsungu\" from blocked account list\n");
        account1.delete_ban(account2);
        System.out.println("\tb. logs out.\n");
        account1.logout();
        System.out.println("4. \"sibelgulmez\" logs in.\n");
        account2.login();
        System.out.println("\ta. tries to view the profile of \"gizemsungu\".\n");
        account2.visit_profile(account1);
        System.out.println("\tb. tries to send a message to \"gizemsungu\".(CONTENT:HI!!)\n");
        account2.add_outboux(account1,new Message("gizemsungu", "sibelgulmez", "HI!!", 2));
        System.out.println("\n");
        account2.logout();
        account1.login();
        System.out.println("\n\ngizemsungu's inbox\n\n");
        System.out.println(account1.get_In_messages());
        account1.logout();
        
    }
}
