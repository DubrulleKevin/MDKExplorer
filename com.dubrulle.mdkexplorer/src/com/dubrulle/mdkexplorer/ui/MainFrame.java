package com.dubrulle.mdkexplorer.ui;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	private FilesPanel filesPanel;
	private ExplorerPanel explorerPanel;

	public MainFrame() {
		super("MDKExplorer");
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		filesPanel = new FilesPanel();
		explorerPanel = new ExplorerPanel();
		
		setContentPane(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, explorerPanel, filesPanel));		
		setJMenuBar(new MenuBar(this));
	}
	
	public void setFilesIconSize(final IconSize iconSize) {
		filesPanel.setIconSize(iconSize);
	}
	
}
