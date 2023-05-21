import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting...");
        Sort s = new Sort();
        int NUMITER = 100;
        int size = 500000;
        Random randomGen = new Random();
        //manually change the k, due to the limited capacity of the laptop
        /*for (int k = 1; k < 4; k++) {
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
                System.out.println("repetition: " +NUMITER+ ", size of numbers: " + upperBound + ", base: "+ base+ " avg: " + sum + " std deviation: "+ sum2);
            }
        }
    }*/
        int[] input_sizes = new int[]{10000, 50000, 100000, 500000, 1000000};
        for(int i = 0; i < input_sizes.length; i++) {
            //
            double[][] durationList = new double[6][NUMITER];
            for (int k = 0; k < 1; k++) {
                //NUMITER
                Integer[] array = new Integer[input_sizes[i]];
                for(int j = 0 ; j < input_sizes[i]; j++){
                    array[j]= (Integer)(Math.abs(randomGen.nextInt()));
                }
                
                long startTime, endTime;
                for (int j = 3; j < 5; j++) {
                    if (j == 0) {
                        int[] b = new int[input_sizes[i]];
                        for (int l = 0; l < input_sizes[i]; l++) {
                            b[l] = array[l];
                        }                        
                        startTime = System.currentTimeMillis();
                        Sort.radixSort(b, 32768);
                        endTime = System.currentTimeMillis();
                        durationList[j][k] = (double) (endTime - startTime);
                    } else {
                        Integer[] b = new Integer[input_sizes[i]];
                        for (int l = 0; l < input_sizes[i]; l++) {
                            b[l] = array[l];
                        }
                        
                        if (j == 1) {
                            startTime = System.currentTimeMillis();
                            s.mergeSortIterative(b);
                            endTime = System.currentTimeMillis();
                            durationList[j][k] = (double) (endTime - startTime);
                        }
                        if (j == 2) {
                            startTime = System.currentTimeMillis();
                            s.mergeSortRecursive(b);
                            endTime = System.currentTimeMillis();
                            durationList[j][k] = (double) (endTime - startTime);
                        }
                        if ((j == 3) ) {
                            startTime = System.currentTimeMillis();
                            s.quickSortClass(b);
                            endTime = System.currentTimeMillis();
                            durationList[j][k] = (double) (endTime - startTime);
                        }
                        if ((j == 4)) {
                            startTime = System.currentTimeMillis();
                            s.quickSortRecitation(b);
                            endTime = System.currentTimeMillis();
                            durationList[j][k] = (double) (endTime - startTime);
                        }

                        if (j == 5) {
                            startTime = System.currentTimeMillis();
                            Arrays.sort(b);
                            endTime = System.currentTimeMillis();
                            durationList[j][k] = (double) (endTime - startTime);
                        }
                    }
                }
            }
            double[] iterresults = new double[6];
            double[] averages = new double[6];
            for(int k = 0; k < NUMITER; k++){
                for(int j = 0; j < 6; j ++){
                    averages[j]+=durationList[j][k];
                }
            }
            for(int j = 0; j < 6; j++){
                averages[j]/=NUMITER;
            }
            for(int k = 0; k< NUMITER; k++){
                for(int j= 0; j < 6; j++){
                    iterresults[j]+=(averages[j]-durationList[j][k])*(averages[j]-durationList[j][k]);
                }
            }
            for(int j = 0; j < 6; j++){
                iterresults[j]/=NUMITER;
                iterresults[j]=Math.sqrt(iterresults[j]);
            }
            for(int j = 0; j < 6; j ++){
                System.out.println("For "+ input_sizes[i]+ " inputs, the "+ j+ "th algorithm has the avg running time of " + averages[j] + " the std deviation is "+ iterresults[j]);
            }
            System.out.println();
        }
        }
    }

