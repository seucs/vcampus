package Library;



import javax.swing.*;

import Connect.*;
import Message.BookMessage;
import Message.BookQueryMessage;

import java.awt.*;
import java.util.*;
import java.lang.*;
public class SearchPanel extends JPanel{
	
//	JButton bookinf=new JButton("查询图书信息");
//	JButton personalinf=new JButton("查询个人记录");
//	JButton searchbook=new JButton("搜索图书");
//	JButton nextpage=new JButton("下一页");
//	JButton previouspage=new JButton("上一页");
	JButton back=new JButton("重新搜索");
//	JLabel changeto=new JLabel("跳转至");
//	JLabel page=new JLabel("页");
//	JButton confirm=new JButton("确定");
//	JLabel searchname=new JLabel("书名");
	JTextField input= new JTextField();
//	JLabel searchauthor=new JLabel("作者");
	JButton search =new JButton("搜索");
//	JLabel message=new JLabel("请输入要搜索的书名或作者");
	String[][] searchData;
	JPanel background_panel=new JPanel();
	JPanel white_panel=new JPanel();
	ArrayList<JButton> subscribe=new ArrayList();
	ArrayList<JButton> guanli=new ArrayList();
	ArrayList<BookMessage> bookmessage=new ArrayList();
	ArrayList<SelectButton> select_button=new ArrayList();
	int admin=1;
	String[] columnNames = {"图书编号","图书名称","作者","出版社","总本数","可借本数","分类","存放处","预约"};
	SuperTable table;
	JScrollPane jsp;


	JLabel currentpage=new JLabel(); 
	ArrayList<String[][]> ALLData=new ArrayList();
	libraryadmin libadm;
	Client mClient;
	
	public SearchPanel(Client client){
		mClient = client;
		this.setLayout(null);
		this.setSize(900, 700);
		
		for (int i = 0; i <14; i++) {
			select_button.add(new SelectButton(null));
			select_button.get(i).setBounds(150+170*((i+2)%4), 180+70*((i+2)/4), 100, 30);
			this.add(select_button.get(i));
		}
		select_button.get(0).setContent("书名");
		select_button.get(1).setContent("作者");
		select_button.get(2).setContent("全部分类");
		select_button.get(3).setContent("小说");
		select_button.get(4).setContent("散文");
		select_button.get(5).setContent("诗歌");
		select_button.get(6).setContent("金融");
		select_button.get(7).setContent("计算机");
		select_button.get(8).setContent("电子类");
		select_button.get(9).setContent("物理");
		select_button.get(10).setContent("数学");
		select_button.get(11).setContent("化学");
		select_button.get(12).setContent("生物");
		select_button.get(13).setContent("外语");
		select_button.get(0).setSelected(true);
		select_button.get(0).setBounds(525, 155, 100, 30);
		select_button.get(1).setBounds(635, 155, 100, 30);
		select_button.get(0).addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				if(!(select_button.get(0).getIsSelected())&&select_button.get(1).getIsSelected()){
					select_button.get(1).setSelected(false);
				}
	
	
			}
		});
		select_button.get(1).addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				if(select_button.get(0).getIsSelected()&&!(select_button.get(1).getIsSelected())){
					select_button.get(0).setSelected(false);
				}
	
	
			}
		});

		select_button.get(2).addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				if(select_button.get(2).getIsSelected()&&
						select_button.get(3).getIsSelected()&&
						select_button.get(4).getIsSelected()&&
						select_button.get(5).getIsSelected()&&
						select_button.get(6).getIsSelected()&&
						select_button.get(7).getIsSelected()&&
						select_button.get(8).getIsSelected()&&
						select_button.get(9).getIsSelected()&&
						select_button.get(10).getIsSelected()&&
						select_button.get(11).getIsSelected()&&
						select_button.get(12).getIsSelected()&&
						select_button.get(13).getIsSelected())
				{for(int i=2;i<=13;i++)select_button.get(i).setSelected(false);
				select_button.get(2).setSelected(true);}
				else 
					for(int i=3;i<=13;i++){select_button.get(i).setSelected(true);
				select_button.get(2).setSelected(false);}
	
			}
		});


		background_panel.add(search);
		
		back.setBounds(400,570,100,30);
		background_panel.add(input);
		background_panel.setLayout(null);
		input.setBorder(null);
		background_panel.setBackground(new Color(35,164,231));
		this.add(background_panel);
		background_panel.setBounds(160, 150, 320, 37);
		input.setBounds(1, 1, 230, 35);
		search.setBounds(231, 1, 90, 35);
		search.setContentAreaFilled(false);
		search.setOpaque(false);
		search.setBorderPainted(false);
		search.setFont(new Font("微软雅黑", Font.BOLD,15));
		
		input.setFont(new Font("Dialog",Font.BOLD,16));

		

