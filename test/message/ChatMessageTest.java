/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package message;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lewismenelaws
 */
public class ChatMessageTest {
    
    public ChatMessageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class ChatMessage.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        ChatMessage instance = new ChatMessage();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class ChatMessage.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Lewis";
        ChatMessage instance = new ChatMessage();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class ChatMessage.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        ChatMessage instance = new ChatMessage();
        String expResult = "";
        String result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocation method, of class ChatMessage.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String location = "";
        ChatMessage instance = new ChatMessage();
        instance.setLocation(location);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessage method, of class ChatMessage.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        ChatMessage instance = new ChatMessage();
        String expResult = "";
        String result = instance.getMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessage method, of class ChatMessage.
     */
    @Test
    public void testSetMessage() {
        System.out.println("setMessage");
        String message = "";
        ChatMessage instance = new ChatMessage();
        instance.setMessage(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
