// With extra space    NOTE: DON'T FORGET TO CHECK PERMUTATIONS II ON LEETCODE, THAT'S JUST ONE LINE OF CHANGE IN THIS CODE, CHECK IT OUT

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = new int[n];

        fun(nums, ans, arr, new ArrayList<>());
        return ans;
    }

    private void fun(int[] nums, List<List<Integer>> ans, int[] arr, List<Integer> ds){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                ds.add(nums[i]);
                arr[i] = 1;
                fun(nums, ans, arr, ds);
                ds.remove(ds.size() - 1);
                arr[i] = 0;
            }
        }
    }
}

// Without extra space

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        fun(nums, 0, ans);
        return ans;
    }

    private void fun(int[] nums, int index, List<List<Integer>> ans) {
        if(index == nums.length) {
            List<Integer> ds = new ArrayList<>();

            for(int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }

            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            fun(nums, index + 1, ans);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}