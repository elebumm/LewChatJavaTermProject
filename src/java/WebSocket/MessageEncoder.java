/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebSocket;

import java.util.Iterator;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import message.ChatMessage;
import message.Message;
import message.UsersMessage;

/**
 *
 * @author lewismenelaws
 */
public class MessageEncoder implements Encoder.Text<Message> {
    
    @Override
    public void destroy() {
        
    }
    
    @Override
    public void init(EndpointConfig arg0) {
        
    }

    @Override
    public String encode(Message message) throws EncodeException {
        String returnString = null;
        if (message instanceof ChatMessage) {
            ChatMessage chatMessage = (ChatMessage) message;
            returnString = Json.createObjectBuilder().add("messageType", chatMessage.getClass().getSimpleName())
                                                     .add("name", chatMessage.getName())
                                                     .add("message", chatMessage.getMessage())
                                                     .add("location", chatMessage.getLocation())
                                                     .build().toString();
        }
        else if (message instanceof UsersMessage) {
        UsersMessage usersMessage = (UsersMessage) message;
        returnString = buildJsonUsersData(usersMessage.getUsers(), usersMessage.getClass().getSimpleName());
    }
        return returnString;
    }
    
    private String buildJsonUsersData(Set<String> set, String messageType) {
        Iterator<String> iterator = set.iterator();
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        while (iterator.hasNext()) jsonArrayBuilder.add(iterator.next());
        return Json.createObjectBuilder().add("messageType", messageType)
                                         .add("users", jsonArrayBuilder)
                                         .build().toString();
    }
}
