package play;
import org.junit.Test;

import java.util.Arrays;
import java.util.jar.JarEntry;

public class sumOfTwoNumbersTest {

    int [] aa={2,7,11,15};
    int aaa=9;
    @Test
    public void si(){
        sumOfTwoNumbers sumOfTwoNumbers = new sumOfTwoNumbers();
        int[] sum = sumOfTwoNumbers.sum(aa, aaa);

        System.out.println(Arrays.toString(sum));
    }


}
