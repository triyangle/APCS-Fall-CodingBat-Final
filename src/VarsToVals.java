
public class VarsToVals {

	public String varsToVals(String exp, String[] vars, String[] vals){

		for(int k = 0; k < vars.length; k++) {

			if(exp.contains(vars[k])) {

				exp = exp.replaceAll(vars[k], vals[k]);

			}

		}
		return exp;

	}

	public static void main(String[] args) {

		VarsToVals test = new VarsToVals();
		System.out.println(test.varsToVals("aab", new String[] {"a", "ab"}, new String[] {"BLAHa", "ZZZZ"}));

	}
}
