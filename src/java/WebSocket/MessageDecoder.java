/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebSocket;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import message.ChatMessage;
import message.Message;

/**
 *
 * @author lewismenelaws
 */
public class MessageDecoder implements Decoder.Text<Message> {

    @Override
    public Message decode(String jsonMessage) throws DecodeException {
        ChatMessage chatMessage = new ChatMessage();
        JsonObject jsonObject = Json.createReader(new StringReader(jsonMessage)).readObject();
        chatMessage.setMessage(jsonObject.getString("message"));
        chatMessage.setLocation(jsonObject.getString("location"));
        return chatMessage;
    }

    @Override
    public boolean willDecode(String jsonMessage) {
        boolean flag = true;
        try { Json.createReader(new StringReader(jsonMessage)).readObject();}
        catch (Exception e) {flag = false;}
        return flag;
    }

    @Override
    public void init(EndpointConfig config) {
        
    }

    @Override
    public void destroy() {
        
    }
    
}
