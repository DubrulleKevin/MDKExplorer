package com.dubrulle.mdkexplorer.ui;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	
	public MenuBar(MainFrame frame) {
		JMenuItem quitItem = new JMenuItem("Quit");
		quitItem.addActionListener(l -> {
			frame.dispose();
		});
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(quitItem);
		
		add(fileMenu);
		
		JMenuItem smallItem = new JMenuItem("Default icons");
		smallItem.addActionListener(l -> {
			frame.getFilesPanel().setIconSize(EIconSize.DEFAULT);
		});
		
		JMenuItem defaultItem = new JMenuItem("Tall icons");
		defaultItem.addActionListener(l -> {
			frame.getFilesPanel().setIconSize(EIconSize.TALL);
		});
		
		JMenuItem bigItem = new JMenuItem("Big icons");
		bigItem.addActionListener(l -> {
			frame.getFilesPanel().setIconSize(EIconSize.BIG);
		});
		
		JCheckBoxMenuItem sortFoldersFirstItem = new JCheckBoxMenuItem("Sort folders first");
		sortFoldersFirstItem.setSelected(frame.getFilesPanel().getSortFoldersFirst());
		sortFoldersFirstItem.addActionListener(l -> {
			frame.getFilesPanel().setSortFoldersFirst(sortFoldersFirstItem.isSelected());
		});
		
		JMenu viewMenu = new JMenu("View");
		viewMenu.add(smallItem);
		viewMenu.add(defaultItem);
		viewMenu.add(bigItem);
		viewMenu.add(sortFoldersFirstItem);
		
		add(viewMenu);
	}

}
