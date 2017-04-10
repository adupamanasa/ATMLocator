package com.ing.atmlocator.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JaxbDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.ing.atmlocator.model.ATM;

@Component
public class ATMRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		JaxbDataFormat jaxb = new JaxbDataFormat(false);
		jaxb.setContextPath("com.ing.atmlocator.model");

/*		restConfiguration()
        .contextPath("/camel-rest").apiContextPath("/api-doc")
            .apiProperty("api.title", "Camel REST API")
            .apiProperty("api.version", "1.0")
            .apiProperty("cors", "true")
            .apiContextRouteId("doc-api")
        .bindingMode(RestBindingMode.json);

       rest("/atms").description("ATM REST service")
        .get("/").description("The list of all the atms")
            .route().routeId("atm-api")
            .bean(ATM.class, "findATM")
            .endRest();*/

		
//		from("timer:foo").marshal(jaxb).to("spring-ws:https://www.ing.nl/api/locator/atms/").unmarshal(jaxb);
//		from("timer:foo").to("spring-ws:https://www.ing.nl/api/locator/atms/");
//		from("spring-ws:rootqname:{https://www.ing.nl/api/locator/atms/}")
		
		
		// Access us using http://localhost:8080/camel/hello
		 from("servlet:///hello").transform().constant("Hello from Camel!");
		 
		// Access us using http://localhost:8080/camel/atm
//		 from("servlet:///atm").marshal(jaxb).to("http://www.ing.nl/api/locator/atms/").unmarshal(jaxb);
		 
		 // Trigger run right after startup. No Servlet request required.
//		 from("timer://foo?fixedRate=true&period=50s").log("Camel timer triggered.");
	}

}
