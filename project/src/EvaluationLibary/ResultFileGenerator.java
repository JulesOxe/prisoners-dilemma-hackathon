package EvaluationLibary;

import HelperClasses.PrisonerYearsPair;
import HelperClasses.Result;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * ResultFileGenerator class, which generates the result file
 */

public class ResultFileGenerator implements ResultGenerator {

    /**
     * generates the result file
     *
     * @param result: Result object with the result of the tournament
     */
    public void generateResultFile(Result result) {
        String content = contentGenerator(result);
        fileGenerator("Results", content);
    }

    /**
     * generates the Markdown file with the result content of the tournament
     *
     * @param title:   Title of the file
     * @param content: Content of the file
     */
    private void fileGenerator(String title, String content) {
        try {
            File file = new File(title + ".md");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(content);
            writer.close();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }

    /**
     * generates the content of the result file
     *
     * @param result: Result object with the result of the tournament
     * @return String with the content of the result file
     */
    private String contentGenerator(Result result) {
        StringBuilder str = new StringBuilder();
        str.append("# Results: \n");
        str.append("## Total result: \n");
        str.append(totalResult("total", result.getTotalResultPrisonYears()));
        str.append("## Own prison years: \n");
        str.append(totalResult("own", result.getTotalPrisonYears()));
        str.append("## Shared prison years: \n");
        str.append(totalResult("shared", result.getTotalSharedPrisonYears()));
        str.append("## Team results: \n");
        str.append(teamResults(result));

        return str.toString();
    }

    /**
     * generates the total result (top list) of the tournament
     *
     * @param contentType:            Type of the content (total, own, shared)
     * @param prisonerYearsPairArray: Array with the different PrisonerYearsPair objects
     * @return String with the total result of the tournament
     */
    private String totalResult(String contentType, PrisonerYearsPair[] prisonerYearsPairArray) {
        PrisonerYearsPair[] prisonerYearsPairArrayCopy = prisonerYearsPairArray.clone();
        Arrays.sort(prisonerYearsPairArrayCopy, PrisonerYearsPair.PrisonYearsComparator);
        StringBuilder str = new StringBuilder();
        str.append(String.format("### 1st place: Team %s with %s %s years in prison. \n",
                prisonerYearsPairArrayCopy[0].getFirst().getTeamName(),
                prisonerYearsPairArrayCopy[0].getSecond(),
                contentType));
        str.append(String.format("### 2nd place: Team %s with %s %s years in prison. \n",
                prisonerYearsPairArrayCopy[1].getFirst().getTeamName(),
                prisonerYearsPairArrayCopy[1].getSecond(),
                contentType));
        str.append(String.format("### 3rd place: Team %s with %s %s years in prison. \n",
                prisonerYearsPairArrayCopy[2].getFirst().getTeamName(),
                prisonerYearsPairArrayCopy[2].getSecond(),
                contentType));
        str.append("### Other teams: \n");
        for (int i = 3; i < prisonerYearsPairArray.length; i++) {
            str.append(String.format("%s. Team %s: %s %s prison years. \n",
                    i + 1, prisonerYearsPairArrayCopy[i].getFirst().getTeamName(),
                    prisonerYearsPairArrayCopy[i].getSecond(),
                    contentType));
        }
        return str.toString();
    }

    /**
     * generates the team results of the tournament
     *
     * @param result: Result object with the result of the tournament
     * @return String with the team results of the tournament
     */
    private String teamResults(Result result) {
        PrisonerYearsPair[] teamNames = result.getTotalPrisonYears();
        int[][] prisonYearMatrix = result.getPrisonYearsMatrix();
        int[][] sharedPrisonYearMatrix = result.getSharedPrisonYearsMatrix();
        int[][] resultPrisonYearMatrix = result.getResultPrisonYearsMatrix();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < teamNames.length; i++) {
            str.append(String.format("- ### %s: \n", teamNames[i].getFirst().getTeamName()));
            str.append("|Opponent|Opponent's Prison Years|My Team's Prison Years|Shared Prison Years|Total PrisonYears| \n");
            str.append("|---|---|---|---|---| \n");
            for (int j = 0; j < teamNames.length; j++) {
                if (i != j) {
                    str.append(String.format("| %s | %s | %s | %s | %s |\n",
                            teamNames[j].getFirst().getTeamName(),
                            prisonYearMatrix[j][i],
                            prisonYearMatrix[i][j],
                            sharedPrisonYearMatrix[i][j],
                            resultPrisonYearMatrix[i][j]));
                }
            }
        }
        return str.toString();
    }
}
