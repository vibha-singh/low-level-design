package websocket;

import com.google.gson.Gson;
import jakarta.websocket.DecodeException;
import jakarta.websocket.Decoder;

import java.util.Base64;

public class MessageDecoder implements Decoder.Text<Message> {
    private Gson gson = new Gson();
    @Override
    public Message decode(String s) throws DecodeException {
        Message message = gson.fromJson(new String(Base64.getDecoder().decode(s.getBytes())), Message.class);
        return message;
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }
}
