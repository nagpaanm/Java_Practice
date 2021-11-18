package htmlEntityParser;

public class Main {

	public static void main(String[] args) {
		String text = "&amp; is an HTML entity but &ambassador; is not.";
		Solution sol = new Solution();
		text = sol.entityParser(text);
		System.out.println(text);

	}

}
