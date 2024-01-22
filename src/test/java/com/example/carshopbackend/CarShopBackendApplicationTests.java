package com.example.carshopbackend;

import com.example.carshopbackend.web.LoginController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CarShopBackendApplicationTests {

    @Autowired
    private LoginController loginController;

    @Test
    void contextLoads() {
        assertThat(loginController).isNotNull();
    }

}
