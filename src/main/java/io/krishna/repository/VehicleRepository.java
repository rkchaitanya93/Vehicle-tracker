package io.krishna.repository;

import io.krishna.entity.Readings;
import io.krishna.entity.Vehicle;

/**
 * Created by Krishna on 6/5/2017.
 */
public interface VehicleRepository {

    Vehicle create(Vehicle vehicle);
    Vehicle findOne(String vin);
    Vehicle update(Vehicle vehicle);
    Readings addReading(Readings reading);
}
