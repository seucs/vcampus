package CallBack;

import Message.LoginMessage;

public interface LoginIcallback {
	public void run(LoginMessage m);// 接口方法

	public void gologin();

	public void newPass();
}

