package com.philvigus.brewery.services;

import com.philvigus.brewery.web.models.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
  @Override
  public BeerDto getBeerById(UUID beerId) {
    log.debug("Getting beer by id - " + beerId);
    return BeerDto.builder().id(UUID.randomUUID()).name("Boors").style("Pale Ale").build();
  }

  @Override
  public BeerDto saveBeer(BeerDto beerDto) {
    log.debug("Saving beer by id");

    return BeerDto.builder().id(UUID.randomUUID()).build();
  }

  @Override
  public void updateBeer(UUID beerId, BeerDto beerDto) {
    // TODO: add a real implementation to update beer
    log.debug("Updating beer with id - " + beerId);
  }

  @Override
  public void deleteById(UUID beerId) {
    log.debug("Deleting beer by id - " + beerId);
  }
}
