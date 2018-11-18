package com.aliniribeiro.wheather.api.controller.city.contracts;

import java.util.List;

public class SearchCityOutput {

    /**
     * Quantidade de cidades encontradas
     */
    public Long registeredFound;

    /**
     * Lista de cidades encontradas
     */
    public List<CityDTO> cityes;
}
