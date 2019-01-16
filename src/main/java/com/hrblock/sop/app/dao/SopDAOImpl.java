package com.hrblock.sop.app.dao;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedCaseInsensitiveMap;

import com.hrblock.sop.app.exception.SopCustomException;
import com.hrblock.sop.app.model.SOPOffice;
import com.hrblock.sop.app.model.SopMainDetails;
import com.hrblock.sop.app.model.WarningStatusDetails;
import com.hrblock.sop.app.rowmapper.OfficeWarningDetailRowMapper;

/**
 *  @author  Umesh Kumar M
 *  @version     1.0
 *  @since       1.0
 *  Release Date: 
 *  <p>
 *  Revision History: 
 * 
 */ 

@Repository
public class SopDAOImpl implements SopDAO {

	@Autowired
	private DataSource dataSource;
	Logger log = Logger.getLogger(this.getClass());

	private NamedParameterJdbcTemplate npJdbcTemplate;
	
	private SimpleJdbcCall simpleJdbcCall;
	
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
	
	/*@Resource(name="dataSource")
    protected void setDataSource(DataSource dataSource) {
        this.dataSource = (DataSource) new NamedParameterJdbcTemplate(dataSource);
    }*/
	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.npJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(dataSource);
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	    return new PersistenceExceptionTranslationPostProcessor();
	}
	
	/** fetch office lists from db corresponding to the user details  **/
	@SuppressWarnings("unchecked")
	@Override
	public SOPOffice getSopMainDetails(List<Integer> districtList,String smUser, String psID) throws SopCustomException{
		
		List<SopMainDetails> sopMainDetails= new ArrayList<>();
		List<SopMainDetails> sopMainDetails2= new ArrayList<>();
		SOPOffice sopOffice = new SOPOffice();
		String resultRole;
		log.info("Entering SSO Integration process DaoImpl");
		try {
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			parameters.addValue("districtlist", districtList);

			/*sopMainDetails = npJdbcTemplate.query(getSQL(), parameters,
					new SopMainDetailRowMapper());*/
			
			//Procedure usage starts
			
			SqlParameterSource in = new MapSqlParameterSource().addValue("P_PSFT_ID", psID);
			 
			simpleJdbcCall.withProcedureName("SOP_GET_OFFICE_LIST_PROC");
			
			Map<String, Object> procedureResultSet = simpleJdbcCall.execute(in);
			
			//List<SopMainDetails> sopMainDetails2= new ArrayList<>();
			
			resultRole= (String) procedureResultSet.get("P_ROLE_NM");
			if(resultRole.equals("I")) {
				sopMainDetails2.add(null);
			}else {
			
			List<LinkedCaseInsensitiveMap<Object>> resultSet = (List<LinkedCaseInsensitiveMap<Object>>) procedureResultSet.get("P_REF_RESULT OUT");
		
			for(LinkedCaseInsensitiveMap<Object> sopMainDetail :resultSet) {
				SopMainDetails details = new SopMainDetails();
				//details.setMarket((sopMainDetail.get("p_MARKET_NM").toString()));
				//details.setRegion((sopMainDetail.get("p_REGION_NM")).toString());
				SimpleDateFormat mdyFormat = new SimpleDateFormat("MM-dd-yyyy");
				 Date lastUpdateDate = (Date) sopMainDetail.get("LAST_UPDATED_TS");
				String lastUpdatedStr = mdyFormat.format(lastUpdateDate.getTime());
				details.setLastUpdated(lastUpdatedStr);
				
				details.setOfficeId(((BigDecimal)sopMainDetail.get("OFFICE_GL_DEPT_ID")).intValue());
				//details.setAccRowId(((BigDecimal)sopMainDetail.get("ACC_ROW_NO")).intValue());
				details.setMarketId(((BigDecimal)sopMainDetail.get("MARKET_ID")).intValue());
				details.setMarket((sopMainDetail.get("MARKET_NM").toString()));
				details.setRegionId(((BigDecimal)sopMainDetail.get("REGION_ID")).intValue());
				details.setRegion((sopMainDetail.get("REGION_NM")).toString());
				details.setDistrictId(((BigDecimal)sopMainDetail.get("DISTRICT_ID")).intValue());
				details.setDistrict((sopMainDetail.get("DISTRICT_NM")).toString());
				details.setWarningStepName((sopMainDetail.get("WARNING_STEP_NM")).toString());
				details.setOmWarningStatusName((sopMainDetail.get("WARNING_STATUS_NM")).toString());
				details.setOmName((sopMainDetail.get("OFFICE_MGR_NM")).toString());
				details.setOfficeId(((BigDecimal)sopMainDetail.get("OFFICE_GL_DEPT_ID")).intValue());
				details.setWarningCycleId(((BigDecimal)sopMainDetail.get("WARNING_CYCLE_ID")).intValue());
				
				
				sopMainDetails2.add(details);
			}
			
			System.out.println(sopMainDetails2);
			sopOffice.setSopMainDetails(sopMainDetails2);
			sopOffice.setRoleName(resultRole);
			}
			
		}catch (Exception e) {
			log.error("Exception occured at Integration process DaoImpl: ",e);
			//System.err.print(e);
//			e.printStackTrace();
			throw new SopCustomException("Exception caught at DAOImpl");
		}
		log.info("Existing SSO Integration process DaoImpl");
		return sopOffice;
	}

	private String getSQL() {
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("SELECT hsa.ACC_ROW_NO,hsa.MARKET_NM,hsa.REGION_NM,hsa.DISTRICT_NM,hsa.OFFICE_GL_DEPT_ID,hsws.WARNING_STEP_NM,hsows.WARNING_STATUS_NM, ");
		sqlQuery.append("hsa.CRE_PROC_TS,hsa.LAST_UPDATED_TS,hsa.OFFICE_MGR_NM,hsa.WARNING_CYCLE_ID ");
		sqlQuery.append("FROM HRB_SOP_ACCOUNTABILITY hsa ");
		sqlQuery.append("JOIN HRB_SOP_WARNING_STATUS hsows ON (hsows.WARNING_STATUS_ID = hsa.WARNING_STATUS_ID) ");
		sqlQuery.append("JOIN HRB_SOP_WARNING_STEP hsws ON (hsws.WARNING_STEP_ID = hsa.WARNING_STEP_ID) ");
		sqlQuery.append("WHERE hsa.DISTRICT_ID IN (:districtlist)");
		return sqlQuery.toString();

	}

	/**  fetching the details of the warning status details for the office id **/
	
	@Override
	public SOPOffice fetchWarningDetailsOfOffice(String officeId) throws SopCustomException{
		
		SOPOffice sopOffice = new SOPOffice();
		Map<String, List<WarningStatusDetails>> warningListofOffice = new HashMap<>();
		List<Integer> warnings = Arrays.asList(1,2,3,4);
		log.info("Entering office warning details fetching DaoImpl");
		try {
			
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			parameters.addValue("officeId", Integer.parseInt(officeId));
			parameters.addValue("warning", warnings);
			
			/*String verbal="1";
			String written="2";
			String finalw="3";
			String decision="4";*/
			
			List<WarningStatusDetails> warningDetails =  npJdbcTemplate.query(getWarningSQL(), parameters,
					new OfficeWarningDetailRowMapper());
						
			sopOffice.setOfficeID(Integer.parseInt(officeId));
			//sopOffice.setOmName("HnR");
			
			List<WarningStatusDetails> verbalWarningList= new ArrayList<WarningStatusDetails>();
			List<WarningStatusDetails> writtenWarningList= new ArrayList<WarningStatusDetails>();
			List<WarningStatusDetails> finalWarningList= new ArrayList<WarningStatusDetails>();
			List<WarningStatusDetails> decisionList= new ArrayList<WarningStatusDetails>();
			
			for (WarningStatusDetails individualWarning : warningDetails) {
				System.out.println(individualWarning);
				WarningStatusDetails verbalWarning = new WarningStatusDetails();
				WarningStatusDetails writtenWarning = new WarningStatusDetails();
				WarningStatusDetails finalWarning = new WarningStatusDetails();
				WarningStatusDetails decision = new WarningStatusDetails();
				
				
				if(individualWarning.getWarningId()==1) {
					verbalWarning.setDate(individualWarning.getDate());
					verbalWarning.setOmWarningStatus(individualWarning.getOmWarningStatus());
					verbalWarning.setException(individualWarning.getException());
					verbalWarning.setExceptionReason(individualWarning.getExceptionReason());
					verbalWarning.setWarningName(individualWarning.getWarningName());
					verbalWarning.setOmStepId(individualWarning.getOmStepId());
					verbalWarning.setWarningId(individualWarning.getWarningId());
					verbalWarning.setWarningCycleId(individualWarning.getWarningCycleId());
					
					verbalWarningList.add(verbalWarning);
				}else if(individualWarning.getWarningId()==2) {
					writtenWarning.setDate(individualWarning.getDate());
					writtenWarning.setOmWarningStatus(individualWarning.getOmWarningStatus());
					writtenWarning.setException(individualWarning.getException());
					writtenWarning.setExceptionReason(individualWarning.getExceptionReason());
					writtenWarning.setWarningName(individualWarning.getWarningName());
					writtenWarning.setOmStepId(individualWarning.getOmStepId());
					writtenWarning.setWarningId(individualWarning.getWarningId());
					writtenWarning.setWarningCycleId(individualWarning.getWarningCycleId());
					
					writtenWarningList.add(writtenWarning);
				}else if(individualWarning.getWarningId()==3) {
					finalWarning.setDate(individualWarning.getDate());
					finalWarning.setOmWarningStatus(individualWarning.getOmWarningStatus());
					finalWarning.setException(individualWarning.getException());
					finalWarning.setExceptionReason(individualWarning.getExceptionReason());
					finalWarning.setWarningName(individualWarning.getWarningName());
					finalWarning.setOmStepId(individualWarning.getOmStepId());
					finalWarning.setWarningId(individualWarning.getWarningId());
					finalWarning.setWarningCycleId(individualWarning.getWarningCycleId());
					
					finalWarningList.add(finalWarning);
				}else if(individualWarning.getWarningId()==4) {
					decision.setDate(individualWarning.getDate());
					decision.setOmWarningStatus(individualWarning.getOmWarningStatus());
					decision.setException(individualWarning.getException());
					decision.setExceptionReason(individualWarning.getExceptionReason());
					decision.setWarningName(individualWarning.getWarningName());
					decision.setOmStepId(individualWarning.getOmStepId());
					decision.setWarningId(individualWarning.getWarningId());
					decision.setWarningCycleId(individualWarning.getWarningCycleId());
					
					decisionList.add(decision);
				}
				
				
				
				
			}
			
			warningListofOffice.put("verbal", verbalWarningList);
			warningListofOffice.put("written", writtenWarningList);
			warningListofOffice.put("final", finalWarningList);
			warningListofOffice.put("decision", decisionList);
			sopOffice.setWarningListofOffice(warningListofOffice);
			
		}catch (Exception e) {
			log.error("Exception occured at warning details fetching DaoImpl: ",e);
			//System.err.print(e);
			e.printStackTrace();
			throw new SopCustomException("Exception caught at DAOImpl");
		}
		
		//sopOffice.setVerbalWarning(verbalWarningDetails);
		/*sopOffice.setWrittenWarning(writtenWarningDetails);
		sopOffice.setFinalWarning(finalWarningDetails);
		sopOffice.setDecision(decisionWarningDetails);*/
		log.info("Existing office warning details fetching DaoImpl");
		return sopOffice;
	}
	
	private String getWarningSQL() {
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("SELECT hscs.UPDATED_TS as dates,hsows.WARNING_STATUS_NM as omWarStatus,hscs.WARNING_CYCLE_ID as warningCycle, ");
		sqlQuery.append("hscs.EXCEPTION_REASON_TXT as exceptionReason,hsws.WARNING_STEP_NM as warnings,hsws.WARNING_STEP_ID as warningid,hsows.WARNING_STATUS_ID as omStepid ");
		sqlQuery.append(" FROM HRB_SOP_CURRENT_STATUS hscs ");
		sqlQuery.append("JOIN HRB_SOP_WARNING_STATUS hsows ON (hsows.WARNING_STATUS_ID = hscs.WARNING_STATUS_ID) ");
		sqlQuery.append("JOIN HRB_SOP_WARNING_STEP hsws ON (hsws.WARNING_STEP_ID = hscs.WARNING_STEP_ID) ");
		sqlQuery.append("WHERE hscs.OFFICE_GL_DEPT_ID= :officeId AND hsws.WARNING_STEP_ID IN (:warning)");
		//sqlQuery.append(warning);
		return sqlQuery.toString();
	}
	
	
	/**  saving the details of the status changed corresponding to office Id **/
	@Override
	public String savingWarningStatus(String officeId, String warningName, String date, String omWarningStatus,
			String exception, String exceptionReason,String warningCycleId,String psID) throws SopCustomException{
		//NamedParameterJdbcTemplate insertionJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		String result;
		int warningStatusId=0;
		log.info("Entering WarningStatus Updation Process DaoImpl");
		try {
			if(omWarningStatus.equalsIgnoreCase("Active")) {
				warningStatusId=1;
			}else if(omWarningStatus.equalsIgnoreCase("Confirmed")) {
				warningStatusId=2;
			}else if(omWarningStatus.equalsIgnoreCase("Exception")) {
				warningStatusId=3;
			}else if(omWarningStatus.equalsIgnoreCase("Received")) {
				warningStatusId=4;
			}else if(omWarningStatus.equalsIgnoreCase("Confirm-Fit for Role")) {
				warningStatusId=5;
			}else if(omWarningStatus.equalsIgnoreCase("Confirm-Termination")) {
				warningStatusId=6;
			}else if(omWarningStatus.equalsIgnoreCase("Confirm-Keep Coaching")) {
				warningStatusId=7;
			}
			MapSqlParameterSource namedParameters = new MapSqlParameterSource();
			 namedParameters.addValue("status", 2);
			 namedParameters.addValue("officeId", Integer.valueOf(officeId));
			 namedParameters.addValue("warningCycleId", Integer.valueOf(warningCycleId));
			 namedParameters.addValue("omWarningStatus", warningStatusId);
			 namedParameters.addValue("warningName", Integer.valueOf(warningName));
			 namedParameters.addValue("exceptionReason", exceptionReason);
			 namedParameters.addValue("user", 12345);
			 namedParameters.addValue("dates", new Date());
			int row = npJdbcTemplate.update(insertSql(), namedParameters);
			if(row >=1) {
				MapSqlParameterSource namedParam = new MapSqlParameterSource();
				namedParam.addValue("warningName", Integer.valueOf(warningName));
				namedParam.addValue("omWarningStatus", warningStatusId);
				namedParameters.addValue("dates", new Date());
				namedParam.addValue("officeId", Integer.valueOf(officeId));
				namedParam.addValue("warningCycleId", Integer.valueOf(warningCycleId));
				
				int updatedRows = npJdbcTemplate.update(updateAccountabilitySql(), namedParam);
				if(updatedRows >=1) {
					if(warningStatusId==4) {
						SqlParameterSource inn = new MapSqlParameterSource().addValue("P_OFFICE_GL_DEPT_ID", Integer.valueOf(officeId)).addValue("P_WARNING_CYCLE_ID", Integer.valueOf(warningCycleId))
								.addValue("P_WARNING_STEP_ID", Integer.valueOf(warningName)).addValue("P_WARNING_STATUS_ID", warningStatusId);
						 
						simpleJdbcCall.withProcedureName("SOP_DLT_DECISION_RECEIVED");
						
						Map<String, Object> procedureResultSet = simpleJdbcCall.execute(inn);
					}
					result= "success";
				}else {
					result= "failure";
				}
				
			}else {
				result="failure";
			}
		}catch (Exception e) {
			log.error("Exception occured at WarningStatus Updation DaoImpl: ",e);
			//System.err.print(e);
			e.printStackTrace();
			throw new SopCustomException("Exception caught at DAOImpl");
		}
		log.info("Exiting WarningStatus Updation Process DaoImpl");
		return result;
	}
	
	private String insertSql() {
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("INSERT INTO hrb_sop_current_status(STATUS_ROW_NO,OFFICE_GL_DEPT_ID,WARNING_CYCLE_ID,WARNING_STEP_ID,WARNING_STATUS_ID,EXCEPTION_REASON_TXT,LAST_UPDATED_USER_ID,UPDATED_TS) "); 
		sqlQuery.append("VALUES (:status,:officeId,:warningCycleId,:warningName,:omWarningStatus,:exceptionReason,:user,:dates)");
		return sqlQuery.toString();
	}
	
	private String updateAccountabilitySql() {
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("UPDATE HRB_SOP_ACCOUNTABILITY SET WARNING_STEP_ID= :warningName ,WARNING_STATUS_ID= :omWarningStatus,LAST_UPDATED_TS= :dates");
		sqlQuery.append("WHERE OFFICE_GL_DEPT_ID=:officeId AND WARNING_CYCLE_ID= :warningCycleId ");
		return sqlQuery.toString();
	}


}
