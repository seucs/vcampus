package Shop;


import java.awt.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

//import shop.itemButton;
public class schoolshop extends JPanel{
//	itemButton item1=new itemButton();
//	itemButton item2=new itemButton();
//	itemButton item3=new itemButton();
//	itemButton item4=new itemButton();
//	itemButton item5=new itemButton();
//	itemButton item6=new itemButton();
//	itemButton item7=new itemButton();
//	itemButton item8=new itemButton();		
	ArrayList<itemButton> item=new ArrayList();
	public schoolshop(){
	this.setLayout(null);
	this.setSize(900, 700);
	for (int i = 0; i < 8; i++) {
		itemButton temp=new itemButton();
		item.add(temp);
		this.add(item.get(i));
		int a=0;
		if(i==0||i==1)a=0;if(i==2||i==3)a=140;if(i==4||i==5)a=280;if(i==6||i==7)a=420;
		item.get(i).setBounds(0+450*(i%2), a, 450, 140);
		
	}

//	this.add(item1);
//	final ImageIcon CT1 =new ImageIcon("CT1.png");
//	item1.setPic(CT1);
//	item1.setName("文化衫1");
//	item1.setPrice("100.00");
//	item1.setDescribe("校园文化衫第一弹");
//	this.add(item2);
//	this.add(item3);
//	this.add(item4);
//	this.add(item5);
//	this.add(item6);
//	this.add(item7);
//	this.add(item8);
//	final ImageIcon CT2 =new ImageIcon("CT2.png");
//	item2.setPic(CT2);
//	item2.setName("文化衫2");
//	item2.setPrice("100.00元");
//	final ImageIcon PSC =new ImageIcon("PSC.png");
//	item3.setPic(PSC);
//	item3.setName("明信片");
//	item3.setPrice("6.00元");
//	item1.setBounds(0, 0, 450, 140);
//	item2.setBounds(450, 0, 450, 140);
//	item3.setBounds(0, 140, 450, 140);
//	item4.setBounds(450,140 , 450, 140);
//	item5.setBounds(0, 280, 450, 140);
//	item6.setBounds(450, 280, 450, 140);
//	item7.setBounds(0, 420, 450, 140);
//	item8.setBounds(450, 420, 450, 140);
	
	}
	 public void setItem(int i,String Name,ImageIcon Pic,String Price){
		item.get(i).setName(Name);
		item.get(i).setPic(Pic);
		item.get(i).setPrice(Price);
		 
	 }
}
