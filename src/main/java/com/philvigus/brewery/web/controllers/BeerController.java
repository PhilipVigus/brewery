package com.philvigus.brewery.web.controllers;

import com.philvigus.brewery.services.BeerService;
import com.philvigus.brewery.web.models.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
  private final BeerService beerService;

  public BeerController(BeerService beerService) {
    this.beerService = beerService;
  }

  @GetMapping("/{beerId}")
  public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
    return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Void> handlePost(BeerDto beerDto) {
    BeerDto savedDto = beerService.saveBeer(beerDto);

    HttpHeaders headers = new HttpHeaders();

    // TODO: add hostname url
    headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());

    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }
}
