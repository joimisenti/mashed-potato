package com.bpCapstone.daybreakBackup.dtos;

import com.bpCapstone.daybreakBackup.entities.Perk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerkDto implements Serializable {

    private Long id;
    private String name;
    private String survivor;

    public PerkDto(Perk perk) {
        if (perk.getId() != null) {
            this.id = perk.getId();
        }
        if (perk.getName() != null) {
            this.name = perk.getName();
        }
        if (perk.getSurvivor() != null) {
            this.survivor = perk.getSurvivor();
        }
    }
}
