package EvaluationLibary;
import HelperClasses.Pair;
import Prisoner.Prisoner;

import java.util.ArrayList;

public class PrisonerEvaluation implements Evaluation{

    private final int NUM_ROUNDS = 1000;

    public String[] evaluation(Prisoner[] prisoners) {
        int[][] prisonYearsMatrix = new int[prisoners.length][prisoners.length];
        Pair<Integer, Integer> pairResultPrisonYears;

        for (int p1 = 0; p1 < prisoners.length; p1++){
            for (int p2 = p1 + 1; p2 < prisoners.length; p2++){
                pairResultPrisonYears = evaluatePair(prisoners[p1], prisoners[p2]);
                prisonYearsMatrix[p1][p2] = pairResultPrisonYears.getFirst();
                prisonYearsMatrix[p2][p1] = pairResultPrisonYears.getSecond();
            }
        }
        return calculateResult(prisonYearsMatrix, prisoners);
    }

    private Pair<Integer, Integer> evaluatePair(Prisoner p1, Prisoner p2) {
        int p1PrisonYears = 0;
        int p2PrisonYears = 0;
        ArrayList<Boolean> p1Decisions = new ArrayList<Boolean>();
        ArrayList<Boolean> p2Decisions = new ArrayList<Boolean>();

        for (int i = 0; i < NUM_ROUNDS; i++) {
            p1Decisions.add(p1.makeDecision(p1Decisions, p2Decisions));
            p2Decisions.add(p2.makeDecision(p2Decisions, p1Decisions));

            p1PrisonYears += calculatePrisonYears(p1Decisions.get(i), p2Decisions.get(i));
            p2PrisonYears += calculatePrisonYears(p2Decisions.get(i), p1Decisions.get(i));
        }
        return new Pair<Integer, Integer>(p1PrisonYears, p2PrisonYears);
    }

    private int calculatePrisonYears (Boolean p1Decision, Boolean p2Decision) {
        if (p1Decision && p2Decision) {
            return 2;
        } else if (p1Decision && !p2Decision) {
            return 0;
        } else if (!p1Decision && p2Decision) {
            return 3;
        }
        return 1;
    }

    private String[] calculateResult (int[][] prisonYearMatrix, Prisoner[] prisoners){
        String[] resultStrings = new String[prisoners.length];
        int totalPrisonYears;
        for (int i = 0; i < prisoners.length; i++){
            totalPrisonYears = 0;
            for (int j = 0; j < prisoners.length; j++){
                totalPrisonYears += prisonYearMatrix[i][j];
            }
            resultStrings[i] = String.format("Prisoner.Prisoner %s have to be %s years in prison.", prisoners[i].getTeamName(), totalPrisonYears);
        }
        return resultStrings;
    }
}