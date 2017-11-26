package com.thinking.in.java.rtti;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LiteralPetCreator extends PetCreator {

    public static final List<Class<? extends Pet>> allTypes =
            Collections.unmodifiableList(Arrays.asList(Pet.class, Dog.class, Cat.class,
                    Mutt.class, Pug.class
                    , Manx.class, Cymric.class));

    private static final List<Class<?extends Pet>> types = allTypes.subList(allTypes.indexOf(
            Mutt.class),allTypes.size());
    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

    public static void main(String[] args) {
        System.out.println(types);
    }
}
