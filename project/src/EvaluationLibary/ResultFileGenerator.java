package EvaluationLibary;

import HelperClasses.PrisonerYearsPair;
import HelperClasses.Result;
import Prisoner.Prisoner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * ResultFileGenerator class, which generates the result file
 */

public class ResultFileGenerator implements ResultGenerator{

    /**
     * generates the result file
     * @param prisonYearMatrix: Matrix with the prison years of each participant
     * @param prisoners: Array with the different Prisoner object of each participant
     * @param totalPrisonYears: Array with the total prison years of each participant
     */
    public void generateResultFile (Result result){

        String totalPrisonYearsContent = contentGenerator("", result);
        String sharedPrisonYearsContent = contentGenerator("Shared", result);
        String totalResultPrisonYearsContent = contentGenerator("Result", result);

        fileGenerator("PrisonYears", totalPrisonYearsContent);
        fileGenerator("SharedPrisonYears", sharedPrisonYearsContent);
        fileGenerator("ResultPrisonYears", totalResultPrisonYearsContent);

    }

    private void fileGenerator(String title, String content){
        try {
            File file = new File(title + ".md");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(content);
            writer.close();
        }
        catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }

    private String contentGenerator(String contentType, Result result){
        StringBuilder str = new StringBuilder();
        str.append(String.format("# %s-Results: \n", contentType));
        str.append("## Total result: \n");
        if (contentType.equals("")){
            str.append(totalResult(contentType, result.getTotalPrisonYears()));
            str.append("## Team results: \n");
            str.append(teamResults(result.getTotalPrisonYears(), result.getPrisonYearsMatrix()));
        } else if (contentType.equals("Shared")) {
            str.append(totalResult(contentType, result.getTotalSharedPrisonYears()));
            str.append("## Team results: \n");
            str.append(teamResults(contentType, result.getTotalSharedPrisonYears(), result.getSharedPrisonYearsMatrix()));
        } else {
            str.append(totalResult(contentType, result.getTotalResultPrisonYears()));
            str.append("## Team results: \n");
            str.append(teamResults(contentType, result.getTotalResultPrisonYears(), result.getResultPrisonYearsMatrix()));
        }
        return str.toString();
    }

    /**
     * generates the total result (top list) of the tournament
     * @param totalPrisonYears: Array with the total prison years of each participant
     * @return String with the total result of the tournament
     */
    private String totalResult (String contentType, PrisonerYearsPair[] prisonerYearsPairArray){
        Arrays.sort(prisonerYearsPairArray, PrisonerYearsPair.PrisonYearsComparator);
        StringBuilder str = new StringBuilder();
        str.append(String.format("### 1st place: Team %s with %s %s years in prison. \n",
                prisonerYearsPairArray[0].getFirst().getTeamName(), prisonerYearsPairArray[0].getSecond(), contentType));
        str.append(String.format("### 2nd place: Team %s with %s %s years in prison. \n",
                prisonerYearsPairArray[1].getFirst().getTeamName(), prisonerYearsPairArray[1].getSecond(), contentType));
        str.append(String.format("### 3rd place: Team %s with %s %s years in prison. \n",
                prisonerYearsPairArray[2].getFirst().getTeamName(), prisonerYearsPairArray[2].getSecond(), contentType));
        str.append("### Other teams: \n");
        for(int i = 3; i < prisonerYearsPairArray.length; i++){
            str.append(String.format("%s. Team %s: %s %s prison years. \n",
                    i+1, prisonerYearsPairArray[i].getFirst().getTeamName(), prisonerYearsPairArray[i].getSecond(), contentType));
        }
        return str.toString();
    }

    private String teamResults (String contentType, PrisonerYearsPair[] prisonerYearsPairArray, int [][] prisonYearMatrix){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < prisonYearMatrix.length; i++){
            str.append(String.format("- ### %s: \n", prisonerYearsPairArray[i].getFirst().getTeamName()));
            str.append(String.format("|Opponent|%s prison years| \n", contentType));
            str.append("|---|---| \n");
            for (int j = 0; j < prisonYearMatrix.length; j++){
                if (i != j) {
                    str.append(String.format("| %s | %s |\n",
                            prisonerYearsPairArray[j].getFirst().getTeamName(), prisonYearMatrix[i][j]));
                }
            }
        }
        return  str.toString();
    }

    /**
     * generates the team results of the tournament
     * @param prisonYearMatrix: Matrix with the prison years of each participant
     * @param prisoners: Array with the different Prisoner object of each participant
     * @return String with the team results of the tournament
     */
    private String teamResults (PrisonerYearsPair[] prisonerYearsPairArray, int[][] prisonYearMatrix){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < prisonYearMatrix.length; i++){
            str.append(String.format("- ### %s: \n", prisonerYearsPairArray[i].getFirst().getTeamName()));
            str.append("|Opponent|Opponent's Prison Years|My Team's Prison Years| \n");
            str.append("|---|---|---| \n");
            for (int j = 0; j < prisonYearMatrix.length; j++){
                if (i != j) {
                    str.append(String.format("| %s | %s | %s |\n",
                            prisonerYearsPairArray[j].getFirst().getTeamName(), prisonYearMatrix[j][i], prisonYearMatrix[i][j]));
                }
            }
        }
        return  str.toString();
    }

}
