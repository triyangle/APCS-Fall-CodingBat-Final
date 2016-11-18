
public class GetSubExpression {

	public String getSubExpression(String str){

		int startIndex = 0;
		int endIndex = 0;
		int parens = 0;
		int maxParens = 0;

		if(!str.contains("(")) {

			return "";

		}

		for(int i = 0; i < str.length(); i++) {

			switch(str.charAt(i)) {

			case '(':
				parens++;
				maxParens++;
				if(parens == 1 && maxParens == 1) {
					startIndex = i + 1;
				}
				break;

			case ')':
				parens--;
				if(parens == 0) {
					endIndex = i;
				}
				break;

			default:
				System.out.println(endIndex);
				break;

			}

			if(endIndex != 0) {

				break;

			}

		}

		return str.substring(startIndex, endIndex);

	}

	public static void main(String[] args) {

		GetSubExpression test = new GetSubExpression();
		System.out.println(test.getSubExpression("(a)&b|(c|d|(e|f|g))"));

	}

}
