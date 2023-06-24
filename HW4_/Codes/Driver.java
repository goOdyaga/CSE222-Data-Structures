public class Driver {

    public static void main(String[] args) {
       int []demoninations= {4,17,29};

        System.out.println("SECURITY SYSTEM");
        System.out.println("\nusername=\"\" password1=\"{[(abacaba)]}\" password2=\"75\" demoninations=\"{4 ,17,29}\"\n");
        System.out.println(" "+Check.CheckInformation("gizem", "recaecare", 54, demoninations));
        System.out.println("\nusername=\"h1mza\" password1=\"{[(abacaba)]}\" password2=\"75\" demoninations=\"{4 ,17,29}\"\n");
        System.out.println(" "+Check.CheckInformation("h1mza", "{[(abacaba)]}", 75, demoninations));
        System.out.println("\nusername=\"1hamza\" password1=\"{[(abacaba)]}\" password2=\"75\" demoninations=\"{4 ,17,29}\"\n");
        System.out.println(" "+Check.CheckInformation("1hamza","{[(abacaba)]}" , 75, demoninations));
        System.out.println("\nusername=\"hamz+\" password1=\"{[(abacaba)]}\" password2=\"75\" demoninations=\"{4 ,17,29}\"\n");
        System.out.println(" "+Check.CheckInformation("hamz+", "{[(abacaba)]}", 75, demoninations));
        System.out.println("\nusername=\"*amza\" password1=\"{[(abacaba)]}\" password2=\"75\" demoninations=\"{4 ,17,29}\"\n");
        System.out.println(" "+Check.CheckInformation("*amza","{[(abacaba)]}" , 75, demoninations));
        System.out.println("\nusername=\"hamza\" password1=\"{[(abacaba)]}\" password2=\"75\" demoninations=\"{4 ,17,29}\"\n");
        System.out.println(" "+Check.CheckInformation("hamza", "{[(abacaba)]}", 75, demoninations));
        System.out.println("\nusername=\"kerem\" password1=\"{[(abacaba)]}\" password2=\"75\" demoninations=\"{4 ,17,29}\"\n");
        System.out.println(" "+Check.CheckInformation("kerem","{[(abacaba)]}" , 75, demoninations));
        System.out.println("\nusername=\"hamza\" password1=\"{[(abacaba)]}\" password2=\"75\" demoninations=\"{4 ,17,29}\"\n");
        System.out.println(" "+Check.CheckInformation("hamza","{[(abacaba)]}" , 75, demoninations));
        System.out.println("\nusername=\"hamza\" password1=\"{ab[bac]caba}\" password2=\"75\" demoninations=\"{4 ,17,29}\"\n");
        System.out.println(" "+Check.CheckInformation("hamza","{ab[bac]caba}" , 75, demoninations));
        System.out.println("\nusername=\"hamza\" password1=\")abc(cba\" password2=\"75\" demoninations=\"{4 ,17,29}\"\n");
        System.out.println(" "+Check.CheckInformation("hamza",")abc(cba" , 75, demoninations));
        System.out.println("\nusername=\"hamza\" password1=\"a]bcd(cb)a\" password2=\"75\" demoninations=\"{4 ,17,29}\"\n");
        System.out.println(" "+Check.CheckInformation("hamza","a]bcd(cb)a" , 75, demoninations));
        System.out.println("\nusername=\"hamza\" password1=\"[a]bcd(cb)a\" password2=\"75\" demoninations=\"{4 ,17,29}\"\n");
        System.out.println(" "+Check.CheckInformation("hamza","[a]bcd(cb)a" , 75, demoninations));
        System.out.println("\nusername=\"hamza\" password1=\"{[(ecarcar)]}\" password2=\"75\" demoninations=\"{4 ,17,29}\"\n");
        System.out.println(" "+Check.CheckInformation("hamza","{[(ecarcar)]}" , 75, demoninations));
        System.out.println("\nusername=\"hamza\" password1=\"{ab[bac]aaba}\" password2=\"75\" demoninations=\"{4 ,17,29}\"\n");
        System.out.println(" "+Check.CheckInformation("hamza","{ab[bac]aaba}" , 75, demoninations));
        System.out.println("\nusername=\"hamza\" password1=\"{(abba)cac}\" password2=\"75\" demoninations=\"{4 ,17,29}\"\n");
        System.out.println(" "+Check.CheckInformation("hamza","{(abba)cac}" , 75, demoninations));
        System.out.println("\nusername=\"hamza\" password1=\"{(abba)cac}\" password2=\"75\" demoninations=\"{4 ,17,29}\"\n");
        System.out.println(" "+Check.CheckInformation("hamza","{(abba)cac}" , 75, demoninations));
        System.out.println("\nusername=\"hamza\" password1=\"{(abba)cac}\" password2=\"74\" demoninations=\"{4 ,17,29}\"\n");
        System.out.println(" "+Check.CheckInformation("hamza","{(abba)cac}" , 74, demoninations));
        System.out.println("\nusername=\"hamza\" password1=\"{(abba)cac}\" password2=\"35\" demoninations=\"{4 ,17,29}\"\n");
        System.out.println(" "+Check.CheckInformation("hamza","{(abba)cac}" , 35, demoninations));
        System.out.println("\nusername=\"hamza\" password1=\"{(abba)cac}\" password2=\"54\" demoninations=\"{4 ,17,29}\"\n");
        System.out.println(" "+Check.CheckInformation("hamza","{(abba)cac}" ,54 , demoninations));
        

    }    
}
 