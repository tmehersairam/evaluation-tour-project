package com.fis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fis.entity.TotalCostResponseDto;
import com.fis.entity.TourPackageDto;
import com.fis.service.TourUserService;

@RestController
public class TourUserController {

	@Autowired
	TourUserService tourUserService;

	@GetMapping("/tourPackage")
	public ResponseEntity<List<TourPackageDto>> getAllTourPackages() {

		return new ResponseEntity<>(tourUserService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/tourPackage/{tourId}")
	public ResponseEntity<TourPackageDto> getByTourId(@PathVariable("tourId") String tourId) {

		return new ResponseEntity<>(tourUserService.get(tourId), HttpStatus.OK);
	}

	@GetMapping("/tourPackage/source/{source}/destination/{destination}")
	public ResponseEntity<List<TourPackageDto>> getToursBySourceAndDestination(@PathVariable("source") String source,
			@PathVariable("destination") String destination) {

		return new ResponseEntity<>(tourUserService.getAllByFilter(source, destination), HttpStatus.OK);
	}

	@GetMapping("/tourPackage/source/{source}/destination/{destination}/cost/{numDays}")
	public ResponseEntity<TotalCostResponseDto> getCostBySourceAndDestination(@PathVariable("source") String source,
			@PathVariable("destination") String destination, @PathVariable("numDays") int numDays) {

		return new ResponseEntity<>(tourUserService.getCostBySourceAndDestination(source, destination, numDays),
				HttpStatus.OK);
	}

	@GetMapping("/tourPackage/{packId}/cost/{numDays}")
	public ResponseEntity<TotalCostResponseDto> getCostByTourPackageId(@PathVariable("packId") String source,
			@PathVariable("numDays") int numDays) {

		return new ResponseEntity<>(tourUserService.getCostByTourId(source, numDays), HttpStatus.OK);
	}
}
