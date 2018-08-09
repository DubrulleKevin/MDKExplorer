package com.dubrulle.mdkexplorer.ui;

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
			frame.setFilesIconSize(IconSize.DEFAULT);
		});
		
		JMenuItem defaultItem = new JMenuItem("Tall icons");
		defaultItem.addActionListener(l -> {
			frame.setFilesIconSize(IconSize.TALL);
		});
		
		JMenuItem bigItem = new JMenuItem("Big icons");
		bigItem.addActionListener(l -> {
			frame.setFilesIconSize(IconSize.BIG);
		});
		
		JMenu viewMenu = new JMenu("View");
		viewMenu.add(smallItem);
		viewMenu.add(defaultItem);
		viewMenu.add(bigItem);
		
		add(viewMenu);
	}

}
