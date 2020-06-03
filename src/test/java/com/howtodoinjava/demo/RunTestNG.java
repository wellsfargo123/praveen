package com.howtodoinjava.demo;

import java.util.ArrayList;
import java.util.List;
 
import org.testng.TestNG;
 
public class RunTestNG {
 
public static void main(String[] args) {
 
// Create object of TestNG Class
TestNG runner=new TestNG();
 
// Create a list of String 
List<String> suitefiles=new ArrayList<String>();
 
// Add xml file which you have to execute
suitefiles.add("/var/lib/jenkins/workspace/testng.xml");
 
// now set xml file for execution
runner.setTestSuites(suitefiles);
 
// finally execute the runner using run method
runner.run();
}
 
}

//import java.util.List;
//
//import org.testng.TestNG;
//
//import com.beust.jcommander.internal.Lists;
//
//public class RunTestNG {
//
//	public static void main(String[] args) {
//		 
//		System.out.println("Execution of TestNG XML file using main() method.");
//		TestNG testng=new TestNG();
//		List<String> suite=Lists.newArrayList();
//		suite.add(".\\src\\main\\resources\\testng.xml");
//		testng.setTestSuites(suite);
//		testng.run();
//	}
//
//}
