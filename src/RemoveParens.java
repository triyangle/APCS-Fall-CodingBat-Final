
public class RemoveParens {

	public String removeParens(String str){

		StringBuilder noParens = new StringBuilder(str);

		for(int i = 0; i < noParens.length(); i++) {

			switch(noParens.charAt(i)) {

			case '(':
				noParens.deleteCharAt(i);
				i--;
				break;

			case ')':
				noParens.deleteCharAt(i);
				i--;
				break;

			default:
				break;

			}

		}

		return new String(noParens);


	}

	public static void main(String[] args) {

		RemoveParens test = new RemoveParens();
		System.out.println(test.removeParens("()"));
		System.out.println(test.removeParens("(a)"));
		System.out.println(test.removeParens("((()))))(((()))"));

	}

}
