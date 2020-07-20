package com.thoughtworks.challenge.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.thoughtworks.challenge.model.InModel;
import com.thoughtworks.challenge.model.OutModel;
import com.thoughtworks.challenge.model.SentencesCountModel;
import com.thoughtworks.challenge.model.VowelCountModel;
import com.thoughtworks.challenge.model.WordCountModel;
import com.thoughtworks.challenge.service.InputOutputStrService;

/**
 * 
 * @author Kuldeep Jha
 *
 */
@Service
public class InputOutputStrServiceImpl implements InputOutputStrService {

	private static final Logger log = LoggerFactory.getLogger(InputOutputStrServiceImpl.class);

	@Value("${servet.input.url}")
	String inputUrl;

	@Value("${servet.onput.url}")
	String outputUrl;

	@Value("${servet.user.id}")
	String userId;

	/**
	 * get input using rest api call and count the char of given string
	 * 
	 * @return: ResponseEntity<String>
	 */
	@Override
	public ResponseEntity<String> charCount() {

		log.info("get input using rest api call and count the char of given string");
		return restOutputApiCharCount(userId, restInputApiConnection());
	}

	/**
	 * get input using rest api call and count the word of given string
	 * 
	 * @return: ResponseEntity<String>
	 */
	@Override
	public ResponseEntity<String> wordCount() {

		log.info("get input using rest api call and count the word of given string");
		return restOutputApiWordCount(wordCount(restInputApiConnection()));
	}

	/**
	 * get input using rest api call and count the sentences of given string
	 * 
	 * @return: ResponseEntity<String>
	 */
	@Override
	public ResponseEntity<String> sentencesCount() {

		log.info("get input using rest api call and count the sentences of given string");
		return restApiSentenceCount(sentenceCount(restInputApiConnection()));
	}
	
	/**
	 * get input using rest api call and count the vowels of given string
	 * 
	 * @return: ResponseEntity<String>
	 */
	@Override
	public ResponseEntity<String> vowelsCount() {

		log.info("get input using rest api call and count the vowels of given string");
		return restApivowelCount(vowelsCount(restInputApiConnection()));
	}

	/**
	 * 
	 * @return
	 */
	private String restInputApiConnection() {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("userid", userId);
		headers.add("content-type", MediaType.APPLICATION_JSON_VALUE);
		InModel inModel = new InModel();
		HttpEntity<InModel> requestEntity = new HttpEntity<>(inModel, headers);
		ResponseEntity<InModel> result = restTemplate.exchange(inputUrl, HttpMethod.GET, requestEntity, InModel.class);
		return result.getBody().getText();
	}

	/**
	 * 
	 * @param userId
	 * @param text
	 * @return
	 */
	private ResponseEntity<String> restOutputApiCharCount(String userId, String text) {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("userid", userId);
		headers.add("content-type", MediaType.APPLICATION_JSON_VALUE);
		OutModel outModel = new OutModel();
		outModel.setCount(text.length());
		HttpEntity<OutModel> requestEntity = new HttpEntity<>(outModel, headers);
		return restTemplate.exchange(outputUrl, HttpMethod.POST, requestEntity, String.class);
	}

	/**
	 * 
	 * @param text
	 * @return
	 */
	private int wordCount(String text) {

		int count = 0;
		char ch[] = new char[text.length()];
		for (int i = 0; i < text.length(); i++) {
			ch[i] = text.charAt(i);
			if (((i > 0) && (ch[i] != ' ') && (ch[i - 1] == ' ')) || ((ch[0] != ' ') && (i == 0)))
				count++;
		}
		return count;
	}

	/**
	 * 
	 * @param count
	 * @return
	 */
	private ResponseEntity<String> restOutputApiWordCount(int count) {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("userid", userId);
		headers.add("content-type", MediaType.APPLICATION_JSON_VALUE);
		WordCountModel outModel = new WordCountModel();
		outModel.setWordCount(count);
		HttpEntity<WordCountModel> requestEntity = new HttpEntity<>(outModel, headers);
		return restTemplate.exchange(outputUrl, HttpMethod.POST, requestEntity, String.class);
	}

	/**
	 * 
	 * @param text
	 * @return
	 */
	private int sentenceCount(String text) {

		String[] sentenceList = text.split("[?.]+");
		return sentenceList.length;
	}

	/**
	 * 
	 * @param count
	 * @return
	 */
	private ResponseEntity<String> restApiSentenceCount(int count) {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("userid", userId);
		headers.add("content-type", MediaType.APPLICATION_JSON_VALUE);
		SentencesCountModel sentencesCountModel = new SentencesCountModel();
		sentencesCountModel.setSentenceCount(count);
		HttpEntity<SentencesCountModel> requestEntity = new HttpEntity<>(sentencesCountModel, headers);
		return restTemplate.exchange(outputUrl, HttpMethod.POST, requestEntity, String.class);
	}

	/**
	 * 
	 * @param text
	 * @return
	 */
	private VowelCountModel vowelsCount(String text) {

		VowelCountModel vowelCountModel = new VowelCountModel();
		char ch;
		for (int i = 0; i < text.length(); i++) {
			ch = text.charAt(i);
			ch = Character.toUpperCase(ch);
			if (ch == 'A')
				vowelCountModel.setA(vowelCountModel.getA() + 1);
			else if (ch == 'E') {
				vowelCountModel.setE(vowelCountModel.getE() + 1);
			} else if (ch == 'I') {
				vowelCountModel.setI(vowelCountModel.getI() + 1);
			} else if (ch == 'O') {
				vowelCountModel.setO(vowelCountModel.getO() + 1);
			} else if (ch == 'U') {
				vowelCountModel.setU(vowelCountModel.getU() + 1);
			} else {
				continue;
			}
		}
		return vowelCountModel;
	}
	
	/**
	 * 
	 * @param vowelCountModel
	 * @return
	 */
	private ResponseEntity<String> restApivowelCount(VowelCountModel vowelCountModel) {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("userid", userId);
		headers.add("content-type", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<VowelCountModel> requestEntity = new HttpEntity<>(vowelCountModel, headers);
		return restTemplate.exchange(outputUrl, HttpMethod.POST, requestEntity, String.class);
	}

}
