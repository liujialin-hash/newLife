package play.AlgorithmSet;

import sun.nio.cs.ext.MS874;

import java.util.*;

public class DecryptMessage {
    //两数之和
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map=new HashMap<>();
            int left=0;
            int right=nums.length-1;
            while(left<=right){
                if(map.containsKey(nums[left])){
                    int [] result={map.get(nums[left]),left};
                    return result;
                }
                map.put(target-nums[left],left);
                if(map.containsKey(nums[right])){
                    int [] result={map.get(nums[right]),right};
                    return result;
                }
                map.put(target-nums[right],right);
                left++;
                right--;
            }
            return null;
        }

}
