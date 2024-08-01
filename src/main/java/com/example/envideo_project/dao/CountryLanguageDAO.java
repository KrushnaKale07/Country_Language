package com.example.envideo_project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CountryLanguageDAO {

	@Select("Select countrycode from countrylanguage where language = #{language} order by Percentage desc")
	@Results({ @Result(property = "countrycode", column = "countrycode") })
	List<String> getbylanguege(String language);

	@Select("Select language from countrylanguage where countrycode = #{countrycode} and isOfficial = 'T' order by Percentage desc")
	@Results({ @Result(property = "language", column = "language") })
	List<String> getofficiallanguagebycountrycode(String language);

	@Select("Select language from countrylanguage where countrycode = #{countrycode} and isOfficial = 'T' order by Percentage desc limit 1 offset 0")
	@Results({ @Result(property = "language", column = "language") })
	String getofficiallanguageByOrder(String countrycode);

}
