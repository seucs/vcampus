package AdmOffice;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import PowfulPanel.ButtonPanel;
import PowfulPanel.PButton;


public class admPanel extends JPanel {
	final AdmStatementPanel admHomePanel = new AdmStatementPanel();
	final InquirePanel inquirePanel = new InquirePanel();
	final HandbookPanel handbookPanel = new HandbookPanel();
	final ContestPanel contestPanel = new ContestPanel(inquirePanel);
	final SelectCoursePanel selectionPanel = new SelectCoursePanel(inquirePanel);
	
	
	JPanel topPanel = new JPanel();
	final JPanel centerPanel = new JPanel();
	final ButtonPanel btp= new ButtonPanel(5);
	final PButton jb1;
	final PButton jb2;
	final PButton jb3;
	final PButton jb4;
	final PButton jb5;
	
	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		jFrame.setSize(900,700);
		jFrame.getContentPane().add(new admPanel());
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public admPanel(){
		
		

		this.setLayout(null);
        topPanel.setLayout(new FlowLayout());
        btp.setBounds(0,0,900,40);
		this.add(btp);
		this.setLayout(null);
		this.setBackground(Color.white);
		
		
        
		topPanel.setBackground(Color.white);
		topPanel.setLayout(null);
		//topPanel.setPreferredSize(new Dimension(this.getWidth(), 50));
		topPanel.setBounds(0, 0, 900, 45);
		centerPanel.setBackground(Color.WHITE);
		centerPanel.setLayout(null);
		centerPanel.setBounds(0, 45, 900,700);
		
		centerPanel.add(admHomePanel);
		admHomePanel.setVisible(true);

		admHomePanel.setBackground(Color.white);
		inquirePanel.setBackground(Color.white);
		handbookPanel.setBackground(Color.white);
		contestPanel.setBackground(Color.white);
		selectionPanel.setBackground(Color.white);
  
		Font font=new Font("微软雅黑", Font.BOLD, 20);
	    jb1 = new PButton("首    页");
		jb1.setFocusPainted(false);
		jb1.setBounds(0, 5, 180, 40);
		jb1.setFont(font);
		
		jb1.setForeground(new Color(254,254,254));
		jb1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				btp.DoSlide(0);
				jb1.setForeground(new Color(35,164,231));
				jb1.setBackground(Color.white);
				jb2.setForeground(new Color(254,254,254));
				jb2.setBackground(new Color(206,206,206));
				jb3.setForeground(new Color(254,254,254));
				jb3.setBackground(new Color(206,206,206));
				jb4.setForeground(new Color(254,254,254));
				jb4.setBackground(new Color(206,206,206));
				jb5.setForeground(new Color(254,254,254));
				jb5.setBackground(new Color(206,206,206));
				resultPanel(admHomePanel);
			}
		});
		jb2 = new PButton("查    询");
		jb2.setBounds(180, 5, 180, 40);
		jb2.setFont(font);
		jb2.setFocusPainted(false);
		
		jb2.setForeground(new Color(254,254,254));
		jb2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				btp.DoSlide(1);
				jb2.setBackground(Color.white);
				jb2.setForeground(new Color(35,164,231));
				jb1.setForeground(new Color(254,254,254));
				jb1.setBackground(new Color(206,206,206));
				jb3.setForeground(new Color(254,254,254));
				jb3.setBackground(new Color(206,206,206));
				jb4.setForeground(new Color(254,254,254));
				jb4.setBackground(new Color(206,206,206));
				jb5.setForeground(new Color(254,254,254));
				jb5.setBackground(new Color(206,206,206));
				resultPanel(inquirePanel);
			}
		});
		jb3 = new PButton("学生手册");
		jb3.setBounds(360, 5, 180, 40);
		jb3.setFont(font);
		jb3.setFocusPainted(false);
		
		jb3.setForeground(new Color(254,254,254));
		jb3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				btp.DoSlide(2);
				jb3.setForeground(new Color(35,164,231));
				jb3.setBackground(Color.white);
				jb1.setForeground(new Color(254,254,254));
				jb1.setBackground(new Color(206,206,206));
				jb2.setForeground(new Color(254,254,254));
				jb2.setBackground(new Color(206,206,206));
				jb4.setForeground(new Color(254,254,254));
				jb4.setBackground(new Color(206,206,206));
				jb5.setForeground(new Color(254,254,254));
				jb5.setBackground(new Color(206,206,206));
				resultPanel(handbookPanel);
			}
		});
		jb4 = new PButton("学科竞赛");
		jb4.setBounds(540, 5, 180, 40);
		jb4.setFont(font);
		jb4.setFocusPainted(false);
		
		jb4.setForeground(new Color(254,254,254));
		jb4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				btp.DoSlide(3);
				jb4.setForeground(new Color(35,164,231));
				jb4.setBackground(Color.white);
				jb1.setForeground(new Color(254,254,254));
				jb1.setBackground(new Color(206,206,206));
				jb3.setForeground(new Color(254,254,254));
				jb3.setBackground(new Color(206,206,206));
				jb2.setForeground(new Color(254,254,254));
				jb2.setBackground(new Color(206,206,206));
				jb5.setForeground(new Color(254,254,254));
				jb5.setBackground(new Color(206,206,206));
				resultPanel(contestPanel);
			}
		});
		jb5 = new PButton("选课系统");
		jb5.setBounds(720, 5, 180, 40);
		jb5.setFont(font);
		jb5.setFocusPainted(false);
		
		jb5.setForeground(new Color(254,254,254));
		jb5.addActionListener(new java.awt.event.ActionListener() {// jb1事件
			public void actionPerformed(java.awt.event.ActionEvent e) {
				btp.DoSlide(4);
				jb5.setBackground(Color.white);
				jb5.setForeground(new Color(35,164,231));
				jb1.setForeground(new Color(254,254,254));
				jb1.setBackground(new Color(206,206,206));
				jb3.setForeground(new Color(254,254,254));
				jb3.setBackground(new Color(206,206,206));
				jb2.setForeground(new Color(254,254,254));
				jb2.setBackground(new Color(206,206,206));
				jb4.setForeground(new Color(254,254,254));
				jb4.setBackground(new Color(206,206,206));
				resultPanel(selectionPanel);
			}
		});
		topPanel.add(jb1);
		topPanel.add(jb2);
		topPanel.add(jb3);
		topPanel.add(jb4);
		topPanel.add(jb5);
		
		this.add(topPanel);
		this.add(centerPanel);
		//btp.DoSlide(0);
		

		

	}
	// 滑动效果方法
	public void 	resultPanel(final JPanel panel) {
		panel.setBounds(0, 0, centerPanel.getWidth(), centerPanel.getHeight());// 设置滑动初始位置
		int count = centerPanel.getComponentCount();// 获取centerPanel中控件数
		List list = new ArrayList();//
		for (Component comp : centerPanel.getComponents()) {
			list.add(comp);// 给list赋值
		}
		if (count > 0) {// 如果centerPanel中控件数大于0就执行效果
			for (int i = 0; i < count; i++) {
				Component comp = centerPanel.getComponent(i);// 获得该位置的控件
				if (comp instanceof JPanel) {// 判断控件类型
					final JPanel currentPanel = (JPanel) comp;// 获得当前panel
					if (currentPanel != panel) {
						new Thread() {
							public void run() {
								Rectangle rec = currentPanel.getBounds();// 获得当前面板的位置信息
								int y = -centerPanel.getWidth();

								for (int i = 0; i <= centerPanel.getWidth(); i += 10) {
									// 设置面板位置
									currentPanel.setBounds(i, 0,centerPanel.getWidth(),centerPanel.getHeight());
									panel.setBounds(y, 0,centerPanel.getWidth(),centerPanel.getHeight());
									try {
										Thread.sleep(3);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									y += 10;
								}
								centerPanel.remove(currentPanel);// 移除當前面板
								panel.setBounds(0, 0, centerPanel.getWidth(),centerPanel.getHeight());
							}
				
							
				
				
						}.start();
						panel.setVisible(false);
						panel.setVisible(true);

						break;
					}
				}
			}
		}
		if (!list.contains(panel)) {
			centerPanel.add(panel);// 添加要切换的面板
		}
		centerPanel.validate();// 重构内容面板
		centerPanel.repaint();// 重绘内容面板
	}
}
