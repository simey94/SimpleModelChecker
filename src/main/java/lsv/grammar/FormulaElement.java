package lsv.grammar;

/**
 * Abstratc superclass for the elements of an asCTL formula.
 */
public abstract class FormulaElement {

    protected boolean negation;

    /**
     * Getter
     * @return The value of the boolean negation field.
     */
    public boolean getNegation() {
        return negation;
    }

    /**
     * Setter
     * @param negation
     */
    public void setNegation(Boolean negation){ this.negation = negation; }
}
