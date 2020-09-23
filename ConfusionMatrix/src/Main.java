import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tp,fp,fn,tn;
        System.out.println("input tp fp fn tn");
        tp = scanner.nextInt();
        fp = scanner.nextInt();
        fn = scanner.nextInt();
        tn = scanner.nextInt();

        double precision = 1.00 * tp / (tp + fp);
        double recall = 1.00 * tp / (tp + fn);
        double f1_score = 2.00 * (precision * recall) / (precision + recall);
        System.out.println("precision is " + precision);
        System.out.println("recall is " + recall);
        System.out.println("f1 score is " + f1_score);
    }
}
//pig: 20 11 6 29
