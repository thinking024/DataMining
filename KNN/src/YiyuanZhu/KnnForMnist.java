package YiyuanZhu;

import java.util.*;
// TODO 修改函数名
public class KnnForMnist {
    public static int knn(int[][] trainImages, int[] trainLabels, int[] testImage, int k) {
        int[] count = new int[10];
        int[] myLabels = new int[10000];
        HashMap<MyPicture, Double> hashMap = new HashMap<>();

        // 6万张图片，每张图片的数据都是一个一维数组
        for (int i = 0; i < trainImages.length; i++) {
            double distance = 0.00;
            MyPicture myPicture = new MyPicture(trainImages[i],trainLabels[i]);
            for (int j = 0; j < myPicture.args.length; j++) {
                distance = distance + (myPicture.args[j] - testImage[j]) * (myPicture.args[j] - testImage[j]);
            }
            hashMap.put(myPicture,distance);
        }

        // TODO map存进来的数据有问题，导致后续排序出问题 控制台不够大
//        System.out.println(hashMap.size());
//        hashMap.forEach((key,value) -> System.out.println(key + "  dis=" + value));

        List<Map.Entry<MyPicture, Double>> list = new ArrayList<>(hashMap.entrySet());
        Comparator<Map.Entry<MyPicture, Double>> valueComparator = new Comparator<Map.Entry<MyPicture, Double>>() {
            @Override
            public int compare(Map.Entry<MyPicture, Double> o1, Map.Entry<MyPicture, Double> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        };

        Collections.sort(list,valueComparator);
        for (int i = 0; i < k; i++) {
            Map.Entry<MyPicture, Double> entry = list.get(i);
            count[entry.getKey().num] ++;
        }

        int label = 0;
        int max = count[0];
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                label = i;
            }
        }
//       System.out.println(label);

        return label;
    }
}
