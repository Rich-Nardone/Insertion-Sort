import java.util.*;

public class InsertionSort {
    public static int COMPCOUNT = 0;
    public static int SIZE = 0;
    static Random rand = new Random();
    static Scanner s = new Scanner(System.in);
    public static void main(String [] args) {
        SIZE = 32;
        int[] random = makeRandom();
        System.out.println("Unsorted Random Array (n = 32):");
        printArray(random);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        int[] worst = makeWorst();
        System.out.println("Unsorted Worst Array (n = 32):");
        printArray(worst);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        int[] best = makeBest();
        System.out.println("Unsorted Best Array (n = 32):");
        printArray(best);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Sorting Arrays...");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        sort(random);
        System.out.println("Sorted Random Array (n = 32):");
        printArray(random);
        System.out.println("Comparison Count = "+COMPCOUNT);
        sort(worst);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Sorted Worst Array (n = 32):");
        printArray(worst);
        System.out.println("Comparison Count = "+COMPCOUNT);
        sort(best);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Sorted Best Array (n = 32):");
        printArray(best);
        System.out.println("Comparison Count = "+COMPCOUNT);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Testing Array Size....");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        SIZE = 100;
        int[] random100 = makeRandom();
        sort(random100);
        System.out.println("Random Array (n = 100) Comparison Count = "+ COMPCOUNT);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        SIZE = 1000;
        int[] random1000 = makeRandom();
        sort(random1000);
        System.out.println("Random Array (n = 1000) Comparison Count = "+ COMPCOUNT);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        SIZE = 10000;
        int[] random10000 = makeRandom();
        sort(random10000);
        System.out.println("Random Array (n = 10000) Comparison Count = "+ COMPCOUNT);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");

    }
    public static void sort(int A[]) {
        COMPCOUNT = 0;
        for(int i = 1; i < SIZE; i++){
            int j = i;
            while( j > 0 && SMALLER(A, j, j-1)){
                int temp = A[j];
                A[j] = A[j-1];
                A[j-1] = temp;
                j = j-1;
            }
        }
    }
    public static boolean SMALLER(int A[], int i, int j) {
        COMPCOUNT = COMPCOUNT + 1;
        return (A[i] < A[j]);
    }
    public static int[] makeWorst() {
        int[] worst = new int[SIZE];
        for(int i = 0; i < SIZE; i++)
            worst[i] = SIZE-i-1;
        return worst;
    }
    public static int[] makeBest() {
        int[] best = new int[SIZE];
        for(int i = 0; i < SIZE; i++)
            best[i] = i;
        return best;
    }
    public static int[] makeRandom() {
        int[] random = new int[SIZE];
        for(int i = 0; i < SIZE; i++)
            random[i] = rand.nextInt(20);
        return random;
    }
    public static void printArray(int A[]) {
        for(int i = 0; i < SIZE; i++)
            System.out.print(A[i]+" ");
        System.out.println("");
    }
}
