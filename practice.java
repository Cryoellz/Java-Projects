import java.util.ArrayList;

public class practice {

    public static void main(String[] args) {
        
        ArrayList<String> objNames = new ArrayList<>();

        objNames.add("Yuan");
        objNames.add("Dominique");
        objNames.add("Tulibas");
        objNames.add("Biong");

        System.out.println("Names\n");
        for (String strName : objNames){
            System.out.println  (strName);
        }

        objNames.remove ("Yuan");

        System.out.print("Names");
            for(String strName : objNames){
                System.out.println(strName);
            }

        objNames.set(0, "Yuan");

        System.out.println("Names \n");
        for (String strName : objNames){
            System.out.println(strName);
        }
    }
}