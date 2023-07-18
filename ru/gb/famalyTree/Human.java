package ru.gb.famalyTree;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Human {
    private String name;
    private LocalDate bornDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private Gender gender;
    private List<Human> children;
    int age;


    public Human (String name, Gender gender, Human mother, Human father, LocalDate bornDate, LocalDate deathDate){
        this.name = name;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        if(this.mother!=null){
            if(mother.children == null){
            mother.children = new ArrayList<>();
            mother.children.add(this);
            father.children = new ArrayList<>();
            father.children.add(this);
            }else{mother.children.add(this);
                father.children.add(this);
            }
        }
        this.bornDate = bornDate;
        this.deathDate = deathDate;
        this.age = Period.between(bornDate, deathDate).getYears();
    }

    public Human (String name, Gender gender, Human mother, Human father, LocalDate bornDate){
        this.name = name;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.bornDate = bornDate;
        if(this.mother!=null){
            if(mother.children == null){
                mother.children = new ArrayList<>();
                mother.children.add(this);
                father.children = new ArrayList<>();
                father.children.add(this);
            }else{mother.children.add(this);
                father.children.add(this);
            }
        }
        Date date = new Date();
        LocalDate now = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.age = Period.between(bornDate, now).getYears();
    }


    public String getChild (){
        StringBuilder stringBuilder = new StringBuilder();
        if (children == null){
            return "";
        }
        stringBuilder.append(", children: ");
        for(Human children: children){
            stringBuilder.append(children.name);
            stringBuilder.append("; ");
        }
        return stringBuilder.toString();
    }

public String toString(){
        if (mother==null && father==null){
            return "name: " + name + ", gender: " + gender + ", mother: Данных о матери нет " + ", father: Данных об отце нет " + ", age: "+ age + getChild();
        }

        return "name: " + name + ", gender: " + gender + ", mother: " + mother.name + ", father: " + father.name + ", age: "+ age  + getChild();
}


public String getDegreeOfKinship(Human human1){

    if(human1.mother.equals(this)){
        return this.name + " являeтся матерью " + human1.name;
    }
    if(human1.father.equals(this)){
        return this.name + " являeтся отцом " + human1.name;
    }
    if(this.mother.equals(human1)){
        if(this.gender.equals(Gender.Male)){
            return this.name + " являeтся сыном " + human1.name;
        }else return this.name + " являeтся дочерью " + human1.name;
    }
    if(this.mother.equals(human1.mother)){
        if(this.gender.equals(human1.gender)){
            if(this.gender.equals(Gender.Male)){
                return this.name + " и " + human1.name + " являются братьями";
            }else return this.name + " и " + human1.name + " являются сёстрами";
        }else return this.name + " и " + human1.name + " являются братом и сестрой";
    }

        return "";}
}

