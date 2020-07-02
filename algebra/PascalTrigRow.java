import java.util.ArrayList;
import java.util.List;

public class PascalTrigRowr {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pascalRow = new ArrayList<Integer>();
        for (int i = 0; i < rowIndex + 1; i++) {
            pascalRow.add(1);
            for (int j = i - 1; j > 0; j--) {
                pascalRow.set(j, pascalRow.get(j - 1) + pascalRow.get(j));
            }
        }
        return pascalRow;
    }
}
