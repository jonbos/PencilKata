package test.java.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestEraserDegradation.class, TestEraserErasing.class, TestPaperCreation.class, TestPencilEditing.class,
		TestPencilPointDegradation.class, TestPencilSharpening.class, TestPencilWriting.class })
public class AllTests {

}
