package com.bpCapstone.daybreakBackup.controllers;

import com.bpCapstone.daybreakBackup.services.LoadoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/loadouts")
public class LoadoutController {
    @Autowired
    private LoadoutService loadoutService;
}
