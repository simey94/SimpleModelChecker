package lsv.core;

import lsv.grammar.Formula;
import lsv.model.Model;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;


public class ModelCheckerTest {

    /*
     * An example of how to set up and call the model building methods and make a call to the
     * model checker itself.  The contents of model.json, constraint1.json and ctl.json are
     * just examples, you need to add new models and formulas for the mutual exclusion task.
     * */

    @Test
    public void checkTrue() {

	Model model = Builder.buildModel("src/test/resources/model.json");

	Formula query = Builder.buildFormula("src/test/resources/true.json");

	ModelChecker mc = new SimpleModelChecker();
    assertTrue(mc.check(model, query, query));
    }

    @Test
    public void testMutualExclusion() {
        ModelChecker mc = new SimpleModelChecker();
//        Test mutual Exclusion
        Formula trueConstraint = Builder.buildFormula("src/test/resources/true.json");
        Model mutualExclusionModel = Builder.buildModel("src/test/resources/mutualExclusion.json");
        Formula mutualExclusionFormula = Builder.buildFormula("src/test/resources/mutualExclusionFormula.json");
        assertTrue(mc.check(mutualExclusionModel, trueConstraint, mutualExclusionFormula));

        mutualExclusionFormula.setNegation(true); //test that negation works
        assertTrue(!(mc.check(mutualExclusionModel, trueConstraint, mutualExclusionFormula)));
    }


    @Test
    public void testConstraint() {
        ModelChecker mc = new SimpleModelChecker();
        Formula trueConstraint = Builder.buildFormula("src/test/resources/true.json");
        trueConstraint.setNegation(true);
        Model mutualExclusionModel = Builder.buildModel("src/test/resources/mutualExclusion.json");
        Formula mutualExclusionFormula = Builder.buildFormula("src/test/resources/mutualExclusionFormula.json");
        assertTrue(!(mc.check(mutualExclusionModel, trueConstraint, mutualExclusionFormula)));
    }



}
