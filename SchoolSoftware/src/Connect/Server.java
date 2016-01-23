package Connect;
import java.io.IOException;
import java.io.Serializable;
import java.net.BindException;
import java.net.ServerSocket;
import java.util.ArrayList;

import Message.*;

public class Server implements Serializable{
	private ServerSocket serverSocket;
	private ServerThread serverThread;
	private ArrayList<ClientThread> clients;
	private boolean isStart = false;
	
	public static void main(String[] args) {
		try {
			new Server().startServer(30, 12345);
		} catch (BindException e) {
			e.printStackTrace();
		}
	}
	
	public boolean IsStarted() {
		
		return isStart;
	}

	public void startServer(int max, int port) throws java.net.BindException {
		try {
			clients = new ArrayList<ClientThread>();
			serverSocket = new ServerSocket(port);
			serverThread = new ServerThread(this, max);
			serverThread.start();
			isStart = true;
		} catch (BindException e) {
			isStart = false;
			throw new BindException("端口号已被占用，请换一个！");
		} catch (Exception e1) {
			e1.printStackTrace();
			isStart = false;
			throw new BindException("启动服务器异常！");
		}
	}

	public void closeServer() {
		try {
			if (serverThread != null) {
				serverThread.stop();
			}
			for (int i = clients.size() - 1; i >= 0; i--) {
				clients.get(i).sendMessage(new ChatMessage());
				clients.get(i).closeThread();
				clients.remove(i);
			}
			if (serverSocket != null) {
				serverSocket.close();
			}
			isStart = false;
		} catch (IOException e) {
			e.printStackTrace();
			isStart = true;
		}
	}

	public void sendServerMessage(ChatMessage chatMessage) {
		if (!isStart) {
			System.out.println("服务器还未启动,不能发送消息！");
			return;
		}
		if (clients.size() == 0) {
			System.out.println("没有用户在线,不能发送消息！");
			return;
		}
		if (chatMessage == null) {
			System.out.println("消息不能为空！");
			return;
		}
		for (int i = clients.size() - 1; i >= 0; i--) {
//			if (chatMessage.getReceiver().equals(clients.get(i).getUid())) {
//				clients.get(i).sendMessage(chatMessage);
//			}
		}
	}

	public void deleteClients(ClientThread clientThread) {
		for (int i = clients.size() - 1; i >= 0; i--) {
			if (clients.get(i) == clientThread) {
				clientThread.closeThread();
				clients.remove(i);
				return;
			}
		}
	}

	public void addClients(ClientThread clientThread){
		clients.add(clientThread);
	}

	public int getClientsSize() {
		return clients.size();
	}

	public ServerSocket getServerSocket(){
		return this.serverSocket;
	}
}
