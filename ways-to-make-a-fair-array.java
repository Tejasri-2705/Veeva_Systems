class Solution {
    public int waysToMakeFair(int[] nums) {
        int c=0;
        int es=0;
        int os=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i%2==0)
            {
                es=es+nums[i];
            }
            else{
                os=os+nums[i];
            }
        }
        
        int leftEven = 0;
        int leftOdd = 0;
        for (int i = 0; i < nums.length; i++) {

            if (i % 2 == 0) {
                es -= nums[i];
            } else {
                os -= nums[i];
            }
            int newe=os+leftEven;
            int newo=es+leftOdd;

            if(newe==newo)
            {
                c++;
            }
            if (i % 2 == 0) {
                leftEven += nums[i];
            } else {
                leftOdd += nums[i];
            }

         }
    return c;
    }
}
