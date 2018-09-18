import sun.misc.BASE64Decoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class Encode {



    public static void main(String[] args) {
        try {
            BASE64Decoder base64Decoder = new BASE64Decoder();
            InputStream is = ClassLoader.getSystemResourceAsStream("encoded.txt");
            final byte[] bytes = base64Decoder.decodeBuffer(is);

            String text = new String(bytes, Charset.forName("windows-1251"));

            System.out.println( text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