//		nextpage.addActionListener(new java.awt.event.ActionListener() {
//
//			public void actionPerformed(java.awt.event.ActionEvent e) {
//				pageplus();
//	
//			}
//		});
//	//	previouspage.addActionListener(new java.awt.event.ActionListener() {
//
//			public void actionPerformed(java.awt.event.ActionEvent e) {
//				pageminus();
//	
//			}
//		});
//		confirm.addActionListener(new java.awt.event.ActionListener() {
//
//			public void actionPerformed(java.awt.event.ActionEvent e) {
//				pageto();
//	
//			}
//		});

		
		search.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				//mClient.sendBookQuery(input.getText());
				//sousuojianting
				
				mClient.sendBookQuery(new BookQueryMessage(input.getText(), select_button.get(1).getIsSelected(), select_button.get(3).getIsSelected(), select_button.get(4).getIsSelected(), select_button.get(5).getIsSelected(), select_button.get(6).getIsSelected(), select_button.get(7).getIsSelected(), select_button.get(8).getIsSelected(), select_button.get(9).getIsSelected(), select_button.get(10).getIsSelected(), select_button.get(11).getIsSelected(), select_button.get(12).getIsSelected(), select_button.get(13).getIsSelected()));
				
//				ArrayList<BookMessage> temp = new ArrayList<BookMessage>();
//				temp.add(new BookMessage("1","1","1","1","1","1",1,1,1,1,1,"1"));
//				temp.add(new BookMessage("1","1","1","1","1","1",1,1,1,1,1,"1"));
//				showSearchresult(temp);
	
		}

		});
	
		
	}

	void showSearchresult(ArrayList<BookMessage> bookmessages){
		table =new SuperTable(bookmessage, 9+admin);
		table.setCellSize(100-10*admin, 45);
		if(admin==1){table.setTextTableHead(9, "管理");}
		jsp =new JScrollPane(table);
		//jsp初始化
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBackground(Color.white);
		table.setTextTableHead(columnNames);
		table.setButtonColumn(8, "预约");
		table.setButtonColumn(9, "管理");
	//	table.ButtonArray.get(0).get(8).setBackground(Color.black);
	
	//	table.ButtonArray.get(8).get(0).setBackground(Color.black);

		 searchData=new String[bookmessages.size()][8];
		//for(int i=0;i<bookmessages.size();i++)for(int j=0;j<=7;j++)searchData[i][j]="1";
		 //测试用数据
			for (int i = 0; i < bookmessages.size(); i++) {
				searchData[i][0] = bookmessages.get(i).getCode();
				searchData[i][1] = bookmessages.get(i).getBookname();
				searchData[i][2] = bookmessages.get(i).getAuthor();
				searchData[i][3] = bookmessages.get(i).getPress();
				searchData[i][4] = bookmessages.get(i).getTotal() + "";
				searchData[i][5] = bookmessages.get(i).getAvailable() + "";
				searchData[i][6] = bookmessages.get(i).getComment();
				searchData[i][7] = bookmessages.get(i).getAddress();

			}
		table.setTextTableAll(searchData);
		for(int i=0;i<bookmessages.size();i++)
		{	if(Integer.valueOf(table.getTextTableCell(i,5))==0)
			{table.ButtonArray.get(i).get(8).setText("不可借");
		table.ButtonArray.get(i).get(8).setEnabled(false);}
				}
		
		table.setTableHeadHeight(23);
		table.setPreferredSize(new Dimension(900, table.getHeight()+45));
		
	
		for(int i=0;i<bookmessages.size();i++)
		{	final int j=i;
			table.ButtonArray.get(i).get(8).addActionListener(new java.awt.event.ActionListener() {
				
			
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(Integer.valueOf(table.getTextTableCell(j, 5))>0){

					JOptionPane.showMessageDialog(null, "预约成功", "提示信息",JOptionPane.CLOSED_OPTION);
					jsp.setVisible(false); jsp.setVisible(true);
					int temp=Integer.parseInt(table.getTextTableCell(j, 5));
					temp=temp-1;
					if( temp<=0) {table.ButtonArray.get(j).get(8).setText("不可借");	table.ButtonArray.get(j).get(8).setEnabled(false);}
					table.setTextTableCell(j, 5,String.valueOf(temp));
					SearchPanel.this.setVisible(false);
					SearchPanel.this.setVisible(true);
					
		
			}
				}
			});
			table.ButtonArray.get(i).get(9).addActionListener(new java.awt.event.ActionListener() {
				
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (!(searchData[j][0].isEmpty())) {
						
					
					
					guanli(j);
					}
						
					
		
				}
	
			});
		}
