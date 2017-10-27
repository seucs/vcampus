package Shop;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import Message.BookMessage;
import Message.ShopMessage;
import PowfulPanel.*;

public class Shoppage extends JLayeredPane {
	PButton SchShop = new PButton("校园商店");
	PButton StuShop = new PButton("跳蚤市场");
	PButton Trolleybt = new PButton("购物车");
	ButtonPanel btp = new ButtonPanel(3);
	PButton Shopcart=new PButton("购物车");
//	JPanel itemgo = new JPanel();
	JPanel SlidePanel  = new JPanel();
	public schoolshop schPage = new schoolshop();
	fleamarketPanel flePage = new fleamarketPanel();
	ShopingTrolley shop_cart_panel=new ShopingTrolley(this);
	boolean animating = false;
	private int shop_admin=1;
	ArrayList<ShopMessage> shopmessages =new ArrayList();
	JButton sellitem=new JButton("出售商品");
	public Shoppage() {
		// TODO 自动生成的构造函数存根
		
		super();
		btp.setBounds(0,0,900,40);
		this.setOpaque(false);
		this.add(btp,new Integer(3));
		this.setLayout(null);
		this.setBackground(Color.white);
		SchShop.setBounds(0,5,300,40);
		StuShop.setBounds(300,5,300,40);
		Trolleybt.setBounds(600,5,300,40);
		SchShop.setForeground(new Color(35,164,231));
		SchShop.setBackground(Color.white);
		this.add(SchShop,new Integer(3));
		this.add(StuShop,new Integer(3));
		this.add(Trolleybt,new Integer(3));
		this.SlidePanel.setBackground(Color.white);
		this.SlidePanel.setOpaque(false);

		btp.DoSlide(0);
		schPage.setBounds(0,45,900,655);
		sellitem.setBounds(	1275,620,150,30);
		this.add(sellitem);
		flePage.setBounds(900,45,900,655);
		shop_cart_panel.setBounds(1800,45,900,655);
		SlidePanel.setLayout(null);
		SlidePanel.setBounds(0, 0, 2700, 700);
		SlidePanel.add(schPage);
		SlidePanel.add(flePage);
		SlidePanel.add(shop_cart_panel);
	
		this.add(SlidePanel,new Integer(2));
		for(int i=0;i<2;i++)
		{
			final int j=i;
			schPage.item.get(i).getconfirm_bt().addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					shop_cart_panel.item.add(new Shop_Item_Button(450, 140,schPage.item.get(j).getImage() , 0,schPage.item.get(j).getmax_Capacity(),schPage.item.get(j).name.getText(),schPage.item.get(j).price.getText()));
					shop_cart_panel.item.get(shop_cart_panel.item.size()-1).setQuantity(schPage.item.get(j).getQuantity());
					shop_cart_panel.item.get(shop_cart_panel.item.size()-1).setBounds(450*((shop_cart_panel.item.size()-1)%2), 140*((shop_cart_panel.item.size()-1)/2), 450, 140);
					shop_cart_panel.background_panel.add(shop_cart_panel.item.get(shop_cart_panel.item.size()-1));
					shop_cart_panel.jsp.setVisible(false);
					shop_cart_panel.jsp.setVisible(true);
				
					
					
					
					
				}
			});
		}
		for(int i=0;i<3;i++)
		{
			final int j=i;
			flePage.item_search.get(i).getconfirm_bt().addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					shop_cart_panel.item.add(new Shop_Item_Button(450, 140,flePage.item_search.get(j).getImage() , 0,flePage.item_search.get(j).getmax_Capacity(),flePage.item_search.get(j).name.getText(),flePage.item_search.get(j).price.getText()));	
					shop_cart_panel.item.get(shop_cart_panel.item.size()-1).setQuantity(flePage.item_search.get(j).getQuantity());
					shop_cart_panel.item.get(shop_cart_panel.item.size()-1).setBounds(450*((shop_cart_panel.item.size()-1)%2), 140*((shop_cart_panel.item.size()-1)/2), 450, 140);
					shop_cart_panel.background_panel.add(shop_cart_panel.item.get(shop_cart_panel.item.size()-1));
					shop_cart_panel.jsp.setVisible(false);
					shop_cart_panel.jsp.setVisible(true);
			
					
					
					
					
				}
			});
		}
		
		
		

		
		SchShop.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				SchShop.setForeground(new Color(35,164,231));
				SchShop.setBackground(Color.white);
				StuShop.setForeground(new Color(254,254,254));
				StuShop.setBackground(new Color(206,206,206));
				Trolleybt.setForeground(new Color(254,254,254));
				Trolleybt.setBackground(new Color(206,206,206));
				changetosch();
				btp.DoSlide(0);
				schPage.jsp.setVisible(false);
				schPage.jsp.setVisible(true);
				schPage.setVisible(false);
				schPage.setVisible(true);

				
			}
		});
		
		StuShop.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				StuShop.setForeground(new Color(35,164,231));
				StuShop.setBackground(Color.white);
				SchShop.setForeground(new Color(254,254,254));
				SchShop.setBackground(new Color(206,206,206));
				Trolleybt.setForeground(new Color(254,254,254));
				Trolleybt.setBackground(new Color(206,206,206));
				changetofle();
				btp.DoSlide(1);
				flePage.jsp_upper.setVisible(false);
				flePage.jsp_upper.setVisible(true);	
				flePage.jsp_lower.setVisible(false);
				flePage.jsp_lower.setVisible(true);
				flePage.setVisible(false);
				flePage.setVisible(true);
				
			}
		});
		
		Trolleybt.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				Trolleybt.setForeground(new Color(35,164,231));
				Trolleybt.setBackground(Color.white);
				SchShop.setForeground(new Color(254,254,254));
				SchShop.setBackground(new Color(206,206,206));
				StuShop.setForeground(new Color(254,254,254));
				StuShop.setBackground(new Color(206,206,206));
				changetoTrolley();
				btp.DoSlide(2);
				shop_cart_panel.setVisible(false);
				shop_cart_panel.setVisible(true);
				shop_cart_panel.jsp.setVisible(false);
				shop_cart_panel.jsp.setVisible(true);
			}
		});

	}
	
	void changetoTrolley(){
		
		if(animating == false){
			final int  location = (int) SlidePanel.getBounds().getX();
			
			new Thread(){	//弹出thread
			public void run(){
				animating = true;
				for (int i = location; i >=-1800; i -= 10) {
					SlidePanel.setBounds(i,0,2700,655);
					
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
			final int  location = (int) SlidePanel.getBounds().getX();
			new Thread(){	//弹出thread
			public void run(){
				animating = true;
				for (int i = location; i <=0; i += 10) {
					SlidePanel.setBounds(i,0,2700,655);	
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

void changetofle(){
	
	if(animating == false){
		final int  location = (int) SlidePanel.getBounds().getX();
		if(location>-900){
			new Thread(){	//弹出thread
				public void run(){
					animating = true;
					for (int i = location; i >=-900; i -= 10) {
						SlidePanel.setBounds(i,0,2700,655);
						
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
		else{
			new Thread(){	//弹出thread
				public void run(){
					animating = true;
					for (int i = location; i <=-900; i += 10) {
						SlidePanel.setBounds(i,0,2700,655);	
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
public	int getAccess(){
	return shop_admin;
}
}
