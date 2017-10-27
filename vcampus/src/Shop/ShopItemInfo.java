package Shop;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShopItemInfo extends JFrame{
	JPanel content = new JPanel();
	//JLabel 
	public ShopItemInfo(String name) {
		super("name");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screensize = kit. getScreenSize();
		this.setBounds((screensize.width-500)/2,(screensize.height-500)/2,500,500);
		content.setBounds(0,0,500,500);
		this.setContentPane(content);
		
		
	}
}
