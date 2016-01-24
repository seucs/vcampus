package Home;
import java.awt.Color;

import javax.swing.*;

import org.omg.CORBA.FloatSeqHelper;

public class PowerSwitch extends JButton{
	//final JLabel backgroundlabel = new JLabel();
	final JLabel switchlabel = new JLabel();
	final JLabel asklabel = new JLabel();
	private boolean flag;
	private boolean animating;
	private Thread shake;
	
	public PowerSwitch() {

		super();
		
		flag = false;
		animating = false;
		this.setLayout(null);
		//添加背景
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		ImageIcon bgicon = new ImageIcon("images/powere_switch_bg.png");
		this.setIcon(bgicon);
//		backgroundlabel.setIcon(bgicon);
//		backgroundlabel.setBounds(0,0,120,60);
//		this.add(backgroundlabel);	
		//this.setIcon(bgicon);
		
		//按钮活动部位设置
		ImageIcon topicon = new ImageIcon("images/powere_switch_0.png");
		switchlabel.setIcon(topicon);
		switchlabel.setBounds(60, 0, 60, 60);
		this.add(switchlabel);
		

		
		
		

	}
	
	public void turnon()
	{
		animating = true;
		flag = true;
		ImageIcon topicon = new ImageIcon("images/powere_switch_1.png");
		switchlabel.setIcon(topicon);
		
		ImageIcon askicon = new ImageIcon("images/powere_switch_2.png");
		asklabel.setIcon(askicon);
		asklabel.setBounds(60,5,60,60);
		this.add(asklabel);
		
		new Thread(){	//弹出thread
			public void run(){
				for (int i = -60; i < 0; i += 1) {
					setMainBounds(i);	
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
		
		shake = new Thread(){	//问号晃动thread
			public void run(){
				
				while (1==1) {
					if(flag==false)
					{
						stop();
					}
					for (int i = 9; i >0; i-=3) {
						
						for (int j = 0; j < i; j++) {
							if(flag==false)
							{
								stop();
							}
							setAskBounds(j);
							try {
								Thread.sleep(25);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						for(int j = i; j > 0; j--) {
							if(flag==false)
							{
								stop();
							}
							setAskBounds(j);
							try {
								Thread.sleep(25);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						
					}
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				
				
				
			}
		};
		shake.start();
		
	}
	
	public void turnoff(){
		if(animating == false){
			shake.stop();
			flag = false;
			ImageIcon topicon = new ImageIcon("images/powere_switch_0.png");
			switchlabel.setIcon(topicon);

			this.remove(asklabel);
			setMainBounds(-60);
		}
		
	}
	
	public void setMainBounds(int i){
		this.setBounds(i,500,120,60);
	}
	
	public void setAskBounds(int i){
		asklabel.setBounds(60,-i+5,60,60);
	}
	
	public boolean getflag(){
		return flag;
	}
	
	public void setflag(boolean newflag){
		flag = newflag;
	}
	
}
