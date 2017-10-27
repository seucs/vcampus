package Library;
import java.util.ArrayList;

public class Bookpages {
	ArrayList<String[][]> ALLData=new ArrayList();
	public Bookpages() {
		
	}
	
	public String[][] page(int i){
		return ALLData.get(i);
	}
}
