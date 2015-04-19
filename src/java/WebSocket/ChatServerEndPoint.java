/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebSocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import message.ChatMessage;
import message.Message;
import message.UsersMessage;
/**
 *
 * @author lewismenelaws
 */

@ServerEndpoint(value = "/chatServerEndpoint", encoders = { MessageEncoder.class }, decoders = { MessageDecoder.class})
public class ChatServerEndPoint {
    static Set<Session> chatroomUsers = Collections.synchronizedSet(new HashSet<Session>());
    @OnOpen
    public void handleOpen(Session userSession) throws IOException, EncodeException {
        chatroomUsers.add(userSession);
        Iterator<Session> iterator = chatroomUsers.iterator();
        while (iterator.hasNext()) iterator.next().getBasicRemote().sendObject(new UsersMessage(getIds()));
    }
    @OnMessage
    public void handleMessage(Message incomingMessage, Session userSession) throws IOException, EncodeException {
        if (incomingMessage instanceof ChatMessage) {
            ChatMessage incomingChatMessage = (ChatMessage)incomingMessage;
            ChatMessage outgoingChatMessage = new ChatMessage();
            String username = (String) userSession.getUserProperties().get("username");
            if (username==null) {
                userSession.getUserProperties().put("username", incomingChatMessage.getMessage());
                outgoingChatMessage.setName("No-Name");
                outgoingChatMessage.setLocation("No-Location");
                userSession.getBasicRemote().sendObject(outgoingChatMessage);
            }
            else{
                outgoingChatMessage.setName(username);
                outgoingChatMessage.setLocation(incomingChatMessage.getLocation());
                outgoingChatMessage.setMessage(incomingChatMessage.getMessage());
                Iterator<Session> iterator = chatroomUsers.iterator();
                        while (iterator.hasNext()) iterator.next().getBasicRemote().sendObject(outgoingChatMessage);
            }
            Iterator<Session> iterator = chatroomUsers.iterator();
        while (iterator.hasNext()) iterator.next().getBasicRemote().sendObject(new UsersMessage(getIds()));
        }
    }
    @OnClose
    public void handleClose(Session userSession) throws IOException, EncodeException {
        chatroomUsers.remove(userSession);
        Iterator<Session> iterator = chatroomUsers.iterator();
        while (iterator.hasNext()) iterator.next().getBasicRemote().sendObject(new UsersMessage(getIds()));
    }
    public static Set<String> getIds() {
        HashSet<String> returnSet = new HashSet<String>();
        Iterator<Session> iterator = chatroomUsers.iterator();
        while (iterator.hasNext()) returnSet.add(iterator.next().getUserProperties().get("username").toString());
        return returnSet;
    }
}
