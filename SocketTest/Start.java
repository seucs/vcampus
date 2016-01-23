public class Start {
	public static void main(String[] args) {
		
		ServerBox sBox =new ServerBox();
		
		Thread threadServer = new Thread(new Runnable() {
			
			@Override
			public void run() {
		        System.out.println("服务器启动...\n");  
		        Server server = new Server(sBox);  
		        server.init();  
		        //////////////////服务器启动////////////////////			
			}
		});
		threadServer.start();
		
		Thread threadClient = new Thread(new Runnable() {
			
			@Override
			public void run() {
		        Client.main(args);
		        //////////////////客户端	启动///////////////////		
			}
		});
		threadClient.start();

	}
}