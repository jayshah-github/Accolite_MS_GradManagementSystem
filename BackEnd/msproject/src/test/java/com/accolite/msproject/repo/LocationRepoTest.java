package com.accolite.msproject.repo;

import com.accolite.msproject.EntityData;
import com.accolite.msproject.model.Institute;
import com.accolite.msproject.model.Location;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
class LocationRepoTest {
    @Autowired
    LocationRepo locationRepo;

    @Test
    void existsById() {
        boolean exists = locationRepo.existsById(1);
        assertThat(exists).isTrue();
    }
    @Test
    void save() {
        Location location = new Location();
        location.setName("new loc");

        Location location1 = locationRepo.save(location);

        Optional<Location> getLoc = locationRepo.findById(location1.getId());
        assertThat(location1).isEqualTo(getLoc.get());

    }
    @Test
    void findAll() {


        List<Location> locationList= (List<Location>) locationRepo.findAll();
        assertThat(locationList).isNotNull();



    }
    @Test
    void getLabels() {
        List<String> locLabels=locationRepo.getLabels();
        assertThat(locLabels).containsExactlyInAnyOrder(EntityData.getLocData());

    }
}