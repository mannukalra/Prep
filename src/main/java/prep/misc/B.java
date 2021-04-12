package prep.misc;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class A{}
public class B implements Serializable {
    private  static A a = new A();

    public static void main(String[] args) {
        B b = new B();
        try {
            FileOutputStream fos = new FileOutputStream("b.ser");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(b);
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
