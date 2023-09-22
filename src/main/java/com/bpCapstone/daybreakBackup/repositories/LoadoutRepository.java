package com.bpCapstone.daybreakBackup.repositories;

import com.bpCapstone.daybreakBackup.entities.Loadout;
import com.bpCapstone.daybreakBackup.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoadoutRepository extends JpaRepository<Loadout, Long> {
    List<Loadout> findAllByUserEquals(User user);
}
