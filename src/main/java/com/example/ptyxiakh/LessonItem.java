package com.example.ptyxiakh;

public class LessonItem {
    private String examino;
    private String kodikos;
    private String titlos;
    private String eidos ;
    private String theoria ;
    private String ergastirio ;
    private String ects ;

    public LessonItem(String examino, String kodikos, String titlos, String eidos, String theoria, String ergastirio, String ects) {
        this.examino = examino;
        this.kodikos = kodikos;
        this.titlos = titlos;
        this.eidos = eidos;
        this.theoria = theoria;
        this.ergastirio = ergastirio;
        this.ects = ects;
    }

    public String getExamino() {
        return examino;
    }

    public void setExamino(String examino) {
        this.examino = examino;
    }

    public String getKodikos() {
        return kodikos;
    }

    public void setKodikos(String kodikos) {
        this.kodikos = kodikos;
    }

    public String getTitlos() {
        return titlos;
    }

    public void setTitlos(String titlos) {
        this.titlos = titlos;
    }

    public String getEidos() {
        return eidos;
    }

    public void setEidos(String eidos) {
        this.eidos = eidos;
    }

    public String getTheoria() {
        return theoria;
    }

    public void setTheoria(String theoria) {
        this.theoria = theoria;
    }

    public String getErgastirio() {
        return ergastirio;
    }

    public void setErgastirio(String ergastirio) {
        this.ergastirio = ergastirio;
    }

    public String getEcts() {
        return ects;
    }

    public void setEcts(String ects) {
        this.ects = ects;
    }
}
