public class StandardCounter implements SmartCounter {

    @Override
    public String next(String last) {

    if (last == null || last.isEmpty())
        return "0001";

    char[] c = last.toCharArray();
    int end = c.length - 1;
    while (end >= 0 && !Character.isDigit(c[end]))
        end--;
    if (end < 0)
        return last + "1";

    int start = end;
    while (start > 0 && Character.isDigit(c[start - 1]))
        start--;

    int pos = end;
    boolean carry = true;
    while (pos >= start && carry) {
        if (c[pos] == '9') {
            c[pos] = '0';
            pos--;
        } else {
            c[pos]++;
            carry = false;
        }
    }

    String result = new String(c);
    if (carry)
        result = result.substring(0, start) + "1" + result.substring(start);
    return result;
    }
}
