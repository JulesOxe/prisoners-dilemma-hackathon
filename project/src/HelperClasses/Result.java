package HelperClasses;

import java.util.Comparator;

public class Result {
    private PrisonerYearsPair[] totalPrisonYears;
    private PrisonerYearsPair[] totalSharedPrisonYears;
    private PrisonerYearsPair[] totalResultPrisonYears;
    private int [][] prisonYearsMatrix;
    private int [][] sharedPrisonYearsMatrix;
    private int [][] resultPrisonYearsMatrix;


    public Result(PrisonerYearsPair[] prisonYears,
                  PrisonerYearsPair[] sharedPrisonYears,
                  PrisonerYearsPair[] resultPrisonYears,
                  int[][] prisonYearsMatrix,
                  int[][] sharedPrisonYearsMatrix,
                  int[][] resultPrisonYearsMatrix) {
        this.totalPrisonYears = prisonYears;
        this.totalSharedPrisonYears = sharedPrisonYears;
        this.totalResultPrisonYears = resultPrisonYears;
        this.prisonYearsMatrix = prisonYearsMatrix;
        this.sharedPrisonYearsMatrix = sharedPrisonYearsMatrix;
        this.resultPrisonYearsMatrix = resultPrisonYearsMatrix;
    }

    public PrisonerYearsPair[] getTotalPrisonYears() {
        return totalPrisonYears;
    }

    public PrisonerYearsPair[] getTotalSharedPrisonYears() {
        return totalSharedPrisonYears;
    }

    public PrisonerYearsPair[] getTotalResultPrisonYears() {
        return totalResultPrisonYears;
    }

    public int[][] getPrisonYearsMatrix() {
        return prisonYearsMatrix;
    }

    public int[][] getSharedPrisonYearsMatrix() {
        return sharedPrisonYearsMatrix;
    }

    public int[][] getResultPrisonYearsMatrix() {
        return resultPrisonYearsMatrix;
    }

    /*public static Comparator<Result> TotalPrisonYearsComparator = new Comparator<Result>() {

        public int compare(Result r1, Result r2) {
            Integer totalPrisonYears1 = r1.getTotalPrisonYears();
            Integer totalPrisonYears2 = r2.getTotalPrisonYears();
            return totalPrisonYears1.compareTo(totalPrisonYears2);
        }
    };

    public static Comparator<Result> ToatalSharedPrisonYearsComparator = new Comparator<Result>() {

        public int compare(Result r1, Result r2) {
            Integer totalSharedPrisonYears1 = r1.getTotalSharedPrisonYears();
            Integer totalSharedPrisonYears2 = r2.getTotalSharedPrisonYears();
            return totalSharedPrisonYears1.compareTo(totalSharedPrisonYears2);
        }
    };

    public static Comparator<Result> TotalResultPrisonYearsComparator = new Comparator<Result>() {

        public int compare(Result r1, Result r2) {
            Integer totalResultPrisonYears1 = r1.getTotalPrisonYears();
            Integer totalResultPrisonYears2 = r2.getTotalPrisonYears();
            return totalResultPrisonYears1.compareTo(totalResultPrisonYears2);
        }
    };*/
}