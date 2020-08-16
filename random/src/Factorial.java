public class Factorial {
    public static void main(String [] args){
        System.out.println("Factorial 0 : " + Factorial(0) );
        System.out.println("Fatorial 1 : " + Factorial(1) );
        System.out.println("Fatorial 3 : " + Factorial(3) );
        System.out.println("Fatorial 7 : " + Factorial(7) );
    }

    public static int Factorial(int x){
        if(x <= 1)
            return 1;
        else
            return x * Factorial(x-1);
    }
}