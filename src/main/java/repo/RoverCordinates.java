package repo;

public class RoverCordinates {
    private int x;
    private int y;
    private char face;
    private String path;

    public RoverCordinates(int x, int y, char face, String path){
        this.setX(x);
        this.setY(y);
        this.setFace(face);
        this.setPath(path);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getFace() {
        return face;
    }

    public String getPath() {
        return path;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setFace(char face) {
        this.face = face;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
