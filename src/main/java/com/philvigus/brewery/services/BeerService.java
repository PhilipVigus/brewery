package com.philvigus.brewery.services;

import com.philvigus.brewery.web.models.BeerDto;

import java.util.UUID;

public interface BeerService {
  BeerDto getBeerById(UUID beerId);

  BeerDto saveBeer(BeerDto beerDto);

  void updateBeer(UUID beerId, BeerDto beerDto);
}
