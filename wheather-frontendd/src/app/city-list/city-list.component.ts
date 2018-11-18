import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Http } from '@angular/http';
import { Observable } from 'rxjs';
import { DropdownService } from '../shared/services/dropdown.service';
import { City } from './../shared/models/city.model';
import { cityDTO } from './../shared/models/cityDTO.model';
import { map } from 'rxjs/operators';
import { MyCity } from '../shared/models/myCity.model';

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

  cities: Observable<City[]>;
  listUser = [];
  selectedCity: City = null;
  public cityInput= new GetCityInput(); 
  myCities: MyCity[];

  tableData1: TableData;
  headerConfig = [{title: 'Cidade', attribute: "name"}, 
  {title: 'País', attribute: "country"}]

  constructor(private http: Http,
    private dropdownService: DropdownService) { }

  ngOnInit() {
    this.cities = this.dropdownService.getCities();
    this.cityInput.q= "";
    this.cityInput.page= 1;
    this.cityInput.size= 1000; 
    this.getTableOfUsers();
  }

  saveCity() {
    console.log("city" + this.selectedCity.name + " was saved by Alini!");
    let city = new cityDTO(this.selectedCity.id, this.selectedCity.name, this.selectedCity.country);
    this.dropdownService.saveCity(city).subscribe(res => {
      window.location.reload();
    });
  }

  getTableOfUsers() {
    this.dropdownService.findMyCities(this.cityInput).subscribe(cities => {
      this.myCities = cities;
    });
  }

}
