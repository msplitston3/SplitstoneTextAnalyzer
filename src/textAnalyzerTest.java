import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class textAnalyzerTest {

	@Test
	void test() {
		SplitstoneTextAnalyzer test = new SplitstoneTextAnalyzer();
		String output = test.textAnalyzer();
		assertEquals("", output);
	}

}
