package com.dubrulle.mdkexplorer.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FilesPanel extends JPanel {
	
	private int iconSize = 48;	
	private List<FilePanel> filePanels;
	
	public FilesPanel() {
		setLayout(new FilesPanelLayoutManager());
		
		filePanels = new ArrayList<>();
		
		filePanels.add(new FilePanel(this, "1", iconSize, IconType.FOLDER));
		filePanels.add(new FilePanel(this, "2", iconSize, IconType.FOLDER));
		filePanels.add(new FilePanel(this, "3", iconSize, IconType.FOLDER));
		filePanels.add(new FilePanel(this, "4", iconSize, IconType.FOLDER));
		filePanels.add(new FilePanel(this, "5", iconSize, IconType.FOLDER));
		filePanels.add(new FilePanel(this, "6", iconSize, IconType.FOLDER));
		filePanels.add(new FilePanel(this, "7", iconSize, IconType.FOLDER));
		filePanels.add(new FilePanel(this, "8", iconSize, IconType.FOLDER));
		filePanels.add(new FilePanel(this, "9", iconSize, IconType.FOLDER));
		filePanels.add(new FilePanel(this, "10", iconSize, IconType.FOLDER));
		
		for (FilePanel filePanel : filePanels) {
			add(filePanel);
		}
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("Unpressed");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Pressed");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				unSelectAll();
			}
		});
	}
	
	public void unSelectAll() {
		for (FilePanel filePanel : filePanels) {
			filePanel.unSelect();
		}
		
		repaint();
	}
	
	public int getIconSize() {
		return iconSize;
	}
	
	public void setIconSize(final int iconSize) {
		this.iconSize = iconSize;
		
		for (FilePanel filePanel : filePanels) {
			filePanel.setIconSize(iconSize);;
		}
		
		revalidate();
	}

}
