package test_cases;



public final class TestVars {
	 private String usrname;
	 private String passwrd;
	 private String prjct;
	 private String org;
	 private String part_code;
	 private String part_desc;
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
	 private String new_survey_name;
	 private String new_survey_description;
	 private String instrument_url;
	 private String existing_org;
	 private String dv_start_date;
	 private String dv_end_date;
	 public String import_file_name;
	 private String participant_status;
	 private String default_assignments;
	 private Integer proj_wizard_import_component_li;
	 public String ema_config_defs;
	
	//set the default value of the test variables
	public TestVars(){
		usrname="bikerjohn";
		passwrd="$Rtchierans9x1";
		prjct="Delete EMA Config Test";
		//prjct="test6008";
		org="EMA Standard Surveys";
		//org="PiLRHealth Auto QA Test Org (OWNER)";
		//org="PiLR Demo (OWNER)";
		part_code="922";
		part_desc="bikerjohn";
		ema_config="New EMA Config";
		new_ema_config="New EMA Config";
		surv_name="Test Survey";
		surv_desc="this is a survey created by an automated qa script";
		sect_name="weather";
		sect_desc="this section created by an automated test script";
		card_type="QUESTION: Yes or no";
		card_titl="Weather Question";
		card_text="Is the sun shining today?";
		instrument_url = "https://raw.githubusercontent.com/pilrhealth/definition-files/master/premium/PiLR%20EMA/base-instrument.json";
		new_survey_name = "Test Survey";
		new_survey_description = "This is an automatically generated survey";
		existing_org = "customer_ema_examples";
		dv_start_date = "10/16/2015";
		dv_end_date = "02/10/2016";
		import_file_name = "C:\\srv\\mei\\bulk_participants.csv";
		participant_status = "Enrolled";
		default_assignments = "Default Assignments";
		proj_wizard_import_component_li = 0;
		ema_config_defs = "C:\\srv\\mei\\emacontent\\ema-configs-standard-surveys-wtriggers.json";
				
		
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
		public final String getPartDesc(){
			return part_desc;
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
		public final String getNewSurveyName(){
			return new_survey_name;
		}
		public final String getNewSurveyDescription(){
			return new_survey_description;
		}
		public final String getExistingOrg(){
			return existing_org;
		}
		public final String get_dv_Start_Date(){
			return dv_start_date;
		}
		public final String get_dv_End_Date(){
			return dv_end_date;
		}
		public final void set_import_File_Name(String newimportpath){
			this.import_file_name=newimportpath;
		}
		public final String get_import_File_Name(){
			return import_file_name;
		}
		public final String get_participant_Status(){
			return participant_status;
		}
		public final String get_default_Assignments(){
			return default_assignments;
		}
		public final Integer get_Import_Component_li(){
			return proj_wizard_import_component_li;
		}
		public final void set_EMA_Config_Defs(String newconfigdefs){
			this.ema_config_defs=newconfigdefs;
		}
		public final String get_EMA_Config_Defs(){
			return ema_config_defs;
		}
}
