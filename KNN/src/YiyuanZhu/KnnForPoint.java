package YiyuanZhu;

import java.util.*;
import java.util.Map;

public class KnnForPoint {
    public static void main(String[] args) {
        int k = 4;
        int count = 0;
        int[] counts = new int[4];
        String[] types = {"a","b","c","d"};
        HashMap<MyPoint, Integer> hashMap = new HashMap<>();
        MyPoint point = new MyPoint(5,5);
        MyPoint[] points = new MyPoint[7];
        points[0] = new MyPoint(10,3,"a");
        points[1] = new MyPoint(1,2,"a");
        points[2] = new MyPoint(2,5,"b");
        points[3] = new MyPoint(3,6,"a");
        points[4] = new MyPoint(8,2,"b");
        points[5] = new MyPoint(6,3,"c");
        points[6] = new MyPoint(7,1,"d");
        int[] dis = new int[7];
        for (int i = 0; i < dis.length; i ++) {
            dis[i] = (points[i].x - point.x) * (points[i].x - point.x) + (points[i].y - point.y) * (points[i].y - point.y);
            hashMap.put(points[i],dis[i]);
        }
//        hashMap.forEach((key,value) -> System.out.println(key + " " + value));
        List<Map.Entry<MyPoint, Integer>> list = new ArrayList<>(hashMap.entrySet());
        Comparator<Map.Entry<MyPoint, Integer>> valueComparator = new Comparator<Map.Entry<MyPoint, Integer>>() {
            @Override
            public int compare(Map.Entry<MyPoint, Integer> o1, Map.Entry<MyPoint, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        };

        Collections.sort(list,valueComparator);


        for (Map.Entry<MyPoint, Integer> e: list) {
            if (count == k) {
                break;
            }
            System.out.println(e.getKey()+":"+e.getValue());
            for (int i = 0; i < types.length; i++) {
                if (e.getKey().type.equals(types[i])) {
                    counts[i] ++;
                    break;
                }
            }
            count ++;
        }
        int max = counts[0];
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > max) {
                max = counts[i];
                index = i;
            }
        }
        System.out.println(types[index]);
    }
}
