public class BogoSort {
    public static void main(int[] vetor) {
        while (!isSorted(vetor))
            shuffle(vetor);
        System.out.println(vetor);
    }

    private static boolean isSorted(int[] vetor) {
        for (int i = 0; i < (vetor.length - 1); ++i) {
            if (vetor[i] > vetor[i + 1]) {
                return false;
            }
        }

        return true;
    }

    private static void shuffle(int[] vetor) {
        for (int x = 0; x < vetor.length; ++x) {
            int index1 = (int) (Math.random() * vetor.length),
                    index2 = (int) (Math.random() * vetor.length);
            int a = vetor[index1];
            vetor[index1] = vetor[index2];
            vetor[index2] = a;
        }
    }
}