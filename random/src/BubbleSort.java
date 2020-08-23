public class BubbleSort {
    public static void main(String [] args){
        int array[] = {9, 0, 4, 2, 3, 8, 7, 1, 6, 5};

        System.out.println("Initial array:");
        showArray(array);

        array = bubbleSort(array);

        System.out.println("Bubble Sort:");
        showArray(array);
    }

    public static int[] bubbleSort(int array[]){
        int swap = 0;
        for (int i = 0; i < array.length-1; i++) {
            if(array[i] > array[i+1]){
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
                swap++;
            }
        }
        if(swap != 0)
            bubbleSort(array);
        return array;
    }


    public static int[] bubbleSort2(int array[]){
        for (int i = 1; i < array.length; i++) {
            int tam = array.length;
            for (int j = 0; j < tam-i; j++) {
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public static void showArray(int array[]){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + ", ");
        }
        System.out.println("");
    }
}
