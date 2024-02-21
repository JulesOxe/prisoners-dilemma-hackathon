package EvaluationLibary;

import Prisoner.Prisoner;

/**
 * Interface for an evaluation module, which generates a result for a given array of prisoner algorithms
 */

public interface Evaluation {

    /**
     * Method signature for expected method to generate a result
     * @param prisoners: Array with the different Prisoner object of each participant
     * @param numRounds: Number of rounds how often the prisoners should play against each other
     */
    public void evaluation(Prisoner[] prisoners, int numRounds);
}
