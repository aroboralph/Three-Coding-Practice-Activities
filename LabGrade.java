/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.labgrade;

/**
 *
 * @author arobo_cpe113
 */
public class LabGrade {

    private String studentName;
    private int quizScore;
    private int labScore;

    public LabGrade(String studentName, int quizScore, int labScore) {
        this.studentName = studentName;

        if (quizScore < 0 || labScore > 100) {
            this.quizScore = 0;
        } else {
            this.quizScore = quizScore;
        }

        if (quizScore < 0 || labScore > 100) {
            this.labScore = 0;
        } else {
            this.labScore = labScore;
        }
    }

    public boolean updateScores(int quizScore, int labScore) {
        if ((quizScore >= 0 && quizScore <= 100) && (labScore >= 00 && labScore <= 100)) {
            this.quizScore = quizScore;
            this.labScore = labScore;
            return true;
        }
        return false;
    }

    public double getFinalGrade() {
        return (this.quizScore * 0.40) + (this.labScore * 0.60);
    }

    public boolean isPassing() {
        return getFinalGrade() >= 75.0;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public static void main(String[] args) {

        LabGrade Grado = new LabGrade("Ana", 80, 90);
        System.out.println(Grado.getFinalGrade() + "; " + (Grado.isPassing() ? "passing" : "not passing"));

        LabGrade ben = new LabGrade("Ben", 101, 85);
        System.out.println(ben.getFinalGrade() + "; " + (ben.isPassing() ? "passing" : "not passing"));

        boolean una = Grado.updateScores(95, 101);
        System.out.println(una + "; grade stays " + Grado.getFinalGrade());

        boolean ikaduha = Grado.updateScores(74, 75);
        System.out.println(ikaduha + "; " + Grado.getFinalGrade() + "; " + (Grado.isPassing() ? "passing" : "not passing"));

        boolean ikatulo = Grado.updateScores(75, 75);
        System.out.println(ikatulo + "; " + Grado.getFinalGrade() + "; " + (Grado.isPassing() ? "passing" : "not passing"));

        System.out.println("Still " + ben.getFinalGrade() + "; " + (ben.isPassing() ? "passing" : "not passing"));
    }
}
//Explanation: Both new scores must be validated before assigning either one so that an invalid second score 
//does not leave the object in a partially updated, inconsistent state. Checking both upfront ensures atomic updates 
//where either both scores change or both remain at their previous valid values