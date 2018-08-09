package com.dubrulle.mdkexplorer.model;

import java.io.File;

public interface IFSProvider {
	
	public File[] listFiles(final String path);

}
