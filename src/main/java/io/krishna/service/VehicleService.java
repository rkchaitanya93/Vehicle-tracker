package io.krishna.service;

import io.krishna.entity.Readings;
import io.krishna.entity.Vehicle;

/**
 * Created by Krishna on 6/5/2017.
 */
public interface VehicleService {

    Vehicle update(String vin, Vehicle vehicle);
    Readings addReading(Readings reading);
}
