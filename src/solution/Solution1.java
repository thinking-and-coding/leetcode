package solution;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    //解法一：基本解题思路：for循环遍历。
    //时间复杂度：o(n2),空间复杂度：o(1)
    public int[] twoSum(int[] nums, int target) {
        int[] array = new int[]{0, 0};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    array[0] = i;
                    array[1] = j;
                }
            }
        }
        return array;
    }

    //解法二：使用hashmap,开辟新的空间，加速查找,本质是空间换时间。
    //时间复杂度：o(n)?,空间复杂度：o(n)?
    public int[] twoSum2(int[] nums, int target) {
        int[] array = new int[]{0, 0};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int secondPara = target - nums[i];
            if (map.containsKey(secondPara)) {
                //map保存的是当前找到元素之前的数据，所以应该先保存map.get()，后保存当前索引。
                array[0] = map.get(secondPara);
                array[1] = i;
                return array;
            }
            //将遍历过的放入hashmap。
            map.put(nums[i], i);
        }
        return array;
    }

    //解法三：
    public static int[] twoSum3(int[] nums, int target) {
        int max = 2047;
        int[] temp = new int[target + 1];
        int diffPos;
        for (int i = 0; i < nums.length; i++) {
            diffPos = (target - nums[i])&max;
            if (temp[diffPos] != 0) {
                return new int[]{temp[diffPos]-1, i};
            }
            int index = nums[i]&max;
            temp[index] = i+1;
        }

        throw new IllegalArgumentException("No two sum solution");

    }

    public static void  main(String[] args){
        int[] input = {2,7,11,15};
        int target = 17;
        int[] result = twoSum3(input,target);
    }

}
