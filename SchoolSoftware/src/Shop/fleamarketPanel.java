package Shop;

import java.awt.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

//import shop.itemButton;
public class fleamarketPanel extends JPanel{
	JButton sellitem=new JButton("出售商品");
ArrayList<itemButton> item=new ArrayList();
public fleamarketPanel(){
this.setLayout(null);
this.setSize(900, 700);
this.add(sellitem);
sellitem.setBounds(	300,570,200,40);
for (int i = 0; i < 8; i++) {
	itemButton temp=new itemButton();
	item.add(temp);
	this.add(item.get(i));
	int a=0;
	if(i==0||i==1)a=0;if(i==2||i==3)a=140;if(i==4||i==5)a=280;if(i==6||i==7)a=420;
	item.get(i).setBounds(0+450*(i%2), a, 450, 140);
	
}
	sellitem.setBounds(300, 570, 200, 40);
	sellitem.addActionListener(new java.awt.event.ActionListener() {

		public void actionPerformed(java.awt.event.ActionEvent e) {
			addsell();
		
		}

	});
	}
public void setItem(int i,String Name,ImageIcon Pic,String Price){
	item.get(i).setName(Name);
	item.get(i).setPic(Pic);
	item.get(i).setPrice(Price);
	 
}
public void addsell() {
	sellframe selljf=new sellframe();
	selljf.flea=this;
	
}
}