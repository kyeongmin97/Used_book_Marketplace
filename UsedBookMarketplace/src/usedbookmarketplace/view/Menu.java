package usedbookmarketplace.view;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel {
	protected JButton btn1 = new JButton();
	protected JButton btn2 = new JButton();;
	
	Menu(){		
		JPanel btnsPanel = new JPanel();
		btnsPanel.setOpaque(false);
		btnsPanel.add(btn1);
		btnsPanel.add(btn2);
		
		add(btnsPanel);	
	}
}