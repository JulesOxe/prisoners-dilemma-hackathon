package Prisoner;

import java.util.ArrayList;

public class PrisonerF extends Prisoner {

    private Boolean result = true;

    public PrisonerF() {
        teamName = "MySavedResult";
    }

    public Boolean makeDecision(ArrayList<Boolean> myDecisions, ArrayList<Boolean> opponentDecisions) {
        if (!myDecisions.isEmpty()) {
            if (myDecisions.get(myDecisions.size() - 1)) {
                result = !result;
            }
        }
        return result;
    }

    public void reset() {
        result = true;
    }
}
