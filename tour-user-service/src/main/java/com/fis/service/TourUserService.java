package com.fis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fis.entity.TotalCostResponseDto;
import com.fis.entity.TourPackageDto;

@Component
public class TourUserService {

	@Autowired
	RestTemplate restTemplate;

	private static final String SERVICE_NAME = "tour-service";
	private static final String SERVICE_URL = "http://" + SERVICE_NAME;

	public List<TourPackageDto> getAll() {
		List<TourPackageDto> packageDtos = restTemplate.getForObject(SERVICE_URL + "/tourPackage", List.class);
		return packageDtos;
	}

	public TourPackageDto get(String tourId) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("packId", tourId);

		TourPackageDto tourPackageDto = restTemplate.getForObject(SERVICE_URL + "/tourPackage/{packId}",
				TourPackageDto.class, map);
		return tourPackageDto;

	}

	public List<TourPackageDto> getAllByFilter(String source, String destination) {
		Map<String, Object> map = new HashMap<>();
		map.put("source", source);
		map.put("destination", destination);
		List<TourPackageDto> packageDtos = restTemplate
				.getForObject(SERVICE_URL + "/tourPackage/source/{source}/destination/{destination}", List.class, map);
		return packageDtos;
	}

	public TotalCostResponseDto getCostBySourceAndDestination(String source, String destination, int numDays) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("source", source);
		map.put("destination", destination);
		map.put("numDays", numDays);
		TotalCostResponseDto totalCostResponseDto = restTemplate.getForObject(
				SERVICE_URL + "/tourPackage/source/{source}/destination/{destination}/cost/{numDays}",
				TotalCostResponseDto.class, map);
		return totalCostResponseDto;
	}

	public TotalCostResponseDto getCostByTourId(String tourPackageId, int numDays) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("packId", tourPackageId);
		map.put("numDays", numDays);

		TotalCostResponseDto totalCostResponseDto = restTemplate
				.getForObject(SERVICE_URL + "/tourPackage/{packId}/cost/{numDays}", TotalCostResponseDto.class, map);
		return totalCostResponseDto;
	}
}
