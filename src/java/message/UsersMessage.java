/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package message;

import java.util.Set;

/**
 *
 * @author lewismenelaws
 */
public class UsersMessage implements Message{
    private Set<String> users = null;
    public UsersMessage(Set<String> users) {
        this.users = users;
    }
    public Set<String> getUsers() {
        return users;
    }
    
}
