package com.example.prototypebp4.database;

import android.provider.BaseColumns;

public class DataTables {

    private DataTables(){

    }

    public static class Gebruikers implements BaseColumns {
        public static final String TABLE_NAME = "gebruikers";
        public static final String COLUMN_NAME_GEBRUIKER = "gebruiker";
    }

    public static class Resultaaten implements BaseColumns {
        public static final String TABLE_NAME = "resultaaten";
        public static final String COLUMN_NAME_RESULTAAT = "resultaat";
    }

    public static class Geslachten implements BaseColumns {
        public static final String TABLE_NAME = "geslachten";
        public static final String COLUMN_NAME_GESLACHT = "geslacht";
    }

    public static class Scores implements BaseColumns {
        public static final String TABLE_NAME = "scores";
        public static final String COLUMN_NAME_SCORE = "score";
    }

    public static class Argumenten implements BaseColumns {
        public static final String TABLE_NAME = "argumenten";
        public static final String COLUMN_NAME_ARGUMENT = "argument";
    }

    public static class Gewichten implements BaseColumns {
        public static final String TABLE_NAME = "gewichten";
        public static final String COLUMN_NAME_GEWICHT = "gewicht";
    }

    public static class Reactievermogens implements BaseColumns {
        public static final String TABLE_NAME = "reactievermogens";
        public static final String COLUMN_NAME_REACTIEVERMOGEN = "reactievermogen";
    }

    public static class GebruikerResultaatGeslachtScore implements BaseColumns {
        public static final String TABLE_NAME = "gebruikerresultaatgeslachtscore";
        public static final String COLUMN_NAME_GEBRUIKER = "gebruiker";
        public static final String COLUMN_NAME_RESULTAAT = "resultaat";
        public static final String COLUMN_NAME_GESLACHT = "geslacht";
        public static final String COLUMN_NAME_SCORE = "score";

    }

    public static class GebruikerGewichtGeslachtArgument implements BaseColumns {
        public static final String TABLE_NAME = "gebruikergewichtagumentargument";
        public static final String COLUMN_NAME_GEBRUIKER = "gebruiker";
        public static final String COLUMN_NAME_GEWICHT = "gewicht";
        public static final String COLUMN_NAME_GESLACHT = "geslacht";
        public static final String COLUMN_NAME_ARGUMENT = "argument";

    }

    public static class GebruikerGamemodeGeslachtReactievermogenRestultaat implements BaseColumns {
        public static final String TABLE_NAME = "gebruikergamemodegeslachtreactievermogenrestultaat";
        public static final String COLUMN_NAME_GEBRUIKER = "gebruiker";
        public static final String COLUMN_NAME_GAMEMODES = "gamemodes";
        public static final String COLUMN_NAME_SCORE = "score";
        public static final String COLUMN_NAME_REACTIEVERMOGEN = "reactievermogen";
        public static final String COLUMN_NAME_RESULTAAT = "resultaat";
    }

}
