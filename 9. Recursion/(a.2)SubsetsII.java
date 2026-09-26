// Optimal (ASK GPT YRRR, ITS OUT OF MY BRAIN MAN) ---> UPDATE: SECOND PASS -> Look at the copy boyyy, haha!

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

// Apna College Crazy (see his subset sum I video as well)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        getAllSubsets(0, nums, new ArrayList<>(), list);
        return list;
    }

    private void getAllSubsets(int i, int[] nums, List<Integer> ds, List<List<Integer>> list){
        if(i == nums.length){
            list.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[i]);
        getAllSubsets(i + 1, nums, ds, list);

        ds.remove(ds.size() - 1);
        int index = i + 1;

        while(index < nums.length && nums[index] == nums[index - 1]){
            index++;
        }

        getAllSubsets(index, nums, ds, list);
    }
}