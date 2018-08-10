package com.dubrulle.mdkexplorer.ui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextArea;

import com.dubrulle.mdkexplorer.config.Config;

@SuppressWarnings("serial")
public class FileNameTextArea extends JTextArea {

	public FileNameTextArea(final FilePanel parent, final String fileName, final int iconSize) {
		super(fileName);
		
		setSize(iconSize * 2, iconSize);
		setLineWrap(true);
		setWrapStyleWord(true);
		setCaretColor(Color.BLACK);
		
		unSelect();
		
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
				parent.select();
				
				if (e.getClickCount() == 2) {
					select();
				}
			}
		});
	}
	
	public void select() {
		setEditable(true);
		setSelectionColor(Color.BLACK);
		setSelectionStart(0);
		setSelectionEnd(getText().length());
	}
	
	public void unSelect() {
		setEditable(false);
		setBackground(Config.getBackgroundColor());
		setSelectionColor(Config.getBackgroundColor());
	}
	
}
