import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { map } from 'rxjs/operators';
import { LOCALHOST } from './consts.api';


@Injectable({
  providedIn: 'root'
})

export class CityService {

  constructor(private http: Http) {
  }

  getCities(){
    return this.http.get('assets/data/city-list.json').pipe(map((res: Response) => res.json()));
  }
  
  findAllCities(city: any) {
    return this.http.post(`${LOCALHOST}/api/city/search`, city).pipe(map((res: Response) => res.json()));
  }

  findMyCities(city: any) {
    return this.http.post(`${LOCALHOST}/api/city/my/search`, city).pipe(map((res: Response) => res.json()));
  }

  saveCity(city: any) {
    return this.http.post(`${LOCALHOST}/api/city/create`, city).pipe(map((res: Response) => res.json()));
  }

  getForecastDetail(cityId: any) {
    return this.http.get(`${LOCALHOST}/api/forecast/detail/`+ cityId).pipe(map((res: Response) => res.json()));
  }

}
