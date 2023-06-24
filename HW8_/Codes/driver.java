public class driver {

    public static void main(String[] args) {
        Map map01=new Map("sourceTxt/map01.txt");
        Map map02=new Map("sourceTxt/map02.txt");
        Map map03=new Map("sourceTxt/map03.txt");
        Map map04=new Map("sourceTxt/map04.txt");
        Map map05=new Map("sourceTxt/map05.txt");
        Map map06=new Map("sourceTxt/map06.txt");
        Map map07=new Map("sourceTxt/map07.txt");
        Map map08=new Map("sourceTxt/map08.txt");
        Map map09=new Map("sourceTxt/map09.txt");
        Map map10=new Map("sourceTxt/map10.txt");
        Map pisa=new Map("sourceTxt/pisa.txt");
        Map tokyo=new Map("sourceTxt/tokyo.txt");
        Map triumph=new Map("sourceTxt/triumph.txt");
        Map vatican=new Map("sourceTxt/vatican.txt");

        Graph grap01=new Graph(map01);
        Graph grap02=new Graph(map02);
        Graph grap03=new Graph(map03);
        Graph grap04=new Graph(map04);
        Graph grap05=new Graph(map05);
        Graph grap06=new Graph(map06);
        Graph grap07=new Graph(map07);
        Graph grap08=new Graph(map08);
        Graph grap09=new Graph(map09);
        Graph grap10=new Graph(map10);
        Graph grappisa=new Graph(pisa);
        Graph graptokyo=new Graph(tokyo);
        Graph graptriumph=new Graph(triumph);
        Graph grapvatican=new Graph(vatican);

        Graph _grap01=new Graph(map01);
        Graph _grap02=new Graph(map02);
        Graph _grap03=new Graph(map03);
        Graph _grap04=new Graph(map04);
        Graph _grap05=new Graph(map05);
        Graph _grap06=new Graph(map06);
        Graph _grap07=new Graph(map07);
        Graph _grap08=new Graph(map08);
        Graph _grap09=new Graph(map09);
        Graph _grap10=new Graph(map10);
        Graph _grappisa=new Graph(pisa);
        Graph _graptokyo=new Graph(tokyo);
        Graph _graptriumph=new Graph(triumph);
        Graph _grapvatican=new Graph(vatican);
        BFS bfs1=new BFS(_grap01);
        BFS bfs2=new BFS(_grap02);
        BFS bfs3=new BFS(_grap03);
        BFS bfs4=new BFS(_grap04);
        BFS bfs5=new BFS(_grap05);
        BFS bfs6=new BFS(_grap06);
        BFS bfs7=new BFS(_grap07);
        BFS bfs8=new BFS(_grap08);
        BFS bfs9=new BFS(_grap09);
        BFS bfs10=new BFS(_grap10);
        BFS bfs11=new BFS(_grappisa);
        BFS bfs12=new BFS(_graptokyo);
        BFS bfs13=new BFS(_graptriumph);
        BFS bfs14=new BFS(_grapvatican);
        Dijkstra Dijkstra1=new Dijkstra(grap01);
        Dijkstra Dijkstra2=new Dijkstra(grap02);
        Dijkstra Dijkstra3=new Dijkstra(grap03);
        Dijkstra Dijkstra4=new Dijkstra(grap04);
        Dijkstra Dijkstra5=new Dijkstra(grap05);
        Dijkstra Dijkstra6=new Dijkstra(grap06);
        Dijkstra Dijkstra7=new Dijkstra(grap07);
        Dijkstra Dijkstra8=new Dijkstra(grap08);
        Dijkstra Dijkstra9=new Dijkstra(grap09);
        Dijkstra Dijkstra10=new Dijkstra(grap10);
        Dijkstra Dijkstra11=new Dijkstra(grappisa);
        Dijkstra Dijkstra12=new Dijkstra(graptokyo);
        Dijkstra Dijkstra13=new Dijkstra(graptriumph);
        Dijkstra Dijkstra14=new Dijkstra(grapvatican);
        
        
        System.out.println("BFS algorithm is performing on txt file Then it draw line for determined path ");
        System.out.println("======================================================");
        
        bfs1.findPath();
        System.out.println("Lengh of BST for "+_grap01.getFileName()+" is "+bfs1.getLength());
        bfs2.findPath();
        System.out.println("Lengh of BST for "+_grap02.getFileName()+" is "+bfs2.getLength());
        bfs3.findPath();
        System.out.println("Lengh of BST for "+_grap03.getFileName()+" is "+bfs3.getLength());
        bfs4.findPath();
        System.out.println("Lengh of BST for "+_grap04.getFileName()+" is "+bfs4.getLength());
        bfs5.findPath();
        System.out.println("Lengh of BST for "+_grap05.getFileName()+" is "+bfs5.getLength());
        bfs6.findPath();
        System.out.println("Lengh of BST for "+_grap06.getFileName()+" is "+bfs6.getLength());
        bfs7.findPath();
        System.out.println("Lengh of BST for "+_grap07.getFileName()+" is "+bfs7.getLength());
        bfs8.findPath();
        System.out.println("Lengh of BST for "+_grap08.getFileName()+" is "+bfs8.getLength());
        bfs9.findPath();
        System.out.println("Lengh of BST for "+_grap09.getFileName()+" is "+bfs9.getLength());
        bfs10.findPath();
        System.out.println("Lengh of BST for "+_grap10.getFileName()+" is "+bfs10.getLength());
        bfs11.findPath();
        System.out.println("Lengh of BST for "+_grappisa.getFileName()+" is "+bfs11.getLength());
        bfs12.findPath();
        System.out.println("Lengh of BST for "+_graptokyo.getFileName()+" is "+bfs12.getLength());
        bfs13.findPath();
        System.out.println("Lengh of BST for "+_graptriumph.getFileName()+" is "+bfs13.getLength());
        bfs14.findPath();
        System.out.println("Lengh of BST for "+_grapvatican.getFileName()+" is "+bfs14.getLength());
        System.out.println("======================================================");
        System.out.println("Dijkstra algorithm is performing on txt file Then it draw line for determined path ");
        System.out.println("*******************************************");
        
        Dijkstra1.findPath();
        System.out.println("Lengh of Dijkstra for "+grap01.getFileName()+" is "+Dijkstra1.getLength());
        Dijkstra2.findPath();
        System.out.println("Lengh of Dijkstra for "+grap02.getFileName()+" is "+Dijkstra2.getLength());
        Dijkstra3.findPath();
        System.out.println("Lengh of Dijkstra for "+grap03.getFileName()+" is "+Dijkstra3.getLength());
        Dijkstra4.findPath();
        System.out.println("Lengh of Dijkstra for "+grap04.getFileName()+" is "+Dijkstra4.getLength());
        Dijkstra5.findPath();
        System.out.println("Lengh of Dijkstra for "+grap05.getFileName()+" is "+Dijkstra5.getLength());
        Dijkstra6.findPath();
        System.out.println("Lengh of Dijkstra for "+grap06.getFileName()+" is "+Dijkstra6.getLength());
        Dijkstra7.findPath();
        System.out.println("Lengh of Dijkstra for "+grap07.getFileName()+" is "+Dijkstra7.getLength());
        Dijkstra8.findPath();
        System.out.println("Lengh of Dijkstra for "+grap08.getFileName()+" is "+Dijkstra8.getLength());
        Dijkstra9.findPath();
        System.out.println("Lengh of Dijkstra for "+grap09.getFileName()+" is "+Dijkstra9.getLength());
        Dijkstra10.findPath();
        System.out.println("Lengh of Dijkstra for "+grap10.getFileName()+" is "+Dijkstra10.getLength());
        Dijkstra11.findPath();
        System.out.println("Lengh of Dijkstra for "+grappisa.getFileName()+" is "+Dijkstra11.getLength());
        Dijkstra12.findPath();
        System.out.println("Lengh of Dijkstra for "+graptokyo.getFileName()+" is "+Dijkstra12.getLength());
        Dijkstra13.findPath();
        System.out.println("Lengh of Dijkstra for "+graptriumph.getFileName()+" is "+Dijkstra13.getLength());
        Dijkstra14.findPath();
        System.out.println("Lengh of Dijkstra for "+grapvatican.getFileName()+" is "+Dijkstra14.getLength());
        System.out.println("*******************************************");
        

        
    }
}
