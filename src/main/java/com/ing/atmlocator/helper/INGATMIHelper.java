package com.ing.atmlocator.helper;

import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.atmlocator.model.ATM;

@Component
public class INGATMIHelper {

	public static String ATM_LOCATE_API_URI = "https://www.ing.nl/api/locator/atms/";

	public ATM[] getATMLOcatiom() {

		String res1 = null;

		System.out.println("Calling the ATM Location API " + ATM_LOCATE_API_URI);
		try {
			// res = new RestTemplate().getForObject(ATM_LOCATE_API_URI,
			// ATM[].class);
			res1 = new RestTemplate().getForObject(ATM_LOCATE_API_URI, String.class);
		} catch (Exception ex) {
			System.out.println("Error calling the ATM Location API - " + ATM_LOCATE_API_URI);
			ex.printStackTrace();
		}
		return formatRes(res1);

	}
/**
 * Temp method to remove invalid char from response
 * @param res
 * @return
 */
	private ATM[] formatRes(String res) {
		ATM[] response = null;
		ObjectMapper mapper = new ObjectMapper();
		// Need to remove )]}', 
		StringBuilder sb = new StringBuilder(res);

		sb.delete(res.indexOf(")"), " )]}',".length());
		
		try {
			response = mapper.readValue(sb.toString(), ATM[].class);
		} catch (IOException e) {
			System.out.println("<<<< invalid data from web service >>>");
			e.printStackTrace();
		}
		return response;
	}
}
