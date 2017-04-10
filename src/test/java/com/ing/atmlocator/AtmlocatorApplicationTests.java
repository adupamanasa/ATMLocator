package com.ing.atmlocator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.ing.atmlocator.model.*;

import com.ing.atmlocator.controller.ATMLocatorController;
import com.ing.atmlocator.helper.INGATMIHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AtmlocatorApplicationTests {

	 @Autowired
	 ATMLocatorController atmLocatorController;
	
	@Autowired
	INGATMIHelper INGATMIHelper;
	
	@Test
	public void getATMLocations() {
		//Testing the web  
		 assertNotNull(atmLocatorController.getAllATM());
		 //testing the api
		 assertNotNull(atmLocatorController.getATMAPI());
		 
	}
	
	 @Test
	public void testWebService(){
		
		
		 ATM[] respArr = INGATMIHelper.getATMLOcatiom();
		 
		 assertNotNull(respArr);
	}
	
    @Test
	public void testPojo(){

    		List<ATM> ls = new ArrayList<ATM>() ;
    		
    		ATM sampleObj = new ATM();
    		sampleObj.setDistance(0);
    		sampleObj.setType("ING");
    		
    		Address address = new Address();
    		address.setCity("Hoogezand");
    		address.setHousenumber("6");
    		address.setPostalcode("9603 AA");
    		address.setStreet("Gorecht-Oost");
    		
    		GeoLocation geoLocation = new GeoLocation();
    		geoLocation.setLat(53.156587);
    		geoLocation.setLng(6.756809);
    		
    		address.setGeoLocation(geoLocation);
    		
    		sampleObj.setAddress(address);
    		
    		ls.add(ATM.builder().address(Address.builder().street("Gorecht-Oost").housenumber("6").postalcode("9603 AA").city("Hoogezand").geoLocation(GeoLocation.builder().lat(53.156587).lng(6.756809).build()).build()).distance(0).type("ING").build());
    		ls.add(ATM.builder().address(Address.builder().street("Prins Bernhardstraat").housenumber("9").postalcode("2396 GA").city("Koudekerk aan den Rijn").geoLocation(GeoLocation.builder().lat(52.133101).lng(4.600767).build()).build()).distance(0).type("ING").build());
    		ls.add(ATM.builder().address(Address.builder().street("Markstraat").housenumber("2-4").postalcode("8141 GC").city("Heino").geoLocation(GeoLocation.builder().lat(52.435637).lng(6.234669).build()).build()).distance(0).type("ING").build());
    		ls.add(ATM.builder().address(Address.builder().street("Emiclaerhof").housenumber("142").postalcode("3823 ER").city("Amersfoort").geoLocation(GeoLocation.builder().lat(52.186678).lng(5.396443).build()).build()).distance(0).type("ING").build());
    		
    		assertNotNull(ls);
    
    		assertEquals(ls.size(), 4);
    		
    		assertEquals(sampleObj, ls.get(0));
    		
		
	}
	
}
