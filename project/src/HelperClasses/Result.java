package HelperClasses;

/**
 * This class is used to store the result of the calculation of the total prison years, the shared prison years and the
 * result prison years. It also stores the matrices of the total prison years, the shared prison years and the result
 * prison years.
 */
public class Result {
    private final PrisonerYearsPair[] totalPrisonYears;
    private final PrisonerYearsPair[] totalSharedPrisonYears;
    private final PrisonerYearsPair[] totalResultPrisonYears;
    private final int[][] prisonYearsMatrix;
    private final int[][] sharedPrisonYearsMatrix;
    private final int[][] resultPrisonYearsMatrix;

    /**
     * Constructor for the Result class.
     *
     * @param prisonYears             The total prison years.
     * @param sharedPrisonYears       The shared prison years.
     * @param resultPrisonYears       The result prison years.
     * @param prisonYearsMatrix       The matrix of the total prison years.
     * @param sharedPrisonYearsMatrix The matrix of the shared prison years.
     * @param resultPrisonYearsMatrix The matrix of the result prison years.
     */
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

    /**
     * returns the array with the total prison years of each participant.
     *
     * @return The total prison years.
     */
    public PrisonerYearsPair[] getTotalPrisonYears() {
        return totalPrisonYears;
    }

    /**
     * returns the array with the shared prison years of each participant.
     *
     * @return The shared prison years.
     */
    public PrisonerYearsPair[] getTotalSharedPrisonYears() {
        return totalSharedPrisonYears;
    }

    /**
     * returns the array with the result prison years of each participant.
     *
     * @return The result prison years.
     */
    public PrisonerYearsPair[] getTotalResultPrisonYears() {
        return totalResultPrisonYears;
    }

    /**
     * returns the matrix with the total prison years of each participant.
     *
     * @return The matrix of the total prison years.
     */
    public int[][] getPrisonYearsMatrix() {
        return prisonYearsMatrix;
    }

    /**
     * returns the matrix with the shared prison years of each participant.
     *
     * @return The matrix of the shared prison years.
     */
    public int[][] getSharedPrisonYearsMatrix() {
        return sharedPrisonYearsMatrix;
    }

    /**
     * returns the matrix with the result prison years of each participant.
     *
     * @return The matrix of the result prison years.
     */
    public int[][] getResultPrisonYearsMatrix() {
        return resultPrisonYearsMatrix;
    }
}