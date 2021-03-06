//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4054 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 法一：滑动窗口法，时间复杂度 o(n), 空间复杂度 o(min(m, n))
     */
//    public int lengthOfLongestSubstring(String s) {
//        int i = 0, j = 0, ans = 0;
//        int n = s.length();
//        Set<Character> set = new HashSet<>();
//        while (i < n && j < n) {
//            if (!set.contains(s.charAt(j))) {
//                set.add(s.charAt(j++));
//                ans = Math.max(j-i, ans);
//            } else {
//                set.remove(s.charAt(i++));
//            }
//        }
//        return ans;
//    }

    /**
     * 法二：滑动窗口法优化，利用 HashMap 代替 HashSet , 时间复杂度 o(n), 空间复杂度 o(min(m, n))
     */
//    public int lengthOfLongestSubstring(String s) {
//        int n = s.length(), ans = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0, j = 0; j < n; j++) {
//            if (map.containsKey(s.charAt(j))) {
//                i = Math.max(i, map.get(s.charAt(j)));
//            }
//            ans = Math.max(ans, j - i + 1);
//            map.put(s.charAt(j), j + 1);
//        }
//        return ans;
//    }
    /**
     * 法三：滑动窗口法优化，利用数组代替 HashMap, 时间复杂度 o(n), 空间复杂度 o(m)
     */
    public int lengthOfLongestSubstring(String s) {
        int ans = 0, n = s.length();
        int[] index = new int[128];
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(i, index[s.charAt(j)]);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
