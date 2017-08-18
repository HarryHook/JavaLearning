package org.litejunit.v1;

public class AssertionFailedError extends Error{
    public AssertionFailedError(){

    }
    public  AssertionFailedError(String message) {
        super(message);
    }
}
