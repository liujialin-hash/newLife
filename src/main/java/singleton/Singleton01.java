package singleton;

public class Singleton01 {

    /*饿汉式*/
    private static Singleton01 singleton01;
    // = new Singleton01();
    
    /*构造方法*/
    private Singleton01(){

    }
    /*synchronized 是为了线程安全*/
    public synchronized static Singleton01 getInstance(){
        //懒汉式
        if (singleton01==null){
            singleton01 =new Singleton01();
        }

        return singleton01;
    }
}
