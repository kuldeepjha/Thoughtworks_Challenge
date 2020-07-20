package com.thoughtworks.challenge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.challenge.service.InputOutputStrService;

/**
 * 
 * @author Kuldeep Jha
 *
 */
@RestController
@RequestMapping("/challenge")
public class ThoughtworksController {

	private static final Logger log = LoggerFactory.getLogger(ThoughtworksController.class);

	@Autowired
	InputOutputStrService inputOutputStrService;

	/**
	 * 
	 * @return
	 */
	@GetMapping("/charCount")
	public ResponseEntity<String> InputOutputCharCount() {

		log.info("controller: return  the count of char to the string");
		return inputOutputStrService.charCount();
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/wordCount")
	public ResponseEntity<String> InputOutputWordCount() {

		log.info("controller: return  the count of word to the string");
		return inputOutputStrService.wordCount();
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/sentenceCount")
	public ResponseEntity<String> InputOutputSentenceCount() {

		log.info("controller: return  the count of sentence to the string");
		return inputOutputStrService.sentencesCount();
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/vowelsCount")
	public ResponseEntity<String> InputOutputvowelsCount() {

		log.info("controller: return  the count of vowels to the string");
		return inputOutputStrService.vowelsCount();
	}

}
