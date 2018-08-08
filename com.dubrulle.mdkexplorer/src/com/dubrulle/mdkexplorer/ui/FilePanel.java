package com.dubrulle.mdkexplorer.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FilePanel extends JPanel {
		
	private BufferedImage fileIcon;
	private int iconSize;
	private FileNameTextArea textArea;
	private IconType iconType;
	private boolean selected = false;
	private FilesPanel parent;

	public FilePanel(final FilesPanel parent, final String fileName, final int iconSize, final IconType iconType) {	
		this.iconType = iconType;
		this.parent = parent;
		
		setLayout(null);
		
		setIconSize(iconSize);
		
		textArea = new FileNameTextArea(this, fileName, iconSize);
		relocateTextArea();
		add(textArea);
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				if (e.getClickCount() == 2) {
					doubleClickOnIcon();
				}
				else {
					simpleClickOnIcon();
				}
			}
		});
	}
	
	private void simpleClickOnIcon() {
		select();
	}
	
	private void doubleClickOnIcon() {
		System.out.println("Double click on icon");
	}
	
	private void loadIcon() {
		switch (iconType) {
		case FILE:
			fileIcon = ResourcesManager.getInstance().getFileIcon();
			break;
		case FOLDER:
			fileIcon = ResourcesManager.getInstance().getFolderIcon();
		}
	}
	
	private void loadAndResizeIcon() {
		loadIcon();
		
		Image scaledImage = fileIcon.getScaledInstance(iconSize, iconSize, BufferedImage.SCALE_DEFAULT);
		fileIcon = new BufferedImage(iconSize, iconSize, fileIcon.getType());
		fileIcon.getGraphics().drawImage(scaledImage, 0, 0, null);
	}
	
	private void relocateTextArea() {
		textArea.setLocation(0, (int)(1.1 * iconSize));
	}
	
	private void resize() {
		setSize(iconSize * 2, iconSize * 2);
	}
	
	public void setIconSize(final int iconSize) {
		this.iconSize = iconSize;
		loadAndResizeIcon();
		resize();
	}
	
	public void paintComponent(Graphics g) {
		if (fileIcon != null) {
			if (selected) {
				g.drawImage(fileIcon, iconSize / 2, 0, Color.BLUE ,null);
			}
			else {
				g.drawImage(fileIcon, iconSize / 2, 0 ,null);
			}
		}
	}
	
	public void select() {
		parent.unSelectAll();
		selected = true;
	}
	
	public void unSelect() {
		textArea.unSelect();
		selected = false;
	}
	
	public void setLocation(int x, int y) {
		relocateTextArea();
		super.setLocation(x, y);
	}
	
	public String toString() {
		return textArea.getText();
	}
	
}
