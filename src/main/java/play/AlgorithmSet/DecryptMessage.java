package play.AlgorithmSet;

import sun.nio.cs.ext.MS874;

import java.util.*;

public class DecryptMessage {
    //两数之和
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (map.containsKey(nums[left])) {
                int[] result = {map.get(nums[left]), left};
                return result;
            }
            map.put(target - nums[left], left);
            if (map.containsKey(nums[right])) {
                int[] result = {map.get(nums[right]), right};
                return result;
            }
            map.put(target - nums[right], right);
            left++;
            right--;
        }
        return null;
    }


    // Definition for singly-linked list.
    //两数相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode firstListNode = l1;
        ListNode twoListNode = l2;
        int count = 0;
        ListNode listNode = null;
        int AdbanceOneDigit = 0;
        List<Integer> list = new ArrayList<>();
        while (firstListNode != null || twoListNode != null) {
            int firstVal = 0;
            if (firstListNode != null) {
                firstVal = firstListNode.val;
                firstListNode = firstListNode.next;
            }

            int twoVal = 0;
            if (twoListNode != null) {
                twoVal = twoListNode.val;
                twoListNode = twoListNode.next;
            }
            count = firstVal + twoVal;
            if (AdbanceOneDigit != 0) {
                count += 1;
            }
            if (count == 10) {
                AdbanceOneDigit = 1;
                count = 0;
            } else if (count > 10) {
                count = count - 10;
                AdbanceOneDigit = 1;
            } else {
                AdbanceOneDigit = 0;
            }
            if (AdbanceOneDigit == 0 || count != 0) {
                list.add(count);
            } else {
                list.add(0);
            }
        }
        if (AdbanceOneDigit == 1) {
            list.add(1);
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            listNode = new ListNode(list.get(i), listNode);
        }

        return listNode;
    }

}
