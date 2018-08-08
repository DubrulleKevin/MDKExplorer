package com.dubrulle.mdkexplorer.ui;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourcesManager {

	private static ResourcesManager instance;
	
	private BufferedImage folderIcon;
	private BufferedImage fileIcon;
	
	public static ResourcesManager getInstance() {
		if (instance == null) {
			instance = new ResourcesManager();
		}
		
		return instance;
	}
	
	public final BufferedImage getFolderIcon() {
		if (folderIcon == null) {
			try {
				folderIcon = ImageIO.read(getClass().getResourceAsStream("/com/dubrulle/mdkexplorer/ui/icons/folder.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return folderIcon;
	}
	
	public final BufferedImage getFileIcon() {
		if (fileIcon == null) {
			try {
				fileIcon = ImageIO.read(getClass().getResourceAsStream("/com/dubrulle/mdkexplorer/ui/icons/file.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return fileIcon;
	}
	
}
