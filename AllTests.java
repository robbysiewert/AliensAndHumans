package com.humans.aliens;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ UnitTestAlien.class, UnitTestEntity.class, UnitTestEnvironment.class,
		UnitTestHuman.class, UnitTestWeapon.class })
public class AllTests {

}
