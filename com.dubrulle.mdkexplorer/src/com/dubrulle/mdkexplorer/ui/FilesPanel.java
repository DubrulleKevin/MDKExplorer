package com.dubrulle.mdkexplorer.ui;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollBar;

import com.dubrulle.mdkexplorer.config.Config;
import com.dubrulle.mdkexplorer.model.IFSProvider;
import com.dubrulle.mdkexplorer.model.LocalFSProvider;

@SuppressWarnings("serial")
public class FilesPanel extends JPanel {
	
	private EIconSize iconSize = EIconSize.DEFAULT;
	private boolean sortFoldersFirst = true;
	private List<FilePanel> filePanels;
	private FilesPanelLayoutManager layout;
	private JScrollBar parentScrollBar;
	
	public FilesPanel(JScrollBar parentScrollBar) {
		this.parentScrollBar = parentScrollBar;
		
		setBackground(Config.getInstance().getBackgroundColor());
		
		layout = new FilesPanelLayoutManager();
		layout.setSortFoldersFirst(getSortFoldersFirst());
		setLayout(layout);
		
		filePanels = new ArrayList<>();
		
		IFSProvider fsProvider = LocalFSProvider.getInstance();
		
		File[] files = fsProvider.listFiles("/etc");
		
		for (File file : files) {
			if (file.isDirectory()) {
				filePanels.add(new FilePanel(this, file.getName(), iconSize, EIconType.FOLDER));
			}
			else {
				filePanels.add(new FilePanel(this, file.getName(), iconSize, EIconType.FILE));
			}
		}
		
		for (FilePanel filePanel : filePanels) {
			add(filePanel);
		}
		
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
				unSelectAll();
			}
		});
		
		addMouseWheelListener(new MouseWheelListener() {
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				if (e.getWheelRotation() < 0 && parentScrollBar.getValue() > 0) {
					parentScrollBar.setValue(parentScrollBar.getValue() - 1);
				}
				else if (e.getWheelRotation() > 0 && parentScrollBar.getValue() < parentScrollBar.getMaximum()) {
					parentScrollBar.setValue(parentScrollBar.getValue() + 1);
				}
			}
		});
		
		addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				int maxRowsNumber = getMaxRowsNumber();
				
				if (maxRowsNumber != 0) {
					parentScrollBar.setMaximum(getRowsNumber() / getMaxRowsNumber());
				}	
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		parentScrollBar.addAdjustmentListener(new AdjustmentListener() {
			
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				layout.setScroll(2 * iconSize.getValue() * e.getValue() * getMaxRowsNumber());
				revalidate();
			}
		});
	}
	
	private final int getRowsNumber() {
		int ret = 0;
		int componentsNumberOnX = getWidth() / (iconSize.getValue() * 2);
		
		if (componentsNumberOnX != 0) {
			ret = (getComponents().length / componentsNumberOnX);
		}
		
		return ret;
	}
	
	private final int getMaxRowsNumber() {
		return getSize().height / (iconSize.getValue() * 2);
	}
	
	public void unSelectAll() {
		for (FilePanel filePanel : filePanels) {
			filePanel.unSelect();
		}
		
		repaint();
	}
	
	public final EIconSize getIconSize() {
		return iconSize;
	}
	
	public void setIconSize(final EIconSize iconSize) {
		this.iconSize = iconSize;
		
		for (FilePanel filePanel : filePanels) {
			filePanel.setIconSize(iconSize);
		}
		
		parentScrollBar.setMaximum(getRowsNumber() / getMaxRowsNumber());
		
		revalidate();
	}
	
	public final boolean getSortFoldersFirst() {
		return sortFoldersFirst;
	}
	
	public void setSortFoldersFirst(final boolean b) {
		sortFoldersFirst = b;
		layout.setSortFoldersFirst(b);
		revalidate();
	}

}
