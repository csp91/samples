/** Name: Christopher Padilla
 ** Purpose: Sorts input numbers into ascending order using bubble sort method.
 ** Date: 21 March 2019
 ** 
 ** 
 **
 */

import java.util.Arrays; 
import java.util.Scanner;

public class NumSorter {

    public static void main(String[] args) {
		
		//Scanner object
        Scanner input = new Scanner(System.in);

        //Prompts user for array size, and validates input.
        do {
            System.out.print("How many integers would you like to sort? ");
        }
        while (!isValid(input));

        /** int[] means we are creating an integer type Array.
         ** [] Square bracket specifies its an array.
         ** Declare 'inputList' as the variable. Use 'inputList' to call an entire array;
         ** 'new int[arraySize]' creates number of objects & assigns to 'inputList'.
         ** Here is the format: elementType[] arrayReferenceVariable = new elementType[arraySize]
         */
        int[] inputList = new int [input.nextInt()];

        //Prompts user to enter the array parameters.
        System.out.println("Enter your numbers: ");

        /** For loop is commonly used to access every index (item location in an array).
         ** Counts from 0 up to inputList.length(size of the array)
         ** index starts from 0. array.length is the number of items. e.g index 0 to 9 is length value 10.
         */
        for (int i = 0; i < inputList.length; i++) {

            //Wrong input causes i to fallback 1, and redo.
            if (!input.hasNextInt()) {
                input.next();
                i--;
                System.err.println("Invalid input");
            }
            //Assign values to an item/index // arrayVariableName[indexNumber] = value;
            else
                inputList[i] = input.nextInt();
        }

        //Arrays.toString() is an array method to convert specified array to String.
        //Makes it readable.
        System.out.println("Original: " + Arrays.toString(inputList));  //Unsorted (Original)

        //Bubble-sorts inputList parameters into ascending order.
        bubbleSort(inputList);

        System.out.println("Sorted: " + Arrays.toString(inputList)); //Sorted
    }

    /** Bubble-sort method */
    public static int[] bubbleSort(int[] list) {

        //Temporary placeholder for swapping values.
        int temp;

        //Declare boolean variable.
        boolean isSorted;

        //do-while loop which only ends on a 'true'.
        do{
            isSorted=true; //ends loop unless 'if' is ran.

            // for loop counts from index 0 up to next to last.
            // e.g length 10 means index 0-9. This for loop will count from 0 to 8(length-1).
            for (int i = 0; i < list.length - 1; i++) {

                /** Compares an index and the adjacent index.
                 ** Last pair would be list[8] and list[8+1].
                 ** If the lower index has higher value than the next index, then pair swap places.
                 */
                if (list[i] > list[i + 1]) { //if not run during for loop, all parameters are sorted.

                    temp = list[i];     //temp now holds lower index value
                    list[i] = list[i + 1]; //lower index receives higher index value
                    list[i + 1] = temp; //higher index receives lower index value from temp

                    isSorted=false; //restart loop at line 72.
                }
            }
        }
        while(isSorted==false);
        return list;
    }

    /** Validates user input */
    public static boolean isValid(Scanner input) {
        if (input.hasNextInt()) {
            return true;
        }
        else
            input.next();
            System.err.println("Invalid input");
            return false;
    }
}

