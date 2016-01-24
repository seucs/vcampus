package AdmOffice;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class HandbookPanel extends JPanel {
	public HandbookPanel() {
		this.setLayout(null);

		JTextArea handBookTextArea = new JTextArea() {
			public void paint(Graphics g) {
				this.setOpaque(false);
				g.drawImage(new ImageIcon("images/studentbook_bg.jpg").getImage(), 0, 0, this);
				super.paint(g);
			}
		};
		String read = "";
		String readStr = "";

		try {
			File filename = new File("database/handbook.book");
			BufferedReader bufread = new BufferedReader(new FileReader(filename));
			while ((read = bufread.readLine()) != null) {
				readStr += read + "\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		handBookTextArea.setText("\n\n\n"+readStr);
		handBookTextArea.setLineWrap(true);
		handBookTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		handBookTextArea.setForeground(Color.WHITE);
		handBookTextArea.setEditable(false);
		handBookTextArea.setBorder(new EmptyBorder(0, 0, 0, 0));
		handBookTextArea.setLocation(40, 20);
		handBookTextArea.setSize(800, 550);
		
		JLabel jLabel = new JLabel("东南大学  止于至善");
		jLabel.setOpaque(false);
		jLabel.setForeground(Color.WHITE);
		jLabel.setFont(new Font("隶书", Font.BOLD, 45));
		jLabel.setSize(jLabel.getPreferredSize());
		jLabel.setLocation(170, 10);
		handBookTextArea.add(jLabel);
		

		this.add(handBookTextArea);

	}

}