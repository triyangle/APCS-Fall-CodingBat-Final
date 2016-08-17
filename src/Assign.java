import java.util.*;

public class Assign {

	private HashMap<Character, Boolean> variableMap = new HashMap<Character, Boolean>();	
	private String sentence;
	private StringBuilder evaluateSentence;
	private ArrayList<Character> charList;
	
	public String assign(String exp, int tvals) {
		
		sentence = exp;
		charList = new ArrayList<Character>();
		
		for(int i = (int) 'a'; i <= (int) 'z'; i++) {
			
			charList.add((char) i);
			
		}
		
		for(int i = 0; i < charList.size(); i++) {
			
			variableMap.put(charList.get(i), (tvals&(1<<i)) == (1<<i));
			
		}
		
		initEval(variableMap);
		
		return new String(evaluateSentence);
		
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
	
	public static void main(String[] args) {

		Assign test = new Assign();
		System.out.println(test.assign("a&b&c&z|(q|w)", 22222));
		
	}

}
