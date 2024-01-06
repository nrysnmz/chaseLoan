package com.example.demo.service;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.*;

public class T {
    String name;

}



class   AA {

     static void loanCreation(){
        System.out.println("Parent");
    }

    public static void main(String[] args) {
        List obj = new ArrayList();

        Map<String,Integer> map = new HashMap<>();
        map.put("Nuray", 33);
        map.put("Nuri", 33);
//        System.out.println(map.toString());


        System.out.println(map.keySet());

    }

}

class BB extends AA {
    static void loanCreation(){
        System.out.println("Child");
    }

    public static void main(String[] args) {

        AA obj  = new BB();
        obj.loanCreation();

    }

}



