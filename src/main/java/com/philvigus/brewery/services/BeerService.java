package com.philvigus.brewery.services;

import com.philvigus.brewery.web.models.BeerDto;

import java.util.UUID;

public interface BeerService {
  BeerDto getBeerById(UUID beerId);
}
