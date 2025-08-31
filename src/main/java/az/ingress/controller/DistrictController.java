package az.ingress.controller;

import az.ingress.model.response.DistrictResponse;
import az.ingress.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/district")
@RequiredArgsConstructor
public class DistrictController {
  private final DistrictService districtService;

    @GetMapping("/{district}")
    public ResponseEntity<Integer> getPopulationByDistrict(@PathVariable String district) {
      final Integer populationByName = districtService.findPopulationByName(district);
      return ResponseEntity.ok(populationByName);
    }

    @GetMapping("/highest-population")
    public ResponseEntity<DistrictResponse> findHighestPopulationDistrict() {
      final DistrictResponse highestPopulationDistrict = districtService.findHighestPopulation();
      return ResponseEntity.ok(highestPopulationDistrict);
    }


}