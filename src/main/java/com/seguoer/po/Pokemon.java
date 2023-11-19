package com.seguoer.po;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pokemon {
    //宝可梦名字
    private String name;
    //个体值
    private IndividualValues individualValues;
    //这里的type为属性，例如电系什么的，也有双系情况。
     private int[] type;
    //蛋群，生蛋条件
    private String eggGroup;
    //种族值
    private SpeciesStrength speciesStrength;
    //闪?
    private boolean isNotShiny;
    //携带物品
    private Item item;
    //性别
    private String Gender;



}
