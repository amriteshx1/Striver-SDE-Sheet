// With extra space

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