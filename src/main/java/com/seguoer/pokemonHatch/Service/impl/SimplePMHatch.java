package com.seguoer.pokemonHatch.Service.impl;

import com.seguoer.po.IndividualValues;
import com.seguoer.po.IndividualValuesAndSpeciesStrength;
import com.seguoer.po.Pokemon;
import com.seguoer.pokemonHatch.Service.HatchEgg;
import com.seguoer.pokemonHatch.Service.PokemonHatchService;

import java.util.Random;

public class SimplePMHatch implements PokemonHatchService {
    @Override
    public Pokemon hatchEggWithoutItem(HatchEgg hatchEgg) {
        Pokemon femaleParent = hatchEgg.getFemaleParent();
        Pokemon maleParent = hatchEgg.getMaleParent();
        Pokemon sonPM = new Pokemon();
        sonPM.setName(femaleParent.getName());

        IndividualValues sonIndividualValues = SumIndividualValuesRandom(femaleParent.getIndividualValues(), maleParent.getIndividualValues(), 0.25, 0.25);
        sonPM.setIndividualValues(sonIndividualValues);

        sonPM.setType(femaleParent.getType());

        sonPM.setEggGroup(femaleParent.getEggGroup());

        sonPM.setNotShiny(probability(1, 1048));

        sonPM.setItem(null);

        sonPM.setGender(sonGender(1, 8));

        return sonPM;
    }

    //几分之几
    public boolean probability(int numerator, int denominator) {
        Random random = new Random();
        int digit = random.nextInt(denominator) + 1;
        return digit > numerator;
    }
    public String sonGender(int numerator,int denominator){
        //female probability
        if (!probability(numerator, denominator)){
            return "female";
        }else {
            return "male";
        }
    }

    //得到所有的个体值IV
    public IndividualValues SumIndividualValuesRandom(IndividualValues femaleParentIndividualValues, IndividualValues maleParentIndividualValues, double leastValue, double maxValue) {
        IndividualValues sonIndividualValues = new IndividualValues();
        sonIndividualValues.setHp(singleIndividualValuesRandom(femaleParentIndividualValues.getHp(), maleParentIndividualValues.getHp(), leastValue, maxValue));
        sonIndividualValues.setAtk(singleIndividualValuesRandom(femaleParentIndividualValues.getAtk(), maleParentIndividualValues.getAtk(), leastValue, maxValue));
        sonIndividualValues.setDef(singleIndividualValuesRandom(femaleParentIndividualValues.getDef(), maleParentIndividualValues.getDef(), leastValue, maxValue));
        sonIndividualValues.setSAtk(singleIndividualValuesRandom(femaleParentIndividualValues.getSAtk(), maleParentIndividualValues.getSAtk(), leastValue, maxValue));
        sonIndividualValues.setSDef(singleIndividualValuesRandom(femaleParentIndividualValues.getSDef(), maleParentIndividualValues.getSDef(), leastValue, maxValue));
        sonIndividualValues.setSpeed(singleIndividualValuesRandom(femaleParentIndividualValues.getSpeed(), maleParentIndividualValues.getSpeed(), leastValue, maxValue));
        return sonIndividualValues;
    }

    //（leastValue<=1,maxValue<=1）&&leastValue+maxValue<=1  IV最低和IV最高的概率
    public int singleIndividualValuesRandom(int femaleParentValue, int maleParentValue, double leastValue, double maxValue) {
        if (femaleParentValue == maleParentValue) {
            return femaleParentValue;
        } else {
            double zeroToOneDigit = Math.random();
            System.out.println(zeroToOneDigit);
            if (zeroToOneDigit <= leastValue) {
                return Math.min(femaleParentValue, maleParentValue);
            } else if (zeroToOneDigit >= 1 - maxValue) {
                return Math.max(femaleParentValue, maleParentValue);
            } else {
                return randomGetValue(femaleParentValue, maleParentValue);
            }
        }
    }

    public int randomGetValue(int femaleParentValue, int maleParentValue) {
        Random random = new Random();
        int min = Math.min(femaleParentValue, maleParentValue);
        int max = Math.max(femaleParentValue, maleParentValue);
        return random.nextInt(max - min + 1) + min;
    }
}
