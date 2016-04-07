package com.example.thier.demo;

import java.io.Serializable;

/**
 * Created by Wendy on 5-4-2016.
 */
public class Method implements Serializable {           // WAAROM serializable

    public String methode;
    public String score;
    public String weight;
    public String endscore;


    public Method(String methode, String score, String weight, String endscore){
        this.methode = methode;
        this.score = score;
        this.weight = weight;
        this.endscore = endscore;
    }

    // ADD GETTERS

    // ADD SETTERS
}