package io.krishna.service;

import io.krishna.entity.Alerts;
import io.krishna.entity.Readings;
import io.krishna.entity.Vehicle;
import io.krishna.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

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
    @Override
    @Transactional
    public Readings addReading(Readings reading){
       // checkAlerts(reading);
        checkAlerts(reading);
        repo.addReading(reading);
        return reading;
    }




    @Override
    @Transactional
    public void checkAlerts(Readings reading) {


        System.out.println("test");
        String vinNumb = reading.getVin();
        System.out.println(vinNumb);
        Vehicle vehicle = repo.findOne(vinNumb);
        System.out.println(vehicle.getRedlineRpm());
        System.out.println("done");

        if (reading.getEngineRpm() > vehicle.getRedlineRpm()) {

            System.out.println("done2");
            Alerts alert = new Alerts();
            alert.setAlertVin(reading.getVin());

            System.out.println("done3");
            alert.setAlertMessage("Current vehicle RPM is exceeding RedlineRPM and vehicle in DANGER!!");
            alert.setPriority("HIGH");
            alert.setAlertTimeStamp(reading.getTimestamp());
            repo.addAlert(alert);

        }

        if(reading.getFuelVolume()<(vehicle.getMaxFuelVolume()*0.1)){
            Alerts alert = new Alerts();
            alert.setAlertVin(reading.getVin());
            alert.setAlertMessage("Fuel level low than 10% of max fuel!!");
            alert.setPriority("MEDIUM");
            alert.setAlertTimeStamp(reading.getTimestamp());
            repo.addAlert(alert);
        }
        if(reading.getTires().getFrontLeft()<32||reading.getTires().getFrontLeft()>36||
                reading.getTires().getFrontRight()<32||reading.getTires().getFrontRight()>36||
                reading.getTires().getRearLeft()<32||reading.getTires().getRearLeft()>36||
                reading.getTires().getRearRight()<32||reading.getTires().getRearRight()>36){
            Alerts alert = new Alerts();
            alert.setAlertVin(reading.getVin());
            alert.setAlertMessage("Pressure in Tire less than 32psi or greater than 36psi!!");
            alert.setPriority("LOW");
            alert.setAlertTimeStamp(reading.getTimestamp());
            repo.addAlert(alert);
        }
        if((reading.isEngineCoolantLow()) || (reading.isCheckEngineLightOn())){
            Alerts alert = new Alerts();
            alert.setAlertVin(reading.getVin());
            alert.setAlertMessage("Coolant is low or Engine light is ON..Please Check !!");
            alert.setPriority("LOW");
            alert.setAlertTimeStamp(reading.getTimestamp());
            repo.addAlert(alert);
        }

    }

}

