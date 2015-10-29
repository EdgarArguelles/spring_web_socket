package hello;

/**
 * Upon receiving the message and extracting the name, the service will process it by creating a greeting
 * and publishing that greeting on a separate queue that the client is subscribed to. The greeting will
 * also be a JSON object, which might look something like this:
 * {"content": "Hello, Fred!"}
 * This class represents the JSON response
 */
public class Greeting {

    private String content;

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}