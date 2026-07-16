// One way is to use the solution of combination sum I and then just inside pick condition increase the index by 1. As well as use a set to store the result and then convert it to a list at the end.

// Optimal without using the conversion from set to list

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(candidates);
        findCombinations(0, candidates, target, list, new ArrayList<>());
        return list;
    }

    private void findCombinations(int ind, int[] arr, int target, List<List<Integer>> list, List<Integer> ds){
        if(target == 0){
            list.add(new ArrayList<>(ds));
            return;
        }

        for(int i = ind; i < arr.length; i++){
            if(i > ind && arr[i] == arr[i - 1]) continue;
            if(arr[i] > target) break;

            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], list, ds);
            ds.remove(ds.size() - 1);
        }
    }
}