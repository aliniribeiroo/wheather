import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { SelectModule } from '../../node_modules/ng-select';

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CityListComponent } from './city-list/city-list.component';
import { CityService } from './services/city.service';
import { HttpClientModule } from '@angular/common/http';
import { CityDetailComponent } from './city-detail/city-detail.component';
import {MatSelectModule} from '@angular/material/select';

@NgModule({
  declarations: [
    AppComponent,
    CityListComponent,
    CityDetailComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    FormsModule,
    HttpClientModule,
    SelectModule,   
    BrowserAnimationsModule,
    MatSelectModule
  ],

  providers: [CityService],
  bootstrap: [AppComponent]
})
export class AppModule { }
