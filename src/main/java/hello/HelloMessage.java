package hello;

/**
 * The service will accept messages containing a name in a STOMP message whose body is a JSON object.
 * If the name given is "Fred", then the message might look something like this:
 * {"name": "Fred"}
 * This class represents the JSON message
 */
public class HelloMessage {

    private String name;

    public String getName() {
        return name;
    }
}