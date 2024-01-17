package com.example.carshopbackend;

import com.example.carshopbackend.domain.Car;
import com.example.carshopbackend.domain.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarShopBackendApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CarShopBackendApplication.class);

    private final CarRepository carRepository;

    public CarShopBackendApplication(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CarShopBackendApplication.class, args);
        logger.info("Application started!");
    }

    @Override
    public void run(String... args) throws Exception {
        carRepository.save(new Car("Ford", "Mustang", "Red",
                "ADF-1121", 2023, 59000));
        carRepository.save(new Car("Nissan", "Leaf", "White",
                "SSJ-3002", 2020, 29000));
        carRepository.save(new Car("Toyota", "Prius",
                "Silver", "KKO-0212", 2022, 39000));
        for (Car car : carRepository.findAll()) {
            logger.info("brand: {}, model: {}",
                    car.getBrand(), car.getModel());
        }
    }
}
