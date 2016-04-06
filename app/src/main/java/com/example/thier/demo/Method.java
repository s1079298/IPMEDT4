package com.example.thier.demo;

import java.io.Serializable;

/**
 * Created by Wendy on 5-4-2016.
 */
public class Method implements Serializable {           // WAAROM serializable

    public String methode;
    public String endscore;


    public Method(String methode, String endscore){
        this.methode = methode;
        this.endscore = endscore;
    }

    // ADD GETTERS

    // ADD SETTERS
}