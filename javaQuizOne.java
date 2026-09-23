import java.util.ArrayList;

public class javaQuizOne{

    public static void main (String[] args){

        ArrayList<String> objPersons = new ArrayList<>();

        objPersons.add("McLorence");
        objPersons.add("Justin");
        objPersons.add("Yuan");
        objPersons.add("Liz");
        objPersons.add("Janna");
        objPersons.add("Marian");


        System.out.print("Persons");
        for (String strName : objPersons) {
            System.out.println(strName);
        }

        }       
    }