package com.dubrulle.mdkexplorer.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.dubrulle.mdkexplorer.model.IFSProvider;
import com.dubrulle.mdkexplorer.model.LocalFSProvider;

@SuppressWarnings("serial")
public class FilesPanel extends JPanel {
	
	private IconSize iconSize = IconSize.DEFAULT;	
	private List<FilePanel> filePanels;
	
	public FilesPanel() {
		setLayout(new FilesPanelLayoutManager());
		
		filePanels = new ArrayList<>();
		
		IFSProvider fsProvider = LocalFSProvider.getInstance();
		
		File[] files = fsProvider.listFiles("/etc");
		
		for (File file : files) {
			if (file.isDirectory()) {
				filePanels.add(new FilePanel(this, file.getName(), iconSize, IconType.FOLDER));
			}
			else {
				filePanels.add(new FilePanel(this, file.getName(), iconSize, IconType.FILE));
			}
		}
		
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
	
	public final IconSize getIconSize() {
		return iconSize;
	}
	
	public void setIconSize(final IconSize iconSize) {
		this.iconSize = iconSize;
		
		for (FilePanel filePanel : filePanels) {
			filePanel.setIconSize(iconSize);;
		}
		
		revalidate();
	}

}
