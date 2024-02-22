package Prisoner;

import java.util.ArrayList;

public class PrisonerD extends Prisoner {

    public PrisonerD() {
        teamName = "MyLoop";
    }

    public Boolean makeDecision(ArrayList<Boolean> myDecisions, ArrayList<Boolean> opponentDecisions) {
        boolean result = true;
        for (Boolean myDecision : myDecisions) {
            if (myDecision) {
                result = !result;
            }
        }
        return result;
    }

    public void reset() {
    }
}