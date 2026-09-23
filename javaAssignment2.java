import java.util.Scanner;

public class javaAssignment2 {
    public static void main (String[] args){
       
        float[][] finalProduct = new float[5][4];
        Scanner scanner = new Scanner (System.in);

        for (int i = 0; i < finalProduct.length; i++){
            System.out.println("Enter Details for Product " + (i + 1));
        
            System.out.print("Enter Product Code: ");
            finalProduct[i][0] = scanner.nextFloat();

            System.out.print("Enter Product Price: ");
            finalProduct[i][1] = scanner.nextFloat();

            System.out.print("Enter Product Quantity: ");
            finalProduct[i][2] = scanner.nextFloat();

            finalProduct[i][3] = finalProduct[i][1] * finalProduct[i][2];
            System.out.println();
        }


        System.out.println("Final list of your Products: ");
        System.out.println("[Product Code]  [Price]      [Quantity]     [Price]");
        System.out.println("-----------------------------------------------------------------------------------");
       
        for (int i = 0; i < finalProduct.length; i++){
            System.out.printf("%d\t \t%.2f\t \t%d\t %.2f\n", (int)finalProduct[i][0], finalProduct[i][1], (int)finalProduct[i][2], finalProduct[i][3]);
        }

        scanner.close();
    }
}