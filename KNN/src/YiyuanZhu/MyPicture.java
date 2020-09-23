package YiyuanZhu;

import java.util.Arrays;

public class MyPicture {
    int[] args = new int[784];
    int num;

    public MyPicture() {
    }

    public MyPicture(int[] args) {
        this.args = args;
    }

    public MyPicture(int[] args, int num) {
        this.args = args;
        this.num = num;
    }

    @Override
    public String toString() {
        return "MyPicture{" +
                "args=" + Arrays.toString(args) +
                ", num=" + num +
                '}';
    }
}
