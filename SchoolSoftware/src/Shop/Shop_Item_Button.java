package Shop;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import org.omg.CORBA.INTERNAL;

public class Shop_Item_Button extends JLayeredPane{
	private JLabel outFit = new JLabel();
	private JButton detail_Bt = new JButton();
	private PopButton confirm_Bt;
	private JLabel item_image = new JLabel();
	private int max_Capacity;
	public ImageIcon image;
	JLabel name=new JLabel();
	JLabel NAME=new JLabel("商品名:");
	JLabel price=new JLabel();
	JLabel PRICE=new JLabel("单价:");
	Timer timer = null;
    
	public int getQuanties(){
		return confirm_Bt.getM_static();
	}

	public Shop_Item_Button(int Loc_x,int Loc_y,ImageIcon img,int type,int maxcapacity) {
		super();
		max_Capacity = maxcapacity;
		confirm_Bt = new PopButton(type,355,88,this,maxcapacity);
		this.setBounds(Loc_x,Loc_y,450,140);
		outFit.setBounds(0, 0, 450, 140);
		outFit.setIcon(new ImageIcon("images/Shop_Item_Outfit.png"));
		this.add(outFit,new Integer(4));
		
	
		item_image.setBounds(22, 15, 110, 110);
		image=img;
		item_image.setIcon(img);
		item_image.setBackground(Color.black);
		this.add(item_image, new Integer(1));
		
		detail_Bt.setBounds(12, 5, 430, 128);
		detail_Bt.setContentAreaFilled(false);
		detail_Bt.setBorderPainted(false);
		this.add(detail_Bt, new Integer(2));
		
		//confirm_Bt.setBounds(355, 88, 80, 35);
		this.add(confirm_Bt, new Integer(3));
		NAME.setBounds(135,30,50,20);
		NAME.setFont(new Font("Dialog",Font.BOLD,13));
		name.setBounds(210,30,265,20);
		name.setFont(new Font("Dialog",Font.BOLD,13));
		PRICE.setBounds(135,65,45,20);
		PRICE.setFont(new Font("Dialog",Font.BOLD,13));
		price.setBounds(210,65,265,20);
		price.setFont(new Font("Dialog",Font.BOLD,13));
		this.add(NAME);
		this.add(name);
		this.add(price);
		this.add(PRICE);
		
	
		
		
		
		confirm_Bt.getConfirm_Bt().addMouseListener((new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e){
			
				confirm_Bt.setShowing(true);
				confirm_Bt.showDetail();
				if(timer != null){
					timer.stop();
				}
			}
			
			public void mouseExited(MouseEvent e){
				if(timer == null){
					timer = new Timer(3000, new ActionListener() {		
						@Override
						public void actionPerformed(ActionEvent e) {
						
							
							confirm_Bt.setShowing(false);
							confirm_Bt.hideDetail();
						}
					});
				}
				else{
					timer.restart();
			
				}
			}
		}));
		
		confirm_Bt.getPositive_Bt().addMouseListener((new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e){
			
				confirm_Bt.setShowing(true);
				confirm_Bt.showDetail();
				if(timer != null){
					timer.stop();
				}
			}
			
			public void mouseExited(MouseEvent e){
				if(timer == null){
					timer = new Timer(3000, new ActionListener() {		
						@Override
						public void actionPerformed(ActionEvent e) {
						
							confirm_Bt.setShowing(false);
							confirm_Bt.hideDetail();
						}
					});
				}
				else{
					timer.restart();
			
				}
			
			}
		}));
		
		confirm_Bt.getNegetive_Bt().addMouseListener((new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e){
				confirm_Bt.setShowing(true);
				confirm_Bt.showDetail();
				if(timer != null){
					timer.stop();
				}
				
			
			}
			
			public void mouseExited(MouseEvent e){
				if(timer == null){
					timer = new Timer(3000, new ActionListener() {		
						@Override
						public void actionPerformed(ActionEvent e) {
						
							confirm_Bt.setShowing(false);
							confirm_Bt.hideDetail();
						}
					});
				}
				else{
					timer.restart();
			
				}
			
			}
		}));
		
		confirm_Bt.getNegetive_Bt().addActionListener(new java.awt.event.ActionListener() {// jb1事件

			public void actionPerformed(java.awt.event.ActionEvent e) {
				if(confirm_Bt.getM_static()-1>0){
					if(confirm_Bt. getM_Detail()==0){
							confirm_Bt.setM_static(confirm_Bt.getM_static()-1);
							confirm_Bt.getStatic_Field().setText("购买("+confirm_Bt.getM_static()+")");
					}
				
				}
			}
		
		});
		
		confirm_Bt.getPositive_Bt().addActionListener(new java.awt.event.ActionListener() {// jb1事件

			public void actionPerformed(java.awt.event.ActionEvent e) {
				if(confirm_Bt.getM_static()+1<=max_Capacity)
				{
					if(confirm_Bt. getM_Detail()==0){
						confirm_Bt.setM_static(confirm_Bt.getM_static()+1);
						confirm_Bt.getStatic_Field().setText("购买("+confirm_Bt.getM_static()+")");
					}
			}
			}
		
		});		
		
	}
	public Shop_Item_Button(int Loc_x,int Loc_y,ImageIcon img,int type,int maxcapacity,
			String item_name,String item_price) {
		super();
		max_Capacity = maxcapacity;
		confirm_Bt = new PopButton(type,355,88,this,maxcapacity);
		this.setBounds(Loc_x,Loc_y,450,140);
		outFit.setBounds(0, 0, 450, 140);
		outFit.setIcon(new ImageIcon("images/Shop_Item_Outfit.png"));
		this.add(outFit,new Integer(4));
		this.setName(item_name);
		this.setPic(img);
		this.setPrice(item_price);
		item_image.setBounds(22, 15, 110, 110);
		image=img;
		item_image.setIcon(img);
		item_image.setBackground(Color.black);
		this.add(item_image, new Integer(1));
		
		detail_Bt.setBounds(12, 5, 430, 128);
		detail_Bt.setContentAreaFilled(false);
		detail_Bt.setBorderPainted(false);
		this.add(detail_Bt, new Integer(2));
		
		//confirm_Bt.setBounds(355, 88, 80, 35);
		this.add(confirm_Bt, new Integer(3));
		NAME.setBounds(135,30,50,20);
		NAME.setFont(new Font("Dialog",Font.BOLD,13));
		name.setBounds(210,30,265,20);
		name.setFont(new Font("Dialog",Font.BOLD,13));
		PRICE.setBounds(135,65,45,20);
		PRICE.setFont(new Font("Dialog",Font.BOLD,13));
		price.setBounds(210,65,265,20);
		price.setFont(new Font("Dialog",Font.BOLD,13));
		this.add(NAME);
		this.add(name);
		this.add(price);
		this.add(PRICE);
		
	
		
		
		
		confirm_Bt.getConfirm_Bt().addMouseListener((new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e){
			
				confirm_Bt.setShowing(true);
				confirm_Bt.showDetail();
				if(timer != null){
					timer.stop();
				}
			}
			
			public void mouseExited(MouseEvent e){
				if(timer == null){
					timer = new Timer(3000, new ActionListener() {		
						@Override
						public void actionPerformed(ActionEvent e) {
						
							
							confirm_Bt.setShowing(false);
							confirm_Bt.hideDetail();
						}
					});
				}
				else{
					timer.restart();
			
				}
			}
		}));
		
		confirm_Bt.getPositive_Bt().addMouseListener((new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e){
			
				confirm_Bt.setShowing(true);
				confirm_Bt.showDetail();
				if(timer != null){
					timer.stop();
				}
			}
			
			public void mouseExited(MouseEvent e){
				if(timer == null){
					timer = new Timer(3000, new ActionListener() {		
						@Override
						public void actionPerformed(ActionEvent e) {
						
							confirm_Bt.setShowing(false);
							confirm_Bt.hideDetail();
						}
					});
				}
				else{
					timer.restart();
			
				}
			
			}
		}));
		
		confirm_Bt.getNegetive_Bt().addMouseListener((new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e){
				confirm_Bt.setShowing(true);
				confirm_Bt.showDetail();
				if(timer != null){
					timer.stop();
				}
				
			
			}
			
			public void mouseExited(MouseEvent e){
				if(timer == null){
					timer = new Timer(3000, new ActionListener() {		
						@Override
						public void actionPerformed(ActionEvent e) {
						
							confirm_Bt.setShowing(false);
							confirm_Bt.hideDetail();
						}
					});
				}
				else{
					timer.restart();
			
				}
			
			}
		}));
		
		confirm_Bt.getNegetive_Bt().addActionListener(new java.awt.event.ActionListener() {// jb1事件

			public void actionPerformed(java.awt.event.ActionEvent e) {
				if(confirm_Bt.getM_static()-1>0){
					if(confirm_Bt. getM_Detail()==0){
							confirm_Bt.setM_static(confirm_Bt.getM_static()-1);
							confirm_Bt.getStatic_Field().setText("购买("+confirm_Bt.getM_static()+")");
					}
				
				}
			}
		
		});
		
		confirm_Bt.getPositive_Bt().addActionListener(new java.awt.event.ActionListener() {// jb1事件

			public void actionPerformed(java.awt.event.ActionEvent e) {
				if(confirm_Bt.getM_static()+1<=max_Capacity)
				{
					if(confirm_Bt. getM_Detail()==0){
						confirm_Bt.setM_static(confirm_Bt.getM_static()+1);
						confirm_Bt.getStatic_Field().setText("购买("+confirm_Bt.getM_static()+")");
					}
			}
			}
		
		});		
		
	}

	public JButton getconfirm_bt(){
		return confirm_Bt.getConfirm_Bt();
	}
	
	public int getQuantity(){
		
		return confirm_Bt.getM_static();
		
	}
	public ImageIcon getImage(){
		return image;
	}
	public int getmax_Capacity()
	{
		return  max_Capacity;
	}
	public void setQuantity (int i) {
		confirm_Bt.setM_static(i);
		confirm_Bt.getStatic_Field().setText("购买("+i+")");
		
	}
	public void setTextIsDelete()
	{
		confirm_Bt.getStatic_Field().setText("   删除");
	}
	public void setPic(ImageIcon img) {
		item_image.setIcon(img);
		image=img;
		
	}
	
	public void setName(String Name)
	{
		name.setText(Name);
	}
	public void setPrice(String Price){
		price.setText(Price);
		
	}

	
}
