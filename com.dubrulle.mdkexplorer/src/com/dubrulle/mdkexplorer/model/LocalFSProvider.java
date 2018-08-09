package com.dubrulle.mdkexplorer.model;

import java.io.File;

public class LocalFSProvider implements IFSProvider {
	
	private static LocalFSProvider instance;
	
	public static LocalFSProvider getInstance() {
		if (instance == null) {
			instance = new LocalFSProvider();
		}
		
		return instance;
	}
	
	private LocalFSProvider() {
		
	}

	@Override
	public File[] listFiles(String path) {
		return new File(path).listFiles();
	}

}
