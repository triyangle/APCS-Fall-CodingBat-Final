import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SameNoParen {

	private String sentence;
	private String sentence2;

	private StringBuilder evaluateSentence;
	private StringBuilder evaluateSentence2;

	private HashSet<Character> variableSet;

	public void numberOfVars() {

		for(int i = 0; i < sentence.length(); i++) {

			switch(sentence.charAt(i)) {

			case '~':
				break;

			case '|':
				break;

			case '&':
				break;

			case '(':
				break;

			case ')':
				break;

			default:
				variableSet.add(sentence.charAt(i));
				break;
			}

		}

	}

	public void initEval(HashMap<Character, Boolean> variableValues) {

		evaluateSentence = new StringBuilder(sentence);
		evaluateSentence2 = new StringBuilder(sentence2);

		for(int i = 0; i < evaluateSentence.length(); i++) {

			switch(evaluateSentence.charAt(i)) {

			case '~':
				break;

			case '|':
				break;

			case '&':
				break;

			case '(':
				break;

			case ')':
				break;

			default:
				char variable = evaluateSentence.charAt(i);
				evaluateSentence.setCharAt(i, variableValues.get(variable) ? 'T' : 'F');
				break;

			}

		}

		for(int i = 0; i < evaluateSentence2.length(); i++) {

			switch(evaluateSentence2.charAt(i)) {

			case '~':
				break;

			case '|':
				break;

			case '&':
				break;

			case '(':
				break;

			case ')':
				break;

			default:
				char variable = evaluateSentence2.charAt(i);
				evaluateSentence2.setCharAt(i, variableValues.get(variable) ? 'T' : 'F');
				break;

			}
		}
	}

	public boolean evaluate(StringBuilder evaluate) {

		if(evaluate.length() != 1) {

			int parens = 0;

			for(int i = 0; i < evaluate.length(); i++) {

				switch(evaluate.charAt(i)) {

				case '(':
					parens++;
					break;

				case ')':
					parens--;
					break;

				case '|':
					if(parens == 0) {

						return evaluate(new StringBuilder(evaluate.substring(0, i))) ||
								evaluate(new StringBuilder(evaluate.substring(i + 1, evaluate.length())));

					}
					break;

				}

			}

			for(int i = 0; i < evaluate.length(); i++) {

				switch(evaluate.charAt(i)) {

				case '(':
					parens++;
					break;

				case ')':
					parens--;
					break;

				case '&':
					if(parens == 0) {

						return evaluate(new StringBuilder(evaluate.substring(0, i))) &&
								evaluate(new StringBuilder(evaluate.substring(i + 1, evaluate.length())));

					}
					break;

				}

			}

			if(evaluate.charAt(0) == '~') {

				return !evaluate(new StringBuilder(evaluate.substring(1, evaluate.length())));

			}

			if(evaluate.charAt(0) == '(' && evaluate.charAt(evaluate.length() - 1) == ')') {

				return evaluate(new StringBuilder(evaluate.substring(1, evaluate.length() - 1)));

			}

		}

		return evaluate.charAt(0) == 'T' ? true : false;

	}

	public boolean equivalent() {

		if(entails() == 1) {

			return true;

		}

		return false;
	}

	public int entails() {

		ArrayList<Character> combinedVariableArray = new ArrayList<Character>(variableSet);

		for(int i = 0; i < (1<<combinedVariableArray.size()); i++) {

			HashMap<Character, Boolean> combinedMap = new HashMap<Character, Boolean>();

			for(int j = 0; j < combinedVariableArray.size(); j++) {

				combinedMap.put(combinedVariableArray.get(j), (i&(1<<j)) == (1<<j));

			}

			initEval(combinedMap);

			if((evaluate(evaluateSentence) == true && evaluate(evaluateSentence2) == false) || (evaluate(evaluateSentence) == false && evaluate(evaluateSentence2) == true)) {

				return -1;

			}

		}

		return 1;

	}

	public boolean sameNoParen(String str){

		sentence = str;
		sentence2 = removeParens(str);

		variableSet = new HashSet<Character>();

		numberOfVars();

		return equivalent();

	}

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

		SameNoParen test = new SameNoParen();

		System.out.println(test.sameNoParen("(a|b)|~(a|b)"));

	}

}
