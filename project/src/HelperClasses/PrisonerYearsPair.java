package HelperClasses;

import Prisoner.Prisoner;

import java.util.Comparator;

/**
 * This class is a pair of a prisoner and the number of years they have to be in prison.
 * It is used to sort the prisoners by the number of years they have been in prison.
 * It is used in the PrisonerList class.
 * It extends the Pair class.
 * It has a comparator to compare the number of years of two prisoners.
 */
public class PrisonerYearsPair extends Pair<Prisoner, Integer> {

    /**
     * Constructor
     *
     * @param first  the prisoner
     * @param second the number of years the prisoner has to be in prison
     */
    public PrisonerYearsPair(Prisoner first, Integer second) {
        super(first, second);
    }

    /**
     * Comparator to compare the number of years of two prisoners.
     */
    public static Comparator<PrisonerYearsPair> PrisonYearsComparator = new Comparator<PrisonerYearsPair>() {

        /**
         * Compare the number of years of two prisoners.
         * @param p1 the first prisoner
         * @param p2 the second prisoner
         * @return 1 if the first prisoner has more years, -1 if the second prisoner has more years, 0 if they have the same number of years
         */
        @Override
        public int compare(PrisonerYearsPair p1, PrisonerYearsPair p2) {
            Integer prisonYears1 = p1.getSecond();
            Integer prisonYears2 = p2.getSecond();
            return prisonYears1.compareTo(prisonYears2);
        }
    };
}
