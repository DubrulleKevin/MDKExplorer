package com.dubrulle.mdkexplorer.ui;

public enum EIconSize {
	
	DEFAULT(48),
	TALL(64),
	BIG(80);
	
	private final int id;
	
	EIconSize(final int id) {
		this.id = id;
	}
	
    public int getValue() {
    	return id;
    }
    
}
