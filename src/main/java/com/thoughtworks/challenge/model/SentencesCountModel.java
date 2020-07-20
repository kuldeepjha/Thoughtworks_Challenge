package com.thoughtworks.challenge.model;

import java.io.Serializable;

/**
 * 
 * @author Kuldeep Jha
 *
 */
public class SentencesCountModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sentenceCount;

	public int getSentenceCount() {
		return sentenceCount;
	}

	public void setSentenceCount(int sentenceCount) {
		this.sentenceCount = sentenceCount;
	}

}
