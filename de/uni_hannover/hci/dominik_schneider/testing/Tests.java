package de.uni_hannover.hci.dominik_schneider.testing;

public class Tests {
    int runTests, successTests;

    Thread exitThread = new Thread(() -> {
        if(runTests > 0) {
            if(runTests == successTests) {
                System.out.println("All " + runTests + " tests passed!");
            } else {
                System.out.println((runTests - successTests) + " of " + runTests + " tests failed.");
            }
        }
    });

    public <T> boolean test(T result, T expected) {
        StackTraceElement caller = Thread.currentThread().getStackTrace()[2];

        System.out.print("In " + caller.getClassName() + "." + caller.getMethodName() + ", line " + caller.getLineNumber() + ": ");

        runTests++;
        if(result == expected) {
            System.out.println("Test passed.");
            successTests++;
            return true;
        }
        System.out.println("Actual value " + result + " differs from expected value " + expected);
        return false;
    }

    public boolean testWithinDeviation(double result, double expected, double epsilon) {
        StackTraceElement caller = Thread.currentThread().getStackTrace()[2];

        System.out.print("In " + caller.getClassName() + "." + caller.getMethodName() + ", line " + caller.getLineNumber() + ": ");

        double difference = Math.abs(result - expected);

        runTests++;
        if(difference <= epsilon) {
            System.out.println("Test passed.");
            successTests++;
            return true;
        }
        System.out.println("Actual value " + result + " is not within " + epsilon + " of expected value " + expected);
        return false;
    }

    public Tests() {
        Runtime.getRuntime().addShutdownHook(exitThread);
    }
}