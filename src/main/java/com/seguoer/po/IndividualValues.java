package com.seguoer.po;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IndividualValues extends IndividualValuesAndSpeciesStrength{

    public IndividualValues(int hp, int atk, int def, int sAtk, int sDef, int speed) {
        super(hp, atk, def, sAtk, sDef, speed);
    }
}
