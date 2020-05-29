package com.howtodoinjava.demo;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class RunJUnit4TestsFromJava {
	
	public static void main(String[] args) {
		
		System.out.println("Before test cases start running.");
		runSuiteOfClasses();
		System.out.println("After test cases start running.");
	}
	
	public static void runSuiteOfClasses() {
        JUnitCore junit = new JUnitCore();
         junit.addListener(new TextListener(System.out));
         Result result = junit.run(MyTestSuite.class);
        
//        Result result = junit.run(
//        		CheckGet.class,
//            	CheckPost.class,
//            	CheckPut.class,
//            	CheckDelete.class
//            	);
        

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        resultReport(result);
    }
	
	public static void resultReport(Result result) {
        System.out.println("Finished. Result: Failures: " +
          result.getFailureCount() + ". Ignored: " +
          result.getIgnoreCount() + ". Tests run: " +
          result.getRunCount() + ". Time: " +
          result.getRunTime() + "ms.");
    }

}
