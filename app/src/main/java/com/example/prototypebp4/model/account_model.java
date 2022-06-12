package com.example.prototypebp4.model;

public class account_model {
    private String gebruiker;
    private int gewicht;
    private String geslacht;
    private String argument;

    public account_model(){

    }

    public account_model(String gebruiker, int gewicht, String geslacht, String argument){
        this.gebruiker = gebruiker;
        this.gewicht = gewicht;
        this.geslacht = geslacht;
        this.argument = argument;
    }

    public String getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(String gebruiker) {
        this.gebruiker = gebruiker;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }
}
