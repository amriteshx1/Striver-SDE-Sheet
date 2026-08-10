// be sure to revise this properly and understand entirely. link of previous one chat: https://chatgpt.com/share/6a797cb6-5ee4-83ee-9245-fd583fceef8f

// Optimal

class Solution {
    public List search(String pat, String txt) {

        List<Integer> ans = new ArrayList<>();

        int n = txt.length();
        int m = pat.length();

        int base = 256;
        int mod = 101;

        int patHash = 0;
        int windowHash = 0;

        // 256^(m - 1)
        int highestPower = 1;

        for (int i = 0; i < m - 1; i++) {
            highestPower = (highestPower * base) % mod;
        }

        // calculate hash of pattern
        // calculate hash of first window
        for (int i = 0; i < m; i++) {

            patHash = (patHash * base + pat.charAt(i)) % mod;

            windowHash = (windowHash * base + txt.charAt(i)) % mod;
        }

        // slide the window through the text
        for (int i = 0; i <= n - m; i++) {

            // hashes match
            if (patHash == windowHash) {

                // verify actual characters
                if (txt.substring(i, i + m).equals(pat)) {
                    ans.add(i);
                }
            }

            // move window
            if (i < n - m) {

                // remove first character
                windowHash = (windowHash
                        - txt.charAt(i) * highestPower) % mod;

                if (windowHash < 0) {
                    windowHash += mod;
                }

                // add new character
                windowHash = (windowHash * base
                        + txt.charAt(i + m)) % mod;
            }
        }

        return ans;
    }
}