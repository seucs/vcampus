package Connect;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

import DAO.DataAccessObject;
import Message.*;

class ClientThread extends Thread implements Serializable {
	private Server sever;
	private Socket socket;
	private ObjectInputStream ob_is = null;
	private ObjectOutputStream ob_os = null;
	private String uid;
	private DataAccessObject mData;

	public String getUid() {
		return uid;
	}

	public ClientThread(Socket socket, String uid, Server sever, ObjectInputStream ob_is, ObjectOutputStream ob_os,DataAccessObject data) {
		this.sever = sever;
		this.uid = uid;
		this.socket = socket;
		this.ob_is = ob_is;
		this.ob_os = ob_os;
		this.mData = data;
	}

	public void run() {
		while (true) {
			try {
				Message theMessage = (Message) ob_is.readObject();
				if (theMessage != null) {
//					if (chatMessage.getReceiver().equals("CLOSE")) {
//						ob_is.close();
//						ob_os.close();
//						socket.close();
//					} else {
//						sever.sendServerMessage(chatMessage);
//					}
					if(theMessage.getcode()==1&&theMessage.getType().equals("Login")){
						LoginMessage temp = (LoginMessage) theMessage.getObj();
//						mData.updateLoginPassword(temp.getStudentnumber(), temp.getPassword());
					}
					
					switch (theMessage.getType()) {
					case "Book":
						
						break;
					
					case "Bookborrowed":
						
						break;	
					
					default:
						break;
					}
					
					sendMessage(null);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public void sendMessage(ChatMessage chatMessage) {
		try {
			ob_os.writeObject(chatMessage);
			ob_os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendLoginAccess() {
		try {
			Message temp = new Message("ACCESS",0,null);
			
			ob_os.writeObject(temp);
			ob_os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendSignupAccess() {
		try {
			Message temp = new Message("NEWPW",0,null);
			
			ob_os.writeObject(temp);
			ob_os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendBookinfo(){
		try {
			
			
			
			Message temp = new Message("NEWPW",0,null);
			
			ob_os.writeObject(temp);
			ob_os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void closeThread() {
		try {
			this.stop();
			this.ob_is.close();
			this.ob_os.close();
			this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}