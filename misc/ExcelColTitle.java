
public class ExcelColTitle {
    public String convertToTitle(int n) {
        StringBuilder title = new StringBuilder();
        while (n > 0) {
            n--;
            title.insert(0, (char)('A' + n % 26));
            n /= 26;
        }
        return title.toString();
    }
}
