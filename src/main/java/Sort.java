import java.lang.reflect.Array;

public class Sort<T extends Comparable<T>> {

    private int naiveSortThreshold;

    // Perform quicksort using the class-based implementation
    public void quickSortClass(T[] array){
        if(array.length<= this.naiveSortThreshold){
            simpleSort(array, 0, array.length);
        } else{
        quickSortClass(array, 0, array.length-1);
    }}

    // Perform quicksort using the recitation-based implementation
    public void quickSortRecitation(T[] array){
        if(array.length<= this.naiveSortThreshold){
            simpleSort(array, 0, array.length);
        } else{
        quickSortRecitation(array, 0, array.length-1);
    }
}

    // Perform merge sort recursively
    public void mergeSortRecursive(T[] array){
        if(array.length<= this.naiveSortThreshold){
            simpleSort(array, 0, array.length);
        } else{
        mergeSortRecursive(array, 0, array.length-1);
    }}

    // Perform radix sort on an array of integers with a given base
    public static void radixSort(int[] array, int base){
        

    }

    // Set the threshold for using naive sort in quicksort
    public void setNaiveSortThreshold(int threshold){
        this.naiveSortThreshold = threshold;
    }
    
    // Perform a simple sort (e.g., bubble sort) on the given array from index p to r
    public void simpleSort(T[] array, int p, int r){
        for(int i = 0; i<array.length; i++){
            for (int j = i+1; j<array.length; j++){
                if(array[j].compareTo(array[i])<0){
                    T temp = array[j];
                    array[j] = array[i];
                    array[i] = array[j];
                }
            }
        }
    }

    // Perform count sort on an array of integers with a given base and place value
    private static void countSort(int[] array, int base, int place){
        boolean done = true;
        int[] keys = new int[base];
        for (int i = 0; i < base; i++){
            keys[i] = 0;
        }
        //int factor = Math.pow(base, place);
        for (int i = 0; i < array.length; i ++){
            keys[array[i]]++;
        }
        for(int i =1; i<array.length; i++){
            keys[i] = keys[i] + keys[i-1];
        }
        int[] result = new int[array.length];
        int n = array.length-1;
        for(int i =n; i>=0; i--){
            result[keys[array[n]]] = array[n];
            keys[array[n]]--;
        }
    }

    // Perform quicksort using the class-based implementation on a subarray from index first to last
    public void quickSortClass(T[] array, int first, int last){
        if (first - last > 3){
            int q = partitionClass(array, first, last);
            quickSortClass(array, first, q-1);
            quickSortClass(array, q+1, last);
        }else{
            simpleSort(array, first, last);
        }
    }

    // Perform quicksort using the recitation-based implementation on a subarray from index first to last
    public void quickSortRecitation(T[] array, int first, int last){
        if (first - last > 3){
            int q = partitionRecitation(array, first, last);
            quickSortClass(array, first, q-1);
            quickSortClass(array, q+1, last);
        }else{
            simpleSort(array, first, last);
        }
    }

    // Partition the array using the class-based implementation of quicksort
    public int partitionClass(T[] array, int p, int r){
        T x = array[r];
        int j = r-1;
        int i = p+1;
        while(true){
            while(array[j].compareTo(x)>0 && j>p){
                j--;
            }
            while(array[1].compareTo(x)<0 && i<r){
                i--;
            }
            if(i<j){
                T temp = array[i];
                array[i]=array[j];
                array[j] = temp;
            } else{
                T temp = array[i];
                array[i]=array[j+1];
                array[j+1] = temp;
                return j+1;
            }
        }
    }

    // Partition the array using the recitation-based implementation of quicksort
    public int partitionRecitation(T[] array, int p, int r){
        T x = array[r];
        int i = p-1;
        for(int j =p; j<r-1; j++){
            if(array[i].compareTo(x)<0){
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            T temp = array[i+1];
            array[i+1] = array[j];
            array[j] = temp;
        }
        return i+1;
    }


    // Perform merge sort recursively on a subarray from index p to r
    public void mergeSortRecursive(T[] array, int p, int r){
        if(p < r){
            int q = (p + r) / 2;
            mergeSortRecursive(array, p, q);
            mergeSortRecursive(array, q+1, r);
            merge(array, p, q, r);
            System.out.print("{ ");
            for (int i = 0; i < array.length; i++){
                System.out.print(array[i] + " ");
            }
            System.out.println("}");
        }
    }

    // Perform merge sort iteratively on the given array
    public void mergeSortIterative(T[] array){
        int size = array.length;
        System.err.println(size);
        //sizes of the arrays we will merge
        for(int iterSize = 2; iterSize < (size * 2) - 1; iterSize *= 2){
            System.out.println("SIZE: " + iterSize);
            for(int leftIndex = 0; leftIndex <= size - 1; leftIndex += iterSize){
                int endRightIndex = Math.min(size - 1, leftIndex + iterSize - 1);
                int middleIndex =  Math.min(size - 1, leftIndex + (iterSize / 2) - 1);
                merge(array, leftIndex, middleIndex, endRightIndex);
                System.out.println("left:" + leftIndex + "  mid:" + middleIndex + "  right:" + endRightIndex);
            }
        }
    }

    // Merge two sorted subarrays within the array from index p to q and from index q+1 to r
    public void merge(T[] array, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        int j = 0;
        T[] left = (T[]) Array.newInstance(Comparable.class, n1);
        for(int i = p; i <= q; i++) {
            left[j] = array[i];
            j++;
        }
        T[ ] right = (T[]) Array.newInstance(Comparable.class, n2);
        j = 0;
        for(int i = q+1; i <= r; i++) {
            right[j] = array[i];
            j++;
        }
        int i = 0;
        j = 0;
        for(int k = p; k <= r; k++){
            if(i == left.length){
                array[k] = right[j];
                j++;
            } else if(j == right.length || left[i].compareTo(right[j])<=0 ){
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
        }
    }
}


