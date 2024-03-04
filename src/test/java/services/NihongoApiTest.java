package services;

import com.nihongo.test.MethodTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class NihongoApiTest {

    @Test
    public void sumTest(){
        int res = MethodTest.sum(10, 20);
        int expected = 30;
        if(expected == res) {
            System.out.println("ans : "+ res);
        }
        else {
            System.out.println("fail..."+expected);
        }
        Assert.assertEquals(expected, res);
    }
}
