package com.example.carshopbackend;

import com.example.carshopbackend.domain.Owner;
import com.example.carshopbackend.domain.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class OwnerRepositoryTest {

    @Autowired
    private OwnerRepository repository;

    @Test
    void saveOwner() {
        repository.save(new Owner("Lisa", "Brown"));
        assertThat(repository.findByFirstname("Lisa")).isPresent();
    }

    @Test
    void deleteOwners() {
        repository.save(new Owner("Lisa", "Morrison"));
        repository.deleteAll();
        assertThat(repository.count()).isEqualTo(0);
    }
}
