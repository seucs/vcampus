package AdmOffice;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class AdmStatementPanel extends JPanel {
	private admTextArea info_text = null;
	private admTextArea act_text = null;
	private static final long serialVersionUID = 1L;

	public AdmStatementPanel() {

		this.setBackground(Color.white);
		this.setLayout(null);

		// 教务信息标签
		JLabel info_label = new JLabel("教务信息：");
		info_label.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		info_label.setForeground(Color.WHITE);
		info_label.setSize(info_label.getPreferredSize());
		info_label.setLocation(50, 25);
		this.add(info_label);

		// 教务信息文本区
		info_text = new admTextArea();
		info_text.setLocation(40, 20);
		info_text.addMessage("关于2015-2016-2学期《大学英语Ⅳ》免修报名的通知", "2015-09-14");
		info_text.addMessage("关于2015年下半年全国大学英语四、六级考试报名的通知", "2015-09-06");
		info_text.addMessage("第十一届“吾爱吾师——我最喜爱的老师评选”活动评选结果公布", "2015-09-10");
		info_text.addMessage("关于2015年国庆节放假的通知", "2015-09-09");
		info_text.addMessage("2014级转院（系）、转专业考试成绩通知", "2015-09-06");
		info_text.addMessage("关于公布2015级新生大学英语3级、4级起点名单的通知", "2015-09-06");
		this.add(info_text);

		// 校园活动标签
		JLabel act_label = new JLabel("校园活动：");
		act_label.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		act_label.setForeground(Color.WHITE);
		act_label.setSize(info_label.getPreferredSize());
		act_label.setLocation(50, 305);
		this.add(act_label);

		// 校园活动文本区
		act_text = new admTextArea();
		act_text.setLocation(40, 300);
		act_text.addMessage("关于征集“2016年东南大学SRTP项目指南”的通知", "2015-09-14");
		act_text.addMessage("关于东南大学2015年第二期命题创客项目招标指南", "2015-09-06");
		act_text.addMessage("关于组织2015年第三次“国家级、省级SRTP”结题验收的通知", "2015-09-10");
		act_text.addMessage("关于举办“东南大学第九届PLD设计竞赛”的通知", "2015-09-09");
		act_text.addMessage("关于开展2015-2016学年第一学期（短学期）学生实习实践情况检查的通知", "2015-09-06");
		act_text.addMessage("关于东南大学2015年第一期命题创客项目招标指南", "2015-09-06");
		this.add(act_text);
	}

	class admTextArea extends JTextArea {
		private static final long serialVersionUID = 1L;
		private JTextArea jTextArea = new JTextArea();

		public admTextArea() {
			this.setText("\n\n");
			this.setOpaque(false);
			this.setFont(new Font("微软雅黑", Font.PLAIN, 18));
			this.setForeground(Color.WHITE);
			this.setEditable(false);
			this.setBorder(new EmptyBorder(0, 0, 0, 0));
			this.setSize(800, 271);

			jTextArea.setText("\n\n");
			jTextArea.setOpaque(false);
			jTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 18));
			jTextArea.setForeground(Color.WHITE);
			jTextArea.setEditable(false);
			jTextArea.setBorder(new EmptyBorder(0, 0, 0, 0));
			jTextArea.setBounds(650, 0, 200, 271);
			this.add(jTextArea);
		}

		// 重绘背景
		public void paint(Graphics g) {
			g.drawImage(new ImageIcon("images/newsimage.jpg").getImage(), 0, 0, this);
			super.paint(g);
		}

		// 添加新消息
		public void addMessage(String msg, String time) {
			this.setText(this.getText() + "   ● " + msg + "\n");
			jTextArea.setText(jTextArea.getText() + time + "\n");
		}
	}

}
