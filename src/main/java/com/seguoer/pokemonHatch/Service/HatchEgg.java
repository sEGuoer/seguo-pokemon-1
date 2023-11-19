package com.seguoer.pokemonHatch.Service;

import com.seguoer.po.Pokemon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HatchEgg {
    private Pokemon maleParent;
    private Pokemon femaleParent;

}
