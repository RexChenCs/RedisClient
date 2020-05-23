package com.redis.cache.gui.layoutProperty;

import java.awt.Color;
import java.awt.Font;


public class LoginPanelProperty {
	
	private Font titleFont = new Font("Times New Roman", Font.PLAIN, 24);
	private Color titleColor = Color.BLACK;
	private Color labelFgColor = Color.BLACK;
	private Color labelBgColor = Color.CYAN;
	
	private Font labelFont = new Font("Tahoma", Font.PLAIN, 14);
	private Font textFont = new Font("Tahoma", Font.PLAIN, 14);
	private int labelInitial_X = 250;
	private int labelInitial_Y = 166;
	private int diff_column = 230;
	private int diff_row = 40;
	private int label_width = 193;
	private int label_height = 24;
	private int text_width = 281;
	private int text_height = 20;
	

	public Font getTitleFont() {
		return titleFont;
	}

	public void setTitleFont(Font titleFont) {
		this.titleFont = titleFont;
	}

	public int getLabelInitial_X() {
		return labelInitial_X;
	}

	public void setLabelInitial_X(int labelInitial_X) {
		this.labelInitial_X = labelInitial_X;
	}

	public int getDiff_row() {
		return diff_row;
	}

	public void setDiff_row(int diff_row) {
		this.diff_row = diff_row;
	}

	public int getLabelInitial_Y() {
		return labelInitial_Y;
	}

	public void setLabelInitial_Y(int labelInitial_Y) {
		this.labelInitial_Y = labelInitial_Y;
	}

	public int getCurrent_X(int column) {
		return this.labelInitial_X + column*this.diff_column;
	}

	public int getCurrent_Y(int row) {
		return this.labelInitial_Y + row*this.diff_row;
	}

	public int getLabel_width() {
		return label_width;
	}

	public void setLabel_width(int label_width) {
		this.label_width = label_width;
	}

	public int getLabel_height() {
		return label_height;
	}

	public void setLabel_height(int label_height) {
		this.label_height = label_height;
	}

	public int getText_width() {
		return text_width;
	}

	public void setText_width(int text_width) {
		this.text_width = text_width;
	}

	public int getText_height() {
		return text_height;
	}

	public void setText_height(int text_height) {
		this.text_height = text_height;
	}

	public Font getLabelFont() {
		return labelFont;
	}

	public void setLabelFont(Font labelFont) {
		this.labelFont = labelFont;
	}

	public Font getTextFont() {
		return textFont;
	}

	public void setTextFont(Font textFont) {
		this.textFont = textFont;
	}

	public Color getTitleColor() {
		return titleColor;
	}

	public void setTitleColor(Color titleColor) {
		this.titleColor = titleColor;
	}

	public Color getLabelBgColor() {
		return labelBgColor;
	}

	public void setLabelBgColor(Color labelBgColor) {
		this.labelBgColor = labelBgColor;
	}

	public Color getLabelFgColor() {
		return labelFgColor;
	}

	public void setLabelFgColor(Color labelFgColor) {
		this.labelFgColor = labelFgColor;
	}

	

}
