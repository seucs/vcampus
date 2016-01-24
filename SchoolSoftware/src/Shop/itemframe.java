package Shop;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class itemframe extends JFrame{
	JButton pic=new JButton();
	JButton nextpic=new JButton(">");
	JButton prepic=new JButton("<");
	JLabel name=new JLabel("商品名:");
	JTextField editname=new JTextField();
	JLabel price=new JLabel("单价:");
	JLabel seller=new JLabel("卖家:");
	JTextField editprice=new JTextField();
	JTextField editseller=new JTextField();
	JButton buy=new JButton("购买");
	JButton delete=new JButton("删除商品");
	JButton cancel=new JButton("取消");
	boolean admin=false;
	public itemframe() {
		this.setVisible(true);
		this.setSize(500,700);
		this.setLayout(null);
		this.add(pic);this.add(editname);this.add(editprice);this.add(editseller);
		this.add(buy);this.add(cancel);this.add(delete);
		this.add(name);this.add(nextpic);this.add(price);this.add(prepic);this.add(seller);
		pic.setBounds(50, 20, 400, 400);
		pic.setBackground(Color.BLACK);
		prepic.setBounds(0, 190, 50,60);
		nextpic.setBounds(450, 190, 50, 60);
		name.setBounds(100, 425, 100, 30);
		editname.setBounds(180, 427, 150, 28);
		price.setBounds(100, 465, 100, 30);
		editprice.setBounds(180, 467, 150, 28);
		seller.setBounds(100, 505, 100, 30);
		editseller.setBounds(180, 507, 150, 28);
		buy.setBounds(150, 550, 200, 40);
		delete.setBounds(0, 610, 100, 30);
		cancel.setBounds(400, 610, 100, 30);
		pic.setLayout(null);
		editname.setEnabled(admin);
		editprice.setEnabled(admin);
		editseller.setEnabled(admin);
		delete.setVisible(admin);
		cancel.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				close();
	
			}

		});
		
		
		
	}
	public void close(){
		this.setVisible(false);
		
	}

}
