package solution.solution700_800;

import java.util.PriorityQueue;

public class Solution703 {



    class KthLargest {
        public PriorityQueue<Integer> queue;
        public int k;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            queue = new PriorityQueue<>(k);
            for (int i : nums){
                add(i);
            }

        }

        public int add(int val) {
            queue.offer(val);

            if (queue.size() > k){
                queue.poll();
            }
            return queue.peek();
        }
    }
}
