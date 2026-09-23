import java.util.Scanner;

public class javaAssignment {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        float[] grades = new float[10];

        System.out.println("Enter 10 Grades: ");
        for (int i = 0; i < grades.length; i++){
            System.out.print("Enter grades for Student " + (i + 1) + ": ");
            grades[i] = scanner.nextFloat();
        }

        int validCount = 0;
        for (int i = 0; i < grades.length; i++){
            if (grades[i] != 0.0f){
                validCount++;
            }
        }

        float[] resizedGrades = new float [validCount];

        int index = 0;
        for (float grade : grades){
            if(grade != 0.0f){
                resizedGrades[index] = grade;
                index++;
            }
        }

        System.out.println("\n Original Grades Aray: ");
        for (float grade : grades){
            System.out.print(grade + " ");
        }

        System.out.println();

        System.out.println("\n Final Grades Resized Format: ");
        for (float grade : resizedGrades){
            System.out.print(grade + " ");
        }


        scanner.close();
    }
}