public class Main {
    public static void main(String[] args){
        System.out.println("Starting...");
        Integer[]a = new Integer[4];
        int j = 4;
        for(int i =0; i<4; i++){
            a[i] = j;
            j++;
        }
        //Integer[] arr = {2134, 346623, 9123, 349, -314, 384, 45, 53, 2034, 5595, 285, 5996, 0};
        int[] arr = {1, 0764, 90064, 367875, 8};
        Sort s = new Sort();
        s.radixSort(arr, 10);
        System.out.print("{ ");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("}");
    }
}
