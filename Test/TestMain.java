import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMain {
//
//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//	}
//
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}
Main m = new Main();
List<String> list = new ArrayList<String>();
@Test
	void testWrittingToFile() throws ParseException {
list.add("2019-02-02 14 USD T-shirt");
list.add("2019-03-03 16 USD T-shirt");
list.add("2019-02-02 16 USD T-shirt");
list.add("2019-02-02 16 USD T-shirt");
//list.add("20190-02-02 16 USD T-shirt"); false
//list.add("201fdrh9-03-03 16 USD T-shirt"); false
//list.add("e2019-02-02 16 USD T-shirt"); false
//list.add("2019---04-04 17 USD T-shirt"); false
		Assert.assertEquals(list,m.writtingToFile(list));
	}

}
