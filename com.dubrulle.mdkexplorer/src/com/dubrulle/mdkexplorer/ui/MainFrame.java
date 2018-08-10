package com.dubrulle.mdkexplorer.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSplitPane;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	private FilesPanel filesPanel;
	private ExplorerPanel explorerPanel;

	public MainFrame() {
		super("MDKExplorer");
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL, 0, 0, 0, 0);
		
		filesPanel = new FilesPanel(scrollBar);
		explorerPanel = new ExplorerPanel();
		
		JPanel mainFilesPanel = new JPanel();
		mainFilesPanel.setLayout(new BorderLayout());
		mainFilesPanel.add(filesPanel, BorderLayout.CENTER);
		mainFilesPanel.add(scrollBar, BorderLayout.EAST);
		
		setContentPane(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, explorerPanel, mainFilesPanel));		
		setJMenuBar(new MenuBar(this));
	}
	
	public final FilesPanel getFilesPanel() {
		return filesPanel;
	}
	
}
