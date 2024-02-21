package EvaluationLibary;

import HelperClasses.PrisonerPrisonYearsPair;
import Prisoner.Prisoner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ResultFileGenerator implements ResultGenerator{

    public void generateResultFile (int [][] prisonYearMatrix, Prisoner[] prisoners){
        File file = new File("Results.md");
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
