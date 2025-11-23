//imports
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * sorts array of integers using
 * Selection sort.
 *
 *
 * @author Dylan Mutabazi
 * @version 1.0
 * @since 2025-November
 */
final class SelectionSort {

    /**
     * Prevent instantiation of utility class.
     *
     * @exception IllegalStateException if constructor is called.
     */
    private SelectionSort() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Sorts an array using the Selection sort algorithm.
     *
     * @param arr the array of integers to sort
     * @return the sorted array
     */
    public static int[] selectSort(final int[] arr) {

        // Selection sort algorithm

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    /**
     * Entrypoint of the program.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(final String[] args) {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        try {
            Scanner sc = new Scanner(inputFile);
            FileWriter writer = new FileWriter(outputFile);

            while (sc.hasNextLine()) {
                String numb = sc.nextLine();
                String[] strArr = numb.split(" ");

                int[] arr = new int[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    arr[i] = Integer.parseInt(strArr[i]);
                }

                int[] result = selectSort(arr);

                for (int i = 0; i < result.length; i++) {
                    writer.write(result[i] + " ");
                    System.out.print(result[i] + " ");
                }
                writer.write("\n");
                System.out.println("");
            }

            writer.close();
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("input.txt not found.");
        } catch (IOException e) {
            System.out.println("Error with writing to the output file.");
        }

        }
    }

