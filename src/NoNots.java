
public class NoNots {

	public String noNots(String exp){

		if(exp.length() != 1) {

			for(int i = 0; i < exp.length(); i++) {

				switch(exp.charAt(i)) {

				case '|':
					return noNots(exp.substring(0, i)) + "|" + noNots(exp.substring(i + 1, exp.length()));

				default:
					break;

				}

			}

			for(int i = 0; i < exp.length(); i++) {

				switch(exp.charAt(i)) {

				case '&':
					return noNots(exp.substring(0, i)) + "&" + noNots(exp.substring(i + 1, exp.length()));

				default:
					break;

				}

			}

			if(exp.charAt(0) == '~') {

				return not(exp.substring(1, exp.length()));

			}

		}

		return "" + exp.charAt(0);


	}

	public String not(String exp) {

		if(exp.length() != 1) {

			if(exp.charAt(0) == '~') {

				return not(not(exp.substring(1, exp.length())));

			} 
		}

		return exp.charAt(0) == 'T' ? "F" : "T";

	}

	public static void main(String[] args) {

		NoNots test = new NoNots();
		System.out.println(test.noNots("~T|F&~T"));
		System.out.println(test.noNots("T&T&~~~~T"));
		System.out.println(test.noNots("~~~T&F"));
		
	}

}
