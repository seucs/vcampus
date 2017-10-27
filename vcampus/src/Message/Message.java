package Message;
import java.io.Serializable;

public class Message implements Serializable {
	private String type;
	private int code;
	private Object data;
	
	public Message(String type, int code, Object data)
	{
		this.type=type;
		this.code=code;
		this.data=data;
	}

	public String getType() 
	{
		return type;
	}

	public void setType(String type) 
	{
		this.type = type;
	}

	public int getCode() 
	{
		return code;
	}

	public void setCode(int code) 
	{
		this.code = code;
	}

	public Object getData() 
	{
		return data;
	}

	public void setData(Object data) 
	{
		this.data = data;
	}
	
	
}

