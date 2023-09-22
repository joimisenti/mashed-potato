package com.bpCapstone.daybreakBackup.controllers;

import com.bpCapstone.daybreakBackup.services.PerkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/perks")
public class PerkController {
    @Autowired
    private PerkService perkService;
}
