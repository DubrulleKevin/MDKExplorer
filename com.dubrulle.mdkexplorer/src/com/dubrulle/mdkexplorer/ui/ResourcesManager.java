package com.dubrulle.mdkexplorer.ui;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourcesManager {

	private static ResourcesManager instance;
	
	private BufferedImage folderIconOriginal;
	private BufferedImage folderIconDefault;
	private BufferedImage folderIconTall;
	private BufferedImage folderIconBig;
	
	private BufferedImage fileIconOriginal;
	private BufferedImage fileIconDefault;
	private BufferedImage fileIconTall;
	private BufferedImage fileIconBig;
	
	public static ResourcesManager getInstance() {
		if (instance == null) {
			instance = new ResourcesManager();
		}
		
		return instance;
	}
	
	private ResourcesManager() {
		
	}
	
	private final BufferedImage resizeIcon(final BufferedImage image, final int size) {		
		Image scaledImage = image.getScaledInstance(size, size, BufferedImage.SCALE_DEFAULT);
		BufferedImage ret = new BufferedImage(size, size, image.getType());
		ret.getGraphics().drawImage(scaledImage, 0, 0, null);
		
		return ret;
	}
	
	private final BufferedImage getOriginalFolderIcon() {
		if (folderIconOriginal == null) {
			try {
				folderIconOriginal = ImageIO.read(getClass().getResourceAsStream("/com/dubrulle/mdkexplorer/ui/icons/folder.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return folderIconOriginal;
	}
	
	private final BufferedImage getOriginalFileIcon() {
		if (fileIconOriginal == null) {
			try {
				fileIconOriginal = ImageIO.read(getClass().getResourceAsStream("/com/dubrulle/mdkexplorer/ui/icons/file.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return fileIconOriginal;
	}
	
	public final BufferedImage getFolderIcon(EIconSize size) {
		BufferedImage ret = null;
		
		switch (size) {
		case DEFAULT:
			if (folderIconDefault == null) {
				folderIconDefault = resizeIcon(getOriginalFolderIcon(), size.getValue());
			}
			
			ret = folderIconDefault;
			
			break;
		case TALL:
			if (folderIconTall == null) {
				folderIconTall = resizeIcon(getOriginalFolderIcon(), size.getValue());
			}
			
			ret = folderIconTall;
			
			break;
		case BIG:
			if (folderIconBig == null) {
				folderIconBig = resizeIcon(getOriginalFolderIcon(), size.getValue());
			}
			
			ret = folderIconBig;
			
			break;
		}
		
		return ret;
	}
	
	public final BufferedImage getFileIcon(EIconSize size) {
		BufferedImage ret = null;
		
		switch (size) {
		case DEFAULT:
			if (fileIconDefault == null) {
				fileIconDefault = resizeIcon(getOriginalFileIcon(), size.getValue());
			}
			
			ret = fileIconDefault;
			
			break;
		case TALL:
			if (fileIconTall == null) {
				fileIconTall = resizeIcon(getOriginalFileIcon(), size.getValue());
			}
			
			ret = fileIconTall;
			
			break;
		case BIG:
			if (fileIconBig == null) {
				fileIconBig = resizeIcon(getOriginalFileIcon(), size.getValue());
			}
			
			ret = fileIconBig;
			
			break;
		}
		
		return ret;
	}
	
}
