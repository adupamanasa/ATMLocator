package com.ing.atmlocator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ing.atmlocator.model.Address.AddressBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoLocation {

	private double lat;
	private double lng;
}
