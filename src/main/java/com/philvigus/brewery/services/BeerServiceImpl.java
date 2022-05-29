package com.philvigus.brewery.services;

import com.philvigus.brewery.web.models.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
  @Override
  public BeerDto getBeerById(UUID beerId) {
    return BeerDto.builder().id(UUID.randomUUID()).name("Boors").style("Pale Ale").build();
  }

  @Override
  public BeerDto saveBeer(BeerDto beerDto) {
    return BeerDto.builder().id(UUID.randomUUID()).build();
  }

  @Override
  public void updateBeer(UUID beerId, BeerDto beerDto) {
    // TODO: add a real implementation to update beer
  }
}
