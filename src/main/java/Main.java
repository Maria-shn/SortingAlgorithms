import java.util.Random;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
       // radixTest();
        testAll(0);
        //testAll(1);
        //testAll(2);
        
    }


    public static void radixTest(){
        Sort s = new Sort();
        int NUMITER = 100;
        int size = 500000;
        Random randGen = new Random();
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
                        arr[i] = Math.abs(randGen.nextInt(upperBound));
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
                System.out.println("size of numbers: " + upperBound + ", base: "+ base+ " avg: " + sum + " std deviation: "+ sum2);
            
        }
    }
}
//@x=1 aarray needs to be sorted, if x=2 then reverse sorted
public static void testAll (int x){
    Sort s = new Sort();
        int NUMITER = 100;
        Random randomGen = new Random();
    
        int[] input_sizes = {10000, 50000, 100000, 500000, 1000000};
        System.out.println("Results:");
        for(int i = 0; i < input_sizes.length; i++) {
            double[][] durationList = new double[6][NUMITER];
            
            for (int k = 0; k < NUMITER; k++) {
    
                Integer[] array = new Integer[input_sizes[i]];
                for(int j = 0 ; j < input_sizes[i]; j++){
                    array[j]= (Integer)(Math.abs(randomGen.nextInt()));
                }
                
                long startTime, endTime;
                for (int j = 0; j < 5; j++) {              
                    if (j == 0) {   
                        int[] b = new int[input_sizes[i]];
                        for (int l = 0; l < input_sizes[i]; l++) {
                            b[l] = array[l];
                        }    
                        if(x == 1 || x==2){
                            Arrays.sort(b);
                        }  
                        if(x==2){
                            for(int l = 0; l< input_sizes[i]/2; l++){
                                int temp = b[l];
                                b[l]=b[input_sizes[i]-l-1];
                                b[input_sizes[i]-l-1]=temp;
                            }
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
                        if(x == 1 || x==2){
                            Arrays.sort(b);
                        }  
                        if(x==2){
                            for(int l = 0; l< input_sizes[i]/2; l++){
                                Integer temp = b[l];
                                b[l]=b[input_sizes[i]-l-1];
                                b[input_sizes[i]-l-1]=temp;
                            }
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
            double[] iterResults = new double[6];
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
                    iterResults[j]+=(averages[j]-durationList[j][k])*(averages[j]-durationList[j][k]);
                }
            }
            for(int j = 0; j < 6; j++){
                iterResults[j]/=NUMITER;
                iterResults[j]=Math.sqrt(iterResults[j]);
            }
            System.out.println();
            System.out.println("Input size: "+ input_sizes[i]);
            for(int j = 0; j < 6; j ++){
                System.out.println("Algorithm  "+ j+ " average of: " + averages[j] + " ,std deviation: "+ iterResults[j]);
            }
            System.out.println();
        }
}
    
    }

