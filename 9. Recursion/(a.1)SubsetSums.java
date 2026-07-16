// Optimal

class Solution {

    public boolean isSubsetSum(int[] arr, int target) {
        return fun(0, 0, arr, target);
    }

    private boolean fun(int index, int sum, int[] arr, int target) {

        if (index == arr.length) {
            return sum == target;
        }

        // pick the element
        if (fun(index + 1, sum + arr[index], arr, target)) {
            return true;
        }

        // not pick the element
        if (fun(index + 1, sum, arr, target)) {
            return true;
        }

        return false;
    }
}