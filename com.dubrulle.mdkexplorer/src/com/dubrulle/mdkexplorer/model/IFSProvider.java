package com.dubrulle.mdkexplorer.model;

public interface IFSProvider {
	
	public boolean isDirectory(final String path);
	
	public boolean isFile(final String path);
	
	public String[] listFiles(final String path);

}
