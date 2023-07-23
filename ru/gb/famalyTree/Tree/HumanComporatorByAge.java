package ru.gb.famalyTree;

import ru.gb.famalyTree.human.Human;

import java.util.Comparator;

public class HumanComporatorByAge implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAge()- o2.getAge();
    }
}
