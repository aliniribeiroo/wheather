package com.aliniribeiro.wheather.api.controller.city;

import com.aliniribeiro.wheather.api.common.util.Spring;
import com.aliniribeiro.wheather.api.controller.city.contracts.CityDTO;
import com.aliniribeiro.wheather.api.controller.city.contracts.SearchCityOutput;
import com.aliniribeiro.wheather.model.city.CityEntity;
import com.aliniribeiro.wheather.model.city.CityRepository;
import com.aliniribeiro.wheather.model.common.PageResult;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CityService {

    private final List<CityDTO> loadedCities = new ArrayList<>();

    /**
     * Método que retorna clientes.
     *
     * @return Optional copm o total de clientes cadastrados no sistema.
     */
    public Optional<List<CityDTO>> searchDatabaseCities(String q, Long page, Long size) {
        PageResult<CityEntity> customers = Spring.bean(CityRepository.class).searchCities(q, page, size);
        List<CityDTO> output = new ArrayList<>();
        customers.getRows().stream().forEach(c -> output.add(Spring.bean(CityMapper.class).toCityDTO(c)));
        return Optional.ofNullable(output);
    }

    /**
     * Método que cria um novo cliente.
     *
     * @param dto dto com as informações da cidade que será criada.
     * @return DTO com as informações da cidade criada.
     */
    public CityDTO createCity(CityDTO dto) {
        CityEntity city = new CityEntity();
        city.setName(dto.name);
        city.setCityId(dto.cityId.toString());
        city.setCountry(dto.country);
        Spring.bean(CityRepository.class).save(city);
        return Spring.bean(CityMapper.class).toCityDTO(city);
    }

    /**
     * Método que retorna clientes.
     *
     * @return Optional copm o total de clientes cadastrados no sistema.
     */
    public Optional<List<CityDTO>> searchCities(String q) {
        List<CityDTO> avaliableCities = getCities();
        List<CityDTO> brazilianCities = avaliableCities.stream().filter(c -> c.country.equalsIgnoreCase("br")).collect(Collectors.toList());
        return Optional.ofNullable(brazilianCities.stream().filter(c -> c.name.toLowerCase().contains(q.toLowerCase())).collect(Collectors.toList()));
    }

    public void loadCities() {
        String filePath = "src/main/resources/city.list.json";
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(filePath));
            JSONArray cities = (JSONArray) obj;
            cities.forEach(c -> {
                JSONObject jsonObject = (JSONObject) c;
                CityDTO city = new CityDTO();
                city.name = (String) jsonObject.get("name");
                city.cityId = (Long) jsonObject.get("id");
                city.country = (String) jsonObject.get("country");
                loadedCities.add(city);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private List<CityDTO> getCities() {
        if (loadedCities.isEmpty()) {
            loadCities();
        }
        return loadedCities;
    }
}
