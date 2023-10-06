package carRental.address.dataAccess.abstracts;

import carRental.address.entities.concretes.BuildingNumber;
import carRental.address.entities.concretes.Street;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BuildingNumberDao extends JpaRepository<BuildingNumber,Integer> {
    BuildingNumber findByBuildingNo(int buildingNo);
    BuildingNumber findByBuildingNumberId(int buildingNumberId);
    Optional<BuildingNumber> findBuildingNumberByBuildingNo(int buildingNo);
    List<BuildingNumber> findBuildingNumbersByStreet(Street street);

    boolean existsByBuildingNo(int buildingNo);
    boolean existsByBuildingNumberId(int buildingNumberId);
}
