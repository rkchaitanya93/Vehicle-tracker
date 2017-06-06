package io.krishna.repository;

import io.krishna.entity.Alerts;
import io.krishna.entity.Readings;
import io.krishna.entity.Vehicle;

public interface VehicleRepository {

    Vehicle create(Vehicle vehicle);
    Vehicle findOne(String vin);
    Vehicle update(Vehicle vehicle);
    Readings addReading(Readings reading);
    Alerts addAlert(Alerts alert);
}
