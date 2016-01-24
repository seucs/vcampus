package Connect;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

import com.hxtt.a.b;

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
//					
					if(theMessage.getCode()==1&&theMessage.getType().equals("Login")){
						LoginMessage temp = (LoginMessage) theMessage.getData();
//						mData.updateLoginPassword(temp.getStudentnumber(), temp.getPassword());
					}
					
					
					handleMessage(theMessage);
					
					
					
					//sendMessage(null);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public void handleMessage(Message m_message){
		switch (m_message.getType()) {
		case "BookQuery":
			
			BookQueryMessage temp = (BookQueryMessage) m_message.getData();
			Message result;
			if(temp.isAuthor()==false){
				result = new Message("Book", 0,mData.getBookDAO().queryBookCategory(temp.getContent(), temp.isNovel(), temp.isEssay(), temp.isPoetry(), temp.isFinance(), temp.isComputer(), temp.isElectron(), temp.isPhysics(), temp.isMaths(), temp.isChemisty(), temp.isBiology(), temp.isLanuage()));

			}
			else {
				result = new Message("Book", 0,mData.getBookDAO().queryBookCategorybyauthor(temp.getContent(), temp.isNovel(), temp.isEssay(), temp.isPoetry(), temp.isFinance(), temp.isComputer(), temp.isElectron(), temp.isPhysics(), temp.isMaths(), temp.isChemisty(), temp.isBiology(), temp.isLanuage()));

			}
			sendMessage(result);
			
			break;
		
		case "Bookborrowed":
			
			break;	
		
		case "PersonalFetch":
			
			
			ArrayList<FriendMessage> tempfriednlist = mData.getFriendDAO().queryFriendMessage("studentnumber", uid);
			ArrayList<PersonMessage> result2 = new ArrayList<PersonMessage>();
			for(FriendMessage f:tempfriednlist){
				result2.add(mData.getPersonDAO().queryPersonMessage_single("number", f.getFriendnumber()));
			}
			Message result_message = new Message("FriendList", 0,result2);
			sendFriendlist(result_message);
			PersonMessage self = mData.getPersonDAO().queryPersonMessage_single("number", uid);
			Message result_self = new Message("Selfmessage", 0, self);
			sendSelfDetial(result_self);
			
			break;
			
		case "Chat":
			
			sever.sendServerMessage(m_message);
				
			break;
			
		default:
			break;
		}
	}
	
	private void sendSelfDetial(Message result_self) {
		try {
			ob_os.writeObject(result_self);
			ob_os.flush();
		} catch (IOException e) {
			e.printStackTrace();
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
	
	public void sendMessage(Message result){
		try {
						
						
			ob_os.writeObject(result);
			ob_os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendFriendlist(Message result){
		
			try {
				ob_os.writeObject(result);
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