package com.fis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fis.entity.TotalCostResponseDto;
import com.fis.entity.TourPackage;
import com.fis.exception.TourPackageException;
import com.fis.repository.TourRepository;
import com.fis.util.AppConstant;

@Component
public class TourService {

	@Autowired
	TourRepository repository;

	public TourPackage create(TourPackage tourPackage) {
		return repository.save(tourPackage);
	}

	public TourPackage get(String packageId) {
		return repository.findById(packageId)
				.orElseThrow(() -> new TourPackageException("Invalid package Id: " + packageId));
	}

	public List<TourPackage> getAll() {
		return repository.findAll();
	}

	public TotalCostResponseDto getTotalPackageCost(String packageId, int numberOfDays) {

		TourPackage tourPackage = get(packageId);
		return getTotalCostForTourPackage(numberOfDays, tourPackage);
	}

	private TotalCostResponseDto getTotalCostForTourPackage(int numberOfDays, TourPackage tourPackage) {

		TotalCostResponseDto totalCostResponseDto = new TotalCostResponseDto();
		totalCostResponseDto.setSource(tourPackage.getSourcePlace());
		totalCostResponseDto.setDestination(tourPackage.getDestinationPlace());

		int discount = getDiscount(numberOfDays);

		double packageCost = (tourPackage.getBasicFare() * numberOfDays);
		double discountedPackageCost = packageCost - (packageCost * discount / 100);
		double totalPackCost = discountedPackageCost + (discountedPackageCost * AppConstant.GST / 100);

		totalCostResponseDto.setTotalCost(totalPackCost);
		return totalCostResponseDto;
	}

	private int getDiscount(int numberOfDays) {

		int discount = 0;
		if (numberOfDays > 5 && numberOfDays <= 8) {
			discount = 3;
		} else if (numberOfDays > 8 && numberOfDays <= 10) {
			discount = 5;
		} else if (numberOfDays > 10) {
			discount = 7;
		}
		return discount;
	}

	public List<TourPackage> getAllBySourceAndDestination(String source, String destination) {

		List<TourPackage> tourPackages = repository.findAllBySourcePlaceAndDestinationPlace(source, destination);
		if (tourPackages.isEmpty()) {
			throw new TourPackageException("No tours available for this filter");
		}
		return tourPackages;

	}

	public TourPackage update(String packId, TourPackage tourPackage) {

		get(packId);
		return repository.save(tourPackage);
	}

	public void delete(String packId) {

		get(packId);
		repository.deleteById(packId);
	}

	public TotalCostResponseDto getTotalPackageCostByFilter(String source, String destination, int numDays) {

		// taking the first one
		TourPackage tourPackage = getAllBySourceAndDestination(source, destination).get(0);
		return getTotalCostForTourPackage(numDays, tourPackage);
	}

}
