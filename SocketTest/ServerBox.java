import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ServerBox extends JFrame{
    private int width = 840;
    private int height = 640;
    private final JTextArea jTextFieldGet = new JTextArea();
    private final JTextArea jTextFieldPost = new JTextArea();
    final private int w = Toolkit.getDefaultToolkit().getScreenSize().width;
    final private int h = Toolkit.getDefaultToolkit().getScreenSize().height;
    
	public ServerBox() {
		super("聊天室控制台——服务器端");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLocation((w - this.width) / 2, (h - this.height) / 2);
        this.setResizable(false);
        this.getContentPane().setLayout(null);
        
        jTextFieldGet.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        jTextFieldGet.setBounds(10, 10, 640, 440);
        jTextFieldGet.setEditable(false);
        jTextFieldGet.setBorder(new EmptyBorder(0,0,0,0));
        jTextFieldGet.setBackground(Color.white);
        this.getContentPane().add(jTextFieldGet);
        /////////////获取客户端内容////////////////////
        
        jTextFieldPost.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        jTextFieldPost.setBounds(10, 470, 640, 80);
        jTextFieldPost.setBorder(new EmptyBorder(0,0,0,0));
        this.getContentPane().add(jTextFieldPost);
        /////////////服务器聊天内容////////////////////
        
        final JButton jButton=new JButton("发送");
        jButton.setFocusPainted(false);
        jButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        jButton.setSize(jButton.getPreferredSize());
        jButton.setLocation(590, 560);
        jButton.addActionListener(arg0 -> {
        	
        });
        this.getContentPane().add(jButton);
        
        
        this.setVisible(true);
        //绘制视图
	}
	public void addGetMessage(String str,String ip) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String TimeStr=df.format(new Date());// new Date()为获取当前系统时间
		
//		InetAddress addr;
//		String address="";
//		try {
//			addr = InetAddress.getLocalHost();
//			ip=addr.getHostAddress().toString();//获得本机IP
//			address=addr.getHostName().toString();//获得本机名称
//			
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		jTextFieldGet.setText(jTextFieldGet.getText()+"\n"+TimeStr+"    来自IP："+ip+"\n"+str);
	}
	
}