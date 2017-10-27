package Home;


import javax.swing.JPanel;
import javax.swing.JTextField;
import CallBack.LoginIcallback;
import Connect.Client;
import Login.JpanelForm;
import Message.LoginMessage;

public class RunHomepage {
	static Client client = new Client();
	static JpanelForm loginFrm;

	public static Client getclient(){
		return client;
	}
	
	public static void main(String[] args) {

		loginFrm = new JpanelForm(client);

		loginFrm.getLgBt().addActionListener(new java.awt.event.ActionListener() {// jb1事件

			public void actionPerformed(java.awt.event.ActionEvent e) {
				login();
			}

		});

		loginFrm.p2.refer.addActionListener(new java.awt.event.ActionListener() {// jb1事件

			public void actionPerformed(java.awt.event.ActionEvent e) {

				signup(loginFrm.p2.studentIDinput, loginFrm.p2.studentcardIDinput, loginFrm.p3);
			}

		});

		loginFrm.p4.refer.addActionListener(new java.awt.event.ActionListener() {// jb1事件

			public void actionPerformed(java.awt.event.ActionEvent e) {

				signup(loginFrm.p4.studentIDinput, loginFrm.p4.studentcardIDinput, loginFrm.p5);
			}

		});
	}

	protected static void signup(JTextField id, JTextField card, final JPanel goal) {
		if (client.signupServer(12345, "127.0.0.1", id.getText(), card.getText())) {
			client.messageThread.setloginListener(new LoginIcallback() {

				@Override
				public void gologin() {

				}

				@Override
				public void run(LoginMessage m) {

				}

				@Override
				public void newPass() {
					loginFrm.xiaoGuo(goal);
				}
			});

		}

	}

	static void login() {
		if (client.connectServer(9090, "127.0.0.1", loginFrm.getStuid(), loginFrm.getPass())) {
			client.messageThread.setloginListener(new LoginIcallback() {

				@Override
				public void gologin() {
					Homepage hp = new Homepage(client);
				}

				@Override
				public void run(LoginMessage m) {
					
				}

				@Override
				public void newPass() {

				}
			});

		}
	}

}
