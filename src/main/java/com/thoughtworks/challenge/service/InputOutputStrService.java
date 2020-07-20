package com.thoughtworks.challenge.service;

import org.springframework.http.ResponseEntity;

/**
 * 
 * @author Kuldeep Jha
 *
 */
public interface InputOutputStrService {

	public ResponseEntity<String> charCount();

	public ResponseEntity<String> wordCount();

	public ResponseEntity<String> sentencesCount();

	public ResponseEntity<String> vowelsCount();

}