//		guanli.get(i).addActionListener(new java.awt.event.ActionListener() {
//
//			public void actionPerformed(java.awt.event.ActionEvent e) {
//				if (!(searchData[j][0].isEmpty())) {
//					
//				
//				
//				guanli(j);
//				}
//					
//				
//	
//			}
//
//		});
		jsp.setVisible(false); jsp.setVisible(true);
		this.removeAll();
		this.add(jsp);
		back.setBounds(400,555,100,30);
		this.add(back);
		back.setVisible(false);back.setVisible(true);
		table.setVisible(false);table.setVisible(true);
		jsp.setBounds(0,0,1000,550);
		final ArrayList<BookMessage> temp=new ArrayList<BookMessage>();
		back.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {

				back(temp);
	
		}

		});

	}
	
	void back(ArrayList<BookMessage> bookmessages){
		this.removeAll();
		this.setVisible(false);
		this.setVisible(true);
		this.setLayout(null);
		this.setSize(900, 700);
		
		table.setEnabled(false);
		for (int i = 0; i <14; i++) {
			select_button.get(i).setBounds(150+170*((i+2)%4), 180+70*((i+2)/4), 100, 30);
			this.add(select_button.get(i));
		}
		select_button.get(0).setBounds(525, 155, 100, 30);
		select_button.get(1).setBounds(635, 155, 100, 30);
		background_panel.add(search);
		background_panel.add(input);
		background_panel.setLayout(null);
		input.setBorder(null);
		background_panel.setBackground(new Color(35,164,231));
		this.add(background_panel);
		background_panel.setBounds(160, 150, 320, 37);
		input.setBounds(1, 1, 230, 35);
		search.setBounds(231, 1, 90, 35);
		search.setContentAreaFilled(false);
		search.setOpaque(false);
		search.setBorderPainted(false);
		search.setFont(new Font("微软雅黑", Font.BOLD,15));	
		input.setFont(new Font("Dialog",Font.BOLD,16));
		for(int i=0;i<bookmessages.size();i++)for(int j=0;j<=7;j++)searchData[i][j]="";


		
	}

