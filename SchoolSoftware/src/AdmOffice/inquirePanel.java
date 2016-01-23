package AdmOffice;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import PowfulPanel.SuperTable;

public class InquirePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel mainInquirePanel = new JPanel();
	private InquireButton scheduleButton = new InquireButton("课表查询");
	private InquireButton onecardButton = new InquireButton("一卡通查询");
	private InquireButton gradeButton = new InquireButton("成绩查询");
	private InquireButton examButton = new InquireButton("考试安排查询");
	private InquireButton compeButton = new InquireButton("已报名竞赛查询");

	public InquirePanel() {

		this.setLayout(null);
		mainInquirePanel.setBounds(0, 0, 900, 700);
		mainInquirePanel.setBackground(Color.WHITE);
		mainInquirePanel.setLayout(null);
		this.add(mainInquirePanel);

		initScheduleButton();
		initOnecardButton();
		initGradeButton();
		initExamButton();
		initCompeButton();
	}

	public void initScheduleButton() {
		scheduleButton.setLocation(200, 50);
		mainInquirePanel.add(scheduleButton);
		JPanel jumppanel = scheduleButton.getJumpPanel();

		SuperTable schdule_table = new SuperTable(3, 5);	
		schdule_table.setCellSize(165, 150);
		schdule_table.setTableHeadHeight(50);
		schdule_table.setLocation(30, 20);
		schdule_table.setTextTableCell(1, 1, "<html><tr><td align='center'>微型机系统与接口技术<br>[1-16周]1-2节<br>九龙湖教六-103<br>计算机图形学<br>[1-16周]3-5节<br>九龙湖教二-106<br></td></tr></html>");
		jumppanel.add(schdule_table);
	}

	public void initOnecardButton() {
		onecardButton.setLocation(500, 50);
		mainInquirePanel.add(onecardButton);
	}

	public void initGradeButton() {
		gradeButton.setLocation(40, 300);
		mainInquirePanel.add(gradeButton);
	}

	public void initExamButton() {
		examButton.setLocation(340, 300);
		mainInquirePanel.add(examButton);
	}

	public void initCompeButton() {
		compeButton.setLocation(640, 300);
		mainInquirePanel.add(compeButton);
	}

	public void setMainInquirePanelVisitable(boolean judge) {
		this.mainInquirePanel.setVisible(judge);
	}

	class InquireButton extends JButton {
		private static final long serialVersionUID = 1L;
		private JPanel jumpPanel = new JPanel();

		public InquireButton(String name) {
			super(name);
			this.setSize(200, 200);
			this.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					jumpPanel.setVisible(true);
					InquirePanel.this.setMainInquirePanelVisitable(false);
				}
			});

			jumpPanel.setBounds(0, 0, 900, 700);
			jumpPanel.setBackground(Color.WHITE);
			jumpPanel.setVisible(false);
			jumpPanel.setLayout(null);
			InquirePanel.this.add(jumpPanel);

			JButton jButton = new JButton("返回");
			jButton.setFont(new Font("微软雅黑", Font.BOLD, 30));
			jButton.setSize(600, 50);
			jButton.setLocation(150, 550);
			jButton.setBorderPainted(false);
			jButton.setFocusPainted(false);
			jButton.setForeground(Color.WHITE);
			jButton.setBackground(new Color(35, 164, 231));
			jButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					jumpPanel.setVisible(false);
					InquirePanel.this.setMainInquirePanelVisitable(true);
				}
			});
			jumpPanel.add(jButton);

		}

		public JPanel getJumpPanel() {
			return jumpPanel;
		}

	}
}
