package solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3 {
    //解法二：引入hashmap，额外记住字符所在的索引值，使得当遇见重复的字符串时
    // 可以快速的跳过[i,j]的位置，其中：i是指窗口的左边索引，j是指第一个重复字符的索引。
    // 直接跳的原因是在[i+1,j'-1]的位置不可能匹配到比[i，j'-1]更长的串。j'为当前位置索引。
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        // current index of character
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcdefghibjklm";
        int result = lengthOfLongestSubstring2(s);
        System.out.println(result);
    }

    //解法一：使用set维持当前[i,j]构成的滑动窗口，不断增加和删除元素来找到最大值。
    //TODO 以下代码还存在问题！
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int i = 0, j = i + 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int size = 0;
        while (j <= s.length()) {
            if (set.contains(s.charAt(j))) {
                i++;
                j++;
            } else {
                set.add(s.charAt(j));
                j++;
            }
            if ((j - i) > size) {
                size = j - i;
            }
        }
        return size;
    }
}

