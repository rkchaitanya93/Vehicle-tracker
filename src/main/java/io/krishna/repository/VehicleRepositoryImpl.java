package io.krishna.repository;

import io.krishna.entity.Alerts;
import io.krishna.entity.Readings;
import io.krishna.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Krishna on 6/5/2017.
 */
@Repository
public class VehicleRepositoryImpl implements VehicleRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Vehicle create(Vehicle vehicle) {
        em.persist(vehicle);
        return vehicle;
    }
    @Override
    public Vehicle findOne(String vin) {

        return em.find(Vehicle.class, vin);
    }

    @Override
    public Vehicle update(Vehicle vehicle){
        return em.merge(vehicle);
    }
    @Override
    public Readings addReading(Readings reading){
        em.persist(reading);
        return(reading);
    }

    @Override
    public Alerts addAlert(Alerts alert){
        em.persist(alert);
        return alert;
    }

}
