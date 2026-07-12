class Solution {
    Boolean check(int arr[]){
        Arrays.sort(arr);
        int diff=arr[1]-arr[0];
        for(int i=2;i<arr.length;i++){
            if(arr[i]-arr[i-1]!=diff)   return false;
        }
        return true;
    }
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> li=new ArrayList<>();
        for(int i=0;i<l.length;i++){
            int arr[]=new int[r[i]-l[i]+1];
            int count=0;
            for(int j=l[i];j<=r[i];j++){
                arr[count]=nums[j];
                System.out.println(arr[count]);
                count++;
            }
            li.add(check(arr));
        }
        return li;
    }
}