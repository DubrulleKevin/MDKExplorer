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
	private IconSize iconSize;
	private FileNameTextArea textArea;
	private IconType iconType;
	private boolean selected = false;
	private FilesPanel parent;

	public FilePanel(final FilesPanel parent, final String fileName, final IconSize iconSize, final IconType iconType) {	
		this.iconType = iconType;
		this.parent = parent;
		
		setLayout(null);
		
		setIconSize(iconSize);
		
		textArea = new FileNameTextArea(this, fileName, iconSize.getValue());
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
	
	private void resizeIcon() {
		switch (iconType) {
		case FILE:
			fileIcon = ResourcesManager.getInstance().getFileIcon(iconSize);
			break;
		case FOLDER:
			fileIcon = ResourcesManager.getInstance().getFolderIcon(iconSize);
			break;
		}
	}
	
	private void relocateTextArea() {
		textArea.setLocation(0, (int)(1.1 * iconSize.getValue()));
	}
	
	private void resize() {
		setSize(iconSize.getValue() * 2, iconSize.getValue() * 2);
	}
	
	public void setIconSize(final IconSize size) {
		this.iconSize = size;
		resizeIcon();
		resize();
	}
	
	public void paintComponent(Graphics g) {
		if (fileIcon != null) {
			if (selected) {
				g.drawImage(fileIcon, iconSize.getValue() / 2, 0, Color.BLUE ,null);
			}
			else {
				g.drawImage(fileIcon, iconSize.getValue() / 2, 0 ,null);
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
