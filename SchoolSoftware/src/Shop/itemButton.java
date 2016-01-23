package Shop;


import javax.swing.*;

import java.awt.*;


public class itemButton extends JButton{
	JLabel pic=new JLabel();
	JLabel name=new JLabel();
	JLabel NAME=new JLabel("商品名:");
	JLabel price=new JLabel();
	JLabel PRICE=new JLabel("单价:");
	JLabel describe=new JLabel();
	JLabel DESCRIBE=new JLabel("商品描述:");
	String seller="学校";
	ImageIcon boundary=new ImageIcon("images/Boundary.png");
	int admin=1;
	public itemButton(){
		this.setLayout(null);
		this.setSize(450, 140);
		this.add(DESCRIBE);
		this.add(NAME);
		this.add(name);
		this.add(price);
		this.add(PRICE);
		this.add(describe);
		this.add(pic);
		this.setIcon(boundary);

		this.setBackground(Color.white);
		this.setBounds(0, 0, 450, 140);
		pic.setBounds(20,20,100,100);
		NAME.setBounds(125,30,50,20);
		NAME.setFont(new Font("Dialog",Font.BOLD,13));
		name.setBounds(200,30,265,20);
		name.setFont(new Font("Dialog",Font.BOLD,13));
		PRICE.setBounds(125,65,45,20);
		PRICE.setFont(new Font("Dialog",Font.BOLD,13));
		price.setBounds(200,65,265,20);
		price.setFont(new Font("Dialog",Font.BOLD,13));
		this.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
			itemframe itemjf=new itemframe();
			itemjf.editname.setText(name.getText());
			itemjf.editprice.setText(price.getText());
			itemjf.editseller.setText(seller);
	
	
	
			}

		});
//		describe.setBounds(200,50,265,20);
//		DESCRIBE.setFont(new Font("Dialog",Font.BOLD,13));
//		DESCRIBE.setBounds(135,50,60,20);
//		describe.setFont(new Font("Dialog",Font.BOLD,13));
  
		
	}
	public	void setPic(ImageIcon img)
	{
		pic.setIcon(img);
		
	}
	public void setName(String Name)
	{
		name.setText(Name);
	}
	public void setPrice(String Price){
		price.setText(Price);
		
	}
	public void setDescribe(String Describe){
		describe.setText(Describe);
		
	}
	public void setSeller( String x) {
				seller=x;
		
	}
	public void setSellerisshool(int flag) {
		if (flag==0) { seller="学校";	}
	
		}
	

}