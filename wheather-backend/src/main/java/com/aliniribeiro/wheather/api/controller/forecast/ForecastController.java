
package com.aliniribeiro.wheather.api.controller.forecast;

import com.aliniribeiro.wheather.api.APIPaths;
import com.aliniribeiro.wheather.api.common.Response;
import com.aliniribeiro.wheather.api.common.util.Spring;
import com.aliniribeiro.wheather.api.controller.forecast.contracts.ForecastOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(APIPaths.FORECAST)
@CrossOrigin(origins = "*")
public class ForecastController {

    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<Response<ForecastOutput>> getForecast(@PathVariable("id") UUID cityId) {
        Response<ForecastOutput> response = new Response<ForecastOutput>();
        try {
            ForecastOutput pastHosted = Spring.bean(ForecastService.class).getCityForecast(cityId);
            response.setData(pastHosted);
        } catch (Exception e) {
            response.getErrors().add(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }


}
