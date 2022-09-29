package com.fis.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fis.entity.TotalCostResponseDto;
import com.fis.entity.TourPackage;
import com.fis.service.TourService;

@RestController
public class TourController {

	@Autowired
	TourService service;

	@GetMapping("/tourPackage/{packId}")
	public ResponseEntity<TourPackage> get(@PathVariable String packId) {
		return new ResponseEntity<>(service.get(packId), HttpStatus.OK);
	}

	@GetMapping("/tourPackage/source/{source}/destination/{destination}")
	public ResponseEntity<List<TourPackage>> getTourPackagesByFilter(@PathVariable("source") String source,
			@PathVariable("destination") String destination) {
		return new ResponseEntity<>(service.getAllBySourceAndDestination(source, destination), HttpStatus.OK);
	}

	@GetMapping("/tourPackage/{packId}/cost/{numOfDays}")
	public ResponseEntity<TotalCostResponseDto> getTotalCostForNumDays(@PathVariable("packId") String packId,
			@PathVariable("numOfDays") int numOfDays) {
		return new ResponseEntity<>(service.getTotalPackageCost(packId, numOfDays), HttpStatus.OK);
	}

	@GetMapping("/tourPackage/source/{source}/destination/{destination}/cost/{numOfDays}")
	public ResponseEntity<TotalCostResponseDto> getTotalCostForFilter(@PathVariable("source") String source,
			@PathVariable("destination") String destination, @PathVariable("numOfDays") int numDays) {
		return new ResponseEntity<>(service.getTotalPackageCostByFilter(source, destination, numDays), HttpStatus.OK);
	}

	@GetMapping("/tourPackage")
	public ResponseEntity<List<TourPackage>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

	@PostMapping("/tourPackage")
	public ResponseEntity<TourPackage> create(@RequestBody @Valid TourPackage tourPackage) {
		return new ResponseEntity<>(service.create(tourPackage), HttpStatus.CREATED);
	}

	@PutMapping("/tourPackage/{packId}")
	public ResponseEntity<TourPackage> update(@PathVariable("packId") String packId,
			@RequestBody @Valid TourPackage tourPackage) {
		return new ResponseEntity<>(service.update(packId, tourPackage), HttpStatus.CREATED);
	}

	@DeleteMapping("/tourPackage/{packId}")
	public ResponseEntity<String> delete(@PathVariable("packId") String packId) {
		service.delete(packId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
