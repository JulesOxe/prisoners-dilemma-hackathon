package EvaluationLibary;

import HelperClasses.Result;

/**
 * Interface for a result generator module, which generates a visualization of the results
 */

public interface ResultGenerator {

    /**
     * Method signature for expected method to generate a result file
     *
     * @param result the result object to be visualized
     */
    public void generateResultFile(Result result);

}
