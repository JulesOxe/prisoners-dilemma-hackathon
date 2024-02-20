package EvaluationLibary;
import HelperClasses.Pair;
import HelperClasses.PrisonerPrisonYearsPair;
import Prisoner.Prisoner;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PrisonerEvaluation implements Evaluation{

    private final int NUM_ROUNDS = 1000;

    public void evaluation(Prisoner[] prisoners) {
        int[][] prisonYearsMatrix = new int[prisoners.length][prisoners.length];
        Pair<Integer, Integer> pairResultPrisonYears;

        for (int p1 = 0; p1 < prisoners.length; p1++){
            for (int p2 = p1 + 1; p2 < prisoners.length; p2++){
                pairResultPrisonYears = evaluatePair(prisoners[p1], prisoners[p2]);
                prisonYearsMatrix[p1][p2] = pairResultPrisonYears.getFirst();
                prisonYearsMatrix[p2][p1] = pairResultPrisonYears.getSecond();
            }
        }
        calculateResult(prisonYearsMatrix, prisoners);
    }

    private Pair<Integer, Integer> evaluatePair(Prisoner p1, Prisoner p2) {
        int p1PrisonYears = 0;
        int p2PrisonYears = 0;
        ArrayList<Boolean> p1Decisions = new ArrayList<>();
        ArrayList<Boolean> p2Decisions = new ArrayList<>();

        for (int i = 0; i < NUM_ROUNDS; i++) {
            p1Decisions.add(p1.makeDecision(p1Decisions, p2Decisions));
            p2Decisions.add(p2.makeDecision(p2Decisions, p1Decisions));

            p1PrisonYears += calculatePrisonYears(p1Decisions.get(i), p2Decisions.get(i));
            p2PrisonYears += calculatePrisonYears(p2Decisions.get(i), p1Decisions.get(i));
        }
        return new Pair<>(p1PrisonYears, p2PrisonYears);
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

    private void calculateResult (int [][] prisonYearMatrix, Prisoner[] prisoners){
        File file = new File("Ergebnisse.md");
        StringBuilder str = new StringBuilder();
        str.append("# Results: \n");
        str.append("## Total result: \n");
        str.append(totalResult(prisonYearMatrix, prisoners));
        str.append("## Team results: \n");
        str.append(teamResults(prisonYearMatrix, prisoners));
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(str.toString());
            writer.close();
        }
        catch(IOException ioe) {
            System.err.println(ioe);
        }
    }

    private String totalResult (int[][] prisonYearMatrix, Prisoner[] prisoners){
        PrisonerPrisonYearsPair[] ppyPair = calculateTotalPrisonYears(prisonYearMatrix, prisoners);
        StringBuilder str = new StringBuilder();
        str.append(String.format("### 1st place: Team %s with %s years in prison. \n", ppyPair[0].getFirst().getTeamName(), ppyPair[0].getSecond()));
        str.append(String.format("### 2nd place: Team %s with %s years in prison. \n", ppyPair[1].getFirst().getTeamName(), ppyPair[1].getSecond()));
        str.append(String.format("### 3rd place: Team %s with %s years in prison. \n", ppyPair[2].getFirst().getTeamName(), ppyPair[2].getSecond()));
        str.append("### Other teams: \n");
        for(int i = 3; i < ppyPair.length; i++){
            str.append(String.format("%s. Team %s: %s prison years. \n", i+1, ppyPair[i].getFirst().getTeamName(), ppyPair[i].getSecond()));
        }
        return str.toString();
    }

    private PrisonerPrisonYearsPair[] calculateTotalPrisonYears (int[][] prisonYearMatrix, Prisoner[] prisoners){
        PrisonerPrisonYearsPair[] result = new PrisonerPrisonYearsPair[prisoners.length];
        int totalPrisonYears;
        for (int i = 0; i < prisoners.length; i++){
            totalPrisonYears = 0;
            for (int j = 0; j < prisoners.length; j++){
                totalPrisonYears += prisonYearMatrix[i][j];
            }
            result[i] = new PrisonerPrisonYearsPair(prisoners[i], totalPrisonYears);
        }
        Arrays.sort(result, PrisonerPrisonYearsPair.PrisonYearsComparator);
        return result;
    }

    private String teamResults (int [][] prisonYearMatrix, Prisoner[] prisoners){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < prisoners.length; i++){
            str.append(String.format("- ### %s: \n", prisoners[i].getTeamName()));
            str.append("|Opponent|Opponent Prison Years|My Teams Prison Years| \n");
            str.append("|---|---|---| \n");
            for (int j = 0; j < prisoners.length; j++){
                if (i != j) {
                    str.append(String.format("| %s | %s | %s |\n", prisoners[j].getTeamName(), prisonYearMatrix[j][i], prisonYearMatrix[i][j]));
                }
            }
        }
        return  str.toString();
    }
}