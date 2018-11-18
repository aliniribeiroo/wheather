import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Http } from '@angular/http';
import { Router } from '@angular/router';
import { MyCity } from '../shared/models/myCity.model';
import { City } from './../shared/models/city.model';
import { cityDTO } from './../shared/models/cityDTO.model';
import { CityService } from './../shared/services/city.service';

export class GetCityInput {
  q: string;
  page: number;
  size: number;
}

declare interface Table {
  type: string;
  name: string;
}

declare interface TableData {
  headerRow: string[];
  dataRows: string[][];
}

@Component({
  selector: 'app-city-list',
  templateUrl: './city-list.component.html',
  styleUrls: ['./city-list.component.css']
})
export class CityListComponent implements OnInit {

  @ViewChild("form")
  form: NgForm;

  cities: City[];
  selectedCity: City;
  public cityInput= new GetCityInput(); 
  myCities: MyCity[];

  tableData1: TableData;
  headerConfig = [{title: 'Cidade', attribute: "name"}, 
  {title: 'País', attribute: "country"}]

  constructor(private http: Http,
    private cityService: CityService,
    private router: Router) { }

  ngOnInit() {
    this.cityInput.q= "";
    this.cityInput.page= 1;
    this.cityInput.size= 1000; 
    this.getCities();
    this.getMyCities();
  }

  saveCity() {
    console.log("city" + this.selectedCity.name + " was saved by Alini!");
    if(this.selectedCity.cityId != null){
      let city = new cityDTO(this.selectedCity.cityId, this.selectedCity.name, this.selectedCity.country);
      this.cityService.saveCity(city).subscribe(city => {
        this.getMyCities();
        this.selectedCity = null;
      });
    }
  }

  getMyCities() {
    this.cityService.findMyCities(this.cityInput).subscribe(cities => {
      this.myCities = cities.data;
    });
  }

  getCities() {
    this.cityService.findAllCities(this.cityInput).subscribe(cities => {
      this.cities = cities.data;
    });
  }

  clear(){
    this.selectedCity = null;
  }

  detailCity(id : string){
    this.router.navigate(['/cityDetail', id]);
  }
}
