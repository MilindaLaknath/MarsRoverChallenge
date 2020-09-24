package repo;

public class Plateau {

    private int upperX;
    private int upperY;
    private int lowerX;
    private int lowerY;

    public Plateau (int x, int y){
        this.upperX = x;
        this.upperY = y;
        this.lowerX = 0;
        this.lowerY = 0;
    }

    public int getUpperX() {
        return upperX;
    }

    public int getUpperY() {
        return upperY;
    }

    public int getLowerX() {
        return lowerX;
    }

    public int getLowerY() {
        return lowerY;
    }
}
