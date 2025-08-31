package az.ingress.service.impl;

import az.ingress.model.response.DistrictResponse;
import az.ingress.service.DistrictService;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.stereotype.Service;

@Service
public class DistrictServiceImpl implements DistrictService {

  @Override
  public Integer findPopulationByName(String name) {
    final Map<String, Integer> district = fillDistrict();
    return district.get(name);
  }

  @Override
  public DistrictResponse findHighestPopulation() {
    final Map<String, Integer> district = fillDistrict();
    //final Integer highPopulation = Collections.max(district.values());

    final Entry<String, Integer> entry = district.entrySet()
        .stream()
        .max(Map.Entry.comparingByValue())
        .orElseThrow();

    return DistrictResponse.builder()
        .population(entry.getValue())
        .name(entry.getKey())
        .build();

  }

  Map<String, Integer> fillDistrict() {
    Map<String, Integer> districtPopulation = new HashMap<>();
    districtPopulation.put("Nizami", 215000);
    districtPopulation.put("Narimanov", 180000);
    districtPopulation.put("Yasamal", 300000);
    districtPopulation.put("Binagadi", 270000);
    districtPopulation.put("Sabail", 160000);
    districtPopulation.put("Khatai", 250000);
    districtPopulation.put("Surakhani", 230000);

    return districtPopulation;
  }
}
