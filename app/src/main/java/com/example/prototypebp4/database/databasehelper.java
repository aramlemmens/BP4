package com.example.prototypebp4.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.prototypebp4.database.DataTables.*;

public class databasehelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Data.db";

    public static final String SQL_CREATE_GEBRUIKERS = "create table " + Gebruikers.TABLE_NAME + " (" +
            Gebruikers.COLUMN_NAME_GEBRUIKER + " text primary key)";

    public static final String SQL_CREATE_RESULTAATEN = "create table " + Resultaaten.TABLE_NAME + " (" +
            Resultaaten.COLUMN_NAME_RESULTAAT + " text primary key)";

    public static final String SQL_CREATE_GESLACHTEN = "create table " + Geslachten.TABLE_NAME + " (" +
            Geslachten.COLUMN_NAME_GESLACHT + " text primary key)";

    public static final String SQL_CREATE_SCORES = "create table " + Scores.TABLE_NAME + " (" +
            Scores.COLUMN_NAME_SCORE + " text primary key)";

    public static final String SQL_CREATE_ARGUMENTEN = "create table " + Argumenten.TABLE_NAME + " (" +
            Argumenten.COLUMN_NAME_ARGUMENT + " text primary key)";

    public static final String SQL_CREATE_GEWICHTEN = "create table " + Gewichten.TABLE_NAME + " (" +
            Gewichten.COLUMN_NAME_GEWICHT + " text primary key)";

    public static final String SQL_CREATE_REACTIEVERMOGENS = "create table " + Reactievermogens.TABLE_NAME + " (" +
            Reactievermogens.COLUMN_NAME_REACTIEVERMOGEN + " text primary key)";

    public static final String SQL_CREATE_GebruikerResultaatGeslachtScore = "create table " + GebruikerResultaatGeslachtScore.TABLE_NAME + " (" +
            GebruikerResultaatGeslachtScore.COLUMN_NAME_GEBRUIKER + " text," +
            GebruikerResultaatGeslachtScore.COLUMN_NAME_RESULTAAT + " integer," +
            GebruikerResultaatGeslachtScore.COLUMN_NAME_GESLACHT + " text," +
            GebruikerResultaatGeslachtScore.COLUMN_NAME_SCORE + " integer, " +
            "foreign key ("+ GebruikerResultaatGeslachtScore.COLUMN_NAME_GEBRUIKER +") references " + Gebruikers.TABLE_NAME + "("+ Gebruikers._ID + "), " +
            "foreign key ("+ GebruikerResultaatGeslachtScore.COLUMN_NAME_GESLACHT +") references " + Geslachten.TABLE_NAME + "("+ Geslachten._ID + "))";

    public static final String SQL_CREATE_GebruikerGewichtGeslachtArgument = "create table " + GebruikerGewichtGeslachtArgument.TABLE_NAME + " (" +
            GebruikerGewichtGeslachtArgument.COLUMN_NAME_GEBRUIKER + " text," +
            GebruikerGewichtGeslachtArgument.COLUMN_NAME_GEWICHT + " integer," +
            GebruikerGewichtGeslachtArgument.COLUMN_NAME_GESLACHT + " text," +
            GebruikerGewichtGeslachtArgument.COLUMN_NAME_ARGUMENT + " text, " +
            "foreign key ("+ GebruikerGewichtGeslachtArgument.COLUMN_NAME_GEBRUIKER +") references " + Gebruikers.TABLE_NAME + "("+ Gebruikers._ID + "), " +
            "foreign key ("+ GebruikerGewichtGeslachtArgument.COLUMN_NAME_GEWICHT +") references " + Gewichten.TABLE_NAME + "("+ Gewichten._ID + "), " +
            "foreign key ("+ GebruikerGewichtGeslachtArgument.COLUMN_NAME_ARGUMENT +") references " + Argumenten.TABLE_NAME + "("+ Argumenten._ID + "))";

    public static final String SQL_CREATE_GebruikerGamemodeGeslachtReactievermogenRestultaat = "create table " + GebruikerGamemodeGeslachtReactievermogenRestultaat.TABLE_NAME + " (" +
            GebruikerGamemodeGeslachtReactievermogenRestultaat.COLUMN_NAME_GEBRUIKER + " text," +
            GebruikerGamemodeGeslachtReactievermogenRestultaat.COLUMN_NAME_GAMEMODES + " text primary key," +
            GebruikerGamemodeGeslachtReactievermogenRestultaat.COLUMN_NAME_SCORE + " integer," +
            GebruikerGamemodeGeslachtReactievermogenRestultaat.COLUMN_NAME_REACTIEVERMOGEN + " text," +
            GebruikerGamemodeGeslachtReactievermogenRestultaat.COLUMN_NAME_RESULTAAT + " integer, " +
            "foreign key ("+ GebruikerGamemodeGeslachtReactievermogenRestultaat.COLUMN_NAME_GEBRUIKER +") references " + Gebruikers.TABLE_NAME + "("+ Gebruikers._ID + "), " +
            "foreign key ("+ GebruikerGamemodeGeslachtReactievermogenRestultaat.COLUMN_NAME_SCORE +") references " + Scores.TABLE_NAME + "("+ Scores._ID + "), " +
            "foreign key ("+ GebruikerGamemodeGeslachtReactievermogenRestultaat.COLUMN_NAME_REACTIEVERMOGEN +") references " + Reactievermogens.TABLE_NAME + "("+ Reactievermogens._ID + "), " +
            "foreign key ("+ GebruikerGamemodeGeslachtReactievermogenRestultaat.COLUMN_NAME_RESULTAAT +") references " + Resultaaten.TABLE_NAME + "("+ Resultaaten._ID + "))";

    public databasehelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_GEBRUIKERS);
        db.execSQL(SQL_CREATE_RESULTAATEN);
        db.execSQL(SQL_CREATE_GESLACHTEN);
        db.execSQL(SQL_CREATE_SCORES);
        db.execSQL(SQL_CREATE_ARGUMENTEN);
        db.execSQL(SQL_CREATE_GEWICHTEN);
        db.execSQL(SQL_CREATE_REACTIEVERMOGENS);
        db.execSQL(SQL_CREATE_GebruikerResultaatGeslachtScore);
        db.execSQL(SQL_CREATE_GebruikerGewichtGeslachtArgument);
        db.execSQL(SQL_CREATE_GebruikerGamemodeGeslachtReactievermogenRestultaat);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
    }

}
