package Message;

import java.io.Serializable;

public class ChatMessage implements Serializable{
    private String time;
    private String sender;
    private String recipient;
    private String content;
    
    public void setTime(String time)
    {
        this.time = time;
    }
    
    public String getTime()
    {
        return time;
    }
    
    public void setSender(String sender)
    {
        this.sender = sender;
    }
    
    public String getSender()
    {
        return sender;
    }
    
    public void setRecipient(String recipient)
    {
        this.recipient = recipient;
    }
    
    public String getRecipient()
    {
        return recipient;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }
    
    public String getContent()
    {
        return content;
    }
    
    
}