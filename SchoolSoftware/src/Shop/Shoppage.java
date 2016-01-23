package Shop;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import PowfulPanel.*;

public class Shoppage extends JPanel {
	PButton SchShop = new PButton("校园商店");
	PButton StuShop = new PButton("跳蚤市场");
	ButtonPanel btp = new ButtonPanel(2);
//	JPanel itemgo = new JPanel();
	schoolshop schPage = new schoolshop();
	fleamarketPanel flePage = new fleamarketPanel();
	boolean animating = false;
	public Shoppage() {
		// TODO 自动生成的构造函数存根
		
		super();
		btp.setBounds(0,0,900,40);
		this.setOpaque(false);
		this.add(btp);
		this.setLayout(null);
		this.setBackground(Color.white);
		SchShop.setBounds(0,5,450,40);
		//SchShop.setContentAreaFilled(false);
		StuShop.setBounds(450,5,450,40);
		SchShop.setForeground(new Color(35,164,231));
		SchShop.setBackground(Color.white);
		this.add(SchShop);
		this.add(StuShop);
		
		btp.DoSlide(0);
		schPage.setBounds(0,45,900,655);
		flePage.setBounds(900,45,900,655);
		this.add(schPage);
		this.add(flePage);

//		itemButton item1=new itemButton();
//		itemButton item2=new itemButton();
//		itemButton item3=new itemButton();
//		itemButton item4=new itemButton();
//		itemButton item5=new itemButton();
//		itemButton item6=new itemButton();
//		itemButton item7=new itemButton();
//		itemButton item8=new itemButton();		
//		itemgo.setLayout(null);
//		itemgo.setSize(900, 700);
//		itemgo.add(item1);
		final ImageIcon CT1 =new ImageIcon("images/CT1.png");
//		item1.setPic(CT1);
//		item1.setName("文化衫1");
//		item1.setPrice("100.00元");

//		itemgo.add(item2);
		final ImageIcon CT2 =new ImageIcon("images/CT2.png");
//		item2.setPic(CT2);
//		item2.setName("文化衫2");
//		item2.setPrice("100.00元");
//		itemgo.add(item3);
		final ImageIcon PSC =new ImageIcon("images/PSC.png");
		schPage.setItem(0, "文化衫1", CT1, "100元");
		flePage.setItem(0,"明信片", PSC, "6元");
//		item3.setPic(PSC);
//		item3.setName("明信片");
//		item3.setPrice("6.00元");
//		itemgo.add(item4);
//		itemgo.add(item5);
//		itemgo.add(item6);
//		itemgo.add(item7);
//		itemgo.add(item8);
//		item1.setBounds(0, 0, 450, 140);
//		item2.setBounds(450, 0, 450, 140);
//		item3.setBounds(0, 140, 450, 140);
//		item4.setBounds(450,140 , 450, 140);
//		item5.setBounds(0, 280, 450, 140);
//		item6.setBounds(450, 280, 450, 140);
//		item7.setBounds(0, 420, 450, 140);
//		item8.setBounds(450, 420, 450, 140);
		
		
		
		SchShop.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				SchShop.setForeground(new Color(35,164,231));
				SchShop.setBackground(Color.white);
				StuShop.setForeground(new Color(254,254,254));
				StuShop.setBackground(new Color(206,206,206));
				changetosch();
				btp.DoSlide(0);
				
			}
		});
		StuShop.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				StuShop.setForeground(new Color(35,164,231));
				StuShop.setBackground(Color.white);
				SchShop.setForeground(new Color(254,254,254));
				SchShop.setBackground(new Color(206,206,206));
				changetofle();
				btp.DoSlide(1);
				
			}
		});
	}
	
	void changetofle(){
		
		if(animating == false){
		schPage.setBounds(0,45,900,655);
		flePage.setBounds(900,45,900,655);
			new Thread(){	//弹出thread
			public void run(){
				animating = true;
				for (int i = 0; i <=900; i += 10) {
					schPage.setBounds(0-i,45,900,655);
					flePage.setBounds(900-i,45,900,655);	
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				animating = false;
			}
		}.start();
		}
		
		
	}
	
void changetosch(){
		
		if(animating == false){
		schPage.setBounds(-900,45,900,655);
		flePage.setBounds(0,45,900,655);
			new Thread(){	//弹出thread
			public void run(){
				animating = true;
				for (int i = 0; i <=900; i += 10) {
					schPage.setBounds(i-900,45,900,655);
					flePage.setBounds(i,45,900,655);	
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				animating = false;
			}
		}.start();
		}
		
		
	}
	
}
