package YiyuanZhu;

public class Main {
    public static void main(String[] args) {

        // TODO 改为相对位置
        final String TRAIN_IMAGES_FILE = "KNN/data/train-images-idx3-ubyte/train-images.idx3-ubyte";
        final String TRAIN_LABELS_FILE = "KNN/data/train-labels-idx1-ubyte/train-labels.idx1-ubyte";

        final String TEST_IMAGES_FILE = "KNN/data/t10k-images-idx3-ubyte/t10k-images.idx3-ubyte";
        final String TEST_LABELS_FILE = "KNN/data/t10k-labels-idx1-ubyte/t10k-labels.idx1-ubyte";

        int[][] trainImages = MnistRead.getImages(TRAIN_IMAGES_FILE);
        int[] trainLabels = MnistRead.getLabels(TRAIN_LABELS_FILE);

        int[][] testImages = MnistRead.getImages(TEST_IMAGES_FILE);
        int[] testLabels = MnistRead.getLabels(TEST_LABELS_FILE);

        for (int k = 1; k <= 30; k++) {
            int count = 0;
            for (int i = 0; i < testImages.length; i++) {
                int myLabel = KnnForMnist.knn(trainImages, trainLabels, testImages[i],k);
                if (myLabel == testLabels[i]) {
                    count ++;
                }
            }
            System.out.println("k=" + k + ", count=" + count);
        }
//        System.out.println(KnnForMnist.knn(trainImages, trainLabels, testImages[1], 10));
        /*for (int i = 0; i < trainImages.length; i++) {
            drawGrayPicture(trainImages[i],28,28,"E:\\Java_program\\DataMining\\KNN\\images\\training_set\\training_set" + i + ".jpeg");
        }*/
        /*for (int i = 0; i < testImages.length; i++) {
            drawGrayPicture(testImages[i],28,28,"E:\\Java_program\\DataMining\\KNN\\images\\testing_set\\testing_set" + i + ".jpeg");
        }*/
    }
}
