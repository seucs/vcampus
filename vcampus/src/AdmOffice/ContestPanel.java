package AdmOffice;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import AdmOffice.SelectCoursePanel.SelectButton;
import DAO.CompetitionDAO;
import DAO.DataAccessObject;
import Message.CompetitionMessage;
import Message.CompetitorMessage;
import Message.CourseMessage;
import Message.ExamMessage;
import PowfulPanel.SuperTable;

public class ContestPanel extends JPanel {
	private DataAccessObject dataAccessObject = new DataAccessObject();
	private HashMap<String, ContestButton> contestBtnMap = new HashMap<String, ContestButton>();
	private SuperTable contest_table = null;
	private InquirePanel inquirePanel;

	public ContestPanel(InquirePanel inquirePanel) {
		this.inquirePanel = inquirePanel;
		this.setBackground(Color.white);
		this.setLayout(null);

		// 全部课程信息获取
		ArrayList<CompetitionMessage> allCompMsgArr = dataAccessObject.getCompetitionDAO().queryAllCompetitionMessage();

		contest_table = new SuperTable(allCompMsgArr.size(), 3);
		contest_table.setLocation(80, 20);
		contest_table.setCellSize(350, 30);
		contest_table.setColumnWidthSize(1, 240);
		contest_table.setColumnWidthSize(2, 120);
		contest_table.setTableHeadHeight(40);

		String[] btn_name = new String[allCompMsgArr.size()];
		for (int i = 0; i < allCompMsgArr.size(); i++) {
			btn_name[i] = "报名";
		}
		contest_table.setButtonColumn(2, btn_name);

		// 选课按钮数组获取
		for (int i = 0; i < allCompMsgArr.size(); i++) {
			contestBtnMap.put(allCompMsgArr.get(i).getCompetition_id(),
					new ContestButton(i + 1 + "", contest_table.ButtonArray.get(i).get(2)));
		}

		contest_table.setTextTableHead(new String[] { "竞赛名字", "竞赛时间", "报名情况" });
		// 选课表格生成
		for (int i = 0; i < allCompMsgArr.size(); i++) {
			contest_table.setTextTableCell(i, 0, allCompMsgArr.get(i).getCompetition_name());
			contest_table.setTextTableCell(i, 1, allCompMsgArr.get(i).getCompetition_time());
		}
		this.add(contest_table);

		// 个人选课信息获取
		ArrayList<CompetitorMessage> myContestMsgArr = dataAccessObject.getCompetitorDAO()
				.queryCompetitorMessage("Capation", "09013125");
		for (CompetitorMessage myContest : myContestMsgArr) {
			contestBtnMap.get(myContest.getCompetition_id()).ChangeButton();
		}
		myContestMsgArr = dataAccessObject.getCompetitorDAO()
				.queryCompetitorMessage("teammate1", "09013125");
		for (CompetitorMessage myContest : myContestMsgArr) {
			contestBtnMap.get(myContest.getCompetition_id()).ChangeButton();
		}
		myContestMsgArr = dataAccessObject.getCompetitorDAO()
				.queryCompetitorMessage("teammate2", "09013125");
		for (CompetitorMessage myContest : myContestMsgArr) {
			contestBtnMap.get(myContest.getCompetition_id()).ChangeButton();
		}
	}
	
	public void RepaintInquirePanel() {
		inquirePanel.handleContest();
	}

	class ContestButton extends JButton {
		private JButton jButton;
		private String contest_id;

		public ContestButton(String contest_id, JButton jButton) {
			this.jButton = jButton;
			this.contest_id = contest_id;
			jButton.setText("报名");
			jButton.setBackground(new Color(35, 164, 231));
			jButton.setForeground(Color.WHITE);
			jButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					if (ContestButton.this.jButton.getText().equals("报名")) {
						dataAccessObject.getCompetitorDAO().addCompetitorInformation(ContestButton.this.contest_id, "09013125", "", "", "进行中");
						JOptionPane.showMessageDialog(null, "报名成功！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
					} else {
						dataAccessObject.getCompetitorDAO().deleteCompetitorMessage("competition_id", ContestButton.this.contest_id,"Capation","09013125");
						JOptionPane.showMessageDialog(null, "取消成功！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
					}
					ContestButton.this.ChangeButton();
					ContestPanel.this.RepaintInquirePanel();
				}
			});
		}
		public void ChangeButton() {
			if (jButton.getText().equals("报名")) {
				jButton.setText("取消");
				jButton.setBackground(new Color(240, 233, 204));
				jButton.setForeground(Color.BLACK);
			} else {
				jButton.setText("报名");
				jButton.setBackground(new Color(35, 164, 231));
				jButton.setForeground(Color.WHITE);
			}
		}
	}

}
