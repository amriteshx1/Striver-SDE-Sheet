// Better

class Solution {
    public int subarraysWithXorK(int[] nums, int k) {
      int n = nums.length;
      int cnt = 0;

      for(int i = 0; i < n; i++){
        int xor = 0;
        for(int j = i; j < n; j++){
            xor ^= nums[j];

            if(xor == k) cnt++;
        }
      }
      return cnt;
    }
}

// Optimal
class Solution {
    public int subarraysWithXorK(int[] nums, int k) {
      int n = nums.length;
      HashMap<Integer, Integer> map = new HashMap<>();
      map.put(0, 1);
      int cnt = 0;
      int xor = 0;

      for(int i = 0; i < n; i++){
        xor = xor ^ nums[i];
        int x = xor ^ k;
        
        cnt += map.getOrDefault(x, 0);
        map.put(xor, map.getOrDefault(xor, 0) + 1);
      }

      return cnt;
    }
}