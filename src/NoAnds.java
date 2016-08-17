
public class NoAnds {

	public String noAnds(String exp){

		if(exp.length() != 1) {

			for(int i = 0; i < exp.length(); i++) {

				switch(exp.charAt(i)) {

				case '&':
					return (noAnds(exp.substring(0, i)).equals("T") &&
							noAnds(exp.substring(i + 1, exp.length())).equals("T")) ? "T" : "F";

				}

			}

		}

		return exp.charAt(0) == 'T' ? "T" : "F";

	}

	public static void main(String[] args) {

		NoAnds test = new NoAnds();
		System.out.println(test.noAnds("T&T&T"));

	}

}
