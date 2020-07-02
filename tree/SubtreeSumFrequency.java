import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubtreeSumFrequency {
 // global variables solution
    Map<Integer, Integer> sumFreq;
    int maxFreq;
    public int[] findFrequentTreeSum(TreeNode root) {
        sumFreq = new HashMap<Integer, Integer>();
        maxFreq = 0;
        findFrequentSum(root);
        List<Integer> mostFreq = new ArrayList<Integer>();
        for (int freq : sumFreq.keySet()) {
            if (sumFreq.get(freq) == maxFreq) {
                mostFreq.add(freq);
            }
        }
        int[] frequentTreeSum = new int[mostFreq.size()];
        for (int i = 0; i < mostFreq.size(); i++) {
            frequentTreeSum[i] = mostFreq.get(i);
        }
        return frequentTreeSum;
    }

    private int findFrequentSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int treeSum = root.val + findFrequentSum(root.left)
            + findFrequentSum(root.left);
        /* Alternatively:
        int leftSum = findFrequentSum(root.left);
        int rightSum = findFrequentSum(root.right);
        int treeSum = leftSum + rightSum + root.val;
        */
        if (!sumFreq.containsKey(treeSum)) {
            sumFreq.put(treeSum, 0);
        } else {
            sumFreq.put(treeSum, sumFreq.get(treeSum) + 1);
        }
        maxFreq = Math.max(maxFreq, sumFreq.get(treeSum));
        return treeSum;
    }
}
