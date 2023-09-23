package com.bpCapstone.daybreakBackup.controllers;

import com.bpCapstone.daybreakBackup.dtos.LoadoutDto;
import com.bpCapstone.daybreakBackup.services.LoadoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/loadouts")
public class LoadoutController {
    @Autowired
    private LoadoutService loadoutService;

    @GetMapping("/user/{userId}")
    public List<LoadoutDto> getLoadoutsByUser(Long userId) {
        return loadoutService.getAllLoadoutsByUserId(userId);
    }

    @PostMapping("/user/{userId}")
    public void addLoadout(@RequestBody LoadoutDto loadoutDto,@PathVariable Long userId){
        loadoutService.addLoadout(loadoutDto, userId);
    }

    @DeleteMapping("/{loadoutId}")
    public void deleteLoadoutById(@PathVariable Long loadoutId) {
        loadoutService.deleteLoadoutById(loadoutId);
    }
    @PutMapping
    public void updateLoadout(@RequestBody LoadoutDto loadoutDto) {
        loadoutService.updateLoadoutById((loadoutDto));
    }

    @GetMapping("/{loadoutId}")
    public Optional<LoadoutDto> getLoadoutById(@PathVariable Long loadoutId) {
        return loadoutService.getLoadoutById(loadoutId);
    }
}
