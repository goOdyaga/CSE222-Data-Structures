public class Edge {
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + dest;
        result = prime * result + source;
        result = prime * result + weight;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Edge other = (Edge) obj;
        if (dest != other.dest)
            return false;
        if (source != other.source)
            return false;
        if (weight != other.weight)
            return false;
        return true;
    }
    private int dest;
    private int source;
    private int weight;
    private int X;
    private int Y;

    public Edge()
    {
        dest=-1;
        source=-1;
        weight=-1;
        X=-1;
        X=-1;
    }
    public Edge(int source, int dest, int weight,int x,int y) {
        this.dest = dest;
        this.source = source;
        this.weight = weight;
        X=x;
        Y=y;
    }
    public Edge(int source, int dest,int x,int y) {
        this.dest = dest;
        this.source = source;
        X=x;
        Y=y;
    }
    public int getDest() {
        return dest;
    }
    public int getSource() {
        return source;
    }
    public int getWeight() {
        return weight;
    }
    public int getX()
    {
        return X;
    }
    public int getY()
    {
        return Y;
    }

    

    
}
