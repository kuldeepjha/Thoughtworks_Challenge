package com.thoughtworks.challenge.model;

import java.io.Serializable;

/**
 * 
 * @author Kuldeep Jha
 *
 */
public class WordCountModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int wordCount;

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}

}
