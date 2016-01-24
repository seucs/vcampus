package Shop;

import java.awt.*;
import java.util.*;
import java.util.List;

import javax.swing.*;


//import shop.Shop_Item_Button;
public class fleamarketPanel extends JPanel{
	private int admin=0;
	JButton sellitem=new JButton("出售商品");
	ArrayList<Shop_Item_Button> item_search=new ArrayList();
	ArrayList<Shop_Item_Button> unchecked_item=new ArrayList();
	ArrayList<Shop_Item_Button> my_selling_item=new ArrayList();
	ArrayList<ShopSelectButton> select_button=new ArrayList();

	public JPanel upper_panel=new JPanel();
	public JPanel lower_panel=new JPanel();
	public JScrollPane jsp_upper;
	public JScrollPane jsp_lower;
	private JLabel tips_upper=new JLabel("",JLabel.CENTER);
	private JLabel tips_lower=new JLabel("",JLabel.CENTER);
	public JButton search_button=new JButton("搜索");
	public JButton re_search=new JButton("重新搜索");
	public JTextField input=new JTextField();
	public JPanel background_panel=new JPanel();
//	public JPanel lower_panel=new JPanel();
	public JPanel search_panel=new JPanel();
	Shoppage shoppage;

	
public fleamarketPanel(){
this.setLayout(null);
;
upper_panel.setLayout(null);
lower_panel.setLayout(null);
search_panel.setLayout(null);
lower_panel.setBackground(Color.white);
lower_panel.add(search_panel);
this.setSize(900, 700);
this.setBackground(Color.white);
//Shoppage shoppage=new Shoppage();
//admin=shoppage.getAccess();
tips_lower.setBounds(17, 7, 120, 20);
tips_upper.setBounds(17, 7, 120, 20);
re_search.setBounds(800, 5, 100, 30);

tips_upper.setFont(new Font("微软雅黑",Font.BOLD,15));
jsp_upper=new JScrollPane(upper_panel);
jsp_lower=new JScrollPane(lower_panel);
upper_panel.setBackground(Color.white);
search_panel.setBackground(Color.white);
jsp_upper.setBounds(0,0, 1000, 210+admin*280);
jsp_lower.setBounds(0, 210+admin*280, 1000,360-300*admin );
search_button.setFont(new Font("微软雅黑", Font.BOLD,15));
jsp_upper.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
jsp_upper.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
jsp_lower.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
jsp_lower.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
jsp_upper.getVerticalScrollBar().setUnitIncrement(20);
jsp_lower.getVerticalScrollBar().setUnitIncrement(20);
sellitem.setBounds(	375,580,150,30);
if(admin==0) {
	this.add(sellitem);
	tips_upper.setText("您出售的商品：");
}
else { tips_upper.setText("待审核商品：");}
tips_lower.setText("搜索结果：");
tips_lower.setFont(new Font("微软雅黑",Font.BOLD,15));
upper_panel.add(tips_upper);
lower_panel.add(tips_lower);
search_panel.setBounds(0, 0, 900, 500);
this.add(jsp_lower);
this.add(jsp_upper);

background_panel.add(search_button);
background_panel.add(input);
background_panel.setBackground(new Color(255,68,0));
search_panel.add(background_panel);
background_panel.setLayout(null);
background_panel.setBounds(290, 30, 320, 37);
input.setBounds(1, 1, 230, 35);
//input.setOpaque(false);
search_button.setBounds(231, 1, 90, 35);
search_button.setContentAreaFilled(false);
search_button.setOpaque(false);
search_button.setBorderPainted(false);
input.setBorder(null);
for (int i = 0; i <6; i++) {
	select_button.add(new ShopSelectButton(null));
	select_button.get(i).setBounds(245+170*((i)%3), 108+70*((i)/3), 100, 30);
	search_panel.add(select_button.get(i));
}
select_button.get(0).setContent("全部分类");
select_button.get(1).setContent("生活用品");
select_button.get(2).setContent("学习用品");
select_button.get(3).setContent("二手书籍");
select_button.get(4).setContent("电子数码");
select_button.get(5).setContent("其他");
select_button.get(0).addActionListener(new java.awt.event.ActionListener() {

	public void actionPerformed(java.awt.event.ActionEvent e) {
		if(select_button.get(0).getIsSelected()&&
				select_button.get(1).getIsSelected()&&
				select_button.get(2).getIsSelected()&&
				select_button.get(3).getIsSelected()&&
				select_button.get(4).getIsSelected()&&select_button.get(5).getIsSelected()
)
		{for(int i=0;i<=5;i++)select_button.get(i).setSelected(false);
		select_button.get(0).setSelected(true);}
		else 
			for(int i=1;i<=5;i++){select_button.get(i).setSelected(true);
		select_button.get(0).setSelected(false);}

	}
});
for (int i = 0; i < 3; i++) {
item_search.add(new Shop_Item_Button(450,140,new ImageIcon(),0,5));
lower_panel.add(item_search.get(i));
item_search.get(i).setBounds(450*(i%2),35+ 140*(i/2), 450, 140);
lower_panel.setPreferredSize(new Dimension(900, 35+140 * (i/2+1)));

}
final ImageIcon mayuan=new ImageIcon("images/mayuan.png");
final ImageIcon jindaishi=new ImageIcon("images/jindaishi.png");
final ImageIcon sixiu=new ImageIcon("images/sixiu.png");
item_search.get(0).setName("马克思主义基本原理概论");
item_search.get(1).setName("中国近代史纲要");
item_search.get(2).setName("思想道德修养与法律基础");
item_search.get(0).setPrice("11元");
item_search.get(1).setPrice("12元");
item_search.get(2).setPrice("9元");
item_search.get(0).setPic(mayuan);
item_search.get(1).setPic(jindaishi);
item_search.get(2).setPic(sixiu);

search_button.addActionListener(new java.awt.event.ActionListener() {

	public void actionPerformed(java.awt.event.ActionEvent e) {
		item_search.clear();
		
		for (int i = 0; i < 3; i++) {
		item_search.add(new Shop_Item_Button(450,140,new ImageIcon(),0,5));
		lower_panel.add(item_search.get(i));
		item_search.get(i).setBounds(450*(i%2),35+ 140*(i/2), 450, 140);
		lower_panel.setPreferredSize(new Dimension(900, 35+140 * (i/2+1)));
		
	}
		item_search.get(0).setName("马克思主义基本原理概论");
		item_search.get(1).setName("中国近代史纲要");
		item_search.get(2).setName("思想道德修养与法律基础");
		item_search.get(0).setPrice("11元");
		item_search.get(1).setPrice("12元");
		item_search.get(2).setPrice("9元");
		item_search.get(0).setPic(mayuan);
		item_search.get(1).setPic(jindaishi);
		item_search.get(2).setPic(sixiu);

		search_panel.setVisible(false);
		lower_panel.add(tips_lower);
		lower_panel.add(re_search);
		lower_panel.setVisible(false);
		lower_panel.setVisible(true);
		
	}
});
re_search.addActionListener(new java.awt.event.ActionListener() {

	public void actionPerformed(java.awt.event.ActionEvent e) {
		
		lower_panel.removeAll();
		lower_panel.add(search_panel);
		search_panel.setVisible(true);
	}
});
for (int i = 0; i < 1; i++) {
	
	my_selling_item.add(new Shop_Item_Button(450,140,new ImageIcon(),1,22));
	upper_panel.add(my_selling_item.get(i));
	
	my_selling_item.get(i).setBounds(450*(i%2),35+ 140*(i/2), 450, 140);
	my_selling_item.get(i).setTextIsDelete();
	upper_panel.setPreferredSize(new Dimension(900, 35+140 * (i/2+1)));
	
}
	final ImageIcon PSC =new ImageIcon("images/PSC.png");
my_selling_item.get(0).setPic(PSC);
my_selling_item.get(0).setName("明信片");
my_selling_item.get(0).setPrice("6.00元");
//for (int i = 0; i < 8; i++) {
//	
//	item_search.add(new Shop_Item_Button());
//	lower_panel.add(item_search.get(i));
//	item_search.get(i).setBounds(450*(i%2),35+ 140*(i/2), 450, 140);
//	lower_panel.setPreferredSize(new Dimension(900, 35+140 * (i/2+1)));
//	
//}
//upper_panel.setVisible(false);upper_panel.setVisible(true);
//upper_panel.add(tips_upper);
	sellitem.addActionListener(new java.awt.event.ActionListener() {

		public void actionPerformed(java.awt.event.ActionEvent e) {
			addsell();
		
		}

	});
jsp_upper.setVisible(false);
jsp_upper.setVisible(true);	
this.setVisible(false);
this.setVisible(true);
upper_panel.setVisible(false);
upper_panel.setVisible(true);
	}
public void setItem(int i,String Name,ImageIcon Pic,String Price){
//	item.get(i).setName(Name);
//	item.get(i).setPic(Pic);
//	item.get(i).setPrice(Price);
	 
}
public void addsell() {
	sellframe selljf=new sellframe();
	selljf.flea=this;
	
}


}