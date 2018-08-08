package com.dubrulle.mdkexplorer.ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.Arrays;
import java.util.Comparator;

public class FilesPanelLayoutManager implements LayoutManager {

	@Override
	public void addLayoutComponent(String name, Component comp) {

	}

	@Override
	public void removeLayoutComponent(Component comp) {

	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		Dimension parentSize = parent.getSize();
		Insets parentInsets = parent.getInsets();
		Dimension ret = new Dimension();
		ret.width = parentSize.width + parentInsets.left + parentInsets.right;
		ret.height = parentSize.height + parentInsets.bottom + parentInsets.top;
		
		return ret;
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		Dimension componentSize = parent.getComponents()[0].getSize();
		Insets parentInsets = parent.getInsets();
		Dimension ret = new Dimension();
		ret.width = componentSize.width + parentInsets.left + parentInsets.right;
		ret.height = componentSize.height + parentInsets.bottom + parentInsets.top;
		
		return ret;
	}

	@Override
	public void layoutContainer(Container parent) {
		Component[] components = parent.getComponents();
		
		Arrays.sort(components, new Comparator<Component>() {

			@Override
			public int compare(Component o1, Component o2) {
				// Alphabetical order
				return o1.toString().compareTo(o2.toString());
			}
			
		});
		
		int iconSize = ((FilesPanel)parent).getIconSize();
		Dimension componentsSize = new Dimension(iconSize, iconSize);
		Dimension parentSize = parent.getSize();
		
		int componentsNumberOnX = parentSize.width / (componentsSize.width * 2);
		
		// Avoid ArithmeticException caused by i / componentsNumberOnX if componentsNumberOnX == 0
		if (componentsNumberOnX != 0) {
			for (int i = 0; i < components.length; i++) {
				components[i].setLocation(
					componentsSize.width * 2 * (i % componentsNumberOnX),
					componentsSize.height * 2 *(i / componentsNumberOnX)
				);
			}
		}
	}

}
