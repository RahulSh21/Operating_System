import java.util.Arrays;
import java.util.Random;
public class Main {
    public static void main(String[] args) {

        //System.out.println("Hello world!");



                int arraySize = 100000;
                int[] arr = new int[arraySize];
                Random rand = new Random();

                // Populate array with random values between 0 and 100
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = rand.nextInt(100);
                }

                // Create a copy of the original array for parallel processing
                int[] arrCopy = Arrays.copyOf(arr, arr.length);

                // Multiply every value in the array with a random value between 0.1 and 0.9
                double randomMultiplier = 0.1 + (0.9 - 0.1) * rand.nextDouble();
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = (int) Math.round(arr[i] * randomMultiplier);
                }

                // Multiply every value in the array copy with the same random value for parallel processing
                for (int i = 0; i < arrCopy.length; i++) {
                    arrCopy[i] = (int) Math.round(arrCopy[i] * randomMultiplier);
                }

                // Calculate the sum of the array in serial
                long startTimeSerial = System.nanoTime();
                int sumSerial = 0;
                for (int i = 0; i < arr.length; i++) {
                    sumSerial += arr[i];
                }
                long endTimeSerial = System.nanoTime();

                // Calculate the sum of the array in parallel
                long startTimeParallel = System.nanoTime();
                int sumParallel = Arrays.stream(arrCopy).parallel().sum();
                long endTimeParallel = System.nanoTime();

                // Compute the time difference between serial and parallel processing
                long timeDifference = endTimeParallel - endTimeSerial;

                // Print the results
                System.out.println("Sum of the array in serial: " + sumSerial);
                System.out.println("Sum of the array in parallel: " + sumParallel);
                System.out.println("Time difference between serial and parallel processing: " + timeDifference + " nanoseconds");

    }
}