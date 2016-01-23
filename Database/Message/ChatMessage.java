package Message;
import java.io.Serializable;

public class ChatMessage implements Serializable {
	
		public ChatMessage(){
			
		}
	
			public ChatMessage(String time, String sender, String recipient, String content) {
		super();
		this.time = time;
		this.sender = sender;
		this.recipient = recipient;
		this.content = content;
	}

			//time(Time:yyyy-mm-dd hh:mm:ss), sender, recipient, content
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
