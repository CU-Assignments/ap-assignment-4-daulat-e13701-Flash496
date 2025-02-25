import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        while (result.size() < n) {
            List<Integer> next = new ArrayList<>();
            
            for (int num : result) {
                if (num * 2 - 1 <= n) next.add(num * 2 - 1); // Odd numbers
            }
            for (int num : result) {
                if (num * 2 <= n) next.add(num * 2); // Even numbers
            }

            result = next;
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
