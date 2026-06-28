// Brute 

// -> Btw just to mention the optimal one includes the popular Moore's Voting Algorithm which is O(n) time and O(1) space.

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(nums[i] == nums[j]){
                    cnt++;
                }
            }
            if(cnt > n / 2) return nums[i];
        }

        return - 1;
    }
}

// Better

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(int key : map.keySet()){
            if(map.get(key) > n / 2){
                return key;
            }
        }

        return - 1;
    }
}

// Optimal (Moore's Voting Algorithm)

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int element = 0;
        int cnt = 0;

        for(int i = 0; i < n; i++){
            if(cnt == 0){
                cnt = 1;
                element = nums[i];
            }else if (element == nums[i]){
                cnt++;
            }else{
                cnt--;
            }
        }

        int cnt1 = 0;
        
        for(int i = 0; i < n; i++){
            if(element == nums[i]) cnt1++;
        }

        if(cnt1 > n / 2) return element;

        return -1;

    }
}