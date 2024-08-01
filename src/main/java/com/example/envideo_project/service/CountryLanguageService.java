package com.example.envideo_project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.envideo_project.dao.CountryLanguageDAO;

@Service
public class CountryLanguageService {

	Logger log = LoggerFactory.getLogger(CountryLanguageService.class);

	@Autowired
	CountryLanguageDAO countryLanguageDAO;

	public List<String> getbylanguege(String language) {
		log.info("CountryLanguageService :: getbylanguege() started");
		List<String> countryCodes = countryLanguageDAO.getbylanguege(language);

		log.info("CountryLanguageService :: getbylanguege() ended");
		return countryCodes;

	}

	public List<String> getofficiallanguagebycountrycode(String countrycode) {
		try {
			log.info("CountryLanguageService :: getofficiallanguagebycountrycode() started");
			List<String> languages = countryLanguageDAO.getofficiallanguagebycountrycode(countrycode);
			return  languages;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return countryLanguageDAO.getofficiallanguagebycountrycode(countrycode);
	}

	public String getofficiallanguageByOrder(String countrycode) {
		try {
			log.info("CountryLanguageService :: getofficiallanguageByOrder() started");
			
			return  countryLanguageDAO.getofficiallanguageByOrder(countrycode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return countryLanguageDAO.getofficiallanguageByOrder(countrycode);
	}

}
