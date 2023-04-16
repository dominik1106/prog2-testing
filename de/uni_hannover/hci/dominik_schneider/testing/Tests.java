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

    public <T> boolean Test(T result, T expected) {
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

    public Tests() {
        Runtime.getRuntime().addShutdownHook(exitThread);
    }
}