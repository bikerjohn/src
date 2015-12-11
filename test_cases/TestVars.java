package test_cases;



public final class TestVars {
	 private String usrname;
	 private String passwrd;
	 private String prjct;
	 private String org;
	 private String part_code;
	
	//set the default value of the test variables
	public TestVars(){
		usrname="bikerjohn";
		passwrd="$Rtchierans9x1";
		prjct="Delete EMA Config Test (OWNER)";
		org="PiLRHealth Auto QA Test Org (OWNER)";
		part_code="922";
			
	    }
	
	// Public methods
		public final String getUserName(){
			return usrname;
		}
		public final String getPassWrd(){
			return passwrd;
		}
		public final String getProject(){
			return prjct;
		}
		public final String getOrg(){
			return org;
		}
		public final String getPartCode(){
			return part_code;
		}
}
