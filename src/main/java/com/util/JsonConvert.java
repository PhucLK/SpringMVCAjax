package com.util;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.model.Content;

/**
 * @author PhucTV7
 *
 */
public class JsonConvert {

	/**
	 * @param c
	 * @return string json
	 * @throws JsonProcessingException
	 */
	public static String convertToJson(List<Content> c) throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		// Serialize Object to JSON.
		return mapper.writeValueAsString(c);
	}
}
