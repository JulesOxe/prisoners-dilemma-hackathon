package Prisoner;

import java.util.ArrayList;

public class PrisonerH extends Prisoner {

    public PrisonerH() {
        teamName = "DoubleLoop";
    }

    public Boolean makeDecision(ArrayList<Boolean> myDecisions, ArrayList<Boolean> opponentDecisions) {
        Boolean myResult = true;
        Boolean opponetResult = false;
        for (Boolean myDecision : myDecisions) {
            if (myDecision) {
                myResult = !myResult;
            }
        }
        for (Boolean opponentDecision : opponentDecisions) {
            if (!opponentDecision) {
                opponetResult = !opponetResult;
            }
        }
        return myResult && opponetResult;
    }

    public void reset() {
    }

}