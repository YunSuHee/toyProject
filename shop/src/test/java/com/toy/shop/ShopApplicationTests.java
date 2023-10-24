package com.toy.shop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShopApplicationTests {
	Util util = new Util();
	@Test
	void stringEscape() {
		String unescapedSQL = "This is an unescaped string with special characters: ' \n \r";
		String unescapedHTML = "<script>alert('XSS Attack');</script>";
		String unescapedJSON = "{\"name\":\"John\",\"message\":\"This is a JSON string with special characters: \\\" \n \r\"}";

		String escapeSQL = util.escapeSQL(unescapedSQL);
		String escapeHTML = util.escapeHTML(unescapedHTML);
		String escapeJSON = util.escapeJSON(unescapedJSON);
		assertNotEquals(unescapedSQL,escapeSQL);
		assertNotEquals(unescapedHTML,escapeHTML);
		assertNotEquals(unescapedJSON,escapeJSON);

	}

}
