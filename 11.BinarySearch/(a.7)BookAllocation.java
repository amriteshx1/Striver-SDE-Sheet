// Brute linear way

class Solution {
    public int findPages(int[] nums, int m) {
        if (m > nums.length) return -1;

        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int sum = 0;

        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
        }

        for(int i = 0; i < n; i++){
            sum += nums[i];
        }

        int low = max;
        int high = sum;

        for(int pages = low; pages <= high; pages++){
            int countStudents = fun(nums, pages);
            if(countStudents <= m) return pages;
        }

        return -1;
    }

    private int fun(int[] nums, int pages){
        int students = 1;
        int studentPages = 0;

        for(int i = 0; i < nums.length; i++){
            if(studentPages + nums[i] <= pages){
                studentPages += nums[i];
            }else{
                students++;
                studentPages = nums[i];
            }
        }

        return students;
    }
}

// Binary Search Optimal

class Solution {
    public int findPages(int[] nums, int m) {
        if (m > nums.length) return -1;

        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int sum = 0;

        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
        }

        for(int i = 0; i < n; i++){
            sum += nums[i];
        }

        int low = max;
        int high = sum;

        while(low <= high){
            int mid = (low + high) / 2;
            int countStudents = fun(nums, mid);
            if(countStudents > m){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return low;
    }

    private int fun(int[] nums, int pages){
        int students = 1;
        int studentPages = 0;

        for(int i = 0; i < nums.length; i++){
            if(studentPages + nums[i] <= pages){
                studentPages += nums[i];
            }else{
                students++;
                studentPages = nums[i];
            }
        }

        return students;
    }
}