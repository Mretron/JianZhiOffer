import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

/**
 * @author etron
 * @date 2019/11/18 21:06
 */
public class Test implements Serializable {

    public String status = "还没被序列化";

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Test test = new Test();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("here.txt"));
        System.out.println(test);
        test.status = "已被序列化";
        objectOutputStream.writeObject(test);
        objectOutputStream.close();



        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("here.txt"));

        test = (Test) objectInputStream.readObject();
        System.out.println(test);
        objectOutputStream.close();

    }

    @Override
    public String toString() {
        return status;
    }
}
