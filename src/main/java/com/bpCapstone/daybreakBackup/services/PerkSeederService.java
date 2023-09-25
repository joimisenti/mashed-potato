package com.bpCapstone.daybreakBackup.services;

import com.bpCapstone.daybreakBackup.entities.Perk;
import com.bpCapstone.daybreakBackup.repositories.PerkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PerkSeederService {

    @Autowired
    private PerkRepository perkRepository;

    @Transactional
    public void seedPerksFromTxtFile(String filePath) {
        List<Perk> perks = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {

                // Skip blank lines or lines with only whitespace
                if (line.trim().isEmpty()) {
                    continue;
                }
                // Create a new Perk entity for each line in the .txt file and add it to the list
                Perk perk = new Perk();
                perk.setName(line.trim());

                // Optionally, can set other attributes of the Perk entity if needed
                perks.add(perk);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Save the list of Perks to the database
        perkRepository.saveAll(perks);
    }
}
