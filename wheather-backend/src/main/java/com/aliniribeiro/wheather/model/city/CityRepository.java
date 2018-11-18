package com.aliniribeiro.wheather.model.city;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CityRepository extends JpaRepository<CityEntity, String>, CityCustom {

    Page<CityEntity> findAll(Pageable pageable);

    Optional<CityEntity> findCityById(UUID id);

}
