class Solution {
    public int maxProfit(int[] prices) {
        int minprice=prices[0];
        int max=0;
        int profit;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<minprice){
                minprice=prices[i];
            }else{
                profit=prices[i]-minprice;
                if(max<profit){
                max=profit;
            }
            }
        }
        return max;
    }
}