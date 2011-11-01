package org.openlegacy.terminal.support;

import org.openlegacy.terminal.ScreenPosition;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * A screen position class for bean configuration comfort purposes
 * 
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class ScreenPositionBean implements ScreenPosition {

	@XmlAttribute
	private int row;

	@XmlAttribute
	private int column;

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public static ScreenPositionBean newInstance(ScreenPosition position) {
		ScreenPositionBean screenPosition = new ScreenPositionBean();
		screenPosition.setRow(position.getRow());
		screenPosition.setColumn(position.getColumn());
		return screenPosition;

	}
}
