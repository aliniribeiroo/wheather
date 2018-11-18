

import { CityService } from './../services/city.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { City } from './city.model';
import { ResponseApi } from '../model/response-api.model';
import { NgForm } from '@angular/forms';

export class GetCityInput {
  q: string;
  page: number;
  size: number;
}

@Component({
  selector: 'app-city-list',
  templateUrl: './city-list.component.html',
  styleUrls: ['./city-list.component.css'],

})

export class CityListComponent implements OnInit {
  
  public listCities: City[];
  public selectedCity = new City(null, null);
  public cityInput= new GetCityInput(); 

  constructor(private cityService: CityService) { }

  ngOnInit() {
    this.cityInput.q= "";
    this.cityInput.page= 1;
    this.cityInput.size= 1000;
    this.findCities();
  }

  findCities(){
    this.cityService.findAllCities(this.cityInput).subscribe((responseApi: ResponseApi) => {
      this.listCities = responseApi.data;
    }, err => {

    });
  }
}
