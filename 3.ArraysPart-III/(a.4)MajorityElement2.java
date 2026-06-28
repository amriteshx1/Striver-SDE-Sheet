
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

// Optimal
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int n = nums.length;
        int element1 = 0;
        int element2 = 0;
        int cnt1 = 0;
        int cnt2 = 0;

        for(int i = 0; i < n; i++){
            if(cnt1 == 0 && element2 != nums[i]){
                element1 = nums[i];
                cnt1 = 1;
            }else if(cnt2 == 0 && element1 != nums[i]){
                element2 = nums[i];
                cnt2 = 1;
            }
            else if(element1 == nums[i]){
                cnt1++;
            }else if(element2 == nums[i]){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;

        for(int i = 0; i < n; i++){
            if(element1 == nums[i]) cnt1++;
            if(element2 == nums[i]) cnt2++;
        }

        if(cnt1 > n / 3) list.add(element1);
        if(cnt2 > n / 3 && element1 != element2) list.add(element2);

        return list;
    }
}