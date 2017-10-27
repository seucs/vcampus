package Connect;
import DAO.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

import Message.*;

class ServerThread extends Thread {
	private Server server;
	private int max;
	DataAccessObject mData = new DataAccessObject();

	public ServerThread(Server server, int max) {
		
		this.server = server;
		this.max = max;
		mData.getConn();

	}

	public void run() {
		while (true) {
			try {

				Socket socket = server.getServerSocket().accept();

				ObjectInputStream ob_is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
				ObjectOutputStream ob_os = new ObjectOutputStream(socket.getOutputStream());
				
				Message message = (Message) ob_is.readObject();
				LoginMessage temp = (LoginMessage) message.getData();
				
				if(mData.getLoginDAO().LoginCheck(temp.getPassword(), temp.getStudentnumber())){
					ClientThread client = new ClientThread(socket, temp.getStudentnumber(), server, ob_is, ob_os,mData);
					server.addClients(client);

					if (server.getClientsSize() > max) {
						//server.sendServerMessage(new ChatMessage("123", "Server", client.getUid(), "MAX",null));
						client.closeThread();
						continue;
					}
					client.start();
					client.sendLoginAccess();
				}
				
				if(mData.getLoginDAO().SignupCheck(temp.getOnecard(), temp.getStudentnumber())){
					ClientThread client = new ClientThread(socket, temp.getStudentnumber(), server, ob_is, ob_os,mData);
					server.addClients(client);

					if (server.getClientsSize() > max) {
						//server.sendServerMessage(new ChatMessage("123", "Server", client.getUid(), "MAX",null));
						client.closeThread();
						continue;
					}
					client.start();
					client.sendSignupAccess();
					
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
