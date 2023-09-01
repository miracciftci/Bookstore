package com.shop.bookstore.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ModelMapperManager implements ModelMapperService{
	private ModelMapper modelMapper;

	@Override
	public ModelMapper forResponse() {
		this.modelMapper.getConfiguration().
		setAmbiguityIgnored(true).
		setMatchingStrategy(MatchingStrategies.LOOSE);
		// MatchingStrategies.LOOSE gevşek mapleme demek yani responslarda databasedeki  her tum ozellikleri almazsak hata dondurmez ama standart maplamede hata dondurur
		return this.modelMapper;
	}

	@Override
	public ModelMapper forRequest() {
		this.modelMapper.getConfiguration().
		setAmbiguityIgnored(true).
		setMatchingStrategy(MatchingStrategies.STANDARD);
		return this.modelMapper;
	}

}
