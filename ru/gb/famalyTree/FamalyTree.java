package ru.gb.famalyTree;

import java.util.ArrayList;
import java.util.List;

public class FamalyTree {
    private List<Human> famalyTree;
    public FamalyTree(){
        famalyTree = new ArrayList<>();
    }


   public void addHuman(Human human){
       famalyTree.add(human);
   }

    public String getFamalyTreeInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список продуктов:\n");
        for (Human human: famalyTree){
            stringBuilder.append(human.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


}
