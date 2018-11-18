package com.aliniribeiro.wheather.api.controller.forecast;

import com.aliniribeiro.wheather.api.common.util.Spring;
import com.aliniribeiro.wheather.api.controller.forecast.contracts.ForecastDTO;
import com.aliniribeiro.wheather.api.controller.forecast.contracts.ForecastOutput;
import com.aliniribeiro.wheather.api.controller.forecast.contracts.WheatherType;
import com.aliniribeiro.wheather.model.city.CityEntity;
import com.aliniribeiro.wheather.model.city.CityRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Component
public class ForecastService {

    private final String URL_API_ID= "&APPID=eb8b1a9405e659b2ffc78f0a520b1a46&units=metric&cnt=5";
    private final String API_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?id=";

    private final String OWM_LIST = "list";
    private final String OWM_WEATHER = "weather";
    private final String OWM_MAX = "max";
    private final String OWM_MIN = "min";
    private final String OWM_TEMP = "temp";
    private final String WHEATHER_ID = "id";
    private final String DATE = "dt_txt";

    public List<ForecastDTO> getCityForecast(UUID cityId) {
        List<ForecastDTO> output = new ArrayList<>();
        Optional<CityEntity> city = Spring.bean(CityRepository.class).findCityById(cityId);
        if (city.isPresent()){
            try {
                URI uri = new URI(API_URL + city.get().getCityId() + URL_API_ID);
                ResponseEntity<String> responseEntity = Spring.bean(RestTemplate.class).exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
                });
                String response = responseEntity.getBody();
                for (int i = 1; i < 5; i ++){
                    output.add(getForecast(response, i, city.get().getName()));
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return output;
    }

    public ForecastDTO getForecast(String weatherJsonStr, int dayIndex, String cityName) {

        ForecastDTO forecast = new ForecastDTO();
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(weatherJsonStr);
            JSONArray data = (JSONArray) jsonObject.get(OWM_LIST);
            JSONObject dayInfo = (JSONObject) data.get(dayIndex);
            //Informações da temperatura
            JSONObject temperatureinfo = (JSONObject) dayInfo.get(OWM_TEMP);
            forecast.maxTemperature = (Double) temperatureinfo.get(OWM_MAX);
            forecast.minTemperature = (Double) temperatureinfo.get(OWM_MIN);

            //Informações do tempo
            JSONArray wheatherInfo = (JSONArray) dayInfo.get(OWM_WEATHER);
            JSONObject firstData = (JSONObject) wheatherInfo.get(0);
            Long wheatherCode = (Long)firstData.get(WHEATHER_ID);
            WheatherType type = WheatherType.getByCode(wheatherCode.intValue());
            forecast.temperatureDescription = type.description;
            forecast.temperatureIcon = type.icon;
            forecast.type = type.toString();
            forecast.cityName = cityName;

            //Data
            forecast.date  = getForecastDate(dayIndex - 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return forecast;
    }

    private String getForecastDate(int index){
        Date date = Date.from(LocalDate.now().minusDays(index).atStartOfDay(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        String str = fmt.format(date);
        return str;
    }
}
