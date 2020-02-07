/** Name: Christopher Padilla
 ** Purpose: Provide four numbers to try winning the lottery.
 ** Date: 23 November 2019
 ** Tools: IntelliJ IDE
 **
 */

import java.util.Scanner;

public class LotteryGame {

    public static void main(String[] args) {

        //When array is created, it creates an array of zeros.
        //Flush it with out of range number as a placeholder.
        //So when program plugs in number, it doesn't detect zero as duplicate.
        int[] lotteryNum = new int[]{-1,-1,-1,-1};
        int[] userNumArr = new int[]{-1,-1,-1,-1};
        int counter = 0;

        //Creates a scanner object.
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < userNumArr.length; i++) {

            //Prompts user for numbers.
            System.out.printf("Enter your numbers from (0-9) %d/4: ",i);

            //Checks if input is valid integer
            if(in.hasNextInt()){

            userNumArr[i] = in.nextInt();

                //ERRORS
                if(userNumArr[i]>9 ||userNumArr[i]<0) {
                    System.out.print("Out of range.\n");
                    i--;

                }else if(checkDuplicate(userNumArr,userNumArr[i],i)){
                    System.out.print("You have already used that number. \n");
                    i--;
                }

            }else{
                //ERROR
                System.out.print("Invalid input.\n");
                i--;
                in.next(); //Rescan
            }
        }

        //Concatenate with user numbers
        System.out.print("\n\n\nHere are your numbers: ");

        for (int element:userNumArr){
            //Display user numbers
            System.out.print(element + " " );
        }

        //Concatenate with lottery numbers
        System.out.print("\nHere are the lottery numbers: ");

        //Creates Lottery Number with no duplicates using check function.
        for (int i = 0; i < lotteryNum.length; i++) {
            while(true) {

                lotteryNum[i] = (int) (Math.random() * 10);

                //Breaks if check function returns false as it didn't detect duplicate
                if (!checkDuplicate(lotteryNum,lotteryNum[i],i)){
                    break;
                }
            }
            //Displays lottery numbers
            System.out.print(lotteryNum[i] + " ");
        }


        //Checks user numbers with lottery numbers
        for (int i=0; i < lotteryNum.length; i++) {

            if(checkUserNum(lotteryNum,userNumArr[i])){
                counter++;
                continue;
            }
        }

        //Spacer
        System.out.print("\n\n");

        //Displays result.
        switch (counter){

            case 0:
                System.out.printf("You matched %d number. You earned %,d point.\n",counter, 0);
                break;
            case 1:
                System.out.printf("You matched %d number. You win %,d points!\n",counter, 5);
                break;
            case 2:
                System.out.printf("You matched %d numbers. You win %,d points!\n",counter, 100);
                break;
            case 3:
                System.out.printf("You matched %d numbers. You win %,d points!\n",counter, 2000);
                break;
            case 4:
                System.out.printf("You matched %d numbers. You win %,d points!\n",counter, 1000000);
                break;
        }
    }

    //Check users array with lottery array
    private static boolean checkDuplicate(int[] arr, int checkValue,int index) {

        boolean test = false;

        //Use Linear Search method
        for (int i = 0; i < arr.length; i++) {

            //Skip so it doesn't check its own element.
            if ( i == index) {
                i++;

            } else {
                if (arr[i] == checkValue) {
                    test = true; //Found a duplicate
                    break;
                }
            }
        }

        return test;
    }

    //Finds parameter 2 value in parameter 1 array
    private static boolean checkUserNum(int[] arr, int checkValue) {

        boolean test = false;

        //Use Linear Search method
        for (int i = 0; i < arr.length; i++) {

                if (arr[i] == checkValue) {
                    test = true; //Found a matching number
                    break;
                }
        }
        return test;
    }
}