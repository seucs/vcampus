package Message;
import java.util.ArrayList;

public class RecivedData {
	
	ArrayList<Object> ALLData=new ArrayList();
	public RecivedData() {

	}
	
	public Object get(int i){
		return ALLData.get(i);
	}
}
