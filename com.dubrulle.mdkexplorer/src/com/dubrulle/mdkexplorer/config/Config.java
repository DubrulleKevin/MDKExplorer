package com.dubrulle.mdkexplorer.config;

import java.awt.Color;

public class Config {
	
	private static Config instance;
	
	public static final Config getInstance() {
		if (instance == null) {
			instance = new Config();
		}
		
		return instance;
	}

	public Color getBackgroundColor() {
		return Color.WHITE;			
	}
	
}
