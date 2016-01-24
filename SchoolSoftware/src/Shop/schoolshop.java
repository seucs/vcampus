package Shop;


import java.awt.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

//import shop.itemButton;
public class schoolshop extends JPanel{
	
	ArrayList<Shop_Item_Button> item=new ArrayList();
	public JScrollPane jsp;
	public JPanel background_panel=new JPanel();

	
	public schoolshop(){
	this.setLayout(null);
	this.setSize(900, 700);
	this.setBackground(Color.white);
	background_panel.setBackground(Color.white);
	background_panel.setLayout(null);
	
	for (int i = 0; i < 2; i++) {
	
		item.add(new Shop_Item_Button(450,140,new ImageIcon(),0,22));
	
		item.get(i).setBounds(0+450*(i%2), 140*(i/2), 450, 140);
		background_panel.add(item.get(i));
		
	}
	final ImageIcon CT1 =new ImageIcon("images/CT1.png");
	item.get(0).setPic(CT1);	
	item.get(0).setName("文化衫1");
	item.get(0).setPrice("100.00");
	final ImageIcon CT2 =new ImageIcon("images/CT2.png");
	item.get(1).setPic(CT2);
	item.get(1).setName("文化衫2");
	item.get(1).setPrice("100.00元");
	jsp=new JScrollPane(background_panel);
	jsp.setBounds(0, 0, 1000, 570);
	this.add(jsp);
	jsp.setVisible(false);
	jsp.setVisible(true);
	this.setVisible(false);
	this.setVisible(true);

	}

}
