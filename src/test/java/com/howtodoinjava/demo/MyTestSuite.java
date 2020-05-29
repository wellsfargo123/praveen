package com.howtodoinjava.demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CheckGet.class,
	CheckPost.class,
	CheckPut.class,
	CheckDelete.class
})
public class MyTestSuite {
}
