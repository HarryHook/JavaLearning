package org.litejunit.v1;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestResult extends Object {
    protected List<TestFailure> failures;
    protected List<TestFailure> errors;

    protected int testCount;
    private boolean stop;

    public TestResult() {
        failures = new ArrayList<>();
        errors = new ArrayList<>();

        testCount = 0;
        stop = false;
    }

    public void addError(Test test, Throwable t) {
        errors.add(new TestFailure(test, t));
    }

    public void addFailure(Test test, AssertionFailedError t) {

        failures.add(new TestFailure(test, t));
    }

    public void startTest(Test test) {
        int count = test.countTestCases();
        testCount += count;
    }

    public void endTest() {
    }

    /*
    RUN A TESTCASE
     */
    public void run(final TestCase test) {
        startTest(test);
        try {
            test.doRun();
        } catch (AssertionFailedError e) {
            addFailure(test, e);
        } catch (Throwable e) {
            addError(test, e);
        }
        endTest();
    }

    public int runCount() {
        return testCount;
    }

    public boolean shouldStop() {
        return stop;
    }

    public void stop() {
        stop = true;
    }

    public int errorCount() {
        return errors.size();
    }

    public int failureCount() {
        return failures.size();
    }

    public Iterator errors() {
        return errors.iterator();
    }

    public Iterator<TestFailure> failures() {
        return failures.iterator();
    }

    public boolean wasSuccessful() {
        return this.failureCount() == 0 && this.errorCount() == 0;
    }

}
