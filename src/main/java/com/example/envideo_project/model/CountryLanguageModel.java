package com.example.envideo_project.model;

public class CountryLanguageModel {

	private String countrycode;
	private String language;
	private String isofficial;
	private Float Percentage;

	public CountryLanguageModel() {
		super();
	}

	public CountryLanguageModel(String countrycode, String language, String isofficial, Float Percentage) {
		super();
		this.countrycode = countrycode;
		this.language = language;
		this.isofficial = isofficial;
		this.Percentage = Percentage;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countryCode) {
		this.countrycode = countryCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getIsofficial() {
		return isofficial;
	}

	public void setIsofficial(String isOfficial) {
		this.isofficial = isOfficial;
	}

	public Float getPercentage() {
		return Percentage;
	}

	public void setPercentage(Float percentage) {
		this.Percentage = percentage;
	}
}
