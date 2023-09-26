package com.bpCapstone.daybreakBackup.services;

import com.bpCapstone.daybreakBackup.dtos.PerkDto;
import com.bpCapstone.daybreakBackup.entities.Perk;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PerkService {
    // Get all Perks
    List<PerkDto> getAllPerks();

    // Delete a Perk
    @Transactional
    void deletePerkById(Long perkId);

    // Updating a Perk
    @Transactional
    void updatePerkById(PerkDto perkDto);

    // Get all Perks made by a User
//    List<PerkDto> getAllPerksByUserId(Long userId);

    // Get a Perk by the Perk id
    Optional<PerkDto> getPerkById(Long perkId);

    @Transactional
    void savePerk(Perk perk);
}
