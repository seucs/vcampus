package Connect;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

import CallBack.ChatCallBack;
import CallBack.Libarycallback;
import CallBack.LoginIcallback;
import CallBack.UpdateCallBack;
import Message.*;

public class MessageThread extends Thread {
	private ObjectInputStream ob_is;
	private Client client;
	private LoginIcallback loginListener = null;
	private Libarycallback libaraylistener =null;
	private UpdateCallBack updatelistener = null;
	private ChatCallBack chatlistner = null;

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
	
	public void setUpdatelistener(UpdateCallBack clb) {
		this.updatelistener=clb;
	}
	
	public void setChatCallBack (ChatCallBack clb){
		this.chatlistner = clb;
	}
	
	public void run() {
		while (true) {
			try {
				Message serverMessage = (Message) ob_is.readObject();
				
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
			
			loginListener.run((LoginMessage) m.getData());
			
			
			break;
			
		case "ACCESS":
			
			loginListener.gologin();
			
			break;
			
		case "NEWPW":
			
			loginListener.newPass();
			
			break;
			
		case "Book":
		
			libaraylistener.getbooklist((ArrayList<BookMessage>) m.getData());
		
			break;
		case "FriendList":
			
			updatelistener.UpdateFriendList(m);
			break;
		case "Selfmessage":
			
			updatelistener.UpdateDetial(m);
			break;
		
		case "Chat":
			
			chatlistner.recived((ChatMessage)m.getData());
		
		default:
			break;
		}
	}

	
}