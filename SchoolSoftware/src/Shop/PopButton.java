package Shop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PopButton extends JLayeredPane{
	private JButton positive_Bt= new JButton();
	private JButton negetive_Bt= new JButton();
	private JButton confirm_Bt= new JButton();
	private JPanel detail_P = new JPanel();
	private JTextField static_Field = new JTextField();
	private int m_Detail = 0;
	private int m_static = 1;
	private int max_Capacity = 0;
	private boolean showing = false; 
	private int loc_X=0;
	private int loc_Y=0;
	private Shop_Item_Button m_Host;
	private final String nBt_dir = "images/confirm_n_";
	private final String pBt_dir = "images/confirm_p_";
	private final String last_dir = ".png";

	
	public PopButton(Integer detail,int x,int y, Shop_Item_Button host,int mcp){
		max_Capacity = mcp;
		m_Detail = detail;
		this.setBackground(Color.black);
		m_Host = host;
		this.setBounds(x,y,80,35);
		loc_X = x;
		loc_Y = y;
		confirm_Bt.setBounds(0, 0, 80, 35);
		confirm_Bt.setIcon(new ImageIcon("images/confirm_button.png"));
		confirm_Bt.setLayout(new BorderLayout(0, 0) );
		static_Field.setText("购买(1)");
		static_Field.setEnabled(false);
		static_Field.setBackground(new Color(255, 68, 0));
		static_Field.setBorder(null);
		
		
		confirm_Bt.add("Center",static_Field);
		//confirm_Bt.setText("try");
		confirm_Bt.setContentAreaFilled(false);
		confirm_Bt.setBorderPainted(false);
		confirm_Bt.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				

			}
		});
		this.add(confirm_Bt,new Integer(5));
		
		detail_P.setBounds(0,0,80,60);
		detail_P.setLayout(null);
		this.add(detail_P, new Integer(1));

		positive_Bt.setBounds(0,0,40,30);
		positive_Bt.setContentAreaFilled(false);
		positive_Bt.setBorderPainted(false);
		if(m_static==max_Capacity){
			positive_Bt.setIcon(new ImageIcon(pBt_dir+m_Detail+1+last_dir));

		}
		else {
			positive_Bt.setIcon(new ImageIcon(pBt_dir+m_Detail+0+last_dir));

		}
		positive_Bt.addMouseListener((new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){
				positive_Bt.setIcon(new ImageIcon(pBt_dir+m_Detail+1+last_dir));
			}
			
			public void mouseReleased(MouseEvent e){
				if(m_static==1&&m_Detail==0){
					negetive_Bt.setIcon(new ImageIcon(nBt_dir+m_Detail+1+last_dir));
				}
				else{
					negetive_Bt.setIcon(new ImageIcon(nBt_dir+m_Detail+0+last_dir));
				}
				if(m_static==max_Capacity&&m_Detail==0){
					positive_Bt.setIcon(new ImageIcon(pBt_dir+m_Detail+1+last_dir));

				}
				else {
					positive_Bt.setIcon(new ImageIcon(pBt_dir+m_Detail+0+last_dir));

				}
				
			}
		}));
		negetive_Bt.setBounds(40,0,40,30);
		negetive_Bt.setIcon(new ImageIcon(nBt_dir+m_Detail+1+last_dir));
		negetive_Bt.setContentAreaFilled(false);
		negetive_Bt.setBorderPainted(false);
		negetive_Bt.addMouseListener((new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){
				
				negetive_Bt.setIcon(new ImageIcon(nBt_dir+m_Detail+1+last_dir));
			}
			
			public void mouseReleased(MouseEvent e){
				if(m_static==1&&m_Detail==0){
					negetive_Bt.setIcon(new ImageIcon(nBt_dir+m_Detail+1+last_dir));
				}
				else{
					negetive_Bt.setIcon(new ImageIcon(nBt_dir+m_Detail+0+last_dir));
				}
				
				if(m_static==max_Capacity&&m_Detail==0){
					positive_Bt.setIcon(new ImageIcon(pBt_dir+m_Detail+1+last_dir));

				}
				else {
					positive_Bt.setIcon(new ImageIcon(pBt_dir+m_Detail+0+last_dir));

				}
			}
		}));
		
		detail_P.add(positive_Bt);
		detail_P.add(negetive_Bt);
			
			
			
			
		

	}
	public void showDetail(){
		new Thread(){
			public void run(){
				while(showing == true&& PopButton.this.getBounds().getY()>loc_Y-30){
					
					PopButton.this.setBounds(loc_X,(int) (PopButton.this.getBounds().getY()-5),80,PopButton.this.getHeight()+5);
					confirm_Bt.setBounds(0,(int) (confirm_Bt.getBounds().getY()+5),80,35);
					m_Host.setVisible(false);
					m_Host.setVisible(true);
					try {
						sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	
	public void hideDetail(){
		new Thread(){
			public void run(){
				while(showing == false&& PopButton.this.getBounds().getY()<loc_Y){
					
					PopButton.this.setBounds(loc_X,(int) (PopButton.this.getBounds().getY()+5),80,PopButton.this.getHeight()-5);
					confirm_Bt.setBounds(0,(int) (confirm_Bt.getBounds().getY()-5),80,35);
					m_Host.setVisible(false);
					m_Host.setVisible(true);
					try {
						sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
					
			}
		}.start();
	}
	public boolean isShowing() {
		return showing;
	}
	public void setShowing(boolean showing) {
		this.showing = showing;
	}
	
	public JButton getConfirm_Bt(){
		return confirm_Bt;
	}
	public JButton getPositive_Bt() {
		return positive_Bt;
	}
	public JButton getNegetive_Bt() {
		return negetive_Bt;
	}
	public JTextField getStatic_Field() {
		return static_Field;
	}
	public void setStatic_Field(JTextField static_Field) {
		this.static_Field = static_Field;
	}
	public int getM_static() {
		return m_static;
	}
	public void setM_static(int m_static) {
		this.m_static = m_static;
	}
	public int getM_Detail() {
		return m_Detail;
	}
	public void setM_Detail(int m_Detail) {
		this.m_Detail = m_Detail;
	}
	
}

	
