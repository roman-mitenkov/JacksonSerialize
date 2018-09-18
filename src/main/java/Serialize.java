import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Serialize {

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            MultiValueMap<String, String> album = new LinkedMultiValueMap<String, String>();
            album.put("Tom", Collections.singletonList("Jerry"));
            final String s = mapper.writeValueAsString(album);
            System.out.println("s = " + s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
