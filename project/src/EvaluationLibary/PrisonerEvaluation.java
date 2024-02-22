package EvaluationLibary;

import HelperClasses.Pair;
import HelperClasses.PrisonerYearsPair;
import HelperClasses.Result;
import Prisoner.Prisoner;

import java.util.ArrayList;

/**
 * Evaluation Class, which calculates the results and generates a result file
 */
public class PrisonerEvaluation implements Evaluation{

    //object, which generates the result file
    private final ResultGenerator resultFileGenerator = new ResultFileGenerator();

    /**
     * starts the evaluation of the tournament
     * @param prisoners: Array with the different Prisoner object of each participant
     * @param numRounds: Number of rounds how often the prisoners should play against each other
     */
    public void evaluation(Prisoner[] prisoners, int numRounds) {
        int[][] prisonYearsMatrix = new int[prisoners.length][prisoners.length];
        int[][] sharedPrisonYearsMatrix = new int[prisoners.length][prisoners.length];
        int[][] resultPrisonYearsMatrix = new int[prisoners.length][prisoners.length];
        Pair<Integer, Integer> pairResultPrisonYears;

        for (int p1 = 0; p1 < prisoners.length; p1++){
            for (int p2 = p1 + 1; p2 < prisoners.length; p2++){
                pairResultPrisonYears = evaluatePair(prisoners[p1], prisoners[p2], numRounds);
                prisonYearsMatrix[p1][p2] = pairResultPrisonYears.getFirst();
                prisonYearsMatrix[p2][p1] = pairResultPrisonYears.getSecond();

                sharedPrisonYearsMatrix[p1][p2] = (pairResultPrisonYears.getFirst() + pairResultPrisonYears.getSecond())/2;
                sharedPrisonYearsMatrix[p2][p1] = (pairResultPrisonYears.getFirst() + pairResultPrisonYears.getSecond())/2;

                resultPrisonYearsMatrix[p1][p2] = pairResultPrisonYears.getFirst() + pairResultPrisonYears.getSecond();
                resultPrisonYearsMatrix[p2][p1] = pairResultPrisonYears.getFirst() + pairResultPrisonYears.getSecond();
            }
        }
        Result result = calculateResult(prisonYearsMatrix, sharedPrisonYearsMatrix, resultPrisonYearsMatrix, prisoners);
        resultFileGenerator.generateResultFile(result);
    }

    /**
     * evaluates the prison years of two participants
     * @param p1: Prisoner object of the first participant of the pair
     * @param p2: Prisoner object of the second participant of the pair
     * @param numRounds: Number of rounds how often the prisoners should play against each other
     * @return Pair object with the prison years of the first and second participant
     */

    private Pair<Integer, Integer> evaluatePair(Prisoner p1, Prisoner p2, int numRounds){
        int p1PrisonYears = 0;
        int p2PrisonYears = 0;
        Boolean p1Decision;
        Boolean p2Decision;
        ArrayList<Boolean> p1DecisionsList = new ArrayList<>();
        ArrayList<Boolean> p2DecisionsList = new ArrayList<>();

        for (int i = 0; i < numRounds; i++) {
            ArrayList<Boolean> p1DecisionsListCopy = p1DecisionsList;
            ArrayList<Boolean> p2DecisionsListCopy = p2DecisionsList;
            p1Decision = p1.makeDecision(p1DecisionsListCopy, p2DecisionsListCopy);
            p2Decision = p2.makeDecision(p2DecisionsListCopy, p1DecisionsListCopy);

            p1DecisionsList.add(p1Decision);
            p2DecisionsList.add(p2Decision);

            p1PrisonYears += calculatePrisonYears(p1DecisionsList.get(i), p2DecisionsList.get(i));
            p2PrisonYears += calculatePrisonYears(p2DecisionsList.get(i), p1DecisionsList.get(i));
        }
        p1.reset();
        p2.reset();
        return new Pair<>(p1PrisonYears, p2PrisonYears);
    }

    /**
     * calculates the prison years of the first participant in context of the decision of the second participant
     * @param p1Decision: decision of the first participant
     * @param p2Decision: decision of the second participant
     * @return prison years of the first participant in context of the decision of the second participant
     */
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

    /**
     * calculates the total prison years of each participant
     * @param prisonYearMatrix: Matrix with the prison years of each participant
     * @param prisoners: Array with the different Prisoner object of each participant
     * @return Array with the total prison years of each participant
     */
    private Result calculateResult (int[][] prisonYearMatrix, int[][] sharedPrisonYearMatrix, int[][] resultPrisonYearsMatrix, Prisoner[] prisoners){
        ArrayList<PrisonerYearsPair> totalPrisonYearsResults = new ArrayList<>();
        ArrayList<PrisonerYearsPair> totalSharedPrisonYearsResults = new ArrayList<>();
        ArrayList<PrisonerYearsPair> totalResultPrisonYearsResults = new ArrayList<>();

        for (int i = 0; i < prisoners.length; i++){
            int totalPrisonYears = 0;
            int totalSharedPrisonYears = 0;
            for (int j = 0; j < prisoners.length; j++){
                totalPrisonYears += prisonYearMatrix[i][j];
                totalSharedPrisonYears += sharedPrisonYearMatrix[i][j];
            }
            int totalResultPrisonYears = totalPrisonYears + totalSharedPrisonYears;
            totalPrisonYearsResults.add(new PrisonerYearsPair(prisoners[i], totalPrisonYears));
            totalSharedPrisonYearsResults.add(new PrisonerYearsPair(prisoners[i], totalSharedPrisonYears));
            totalResultPrisonYearsResults.add(new PrisonerYearsPair(prisoners[i], totalResultPrisonYears));
        }
        Result result = new Result(
                totalPrisonYearsResults.toArray(PrisonerYearsPair[]::new),
                totalSharedPrisonYearsResults.toArray(PrisonerYearsPair[]::new),
                totalResultPrisonYearsResults.toArray(PrisonerYearsPair[]::new),
                prisonYearMatrix,
                sharedPrisonYearMatrix,
                resultPrisonYearsMatrix);
        return result;
    }
}