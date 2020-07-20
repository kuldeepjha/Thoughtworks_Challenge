package com.thoughtworks.challenge.model;

import java.io.Serializable;

/**
 * 
 * @author Kuldeep Jha
 *
 */
public class InModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
