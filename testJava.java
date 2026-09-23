import java.util.Scanner;

public class testJava {

    public static void main (String[] args){
        
       String strFirst;
       String strLast;

       Scanner objInput = new Scanner(System.in);

       System.out.print("Enter First Name: ");
       strFirst = objInput.next();
       
       System.out.print("Enter Last Name: ");
       strLast = objInput.next();

       System.out.println("Hello! " + strFirst + " " + strLast);


    }
}