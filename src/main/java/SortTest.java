import java.util.Arrays;
import java.util.Random;

public class SortTest {
    private static final int NUMITER = 100;
    private static final int[] inputSizes = {10000, 50000, 100000, 500000, 1000000};

    
    public void radixTest(){
        for (int t = 1; t <= 3; t++){
            int[][] durationList = new int[7][NUMITER];
            for (int i = 0; i < 100; i++) {
                System.out.println("i need this");
                int[] array = generateRandomArray(NUMITER, (int) Math.pow(2, t * 10));
                long startTime = 0;
                long endTime = 0;
                Sort sorter = new Sort();
                for (int p = 1; p <= 6; p++){
                    int[] intArr = Arrays.copyOf(array, array.length);
                    if(p==0){
                        startTime = System.currentTimeMillis();
                        sorter.radixSort(intArr, 2);
                        endTime = System.currentTimeMillis();
                    } else{
                        startTime = System.currentTimeMillis();
                        sorter.radixSort(intArr, (int) Math.pow(2, 5 * p));
                        endTime = System.currentTimeMillis();
                    }
                    durationList[p][i] = (int) (endTime - startTime);

                }
            }
            calculateStats(durationList);
        }
    }

    public void runPerformanceTests() {
        Sort sorter = new Sort();
        long startTime = 0;
        long endTime = 0;
        for (int size : inputSizes) {
            int[][] durationList = new int[6][NUMITER];

            // Random input test
            System.out.println("Random input - Size: " + size);
            for (int i = 0; i < NUMITER; i++) {
                Integer[] array = generateRandomArray(size);

                for (int algorithmIndex = 0; algorithmIndex < 5; algorithmIndex++) {
                    Integer[] copyArray = Arrays.copyOf(array, array.length);
                    
                    switch (algorithmIndex) {
                        case 0:
                            startTime = System.currentTimeMillis();
                            sorter.quickSortClass(copyArray);
                            endTime = System.currentTimeMillis();
                            break;
                        case 1:
                            startTime = System.currentTimeMillis();
                            sorter.quickSortRecitation(copyArray);
                            endTime = System.currentTimeMillis();
                            break;
                        case 2:
                            startTime = System.currentTimeMillis();
                            sorter.mergeSortRecursive(copyArray);
                            endTime = System.currentTimeMillis();
                            break;
                        case 3:
                            startTime = System.currentTimeMillis();
                            sorter.mergeSortIterative(copyArray);
                            endTime = System.currentTimeMillis();
                            break;
                        case 4:
                        int[] intArr = new int[array.length];
                        for(int j =0; j<array.length; j++){
                            intArr[j] = (int) array[j];
                        }
                            startTime = System.currentTimeMillis();
                            sorter.radixSort(intArr, (int) Math.pow(2, 20));
                            endTime = System.currentTimeMillis();
                            break;
                        case 5:
                            startTime = System.currentTimeMillis();
                            Arrays.sort(copyArray);
                            endTime = System.currentTimeMillis();
                            break;
                        
                    }
                    
                    durationList[algorithmIndex][i] = (int) (endTime - startTime);
                }
            }

            // Calculate average and standard deviation
            calculateStats(durationList);

            // Sorted inputs in increasing order test
            System.out.println("Sorted input (increasing order) - Size: " + size);
            for (int i = 0; i < NUMITER; i++) {
                Integer[] array = generateRandomArray(size);
                Arrays.sort(array);

                for (int algorithmIndex = 0; algorithmIndex < 6; algorithmIndex++) {
                    Integer[] copyArray = Arrays.copyOf(array, array.length);
                    switch (algorithmIndex) {
                        case 0:
                            startTime = System.currentTimeMillis();
                            sorter.quickSortClass(copyArray);
                            endTime = System.currentTimeMillis();
                            break;
                        case 1:
                            startTime = System.currentTimeMillis();
                            sorter.quickSortRecitation(copyArray);
                            endTime = System.currentTimeMillis();
                            break;
                        case 2:
                            startTime = System.currentTimeMillis();
                            sorter.mergeSortRecursive(copyArray);
                            endTime = System.currentTimeMillis();
                            break;
                        case 3:
                            startTime = System.currentTimeMillis();
                            sorter.mergeSortIterative(copyArray);
                            endTime = System.currentTimeMillis();
                            break;
                        case 4:
                        int[] intArr = new int[array.length];
                        for(int j =0; j<array.length; j++){
                            intArr[j] = (int) array[j];
                        }
                            startTime = System.currentTimeMillis();
                            sorter.radixSort(intArr, (int) Math.pow(2, 20));
                            endTime = System.currentTimeMillis();
                            break;
                        case 5:
                            startTime = System.currentTimeMillis();
                            Arrays.sort(copyArray);
                            endTime = System.currentTimeMillis();
                            break;
                        
                    }
                    durationList[algorithmIndex][i] = (int) (endTime - startTime);
                }
            }

            // Calculate average and standard deviation
            calculateStats(durationList);

            // Sorted inputs in decreasing order test
            System.out.println("Sorted input (decreasing order) - Size: " + size);
            for (int i = 0; i < NUMITER; i++) {
                Integer[] array = generateRandomArray(size);
                Arrays.sort(array);
                reverseArray(array);

                for (int algorithmIndex = 0; algorithmIndex < 6; algorithmIndex++) {
                    Integer[] copyArray = Arrays.copyOf(array, array.length);
                    switch (algorithmIndex) {
                        case 0:
                            startTime = System.currentTimeMillis();
                            sorter.quickSortClass(copyArray);
                            endTime = System.currentTimeMillis();
                            break;
                        case 1:
                            startTime = System.currentTimeMillis();
                            sorter.quickSortRecitation(copyArray);
                            endTime = System.currentTimeMillis();
                            break;
                        case 2:
                            startTime = System.currentTimeMillis();
                            sorter.mergeSortRecursive(copyArray);
                            endTime = System.currentTimeMillis();
                            break;
                        case 3:
                            startTime = System.currentTimeMillis();
                            sorter.mergeSortIterative(copyArray);
                            endTime = System.currentTimeMillis();
                            break;
                        case 4:
                        int[] intArr = new int[array.length];
                        for(int j =0; j<array.length; j++){
                            intArr[j] = (int) array[j];
                        }
                            startTime = System.currentTimeMillis();
                            sorter.radixSort(intArr, (int) Math.pow(2, 20));
                            endTime = System.currentTimeMillis();
                            break;
                        case 5:
                            startTime = System.currentTimeMillis();
                            Arrays.sort(copyArray);
                            endTime = System.currentTimeMillis();
                            break;
                }
                durationList[algorithmIndex][i] = (int) (endTime - startTime);
            }

            // Calculate average and standard deviation
            calculateStats(durationList);
            }}
    }

    private Integer[] generateRandomArray(int size) {
        Integer[] array = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    private int[] generateRandomArray(int size, int range) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(range);
        }
        return array;
    }


    private void reverseArray(Integer[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            Integer temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    private void calculateStats(int[][] durationList) {
        for (int i = 0; i < durationList.length; i++) {
            int[] durations = durationList[i];
            long sum = 0;
            for (long duration : durations) {
                sum += duration;
            }
            double average = sum / (double) NUMITER;

            double squaredDiffSum = 0;
            for (long duration : durations) {
                double diff = duration - average;
                squaredDiffSum += diff * diff;
            }
            double standardDeviation = Math.sqrt(squaredDiffSum / NUMITER);

            System.out.println("Algorithm " + i + ": Average = " + average + ", Standard Deviation = " + standardDeviation);
        }
    }

}
