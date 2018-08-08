package com.dubrulle.mdkexplorer.model;

public class MDKExplorerModel {

	private String currentPath;
	
	public MDKExplorerModel() {
		currentPath = System.getenv("HOME");
	}
	
	public String getCurrentPath() {
		return currentPath;
	}
	
}
