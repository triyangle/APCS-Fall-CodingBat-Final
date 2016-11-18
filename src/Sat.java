
import java.util.*;

public class Sat {

	private HashSet<Character> variableSet;
	private String sentence;
	private ArrayList<Character> variableArray;
	private HashMap<Character, Boolean> variableMap;
	private StringBuilder evaluateSentence;

	public boolean sat(String str){

		sentence = str;
		variableSet = new HashSet<Character>();
		numberOfVars();

		return test();

	}

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

		variableArray = new ArrayList<Character>(variableSet);

	}

	public boolean test() {

		for(int i = 0; i < (1<<variableArray.size()); i++) {

			variableMap = new HashMap<Character, Boolean>();

			for(int j = 0; j < variableArray.size(); j++) {

				variableMap.put(variableArray.get(j), (i&(1<<j)) == (1<<j));

			}

			initEval(variableMap);

			if(evaluate(evaluateSentence) == true) {

				return true;

			}

		}

		return false;

	}

	public void initEval(HashMap<Character, Boolean> variableValues) {

		evaluateSentence = new StringBuilder(sentence);

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

}
