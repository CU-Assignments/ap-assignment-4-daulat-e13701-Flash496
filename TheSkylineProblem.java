import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();
        
        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2], b[1]});
            events.add(new int[]{b[1], 0, 0}); 
        }
        
       
        Collections.sort(events, (a, b) -> 
            a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
        );

       
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(0);
        int prevHeight = 0;

        for (int[] event : events) {
            if (event[1] < 0) { 
                maxHeap.add(-event[1]); 
            } else { 
                maxHeap.remove(event[1]); 
            }

            int currHeight = maxHeap.peek();
            if (currHeight != prevHeight) {
                result.add(Arrays.asList(event[0], currHeight));
                prevHeight = currHeight;
            }
        }

        return result;
    }
}
