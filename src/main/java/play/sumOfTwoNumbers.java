package play;

public class sumOfTwoNumbers {

    public int[] sum(int [] sums,int target){
        int [] is=new int[2];
        for (int i = 0; i < sums.length-1; i++) {
            for (int j = 0; j < sums.length-2; j++) {
                if (i==j){
                    continue;
                }
                if (sums[i]+sums[j]==target){
                    is[0]=j;
                    /*日上三竿，摇头晃脑*/
                    is[1]=i;
                }

            }
        }
        return is;
    }

}
