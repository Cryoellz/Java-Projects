public class CounterTest {
    public static void main(String[] args) {
        SmartCounter counter = new StandardCounter();

        String[][] cases = {
            {"0023", "0024"},
            {"333ZZ", "334ZZ"},
            {"ABC145DEF", "ABC146DEF"},
            {"001ABC123XYZ", "001ABC124XYZ"},
            {"AA33CC44EZ003", "AA33CC44EZ004"},
            {"0099", "0100"},
            {"999", "1000"},
            {"A9Z", "A10Z"},
            {"ABC", "ABC1"}
        };

        System.out.println("== Variation 1: Standard (no regex) ==");
        for (String[] c : cases) {
            String got = counter.next(c[0]);
            String status = got.equals(c[1]) ? "OK" : "FAIL (expected " + c[1] + ")";
            System.out.printf("%-15s -> %-15s %s%n", c[0], got, status);
        }
    }
}