void sousuo(){

	//for(int i=0;i<=29;i++) for(int j=0;j<=7;j++) ;		

//	nextpage.setVisible(false);		nextpage.setVisible(true);
//	page.setVisible(false);		page.setVisible(true);
//	previouspage.setVisible(false);		previouspage.setVisible(true);
//	confirm.setVisible(false);		confirm.setVisible(true);
//	changeto.setVisible(false);		changeto.setVisible(true);
//	if (subscribe.size()<14) {
//	for( int i=0;i<=29;i++)
//	{
//		if(searchData[i][5]!="0"){
//			JButton temp = new JButton("预约");	
//			subscribe.add(temp);			
//			subscribe.get(i).setBounds(800-80*admin, 22+16*i, 101-admin*20,15);			
//			this.add(subscribe.get(i));			
//			subscribe.get(i).setVisible(false);
//			subscribe.get(i).setVisible(true);			
//			subscribe.get(i).setBorderPainted(false);		
//			returnNumber(i);
//			
//			JButton temp1 = new JButton("管理");	
//			guanli.add(temp1);			
//			guanli.get(i).setBounds(802, 22+16*i, 101,15);			
//			this.add(guanli.get(i));			
//			if(admin==0)guanli.get(i).setVisible(false);
//			if(admin==1){guanli.get(i).setVisible(false);guanli.get(i).setVisible(true);}			
//			guanli.get(i).setBorderPainted(false);		
//			final int j=returnNumber(i);
//			subscribe.get(i).addActionListener(new java.awt.event.ActionListener() {
//
//				public void actionPerformed(java.awt.event.ActionEvent e) {
//					if(Integer.valueOf(searchData[j][5])>0){
//
//					JOptionPane.showMessageDialog(null, "预约成功", "提示信息",JOptionPane.CLOSED_OPTION);
//					jsp.setVisible(false); jsp.setVisible(true);
//					int temp=Integer.parseInt(searchData[j][5]);
//					temp=temp-1;
//					if( temp==0) {subscribe.get(j).setText("不可借");	subscribe.get(j).setEnabled(false);}
//					searchData[j][5]=String.valueOf(temp);
//					ALLData.get(pagenumber)[j][5]=searchData[j][5];
//					ALLData.get(pagenumber)[j][5]=searchData[j][5];
//						
//					}
//		
//				}
//
//			});
//
//			guanli.get(i).addActionListener(new java.awt.event.ActionListener() {
//
//				public void actionPerformed(java.awt.event.ActionEvent e) {
//					if (!(searchData[j][0].isEmpty())) {
//						
//					
//					
//					guanli(j);
//					}
//						
//					
//		
//				}
//
//			});
//		
//		
//			
//		}
//		
//		
//	
//		else{
//			JButton temp = new JButton("不可借");			
//			subscribe.add(temp);			
//			subscribe.get(i).setBounds(800-80*admin, 22+16*i, 101-admin*20,15);			
//			this.add(subscribe.get(i));			
//			subscribe.get(i).setVisible(false);
//			subscribe.get(i).setVisible(true);			
//			subscribe.get(i).setBorder(null);
//			subscribe.get(i).setEnabled(false);
//			}
//			
//
//		}
//	}
//	else {
//		for( int i=0;i<=29;i++)
//			{subscribe.get(i).setBounds(800-80*admin, 22+16*i, 101-admin*20,15);			
//			this.add(subscribe.get(i));	
//			this.add(guanli.get(i));			
//			if(admin==0)guanli.get(i).setVisible(false);
//			if(admin==1){guanli.get(i).setVisible(false);guanli.get(i).setVisible(true);}	
//			subscribe.get(i).setVisible(false);
//			subscribe.get(i).setVisible(true);	
//			guanli.get(i).setBounds(802, 22+16*i, 101,15);	
//			}
//	}
	

//	previouspage.setBounds(224,510,80,20);
//	nextpage.setBounds(314,510,80,20);
//	page.setBounds(479,510,80,20);

//	changeto.setBounds(404,510,80,20);
//	confirm.setBounds(499,510,80,20);
	
	
	
}
public void guanli(int x) 
{
	
	libadm = new libraryadmin(); 
	libadm.setsearchpanel(this);
	libadm.setVisible(true);
	libadm.tablenumber=x;
	libadm.ABLETOBORROW.setText(table.getTextTableCell(x, 5));
	libadm.BOOKNAME.setText(table.getTextTableCell(x, 1));
	libadm.BOOKNUMBER.setText(table.getTextTableCell(x, 0));
	libadm.TOTAL.setText(table.getTextTableCell(x, 4));
	libadm.author_input.setText(table.getTextTableCell(x, 2));
	libadm.press_input.setText(table.getTextTableCell(x, 3));
	libadm.class_input.setText(table.getTextTableCell(x, 6));
	libadm.location_input.setText(table.getTextTableCell(x, 7));
	
	
	
	
}


int returnNumber(int i){
	return i;
	
}

	
//public static void main(String[] args) {
//	JFrame jf=new JFrame();
//	SearchPanel s=new SearchPanel(null);
//	jf.add(s.jsp);
//	jf.setLayout(null);
//	jf.setSize(900, 700);
//	jf.setVisible(true);
//	
//}
}