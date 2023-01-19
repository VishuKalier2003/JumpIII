/* You are given a 0-indexed array of integers nums of length n... You are initially positioned at nums[0]... Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
* 0 <= j <= nums[i] and
* i + j < n
Return the minimum number of jumps to reach nums[n - 1]... The test cases are generated such that you can reach nums[n - 1]...
 * Eg 1: nums = [2,3,1,1,4]        Output = 2
 * Eg 2: nums = [2,3,0,1,4]        Output = 2
*/
import java.util.*;
public class JumpIII
{
    public int MinJumps(int nums[])
    {
        int len = nums.length - 1, curr = -1, next = 0, ans = 0;
        for (int i = 0; next < len; i++)
        {
            if (i > curr)   // While the range is not reached the end...
            {
                ans++;    // Updating the number of steps taken...
                curr = next;
            }
            next = Math.max(next, nums[i] + i);    // Taking the maximum range possible...
        }
        return ans;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.print("Enter the number of jumps : ");
        x = sc.nextInt();
        int jump[] = new int[x];
        for(int i = 0; i < x; i++)
        {
            System.out.print("Enter the value of "+(i+1)+" th jump : ");
            jump[i] = sc.nextInt();
        }
        JumpIII jumpIII = new JumpIII();    // object creation...
        System.out.println("The Minimum Jumps Required :"+jumpIII.MinJumps(jump));
        sc.close();
    }
}

// Time Complexity  - O(n) time...
// Space Complexity - O(1) space...

/* DEDUCTIONS :- 
 * 1. We want to reach the end, and we greedily choose the maximum range we can attain at every step...
 * 2. When our maximum range hits the end of the array we return our answer as the number of steps iterated...
*/