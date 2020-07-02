
public class ProductOfOtherCells {
    public int[] productExceptSelf(int[] nums) {
        // O(n) time, O(n) space
        // big idea: multiply entries which are to the left of an entry to it
        // then multiply entries which are to the right of an entry to it
        int[] products = new int[nums.length];
        if (nums == null) {
            return product;
        }
        // shift the original array entries by one cell
        // but multiply products of all entries to the current cell to it
        products[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            products[i] = products[i - 1] * nums[i - 1];
        }
        // a variable to memorize products of all entries to the right
        int rightProducts = 1;
        for (int i = products.length - 1; i >= 0; i--) {
            products[i] *= rightProducts;
            rightProducts *= nums[i];
        }
        return products;
    }
}
