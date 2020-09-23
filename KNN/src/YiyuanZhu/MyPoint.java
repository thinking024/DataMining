package YiyuanZhu;

public class MyPoint {
    int x;
    int y;
    String type;

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", type='" + type + '\'' +
                '}';
    }

    public MyPoint(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MyPoint() {
    }
}

