import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static final int PORT = 12345;// 监听的端口号
	private ServerBox serverBox;

	public Server(ServerBox sB) {
		serverBox = sB;
	}

	public void init() {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			while (true) {
				// 一旦有堵塞, 则表示服务器与客户端获得了连接
				Socket client = serverSocket.accept();
				// 处理这次连接
				new HandlerThread(client);
			}
		} catch (Exception e) {
			System.out.println("服务器异常: " + e.getMessage());
		}

	}
	/////////////// 初始化//////////////////////////

	public static void SendMessage(Socket socket, String str) throws IOException {
		// 向客户端回复信息
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		// String s = new BufferedReader(new
		// InputStreamReader(System.in)).readLine();
		out.writeUTF(str);
		out.close();
	}

	/**
	 * 
	 * @param socket
	 * @throws IOException
	 */
	public void GetMessage(Socket socket) throws IOException {
		DataInputStream input = new DataInputStream(socket.getInputStream());
		String clientInputStr = input.readUTF();
		String ip = socket.getInetAddress().getHostAddress().toString();
		serverBox.addGetMessage(clientInputStr, ip);
		input.close();
	}

	private class HandlerThread implements Runnable {
		private Socket socket;

		public HandlerThread(Socket client) {
			socket = client;
			new Thread(this).start();
		}

		public void run() {
			try {
				GetMessage(socket);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// try {
			//
			//
			//
			// } catch (Exception e) {
			// System.out.println("服务器 run 异常: " + e.getMessage());
			// } finally {
			// if (socket != null) {
			// try {
			// socket.close();
			// } catch (Exception e) {
			// socket = null;
			// System.out.println("服务端 finally 异常:" + e.getMessage());
			// }
			// }
			// }
		}
		////////////// 新线程///////////////////
	}
}