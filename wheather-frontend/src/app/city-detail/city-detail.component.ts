import { CityForecast } from './../shared/models/city-forecast.model';
import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Router, ActivatedRoute } from '@angular/router';
import { CityService } from '../shared/services/city.service';

@Component({
  selector: 'app-city-detail',
  templateUrl: './city-detail.component.html',
  styleUrls: ['./city-detail.component.css']
})
export class CityDetailComponent implements OnInit {

  cityForecasts: CityForecast[];
  cityName: String;
  constructor( private router: Router,
    private route: ActivatedRoute,
    private cityService: CityService) { }
  inscricao: Subscription;

  ngOnInit() {
    this.inscricao = this.route.params.subscribe(
      (params: any) => {
        let id = params['id'];
        if (id != undefined) {
          this.findCityForecast(id);
        }
      }
    );
  }

  findCityForecast(id: string){
    this.cityService.getForecastDetail(id).subscribe(forecasts => {
      this.cityForecasts = forecasts.data;
      this.cityName = this.cityForecasts[0].cityName;
    })
  }

  back(){
    this.router.navigate(['']);
  }
}
