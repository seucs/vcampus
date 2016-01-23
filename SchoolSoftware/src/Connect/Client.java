package Connect;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

import Message.*;

public class Client implements Serializable{

	private boolean isConnected = false;
	private Socket socket;
	private ObjectOutputStream ob_os = null;
	private ObjectInputStream ob_is = null;
	
	private String id;
	public  MessageThread messageThread;// 负责接收消息的线程

	public Client() {
		//this.id = id;
		
	}

	// 连接服务器
	public boolean signupServer(int port, String hostIp,String stuid,String onecard) {
		try {
			socket = new Socket(hostIp, port);

			ob_os = new ObjectOutputStream(socket.getOutputStream());
			isConnected = true;
			//sendClientMessage(new ChatMessage("111", id, "Server", "aaa",null));
			id = stuid;
			LoginMessage temp = new LoginMessage();
			temp.setStudentnumber(stuid);
			temp.setOnecard(onecard);
			Message login_m = new Message("Login", 0, temp);
			sendMessage(login_m);
			
			
			ob_is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));

			messageThread = new MessageThread(Client.this);
			messageThread.start();
			return true;
		} catch (Exception e) {
			isConnected = false;
			return false;
		}
	}
	
	public boolean connectServer(int port, String hostIp,String stuid,String pass) {
		try {
			socket = new Socket(hostIp, port);
			id = stuid;
			ob_os = new ObjectOutputStream(socket.getOutputStream());
			isConnected = true;
			//sendClientMessage(new ChatMessage("111", id, "Server", "aaa",null));
			
			LoginMessage temp = new LoginMessage();
			temp.setStudentnumber(stuid);
			temp.setPassword(pass);
			Message login_m = new Message("Login", 0, temp);
			sendMessage(login_m);
			
			
			ob_is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));

			messageThread = new MessageThread(Client.this);
			messageThread.start();
			return true;
		} catch (Exception e) {
			isConnected = false;
			return false;
		}
	}

	// 发送消息
	public void sendMessage(Message message) {
		if (!isConnected) {
			System.out.println("客户端还未启动,不能发送消息！");
			return;
		}
		if (message == null ) {
			System.out.println("消息不能为空！");
			return;
		}
		try {
			ob_os.writeObject(message);
			ob_os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendNewPass(String pass) {
		if (!isConnected) {
			System.out.println("客户端还未启动,不能发送消息！");
			return;
		}
		if (pass == null ) {
			System.out.println("消息不能为空！");
			return;
		}
		try {
			LoginMessage temp = new LoginMessage();
			temp.setStudentnumber(id);
			temp.setPassword(pass);
			Message login_m = new Message("Login", 1, temp);
			ob_os.writeObject(login_m);
			ob_os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendBookQuery(String b_name) {
		if (!isConnected) {
			System.out.println("客户端还未启动,不能发送消息！");
			return;
		}
		if (b_name == null ) {
			System.out.println("消息不能为空！");
			return;
		}
		try {
			
			Message login_m = new Message("BookQuery", 1, b_name);
			ob_os.writeObject(login_m);
			ob_os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	// 客户端主动关闭连接
	@SuppressWarnings("deprecation")
	public synchronized boolean closeConnection() {
		try {
			//sendClientMessage(new ChatMessage("111", id, "CLOSE", "CLOSE",null));
			messageThread.stop();

			if (ob_is != null) {
				ob_is.close();
			}
			if (ob_os != null) {
				ob_os.close();
			}
			if (socket != null) {
				socket.close();
			}
			isConnected = false;
			return true;
		} catch (IOException e1) {
			e1.printStackTrace();
			isConnected = true;
			return false;
		}
	}

	// 判断是否连接
	public boolean IsConnected() {
		return isConnected;
	}

	public ObjectOutputStream getObjectOutputStream() {
		return ob_os;
	}

	public ObjectInputStream getObjectInputStream() {
		return ob_is;
	}

	

}