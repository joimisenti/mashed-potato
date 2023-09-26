package com.bpCapstone.daybreakBackup.services;

import com.bpCapstone.daybreakBackup.dtos.PerkDto;
import com.bpCapstone.daybreakBackup.entities.Perk;
import com.bpCapstone.daybreakBackup.repositories.LoadoutRepository;
import com.bpCapstone.daybreakBackup.repositories.PerkRepository;
import com.bpCapstone.daybreakBackup.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PerkServiceImpl implements PerkService {

    @Autowired
    private PerkRepository perkRepository;
    @Autowired
    private LoadoutRepository loadoutRepository;
    @Autowired
    private UserRepository userRepository;

    // Get all Perks
    @Override
    public List<PerkDto> getAllPerks() {
        List<Perk> perks = perkRepository.findAll();
        List<PerkDto> perkDtos = new ArrayList<>();
        for (Perk perk : perks) {
            perkDtos.add(new PerkDto(perk));
        }
        return perkDtos;
    }

    // Add a perk to the Perks list set uniquely by a User
//    @Transactional
//    public void addPerkByUser(PerkDto perkDto, Long userId) {
//        Optional<User> userOptional = userRepository.findById(userId);
//        Perk perk = new Perk(perkDto);
//        userOptional.ifPresent(perk::setUser);
//        perkRepository.saveAndFlush(perk);
//    }

    // Delete a Perk
    @Override
    @Transactional
    public void deletePerkById(Long perkId) {
        Optional<Perk> perkOptional = perkRepository.findById(perkId);
        perkOptional.ifPresent(perk -> perkRepository.delete(perk));
    }

    // Updating a Perk
    @Override
    @Transactional
    public void updatePerkById(PerkDto perkDto) {
        Optional<Perk> perkOptional = perkRepository.findById(perkDto.getId());
        perkOptional.ifPresent(perk -> {
            perk.setName(perkDto.getName());
            perk.setSurvivor(perkDto.getSurvivor());
            perkRepository.saveAndFlush(perk);
        });
    }

    // Get all Perks made by a User
//    @Override
//    public List<PerkDto> getAllPerksByUserId(Long userId) {
//        Optional<User> userOptional = userRepository.findById(userId);
//        if (userOptional.isPresent()) {
//            List<Perk> perkList = perkRepository.findAllByUserEquals(userOptional.get());
//            return perkList.stream().map(perk -> new PerkDto(perk)).collect(Collectors.toList());
//        }
//        return Collections.emptyList();
//    }

    // Get a Perk by the Perk id
    @Override
    public Optional<PerkDto> getPerkById(Long perkId) {
        Optional<Perk> perkOptional = perkRepository.findById(perkId);
        if (perkOptional.isPresent()) {
            return Optional.of(new PerkDto(perkOptional.get()));
        }
        return Optional.empty();
    }

    // Save a Perk being loaded from JSON file
    @Transactional
    public void savePerk(Perk perk) {
        perkRepository.save(perk);
    }
}
