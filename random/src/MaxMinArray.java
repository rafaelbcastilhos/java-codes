public class MaxMinArray {
    public static void main(String [] args){
        int array[] = {9, 0, 4, 2, 3, 8, 7, 1, 6, 5};
        MaxMinRecursive(array, array[0], array[0], 0);
        System.out.println("---------");
        MaxMinIterative(array);
    }

    public static void MaxMinRecursive(int array[], int max, int min, int index){
        if(array[index] > max)
            max = array[index];
        if(array[index] < min)
            min = array[index];
        if(index < array.length-1)
            MaxMinRecursive(array, max, min, index+1);
        else{
            System.out.println("Max: " + max);
            System.out.println("Min: " + min);
        }
    }

    public static void MaxMinIterative(int array[]){
        int max = array[0], min = array[0];
        if(array.length > 1){
            for (int i = 0; i < array.length; i++) {
                if(array[i] > max)
                    max = array[i];
                else if(array[i] < min)
                    min = array[i];
            }
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}
