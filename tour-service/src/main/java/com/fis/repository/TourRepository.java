package com.fis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fis.entity.TourPackage;

public interface TourRepository extends JpaRepository<TourPackage, String> {

	public List<TourPackage> findAllBySourcePlaceAndDestinationPlace(String source, String destination);
	public TourPackage findBySourcePlaceAndDestinationPlace(String source, String destination);

}
