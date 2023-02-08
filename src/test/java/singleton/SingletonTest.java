package singleton;

import org.junit.Test;

public class SingletonTest {
    @Test
    public void singleton(){
        Singleton01 instance = Singleton01.getInstance();
        Singleton01 instance1 = Singleton01.getInstance();
        System.out.println(instance==instance1);
    }


}
