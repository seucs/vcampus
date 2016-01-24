package Shop;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.hxtt.b.bg;

import Library.AddBookFrame;
import Library.HomePanel;
import Library.SuperTable;

public class ShopingTrolley extends JPanel{
	public ArrayList<Shop_Item_Button> item =new ArrayList();
	public JScrollPane jsp;
	public JPanel background_panel=new JPanel();
	public Shoppage shoppage;
	public JButton buyall=new JButton("一键购买");

	
	public ShopingTrolley(Shoppage mshop){
	buyall.setBackground(new Color(255, 68, 0));
	shoppage =  mshop;
	this.add(buyall);
	this.setLayout(null);
	this.setSize(900, 700);
	buyall.setBounds(375,580,150,30);
	shoppage.shop_cart_panel=this;
	this.setBackground(Color.white);
	background_panel.setBackground(Color.white);
	background_panel.setLayout(null);
	
	
	
	jsp=new JScrollPane(background_panel);
	jsp.setBounds(0, 0, 1000, 570);
	jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	background_panel.setPreferredSize(new Dimension(900, background_panel.getHeight()+140));
	this.add(jsp);
	
	jsp.setVisible(false);
	jsp.setVisible(true);
	this.setVisible(false);
	this.setVisible(true);
	buyall.addActionListener(new java.awt.event.ActionListener() {

		public void actionPerformed(java.awt.event.ActionEvent e) {
			if (item.size()>0) {
				
			
			background_panel.removeAll();
			item.clear();
			jsp.setVisible(false);
			jsp.setVisible(true);
			JOptionPane.showMessageDialog(null, "购买成功", "提示信息",JOptionPane.CLOSED_OPTION);
	


			}


	}

	});

	}

}
