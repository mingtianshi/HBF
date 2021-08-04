package until;

public class Mouse {
    /**
     * 时时获取本地鼠标位置
     * 每100ms获取一次
     */
    public void Mouse(){

    }

    public void KeyboardLog(){

    }

}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // x1 + x2 = x3
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }
    public <n> int[] twoSumX(int[] nums, int[] target) {

        return null;
    }


    public boolean areOccurrencesEqual(String s) {
        int d[] = new int[26];
        int a;
        for(char c:s.toCharArray()){
            // 1 2 3
            a = d[c-'1'];
        }
        int f = 0;
        for(int i=0;i<26;++i){
            if(f==0){
                f= d[i];
            }else if(f!=d[i]) return false;
        }
        return true;
    }
    public int getLucky(String s, int k) {
        char[] chars = s.toCharArray();
        int[] an = new int[100];
        int[] ans = new int[100];
        int num = 0;
        int nums = 0;
        //for (int j = 0; j < k; j++) {
            for (int i = 0; i < s.length(); i++) {
                int a =  chars[i] - '`';
                //a - a-1 = 1 a b c d e f g h i j k l m n o p q r
                // s t u v w s y z
                // a = 普通值
                an[i] += a;
                //an[i] 1 + num[an[i+1]]
                nums = an[i] + an[i+1];
                num += nums;
                // num 69
                if(k == 1){
                    num = nums/10;
                }else {
                    for (int l = 0; l < k; l++) {
                        // 6
                        num = nums / 10;
                    }
                }
            }
       // }
        return num;
    }

    int getLuckys(String s, int k) {
        int t = 0;
        for (char c: s.toCharArray()) {
            int x = c - 'a' + 1;
            //5 % 10
            t += x%10;
            //l
            System.out.println(t);
            t += x/10;
            System.out.println(t);
        }

        for (int i=1; i<k; ++i) {
            //!=k == 1
            int r = 0;
            // 33
            while (t>0) {
                // % 10
                //3
                r += t%10;
                //33/10
                t/=10;
            }
            //
            t = r;
        }
        return t;
    }

    public static void main(String[] args) {
        Mouse m = new Mouse();
        //
        String a1 = "iiii";
        String a = "leetcode";
        Solution solution = new Solution();
        System.out.println(solution.getLuckys(a,2));
    }
// t
// v
// e
// i
// x
// w
// a
// e
// o
// e
// z
// c
// f
}
