package com.example.carshopbackend;

import com.example.carshopbackend.domain.Car;
import com.example.carshopbackend.domain.CarRepository;
import com.example.carshopbackend.domain.Owner;
import com.example.carshopbackend.domain.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CarShopBackendApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CarShopBackendApplication.class);

    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;

    public CarShopBackendApplication(CarRepository carRepository, OwnerRepository ownerRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CarShopBackendApplication.class, args);
        logger.info("Application started!");
    }

    @Override
    public void run(String... args) throws Exception {
        Owner tim = new Owner("Tim", "Brown");
        Owner jim = new Owner("Jim", "Green");
        ownerRepository.saveAll(Arrays.asList(tim, jim));
        carRepository.save(new Car("Ford", "Mustang", "Red",
                "ADF-1121", 2023, 59000, tim));
        carRepository.save(new Car("Nissan", "Leaf", "White",
                "SSJ-3002", 2020, 29000, tim));
        carRepository.save(new Car("Toyota", "Prius",
                "Silver", "KKO-0212", 2022, 39000, jim));
        for (Owner owner : ownerRepository.findAll()) {
            logger.info("Owner: {} {}", owner.getFirstname(), owner.getLastname());
            for (Car car : owner.getCars()) {
                logger.info("brand: {}, model: {}",
                        car.getBrand(), car.getModel());
            }
        }
    }
}
