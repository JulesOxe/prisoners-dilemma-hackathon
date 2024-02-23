package HelperClasses;

/**
 * A simple class to hold a pair of objects
 *
 * @param <A> The type of the first object
 * @param <B> The type of the second object
 */
public class Pair<A, B> {
    private A first;
    private B second;

    /**
     * Constructor for the Pair class
     *
     * @param first  The first object
     * @param second The second object
     */
    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Returns the first object
     *
     * @return The first object
     */
    public A getFirst() {
        return first;
    }

    /**
     * Returns the second object
     *
     * @return The second object
     */
    public B getSecond() {
        return second;
    }

    /**
     * Sets the first object
     *
     * @param first The first object
     */
    public void setFirst(A first) {
        this.first = first;
    }

    /**
     * Sets the second object
     *
     * @param second The second object
     */
    public void setSecond(B second) {
        this.second = second;
    }
}
