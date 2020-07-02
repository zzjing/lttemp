import java.io.*;
import java.util.*;

public class CountInversion {
    public static void main(String[] args) throws FileNotFoundException {
	Scanner input = new Scanner(new File("IntegerArray.txt"));
	List<Integer> intArray = fileToArray(input);
	long numInversions = countInv(intArray);
	System.out.println(numInversions);
    }

    private static List<Integer> fileToArray(Scanner input) {
	List<Integer> intArray = new ArrayList<Integer>();
	while (input.hasNextLine()) {
	    String line = input.nextLine();
            int getInteger = Integer.parseInt(line);
            intArray.add(getInteger);
        }
	return intArray;
    }

    private static long countInv(List<Integer> intArray) {
	List<Integer> auxiliary = new ArrayList<Integer>(intArray);
	return countInv(intArray, auxiliary, 0, intArray.size() - 1);
    }

    private static long countInv(List<Integer> intArray,
	List<Integer> auxiliary, int start, int end) {
	if (start == end) {
	    return 0;
	}
	int mid = (start + end) / 2;
	return countInv(intArray, auxiliary, start, mid) +
		countInv(intArray, auxiliary, mid + 1, end) +
		countSplitInv (intArray, auxiliary, start, mid, end);
    }

    private static long countSplitInv(List<Integer> intArray, List<Integer> auxiliary,
	int start, int mid, int end) {
	long invCount = 0;
	int leftStart = start;
	int rightStart = mid + 1;
	for (int i = start; i <= end; i++) {
	    if (rightStart > end || leftStart < mid &&
	    auxiliary.get(leftStart) <= auxiliary.get(rightStart)) {
	    intArray.set(i, auxiliary.get(leftStart));
				leftStart++;
			} else if (leftStart > mid) {
				rightStart++;
			} else {
				// claim that number of inversions is the number of
				// elements of the left half
				invCount += (mid - leftStart + 1);
				intArray.set(i, auxiliary.get(rightStart));
				rightStart++;
			}
		}
		return invCount;
	}
}
