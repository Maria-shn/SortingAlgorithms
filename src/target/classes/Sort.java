public class Sort <T extends comparable<T>> {
    public void quickSortClass(T[] array){
        
    }

    public void quickSortRecitation(T[] array){

    }

    public static void radixSort(int[] array, int base){

    }
    
    public void mergeSortRecursive(T[] array){

    }

    public void mergeSortIterative(T[] array){

    }

    public void setNaiveSortThreshold(int threshold){

    }

    public void quickSortClass(T[] array, int first, int last){
        if (first - last > 3){
            int q = partition(array, p, r);
            quickSortClass(array, first, q-1);
            quickSortClass(array, q+1, last);
        }else{
            simpleSort(array, first, last);
        }
    }

    public int partition(T[] array, int p, int r){
        int x = A[r];
        int j = r-1;
        int i = p+1;
        while(true){
            while(array[j].comparable(x) || j<p){
                j--;
            }
            while(array[1]>x || i>r){
                i--;
            }
            if(i<j){
                int temp = T[i];
                array[i]=array[j];
                array[j] = temp;
            } else{
                int temp = array[i];
                array[i]=array[j+1];
                array[j+1] = temp;
                return j+1;
            }
        }
    }

    public void simpleSort(T[] array, int p, int r){
        for(int i = 0; i<array.length; i++){
            for (int j = i+1; j<array.length; j++){
                if(array[j].comparable(array[i])<0){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = array[j];
                }
            }
        }
    }
}
