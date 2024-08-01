package com.example.envideo_project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.envideo_project.service.CountryLanguageService;

@RestController
public class CountryLanguageController {

	Logger log = LoggerFactory.getLogger(CountryLanguageController.class);

	@Autowired
	CountryLanguageService countryLanguageService;

	@GetMapping("/api/getbylanguege/{language}")
	public ResponseEntity<?> getbylanguege(@PathVariable("language") String language) {
		
		log.info("CountryLanguageController :: getbylanguege() started");
		
		try {
			List<String> countryCodes = countryLanguageService.getbylanguege(language);
			if (countryCodes.size() != 0) {
				log.info("CountryLanguageController :: getbylanguege() ended");
				return new ResponseEntity<>(countryCodes, HttpStatus.OK);
			} else {
				log.info("CountryLanguageController :: getbylanguege() ended");
				return new ResponseEntity<>("Invalid language", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("CountryLanguageController :: getbylanguege() error" + e);
		}
		return new ResponseEntity<>("Invalid language", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/api/getofficiallanguagebycountrycode/{countrycode}")
	public ResponseEntity<?> getofficiallanguagebycountrycode(@PathVariable("countrycode") String countrycode) {

		log.info("CountryLanguageController :: getofficiallanguagebycountrycode() started");
		try {
			List<String> language = countryLanguageService.getofficiallanguagebycountrycode(countrycode);
			if (language != null) {
				log.info("CountryLanguageController :: getofficiallanguagebycountrycode() ended");
				return new ResponseEntity<>(language, HttpStatus.OK);
			} else {
				log.info("CountryLanguageController :: getbylanguege() ended");
				return new ResponseEntity<>("Invalid country code", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>("Invalid country code", HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/api/getofficiallanguagebyorder/{countrycode}")
	public ResponseEntity<String> getofficiallanguageByOrder(@PathVariable("countrycode") String countrycode ) {

		log.info("CountryLanguageController :: getofficiallanguageByOrder() started");
		try {
			String language = countryLanguageService.getofficiallanguageByOrder(countrycode);
			if (language != null) {
				log.info("CountryLanguageController :: getofficiallanguageByOrder() ended");
				return new ResponseEntity<>(language, HttpStatus.OK);
			} else {
				log.info("CountryLanguageController :: getofficiallanguageByOrder() ended");
				return new ResponseEntity<>("Invalid country code", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>("Invalid country code", HttpStatus.BAD_REQUEST);

	}
	
}
