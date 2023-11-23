package com.seguoer;

import com.seguoer.po.IndividualValues;
import com.seguoer.po.IndividualValuesAndSpeciesStrength;
import com.seguoer.po.Pokemon;
import com.seguoer.po.SpeciesStrength;
import com.seguoer.pokemonHatch.Service.HatchEgg;
import com.seguoer.pokemonHatch.Service.PokemonHatchService;
import com.seguoer.pokemonHatch.Service.impl.SimplePMHatch;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SimplePMHatchTest {

    String individualValuesToString(IndividualValuesAndSpeciesStrength individualValues) {
        if (individualValues ==null){
            return "{hp=" + 0 + " ;" +
                    "atk=" + 0 + " ;" +
                    "def=" + 0 + " ;" +
                    "sAtk=" + 0 + " ;" +
                    "sDef=" + 0 + " ;" +
                    "speed=" + 0 + "}";
        }else {
            return "{hp=" + individualValues.getHp() + " ;" +
                    "atk=" + individualValues.getAtk() + " ;" +
                    "def=" + individualValues.getDef() + " ;" +
                    "sAtk=" + individualValues.getSAtk() + " ;" +
                    "sDef=" + individualValues.getSDef() + " ;" +
                    "speed=" + individualValues.getSpeed() + "}";
        }
    }

    @Test
    void randomHatch() {
        Pokemon femalePM = new Pokemon("皮卡丘", new IndividualValues(0, 0, 0, 0, 0, 0)
                , new int[]{1}, "WaterOne", new SpeciesStrength(0, 0, 0, 0, 0, 0),
                false, null, "female");
        Pokemon malePM = new Pokemon("电击兽", new IndividualValues(31, 31, 31, 31, 31, 31)
                , new int[]{1}, "WaterOne", new SpeciesStrength(0, 0, 0, 0, 0, 0),
                false, null, "male");
        HatchEgg hatchEgg = new HatchEgg(malePM, femalePM);
        PokemonHatchService pokemonSimpleHatch = new SimplePMHatch();
        Pokemon son = pokemonSimpleHatch.hatchEggWithoutItem(hatchEgg);
        System.out.println("name:" + son.getName() + "\n" +
                "individualValues:" + individualValuesToString(son.getIndividualValues()) + "\n" +
                "type:" + Arrays.toString(son.getType()) + "\n" +
                "eggGroup:" + son.getEggGroup() + "\n" +
                "SpeciesStrength:" + individualValuesToString(son.getSpeciesStrength()) + "\n" +
                "inNotShiny:" + son.isNotShiny() + "\n" +
                "item:" + son.getItem() + "\n" +
                "Gender:" + son.getGender() + "\n"
        );
    }
}
