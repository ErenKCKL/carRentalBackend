package carRental.address.entities.concretes.dtos;
import carRental.address.entities.concretes.City;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
public class StreetDTO {
    private String streetName;
    private int streetId;

    private City city;

    private List<Integer> buildingNumbers;

}
