package com.aliniribeiro.wheather.api.controller.city;

import com.aliniribeiro.wheather.api.controller.city.contracts.CityDTO;
import com.aliniribeiro.wheather.model.city.CityEntity;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {

    public CityDTO toCityDTO(CityEntity entity) {
        if (entity == null) {
            return null;
        }

        CityDTO dto = new CityDTO();
        dto.name = entity.getName();
        dto.country = entity.getCountry();
        dto.cityId = Long.parseLong(entity.getCityId());
        dto.id = entity.getId();
        return dto;
    }
}
