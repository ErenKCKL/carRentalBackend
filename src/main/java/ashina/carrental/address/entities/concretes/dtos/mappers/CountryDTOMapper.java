package carRental.address.entities.concretes.dtos.mappers;

import carRental.address.entities.concretes.City;
import carRental.address.entities.concretes.Country;
import carRental.address.entities.concretes.dtos.CountryDTO;

import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service

public class CountryDTOMapper implements Function<Country, CountryDTO> {

    @Override
    public CountryDTO apply(Country country) {
        return new CountryDTO(
                country.getCountryName(),
                country.getCountryId(),
                country.getCities()
                        .stream()
                        .map(City::getCityName)
                        .collect(Collectors.toList()
                        ));
    }
}
