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
        Integer[] arr = {12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Sort s = new Sort();
        s.mergeSortIterative(arr);
        System.out.print("{ ");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("}");
    }
}
