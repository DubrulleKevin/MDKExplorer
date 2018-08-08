package com.dubrulle.mdkexplorer.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTree;

@SuppressWarnings("serial")
public class ExplorerPanel extends JPanel {
	
	public ExplorerPanel() {
		setLayout(new BorderLayout());
		
		JTree tree = new JTree();
		
		add(tree);
	}

}
