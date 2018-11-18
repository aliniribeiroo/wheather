package com.aliniribeiro.wheather.model.city;

import com.aliniribeiro.wheather.model.common.PageResult;

public interface CityCustom {

    PageResult searchCities(String q, Long page, Long size);

}
