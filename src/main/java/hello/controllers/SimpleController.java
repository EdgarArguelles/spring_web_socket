package hello.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * This controller receives and handles the messages
 */
@Controller
public class SimpleController {

    @MessageMapping("/simple")
    @SendTo("/topic/simple")
    public String simpleGreeting(String name) throws Exception {
        Thread.sleep(3000);
        return "Simple hi " + name + "!";
    }
}