package PowfulPanel;
import java.awt.Color;

import javax.swing.JPanel;

public class ButtonPanel extends JPanel{
	JPanel Slide;
	private int buttonCount;
	private int slideFlag;
	public ButtonPanel(int i){
		this.setOpaque(false);
		Slide = new JPanel();
		buttonCount = i;
		slideFlag = 1;
		Slide.setBackground(new Color(5,211,255));
		Slide.setBounds(25,0,(900/i)-50,5);	
		this.add(Slide);
		
	}
	
	public void DoSlide(final int j){
		
		new Thread(){	//弹出thread
			int goal = 900*j/buttonCount+25;
			int current = 900*slideFlag/buttonCount+25;
			public void run(){
				if(slideFlag<j){
					for (int i = current; i < goal; i += 5) {
						slideFlag = j;
						setSlideBounds(i);
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
				else{
					for (int i =current; i > goal; i -= 5) {
						slideFlag = j;
						setSlideBounds(i);
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			
			}
		}.start();
		
	}
	
	void setSlideBounds(int i)
	{
		Slide.setBounds(i,0,(900/buttonCount)-50,5);
	}

}
