package com.bpCapstone.daybreakBackup.controllers;

import com.bpCapstone.daybreakBackup.dtos.PerkDto;
import com.bpCapstone.daybreakBackup.entities.Perk;
import com.bpCapstone.daybreakBackup.services.PerkSeederService;
import com.bpCapstone.daybreakBackup.services.PerkService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/perks")
public class PerkController {
    @Autowired
    private PerkService perkService;

    @Autowired
    private PerkSeederService perkSeederService;

    @PostMapping("/seedPerks")
    public void seedPerks() {
        perkSeederService.seedPerksFromTxtFile("/Users/jmisenti/Desktop/Java-Specs/daybreakBackup/src/main/" +
                "java/com/bpCapstone/daybreakBackup/assets/survivor_perks.txt");
    }

    @GetMapping
    public List<PerkDto> getAllPerks() {
        return perkService.getAllPerks();
    }

    // Get all custom Perks created by User
//    @GetMapping("/user/{userId}")
//    public List<PerkDto> getPerksByUser(@PathVariable Long userId) {
//        return perkService.getAllPerksByUserId(userId);
//    }

    @DeleteMapping("/{perkId}")
    public void deletePerkById(@PathVariable Long perkId) {
        perkService.deletePerkById(perkId);
    }

    @PutMapping
    public void updatePerk(@RequestBody PerkDto perkDto) {
        perkService.updatePerkById(perkDto);
    }

    @GetMapping("/{perkId}")
    public Optional<PerkDto> getPerkById(@PathVariable Long perkId) {
        return perkService.getPerkById(perkId);
    }
}
