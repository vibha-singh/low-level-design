package websocket;


import jakarta.websocket.EncodeException;
import jakarta.websocket.Encoder;

import java.util.Base64;

public class MessageEncoder implements Encoder.Text<Message>{
    @Override
    public String encode(Message message) throws EncodeException {
        return Base64.getEncoder().encodeToString(message.toString().getBytes());
    }
}
