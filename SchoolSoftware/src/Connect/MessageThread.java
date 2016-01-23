package Connect;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

import CallBack.Libarycallback;
import CallBack.LoginIcallback;
import Message.*;

public class MessageThread extends Thread {
	private ObjectInputStream ob_is;
	private Client client;
	private LoginIcallback loginListener = null;
	private Libarycallback libaraylistener =null;

	public MessageThread(Client client) {
		this.client = client;
		this.ob_is = client.getObjectInputStream();
		
	}

	public void setloginListener(LoginIcallback cbl){//2.2  
        this.loginListener = cbl;  
    } 
	
	public void setlibaraylistener(Libarycallback clb)
	{
		this.libaraylistener = clb;
	}
	
	public void run() {
		while (true) {
			try {
				Message serverMessage = (Message) ob_is.readObject();
				System.out.println("nice try");
//				if(serverMessage.getSender().equals("Server")){
//					if (serverMessage.getContent().equals("CLOSE")) {
//						client.closeConnection();
//						return;
//					} else if(serverMessage.getContent().equals("MAX")){
//						client.closeConnection();
//					}
//				}else{
//					//System.out.println(chatMessage);
//					//listener.run(chatMessage.getH());
//					
//				}
				handleMessage(serverMessage);
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void handleMessage(Message m){
		switch (m.getType()) {
		case "Login":
			
			loginListener.run((LoginMessage) m.getObj());
			
			
			break;
			
		case "ACCESS":
			
			loginListener.gologin();
			
			break;
			
		case "NEWPW":
			
			loginListener.newPass();
			
			break;
			
		case "Book":
		
			libaraylistener.getbooklist((ArrayList<BookMessage>) m.getObj());
		
			break;

		default:
			break;
		}
	}
}