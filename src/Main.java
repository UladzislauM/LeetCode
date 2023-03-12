import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,-2,-3,-4,-5};
        System.out.println(Arrays.toString(twoSum(nums, -8)));
    }

    public static class ObjectNums {
        public ObjectNums(int val, int index) {
            this.val = val;
            this.index = index;
        }

        private int val;
        private int index;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        ObjectNums[] unsortedNums = new ObjectNums[nums.length];
        for(int i = 0; i < nums.length; i++){
            unsortedNums[i] = new ObjectNums(nums[i], i);
        }
        List<ObjectNums> sortedNums = Arrays.asList(unsortedNums);
        sortedNums.sort(Comparator.comparing(ObjectNums::getVal));

        int multiplyIndex1 = 0;
        int length = nums.length;
        int multiplyIndex2 = length - 1;
        int sum;
        do {
            sum = sortedNums.get(multiplyIndex1).val + sortedNums.get(multiplyIndex2).val;

            if (sum < target) {
                multiplyIndex1++;
            } else if (sum > target) {
                multiplyIndex2--;
            }
        } while (target != sum);
        int[] answer = new int[2];
        answer[0] = sortedNums.get(multiplyIndex1).index;
        answer[1] = sortedNums.get(multiplyIndex2).index;
        return answer;
    }
}