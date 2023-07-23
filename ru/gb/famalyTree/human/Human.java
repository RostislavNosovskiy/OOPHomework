package ru.gb.famalyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;

public class Human implements Serializable {
    private String name;
    private LocalDate bornDate;
    private LocalDate deathDate;
    private List<Human> parents;
    private Gender gender;
    private List<Human> childrens;
    private Human spouse;



    public Human (String name, Gender gender, LocalDate bornDate, LocalDate deathDate, Human father, Human mother){
        this.name = name;
        this.gender = gender;
        parents = new ArrayList<>();
        if (father != null){
            parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }

        this.bornDate = bornDate;
        this.deathDate = deathDate;

        childrens = new ArrayList<>();
    }

    public Human (String name, Gender gender,  LocalDate bornDate, LocalDate deathDate) {
        this(name, gender, bornDate, deathDate, null, null);
    }
    public Human (String name, Gender gender,  LocalDate bornDate) {
        this(name, gender, bornDate, null, null, null);
    }
    public Human(String name, Gender gender,  LocalDate bornDate, Human father, Human mother){
        this(name, gender, bornDate, null,  father, mother);
    }

    public int getAge(){
        if (deathDate != null){
            return  Period.between(bornDate, deathDate).getYears();
        }else {
            Date date = new Date();
            LocalDate now = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return Period.between(bornDate, now).getYears();
        }
    }


    public boolean addParent(Human parent){
        if(!parents.contains(parent)){
            parents.add(parent);
            return true;
        }
        return false;
    }

    public boolean addChildren(Human children){
        if(!childrens.contains(children)){
            childrens.add(children);
            return true;
        }
        return false;
    }
    public Human getMother(){
        for(Human parent : parents){
            if(parent.gender.equals(Gender.Female)){
                return parent;
            }
        }return null;
    }
    public Human getFather(){
        for(Human parent : parents){
            if(parent.gender.equals(Gender.Male)){
                return parent;
            }
        }return null;
    }

    public String getName(){
        return name;
    }
    public Human getSpouse(){
        return spouse;
    }
    public void setSpouse(Human human){
        spouse = human;
    }

    public LocalDate getBornDate(){
        return bornDate;
    }
    public LocalDate getDeathDate(){
        return deathDate;
    }
    public List<Human> getChild(){return childrens;}

    public List<Human> getParents(){return parents;}

public String toString(){
        return getInfo();
}
    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("имя: ");
        stringBuilder.append(name);
        stringBuilder.append(", пол: ");
        stringBuilder.append(gender);
        stringBuilder.append(", возраст: ");
        stringBuilder.append(getAge());
        stringBuilder.append(getSpouseInfo());
        stringBuilder.append(getMotherInfo());
        stringBuilder.append(getFatherInfo());
        stringBuilder.append(getChildInfo());

        return  stringBuilder.toString();
    }

    public String getMotherInfo(){
        StringBuilder res = new StringBuilder();
        res.append(", мать: ");
        if (getMother()!=null){
            res.append(getMother().name);
        }else {res.append(" нет информации");}
    return res.toString();}

    public String getFatherInfo(){
        StringBuilder res = new StringBuilder();
        res.append(", отец: ");
        if (getFather()!=null){
            res.append(getFather().name);
        }else {res.append(" нет информации");}
        return res.toString();}

    public String getSpouseInfo(){
        StringBuilder res = new StringBuilder();
        res.append(", супруг(-а): ");
        if (spouse!=null){
            res.append(spouse.name);
        }else {res.append(" нет");}
        return res.toString();}


    public String getChildInfo(){
        StringBuilder res = new StringBuilder();
        res.append(", дети: ");
        if (childrens.size()!=0){
            res.append(childrens.get(0).name);
            for (int i = 1; i < childrens.size() ; i++) {
               res.append(", ");
               res.append(childrens.get(i).name);
            }
        }else {res.append(" нет");}
        return res.toString();
    }

    public boolean equals(Human human){
       return human.getName().equals(getName()) && human.getBornDate().equals(getBornDate());
    }

}

