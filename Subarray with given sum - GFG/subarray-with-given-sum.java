//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution
{
public static ArrayList<Integer> subarraySum(int[] arr, int N,int S){
    int right=0;
    int left=0;
    int sum=0;
       if (S == 0) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        return result;
    }
    ArrayList<Integer>result=new ArrayList<>();
    while(right<N){
        sum+=arr[right];
        
        while(sum>S && left<=right){
            sum-=arr[left];
            left++;
        }
        if(sum==S){
            result.add(left+1);
            result.add(right+1);
            return result;
        }
        right++;
    }
    result.add(-1);
    return result;
}
// public static ArrayList<Integer> subarraySum(int[] arr, int N, int S) {
//     int left = 0, right = 0, sum = 0;
//     ArrayList<Integer> result = new ArrayList<>();

//     while (right < N) {
//         sum += arr[right];

//         while (sum > S && left <= right) {
//             sum -= arr[left];
//             left++;
//         }

//         if (sum == S) {
//             result.add(left + 1);
//             result.add(right + 1);
//             return result;
//         }

//         right++;
//     }

//     result.add(-1);
//     return result;
// }
}

