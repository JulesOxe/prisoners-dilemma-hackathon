package Prisoner;

import java.util.ArrayList;

public class PrisonerE extends Prisoner {

    public PrisonerE() {
        teamName = "OpponentLoop";
    }

    public Boolean makeDecision(ArrayList<Boolean> myDecisions, ArrayList<Boolean> opponentDecisions) {
        boolean result = false;
        for (Boolean opponentDecision : opponentDecisions) {
            if (opponentDecision) {
                result = !result;
            }
        }
        return result;
    }

    public void reset() {
    }
}