class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hi=new HashMap<>();
        hi.put(0,1);
        int sum=0;
        int count=0;
        for(int n:nums){
            sum+=n;
            if(hi.containsKey(sum-k)){
                count+=hi.get(sum-k);
            }
            hi.put(sum,hi.getOrDefault(sum,0)+1);
        }
        return count;
    }
}