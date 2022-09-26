import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MinAmongNegative {
    public static void main (String[] args) {
        while (true) {
            Scanner scan = new Scanner(System.in, "cp1251");
            System.out.println("Enter the number of values in array =>");
            int num;
            float[] n_array;

            try {  //try-catch for incorrect size of array , and entering string value into array size
                num = scan.nextInt();
                n_array = new float[num];
            } catch (InputMismatchException inp_mis){
                System.out.println("Enter the the correct size");
                continue;
            } catch (NegativeArraySizeException n_array_size){
                System.out.println("Enter the positive array size");
                continue;
            }

            for (int i = 0; i < n_array.length; i++) {
                try{
                    System.out.print("Enter the " + i + " value into array ->");
                    n_array[i] = scan.nextInt();
                } catch (InputMismatchException inp_mis){
                    System.out.println("You entered incorrect value into array");
                    break;
                }
            }

            for (int i = 0; i < n_array.length; i++) { //Exception for positive elements into array
                try {
                    if (n_array[i] >= 0) {
                        throw new InputMismatchException();
                    }
                } catch (InputMismatchException error) {
                    n_array[i] = 0;
                }
            }

            System.out.println("\n---Entered array is---\n");  //Show entered array with theirs id
            for (int i = 0; i < n_array.length; i++) {
                System.out.println(i + " - " + n_array[i]);
            }

            int min_id = -1;  //Search for minimal value id
            for (int i = 0; i < n_array.length; i++) {
                if (n_array[i] < n_array[0]) {
                    min_id = i;
                }
            }

            if(min_id==-1)  //if all values are "positive" (zero or entered positive elements into array)
                System.out.println("\nMinimal value doesn't exist");
            else  //in another causes
                System.out.println("\nIndex of the minimal value is - " + min_id);

            break;
        }
    }
}
