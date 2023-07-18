package ru.gb.famalyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human human10 = null;
        Human human11 = null;
        Human human12 = null;
        Human human13 = null;
        Human human14 = null;
        Human human15 = null;
        Human human16 = null;
        Human human17 = null;
        Human human6 = new Human("Геннадий", Gender.Male,human10,human11,LocalDate.of(1947,8 , 13));
        Human human7 = new Human("Галина", Gender.Female,human12,human13,LocalDate.of(1954,11 , 11));
        Human human4 = new Human("Валентина", Gender.Female,human15,human14, LocalDate.of(1952, 2, 10));
        Human human5 = new Human("Александр", Gender.Male, human16,human17,LocalDate.of(1949,10 , 20), LocalDate.of(2002, 9, 15));
        Human human2 = new Human("Алла", Gender.Female,human4, human5,LocalDate.of(1976, 5, 19));
        Human human3 = new Human("Олег", Gender.Male,human7, human6,LocalDate.of(1972,3 , 21));
        Human human1 = new Human("Ростислав", Gender.Male, human2, human3, LocalDate.of(2003, 3, 4));
        Human human8 = new Human("Роман", Gender.Male, human2, human3, LocalDate.of(1998, 8, 18));
        Human human9 = new Human("Игорь", Gender.Male,human4, human5,LocalDate.of(1971, 10, 30));

        FamalyTree famalyTree = new FamalyTree();
        famalyTree.addHuman(human1);
        famalyTree.addHuman(human2);
        famalyTree.addHuman(human3);
        famalyTree.addHuman(human4);
        famalyTree.addHuman(human5);
        famalyTree.addHuman(human6);
        famalyTree.addHuman(human7);
        famalyTree.addHuman(human8);
        famalyTree.addHuman(human9);



        System.out.println(famalyTree.getFamalyTreeInfo());
        System.out.println(human1.getDegreeOfKinship(human2));
        System.out.println(human1.getDegreeOfKinship(human8));
        System.out.println(human3.getDegreeOfKinship(human1));
        System.out.println(human7.getDegreeOfKinship(human3));

    }
}
