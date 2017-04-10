package com.ing.atmlocator.controller;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.Arrays;
import com.ing.atmlocator.helper.INGATMIHelper;
@RestController
public class ATMLocatorController {
	@Autowired
	CamelContext camelContext;
	
	@Autowired
	INGATMIHelper INGATMIHelper;
	
	/**
	 * Used in home.html for display 
	 * @return
	 */
	@RequestMapping("/ViewAllATM")
	public ModelAndView getAllATM(){
		return new ModelAndView("home","atmLst",Arrays.asList( INGATMIHelper.getATMLOcatiom()));
	}
	/**
	 * 
	 * @return well formed JSON response with all ATM information
	 */
	
	@RequestMapping("/api/ViewAllATM")
	public @ResponseBody String getATMAPI(){
		return Arrays.asList( INGATMIHelper.getATMLOcatiom()).toString();
	}
	
}
