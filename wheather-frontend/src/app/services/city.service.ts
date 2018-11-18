import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LOCALHOST } from './consts.api';

@Injectable({
  providedIn: 'root'
})
export class CityService {

  constructor(private http: HttpClient) { }

  findAllCities(city: any) {
    return this.http.post(`${LOCALHOST}/api/city/search`, city);
  }

  findMyCities(city: any) {
    return this.http.post(`${LOCALHOST}/api/city/my/search`, city);
  }

  saveCity(city: any) {
    return this.http.post(`${LOCALHOST}/api/city/create`, city);
  }

  getForecastDetail(cityId: any) {
    return this.http.get(`${LOCALHOST}/api/forecast/detail/`+ cityId);
  }



}
