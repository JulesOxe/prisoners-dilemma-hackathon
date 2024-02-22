package EvaluationLibary;

import HelperClasses.Result;
import Prisoner.Prisoner;

/**
 * Interface for a result generator module, which generates a visualization of the results
 */

public interface ResultGenerator {

    /**
     * Method signature for expected method to generate a result file
     * @param prisonYearMatrix: Matrix with the prison years of each pair of prisoners
     * @param prisoners: Array with the different Prisoner object of each participant
     * @param totalPrisonYears: Array with the total prison years of each participant
     */
    public void generateResultFile (Result result);

}
