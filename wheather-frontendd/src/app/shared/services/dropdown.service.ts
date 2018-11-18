import { LOCALHOST } from './consts.api';

import {Http, Response} from '@angular/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { restoreBindingIndex } from '@angular/core/src/render3/instructions';

@Injectable({
  providedIn: 'root'
})

export class DropdownService {

  constructor(private http: Http) {
  }

  getCities(){
    return this.http.get('assets/data/city-list.json').pipe(map((res: Response) => res.json()));
  }
  
  findMyCities(city: any) {
    return this.http.post(`${LOCALHOST}/api/city/my/search`, city).pipe(map((res: Response) => res.json()));
  }

  saveCity(city: any) {
    return this.http.post(`${LOCALHOST}/api/city/create`, city);
  }

  getForecastDetail(cityId: any) {
    return this.http.get(`${LOCALHOST}/api/forecast/detail/`+ cityId);
  }

}
