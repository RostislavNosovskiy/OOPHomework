package ru.gb.famalyTree;

import ru.gb.famalyTree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FamalyTree implements Serializable {
    private List<Human> famalyTree;
    public FamalyTree(){
        famalyTree = new ArrayList<>();
    }


   public boolean addHuman(Human human){
        if(!famalyTree.contains(human)){
            famalyTree.add(human);
            addToParenst(human);
            addToChildren(human);
            return true;
        }
return false;
   }

   public void addToParenst(Human human){
        for(Human parent: human.getParents()){
            parent.addChildren(human);
        }
   }

    public void addToChildren(Human human){
        for(Human parent: human.getChild()){
            parent.addParent(human);
        }
    }

    public List<Human> getSistersBrothers(Human human){
        List <Human> res = new ArrayList<>();
        if(human == null){
            return null;
        }
        for (Human human1: famalyTree){
            for (Human parents : human1.getParents()){
                for (Human parents1 : human.getParents())
                    if (parents.equals(parents1)){
                    res.add(human1);
                }
            }}
            return res;

    }
    public boolean setWedding(Human human1, Human human2){
        if (human1.getSpouse()==null && human2.getSpouse()==null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        return false;
    }

    public boolean setDivorce (Human human1, Human human2){
        if (human1.getSpouse().equals(human2) && human2.getSpouse().equals(human1)){
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        }
        return false;
    }

    public String getFamalyTreeInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human: famalyTree){
            stringBuilder.append(human.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        Collections.sort(famalyTree, new HumanComporatorByName());
    }

    public  void sortByAge(){
        Collections.sort(famalyTree, new HumanComporatorByAge());
    }



}
