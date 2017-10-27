package Shop;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class sellframe extends JFrame{
	JButton pic=new JButton();
	JButton nextpic=new JButton(">");
	JButton prepic=new JButton("<");
	JLabel name=new JLabel("商品名:");
	JTextField editname=new JTextField();
	JLabel price=new JLabel("单价:");
	JLabel seller=new JLabel("卖家:");
	JTextField editprice=new JTextField();
	JTextField editseller=new JTextField();
	JButton sell=new JButton("出售");
	JButton cancel=new JButton("取消");
	fleamarketPanel flea=new fleamarketPanel();
	final ImageIcon img=new ImageIcon();

//	boolean admin=false;
	public sellframe() {
		this.setVisible(true);
		this.setSize(500,700);
		this.setLayout(null);
		this.add(pic);this.add(editname);this.add(editprice);this.add(editseller);
		this.add(sell);this.add(cancel);
		this.add(name);this.add(nextpic);this.add(price);this.add(prepic);this.add(seller);
		pic.setBounds(50, 20, 400, 400);
		pic.setText("点击添加图片");;
		prepic.setBounds(0, 190, 50,60);
		nextpic.setBounds(450, 190, 50, 60);
		name.setBounds(100, 425, 100, 30);
		editname.setBounds(180, 427, 150, 28);
		price.setBounds(100, 465, 100, 30);
		editprice.setBounds(180, 467, 150, 28);
		seller.setBounds(100, 505, 100, 30);
		editseller.setBounds(180, 507, 150, 28);
		sell.setBounds(150, 550, 200, 40);
//		delete.setBounds(0, 610, 100, 30);
		cancel.setBounds(400, 610, 100, 30);
//		editname.setEnabled(admin);
//		editprice.setEnabled(admin);
//		editseller.setEnabled(admin);
//		delete.setVisible(admin);
		sell.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				int number=0;
				for(int i=1;i<7;i++)
					//if(flea.my_selling_item.get(i).name.getText().isEmpty()&&!(flea.my_selling_item.get(i-1).name.getText().isEmpty()))number=i;
				System.out.println(number);
				flea.setItem(number, editname.getText(), img, editprice.getText());
				flea.my_selling_item.get(number).setVisible(false);flea.my_selling_item.get(number).setVisible(true);
				close();
	
				}

		});
		cancel.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				close();
	
			}

		});
		
		
		
	}
	public void close(){
		this.setVisible(false);
		
	}
//
//	int getbuttonnumber(){
//		int number=0;
//		for(int i=0;i<6;i++)
//			{if(flea.item.get(i+1).name.getText().isEmpty()&&!(flea.item.get(i).name.getText().isEmpty()))
//		{number=i;}}
//		return number+1;
//	}
}
