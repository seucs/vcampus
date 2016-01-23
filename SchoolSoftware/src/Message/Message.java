package Message;

import java.io.Serializable;

public class Message implements Serializable {
	private String type;
	private int code;
	private Object data;

	public Message(String type, int code, Object data) {
		this.type = type;
		this.code = code;
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public int getcode() {
		return code;
	}

	public Object getObj() {
		return data;
	}

}
