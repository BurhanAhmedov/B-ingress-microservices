package az.ingress.service;

import az.ingress.model.response.DistrictResponse;

public interface DistrictService {
  Integer findPopulationByName(String name);
  DistrictResponse findHighestPopulation();

}
