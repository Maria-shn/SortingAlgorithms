import java.util.Random;

public class Main{
    public static void main(String[] args) {
        SortTest test = new SortTest();
        test.radixTest();
        //test.runPerformanceTests();
       /*System.out.println("Starting...");
        Sort s = new Sort();
        int NUMITER = 100;
        int size = 500000;
        Random randomGen = new Random();

        for (int k = 1; k < 4; k++) {
            for (int l = 0; l <= 6; l++) {
                int base = (int) Math.pow(2, 5 * l);
                if (l == 0) {
                    base = 2;
                }
                double[] avg = new double [NUMITER];
                int upperBound = (int) Math.pow(2, 10 * k);
                for (int i = 0; i < NUMITER; i++) {
                    int[] arr = new int[size];
                    for (int j = 0; j < size; j++) {
                        arr[i] = Math.abs(randomGen.nextInt(upperBound));
                    }
                    long startTime, endTime;
                    startTime = System.currentTimeMillis();
                    Sort.radixSort(arr, base);
                    endTime= System.currentTimeMillis();
                    avg[i]= (double)(endTime-startTime);
                }
                double sum = 0;
                double sum2 = 0;
                for(int i = 0; i < NUMITER; i++){
                    sum+=avg[i];
                }
                sum/=NUMITER;
                for (int i = 0; i < NUMITER; i++) {
                    sum2 += (sum-avg[i])*(sum-avg[i]);
                }
                sum2/=NUMITER;
                sum2=Math.sqrt(sum2);
                System.out.println("repetition: " +NUMITER+ ", size of numbers: " + upperBound + ", base: "+ base+ " avg: " + sum + "std deviation: "+ sum2);
            }
        }
    */
    
}
}
