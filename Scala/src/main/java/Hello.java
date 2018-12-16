import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * created by bing57592
 * 2018-09-09 19:16
 */
public class Hello {
	public static void main(String[] args) {
		String Hello = new String();

		String str = "";
		List<Integer> list = new ArrayList<>();
		Map<Integer, String> map = new HashMap<>();
		System.out.println(str);

	}

	@Test
	public void test() throws Exception {
		long result = (1516609143869l / (1000 * 60 * 60)) % 24;
		System.out.println(result);
		Date date = new Date(1516609143869l);
		String format = new SimpleDateFormat("yyy-MM-dd HH").format(date);
		System.out.println(format);
	}
}
