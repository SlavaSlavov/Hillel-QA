
import java.util.Scanner;

public class Arrays {

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

            ///////////////////////
//        System.out.print("Enter how many numbers you want to sum: ");
//        int input = sc.nextInt();
//
//        int[] inputNumbers = new int [input];
//
//        for (int i=0; i < inputNumbers.length; i++){
//            System.out.print("Enter " + (i+1) +" number: ");
//            inputNumbers[i] = sc.nextInt();
//        }
//
//        int sum = 0;
//        for (int i=0; i < inputNumbers.length; i++){
//            sum += inputNumbers[i];
//        }
//
//        System.out.println("The sum is " + sum);

            //////////////////////////////////////////////////
        System.out.print("Enter your`s text: ");
        String input = sc.nextLine();

        int sum = 0;
        char temp;

        for (int i=0; i <input.length(); i++) {
            temp = input.charAt(i);
            if(temp == 'e' || temp == 'E') {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
