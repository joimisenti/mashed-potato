package com.bpCapstone.daybreakBackup.controllers;

import com.bpCapstone.daybreakBackup.dtos.PerkDto;
import com.bpCapstone.daybreakBackup.entities.Perk;
import com.bpCapstone.daybreakBackup.services.PerkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/perks")
public class PerkController {
    @Autowired
    private PerkService perkService;

    @GetMapping("/perks")
    public List<Perk> getAllPerks() {
        return perkService.getAllPerks();
    }

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
