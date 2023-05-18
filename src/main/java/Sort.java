import java.lang.reflect.Array;

public class Sort <T extends Comparable<T>> {

    public void quickSortClass(T[] array){
        quickSortClass(array, 0, array.length-1);
    }

    public void quickSortRecitation(T[] array){
        quickSortRecitation(array, 0, array.length-1);
    }

    public static void radixSort(int[] array, int base){

    }
    
    public void mergeSortRecursive(T[] array){
        mergeSortRecursive(array, 0, array.length-1);
    }
/*
    public void mergeSortIterative(T[] array){
        int size = array.length;
        //sizes of the arrays we will merge
        for(int iterSize = 2; iterSize< size-1; iterSize *=2){
                    for(int leftIndex = 0; leftIndex< size-1; leftIndex +=iterSize){
                        int endRightIndex = Math.min(leftIndex + 2*iterSize, size-1);
                        int middleIndex =  (int) ((leftIndex+ endRightIndex)/2);
                        merge(array, leftIndex, middleIndex, endRightIndex);
        }
    }
    }*/
    public void mergeSortIterative(T[] array){
        int size = array.length;
        //sizes of the arrays we will merge
        for(int iterSize = 2; iterSize <= size; iterSize *= 2){
            for(int leftIndex = 0; leftIndex <= size - iterSize; leftIndex += iterSize){
                int endRightIndex = Math.min(size - 1, leftIndex + iterSize - 1);
                int middleIndex =  leftIndex + (iterSize / 2) - 1;
                merge(array, leftIndex, middleIndex, endRightIndex);
            }
        }
    }

    public void setNaiveSortThreshold(int threshold){

    }

    public void quickSortClass(T[] array, int first, int last){
        if (first - last > 3){
            int q = partitionClass(array, first, last);
            quickSortClass(array, first, q-1);
            quickSortClass(array, q+1, last);
        }else{
            simpleSort(array, first, last);
        }
    }

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

    public void quickSortRecitation(T[] array, int first, int last){
        if (first - last > 3){
            int q = partitionRecitation(array, first, last);
            quickSortClass(array, first, q-1);
            quickSortClass(array, q+1, last);
        }else{
            simpleSort(array, first, last);
        }
    }

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

    public void  mergeSortRecursive(T[] array, int p, int r){
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
    private static boolean countSort(int[] array, int base, int place){
        boolean done = true;
        int[] keys = new int[base];
        for (int i = 0; i < base; i++){
            keys[i] = 0;
        }
        int factor = Math.pow(base, place);
        for (int i = 0; i < array.length; i ++){
            keys[array[i]]++;
        }
        for(int i =1; i<array.length; i++){
            keys[i] = keys[i] + keys[i-1];
        }
        int[] result = new int[array.length];
        for(int i =n; i>=0; i--){
            result[keys[array[n]]] = array[n];
            keys[array[n]]--;
        }
    }

}

