
package com.aliniribeiro.wheather.api.controller.city;

import com.aliniribeiro.wheather.api.APIPaths;
import com.aliniribeiro.wheather.api.common.Response;
import com.aliniribeiro.wheather.api.common.util.Spring;
import com.aliniribeiro.wheather.api.controller.city.contracts.CityDTO;
import com.aliniribeiro.wheather.api.controller.city.contracts.SearchCityInput;
import com.aliniribeiro.wheather.api.controller.city.contracts.SearchCityOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(APIPaths.CITY)
@CrossOrigin(origins = "*")
public class CityController {

    @PostMapping(value = "/create")
    public ResponseEntity<Response<CityDTO>> createClient(HttpServletRequest request, @RequestBody CityDTO city, BindingResult result) {
        Response<CityDTO> response = new Response<CityDTO>();
        try {
            CityDTO createdCustumer = Spring.bean(CityService.class).createCity(city);
            response.setData(createdCustumer);
        } catch (Exception e) {
            response.getErrors().add(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }


    @PostMapping(value = "/my/search")
    public ResponseEntity<Response<List<CityDTO>>> searchDatabaseCities(HttpServletRequest request, @RequestBody SearchCityInput input, BindingResult result) {
        Response<List<CityDTO>> response = new Response<List<CityDTO>>();
        try {
            Optional<List<CityDTO>> serviceResponse = Spring.bean(CityService.class).searchDatabaseCities(input.q, input.page, input.size);
            if (serviceResponse.isPresent()) {
                response.setData(serviceResponse.get());
            }
        } catch (Exception e) {
            response.getErrors().add(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Response<List<CityDTO>>> searchCities(HttpServletRequest request, @RequestBody SearchCityInput input, BindingResult result) {
        Response<List<CityDTO> > response = new Response<List<CityDTO> >();
        try {
            Optional<List<CityDTO>> serviceResponse = Spring.bean(CityService.class).searchCities(input.q);
            if (serviceResponse.isPresent()) {
                response.setData(serviceResponse.get());
            }
        } catch (Exception e) {
            response.getErrors().add(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }

}
