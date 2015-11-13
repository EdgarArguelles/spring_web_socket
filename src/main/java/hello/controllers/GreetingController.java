package hello.controllers;

import hello.pojos.Greeting;
import hello.pojos.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * This controller receives and handles the messages
 */
@Controller
public class GreetingController {

    // MessageMapping annotation ensures that if a message is sent to destination "/say_hello", then the greeting() method is called.
    @MessageMapping("/say_hello")
    @SendTo("/topic/greetings")
    /**
     * Receives the hello message and sends back a greeting message.
     * @Param message the payload of the message is bound to a HelloMessage class
     * @return a greeting message bound to a Greeting class
     */
    public Greeting greeting(HelloMessage message) throws Exception {
        /* Internally, the implementation of the method simulates a processing delay by causing the thread
        to sleep for 3 seconds. This is to demonstrate that after the client sends a message, the server
        can take as long as it needs to process the message asynchronously. The client may continue with
        whatever work it needs to do without waiting on the response.*/
        Thread.sleep(3000); // simulate delay

        /* After the 3 second delay, the greeting() method creates a Greeting object and returns it. The return
        value is broadcast to all subscribers to "/topic/greetings" as specified in the @SendTo annotation.*/
        return new Greeting("Hello, " + message.getName() + "!");
    }

    @MessageMapping("/say_hello2")
    @SendTo("/topic/greetings")
    public Greeting greeting2(HelloMessage message) throws Exception {
        Thread.sleep(3000);
        return new Greeting("Hello2, " + message.getName() + "!");
    }
}