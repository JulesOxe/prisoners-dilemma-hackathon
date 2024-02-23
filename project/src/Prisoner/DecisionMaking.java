package Prisoner;

import java.util.ArrayList;

/**
 * Interface for a prisoner module, which generates a decision based on the previous decisions of the opponent and the prisoner itself
 */
public interface DecisionMaking {

    /**
     * Method signature for expected method to generate a decision
     *
     * @param myDecisions:       ArrayList with the previous decisions of the prisoner
     * @param opponentDecisions: ArrayList with the previous decisions of the opponent
     * @return: Boolean value for the decision of the prisoner (true for cooperate, false for defect)
     */
    public Boolean makeDecision(ArrayList<Boolean> myDecisions, ArrayList<Boolean> opponentDecisions);

    /**
     * Method signature for expected method to reset the prisoner's memory
     */
    public void reset();
}
