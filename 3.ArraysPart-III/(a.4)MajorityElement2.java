
// Brute
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int n = nums.length;

        for(int i = 0; i < n; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(nums[i] == nums[j]){
                    cnt++;
                }
            }

            if(cnt > n / 3 && !list.contains(nums[i])){
                list.add(nums[i]);
            }
        }

        return list;

    }
}

// Better
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        int n = nums.length;

        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(int key : map.keySet()){
            if(map.get(key) > n / 3){
                list.add(key);
            }
        }

        return list;

    }
}
