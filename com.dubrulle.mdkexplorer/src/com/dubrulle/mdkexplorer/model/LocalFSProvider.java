package com.dubrulle.mdkexplorer.model;

import java.io.File;

public class LocalFSProvider implements IFSProvider {

	@Override
	public boolean isDirectory(String path) {
		return new File(path).isDirectory();
	}

	@Override
	public boolean isFile(String path) {
		return new File(path).isFile();
	}

	@Override
	public String[] listFiles(String path) {
		File[] files = new File(path).listFiles();
		
		String[] strings = new String[files.length];
		
		for (int i = 0; i < files.length; i++) {
			strings[i] = files[i].getName();
		}
		
		return strings;
	}

}
