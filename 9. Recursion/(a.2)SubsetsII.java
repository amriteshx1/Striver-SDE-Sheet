// Optimal (ASK GPT YRRR, ITS OUT OF MY BRAIN MAN)

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), list);
        return list;
    }

    private void findSubsets(int ind, int[] nums, List<Integer> ds, List<List<Integer>> list){
        list.add(new ArrayList<>(ds));

        for(int i = ind; i < nums.length; i++){
            if(i != ind && nums[i] == nums[i - 1]) continue;
            ds.add(nums[i]);
            findSubsets(i + 1, nums, ds, list);
            ds.remove(ds.size() - 1);
        }
    }
}