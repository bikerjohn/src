package test_cases;



public final class TestVars {
	 private String usrname;
	 private String passwrd;
	 private String prjct;
	 private String org;
	 private String part_code;
	 private String ema_config;
	 private String new_ema_config;
	 private String surv_name;
	 private String surv_desc;
	 private String sect_name;
	 private String sect_desc;
	 private String card_type;
	 private String card_titl;
	 private String card_text;
	 private String new_prjct;
	 private String instrument_url;
	
	//set the default value of the test variables
	public TestVars(){
		usrname="bikerjohn";
		passwrd="$Rtchierans9x1";
		prjct="Delete EMA Config Test (OWNER)";
		org="PiLRHealth Auto QA Test Org (OWNER)";
		part_code="922";
		ema_config="Delete Config Test     (00946)";
		new_ema_config="New EMA Config";
		surv_name="Delete Config Test1     (08972)";
		surv_desc="this is a survey created by an automated qa script";
		sect_name="weather";
		sect_desc="this section created by an automated test script";
		card_type="QUESTION: Yes or no";
		card_titl="Weather Question";
		card_text="Is the sun shining today?";
		instrument_url = "https://raw.githubusercontent.com/pilrhealth/definition-files/master/premium/PiLR%20EMA/base-instrument.json";
		
			
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
		public final String getEmaConfig(){
			return ema_config;
		}
		public final String getSurveyName(){
			return surv_name;
		}
		public final String getSurveyDescription(){
			return surv_desc;
		}
		public final String getSectionName(){
			return sect_name;
		}
		public final String getSectionDescription(){
			return sect_desc;
		}
		public final String getCardTitle(){
			return card_titl;
		}
		public final String getCardText(){
			return card_text;
		}
		public void setnewProject(String newproject){
			this.new_prjct=newproject;
		}
		public final String getNewProject(){
			return new_prjct ;
		}
		public final String getInstrumentURL(){
			return instrument_url ;
		}
		public final String getNewEMAConfig(){
			return new_ema_config;
		}
}
