package com.aliniribeiro.wheather;

import com.aliniribeiro.wheather.api.controller.city.contracts.CityDTO;
import org.assertj.core.api.Assertions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class WheatherApplicationTests {

	@Test
	public void contextLoads() {
	}



	@Test
	public void testCityList() {
		List<CityDTO> cities444 = new ArrayList<>();

		String filePath = "src/main/resources/city.list.json";
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(filePath));
			JSONArray cities = (JSONArray) obj;
			cities.forEach( c -> {
				JSONObject jsonObject =  (JSONObject) c;
				CityDTO  city = new CityDTO();
				city.name = (String)jsonObject.get("name");
				city.cityId = (Long) jsonObject.get("id");
				city.country = (String)jsonObject.get("country");
				cities444.add(city);
			});
			Assertions.assertThat(!cities444.isEmpty());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


}
