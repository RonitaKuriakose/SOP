package com.hrblock.sop.app.dao;

import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hrblock.sop.app.model.SOPOffice;
import com.hrblock.sop.app.model.SopMainDetails;
import com.hrblock.sop.app.model.WarningStatusDetails;
import com.hrblock.sop.app.rowmapper.OfficeWarningDetailRowMapper;
import com.hrblock.sop.app.rowmapper.SopMainDetailRowMapper;

@Repository
public class SopDAOImpl implements SopDAO {

	@Autowired
	private DataSource dataSource;
	

	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	/** fetch office lists from db corresponding to the user details  **/
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	    return new PersistenceExceptionTranslationPostProcessor();
	}
	
	
	@Override
	public List<SopMainDetails> getSopMainDetails(List<Integer> districtList) {
		
		NamedParameterJdbcTemplate npJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("districtlist", districtList);

		List<SopMainDetails> sopMainDetails = npJdbcTemplate.query(getSQL(), parameters,
				new SopMainDetailRowMapper());
		return sopMainDetails;
	}

	private String getSQL() {
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("SELECT market_nm,region_nm,district_nm,officeid,warning_status,last_update_ts ");
		sqlQuery.append("FROM HRB_SOP_ACCOUNT WHERE district_id IN (:districtlist)");
		return sqlQuery.toString();

	}

	/**  fetching the details of the warning status details for the office id **/
	
	@Override
	public SOPOffice fetchWarningDetailsOfOffice(String officeId) {
		
		SOPOffice sopOffice = new SOPOffice();
		NamedParameterJdbcTemplate warJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("officeId", Integer.parseInt(officeId));
		
		String verbal="1";
		String written="2";
		String finalw="3";
		String decision="4";
		
		List<WarningStatusDetails> verbalWarningDetails =  warJdbcTemplate.query(getWarningSQL(verbal), parameters,
				new OfficeWarningDetailRowMapper());
		List<WarningStatusDetails> writtenWarningDetails =  warJdbcTemplate.query(getWarningSQL(written), parameters,
				new OfficeWarningDetailRowMapper());
		List<WarningStatusDetails> finalWarningDetails =  warJdbcTemplate.query(getWarningSQL(finalw), parameters,
				new OfficeWarningDetailRowMapper());
		List<WarningStatusDetails> decisionWarningDetails =  warJdbcTemplate.query(getWarningSQL(decision), parameters,
				new OfficeWarningDetailRowMapper());
		
		
		sopOffice.setOfficeID(Integer.parseInt(officeId));
		sopOffice.setOmName("HnR");
		sopOffice.setVerbalWarning(verbalWarningDetails);
		sopOffice.setWrittenWarning(writtenWarningDetails);
		sopOffice.setFinalWarning(finalWarningDetails);
		sopOffice.setDecision(decisionWarningDetails);
		
		return sopOffice;
	}
	
	private String getWarningSQL(String warning) {
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("SELECT hscs.last_updated_ts as dates,hsows.status_nm as omWarStatus, ");
		sqlQuery.append("hscs.reason as exceptionReason,hsws.warning_steps as warnings,hsws.warning_stepid as warningid,hsows.statusid as omStepid ");
		sqlQuery.append(" FROM HRB_SOP_CURRENT_STATUS hscs ");
		sqlQuery.append("JOIN HRB_SOP_OM_WARNING_STATUS hsows ON (hsows.statusid = hscs.om_warning_statusid) ");
		sqlQuery.append("JOIN HRB_SOP_WARNING_STEP hsws ON (hsws.warning_stepid = hscs.warning_stepid) ");
		sqlQuery.append("WHERE hscs.officeid= :officeId AND hsws.warning_stepid =");
		sqlQuery.append(warning);
		return sqlQuery.toString();
	}
	
	
	/**  saving the details of the status changed corresponding to office Id **/
	@Override
	public String savingWarningStatus(String officeId, String warningName, String date, String omWarningStatus,
			String exception, String exceptionReason) {
		NamedParameterJdbcTemplate insertionJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		String result;
		int warningStatusId=0;
		 //Object[] params = new Object[] { officeId, omWarningStatus, warningName, exceptionReason,new Date() };
		if(omWarningStatus.equalsIgnoreCase("Active")) {
			warningStatusId=1;
		}else if(omWarningStatus.equalsIgnoreCase("Confirmed")) {
			warningStatusId=2;
		}else if(omWarningStatus.equalsIgnoreCase("Exception")) {
			warningStatusId=3;
		}else if(omWarningStatus.equalsIgnoreCase("Received")) {
			warningStatusId=4;
		}else if(omWarningStatus.equalsIgnoreCase("Confirmed -“ Fit for Role")) {
			warningStatusId=5;
		}else if(omWarningStatus.equalsIgnoreCase("Confirmed -“ Termination")) {
			warningStatusId=6;
		}else if(omWarningStatus.equalsIgnoreCase("Confirmed -“ Keep Coaching")) {
			warningStatusId=7;
		}
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		 namedParameters.addValue("officeId", Integer.valueOf(officeId));
		 namedParameters.addValue("omWarningStatus", warningStatusId);
		 namedParameters.addValue("warningName", Integer.valueOf(warningName));
		 namedParameters.addValue("exceptionReason", exceptionReason);
		 namedParameters.addValue("dates", new Date());
		int row = insertionJdbcTemplate.update(insertSql(), namedParameters);
		if(row >=1) {
			result= "success";
		}else {
			result="failure";
		}
		return result;
	}
	
	private String insertSql() {
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("INSERT INTO hrb_sop_current_status(OFFICEID,OM_WARNING_STATUSID,WARNING_STEPID,REASON,LAST_UPDATED_TS) "); 
		sqlQuery.append("VALUES (:officeId,:omWarningStatus,:warningName,:exceptionReason,:dates)");
		return sqlQuery.toString();
	}


}
