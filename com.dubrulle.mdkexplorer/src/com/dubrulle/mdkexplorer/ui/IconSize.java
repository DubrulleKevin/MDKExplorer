package com.dubrulle.mdkexplorer.ui;

public enum IconSize {
	
	DEFAULT(48),
	TALL(64),
	BIG(80);
	
	private final int id;
	
	IconSize(final int id) {
		this.id = id;
	}
	
    public int getValue() {
    	return id;
    }
    
}
