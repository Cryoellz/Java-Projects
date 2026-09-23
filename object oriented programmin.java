import java.util.Scanner;

public class javaTesting {
    public static void main (String[] args){

        String strName;
        Scanner objInputStr = new Scanner(System.in);
    
        System.out.print("Enter your name: ");
        strName = objInputStr.nextLine();

        switch(strName.toLowerCase()){
            case "optimus prime":
                System.out.println("Greetings Optimus Prime!");
                break;
            
            case "bumblebee":
                System.out.println("Greetings bumblebee!");
                break;

            case "skusta clee":
                System.out.println("ITS YAH BOI CLEEZY YEAHHH");
                break;

            default:
                System.out.println("Unknown Name");
                break;
        }
        objInputStr.close();

        for (int i; i < 0; i++){

        }
    }
}