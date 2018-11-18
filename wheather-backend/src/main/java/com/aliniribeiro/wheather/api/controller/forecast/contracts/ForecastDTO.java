package com.aliniribeiro.wheather.api.controller.forecast.contracts;

import java.time.LocalDate;

public class ForecastDTO {


    public String cityName;
    public Double maxTemperature;
    public Double minTemperature;
    public String temperatureDescription;
    public String temperatureIcon;
    public String type;
    public LocalDate date;

}
