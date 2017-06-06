package io.krishna.service;

import io.krishna.entity.Vehicle;
import io.krishna.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Krishna on 6/5/2017.
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository repo;

    @Override
    @Transactional
    public Vehicle update(String vin, Vehicle vehicle) {
        Vehicle existing = repo.findOne(vin);
        if (existing == null) {
            repo.create(vehicle);
        }
        else {
            repo.update(vehicle);
        }
        return vehicle;
    }
}

