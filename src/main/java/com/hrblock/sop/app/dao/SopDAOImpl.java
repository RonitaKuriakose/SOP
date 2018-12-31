package com.hrblock.sop.app.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.hrblock.sop.app.model.SOPOffice;
import com.hrblock.sop.app.model.SopMainDetails;
import com.hrblock.sop.app.model.OmWarningStatus;
import com.hrblock.sop.app.rowmapper.OfficeWarningDetailRowMapper;
import com.hrblock.sop.app.rowmapper.SopMainDetailRowMapper;

public class SopDAOImpl implements SopDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private StringBuilder sqlQuery = new StringBuilder();

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	/** fetch office lists from db corresponding to the user details  **/
	
	@Override
	public List<SopMainDetails> getSopMainDetails(List<Integer> districtList) {

		NamedParameterJdbcTemplate npJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("districtlist", districtList);

		List<SopMainDetails> sopMainDetails = npJdbcTemplate.query(getSQL(), parameters,
				new SopMainDetailRowMapper());
		return sopMainDetails;
	}

	private String getSQL() {
		sqlQuery.append("SELECT market_nm,region_nm,district_nm,officeid,warning_status,last_update_ts ");
		sqlQuery.append("FROM HRB_SOP_ACCOUNT WHERE district_id IN (:districtlist)");
		return sqlQuery.toString();

	}

	/**  fetching the details of the warning status details for the office id **/
	
	@Override
	public SOPOffice fetchWarningDetailsOfOffice(String officeId) {
		
		SOPOffice sopOffice = new SOPOffice();
		NamedParameterJdbcTemplate warJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("officeId", Integer.parseInt(officeId));
		
		String verbal="1";
		String written="2";
		String finalw="3";
		String decision="4";
		
		List<WarningStatusDetailsBean> verbalWarningDetails =  warJdbcTemplate.query(getWarningSQL(verbal), parameters,
				new OfficeWarningDetailRowMapper());
		List<WarningStatusDetailsBean> writtenWarningDetails =  warJdbcTemplate.query(getWarningSQL(written), parameters,
				new OfficeWarningDetailRowMapper());
		List<WarningStatusDetailsBean> finalWarningDetails =  warJdbcTemplate.query(getWarningSQL(finalw), parameters,
				new OfficeWarningDetailRowMapper());
		List<WarningStatusDetailsBean> decisionWarningDetails =  warJdbcTemplate.query(getWarningSQL(decision), parameters,
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
		sqlQuery.append("SELECT hscs.last_updated_ts as dates,hsows.status_nm as omWarStatus,");
		sqlQuery.append("hscs.reason as exceptionReason,hsws.warning_steps as warnings,hsws.warning_stepid as warningid,hsows.statusid as omStepid ");
		sqlQuery.append(" FROM HRB_SOP_CURRENT_STATUS hscs ");
		sqlQuery.append("JOIN HRB_SOP_OM_WARNING_STATUS hsows ON (hsows.statusid = hscs.om_warning_statusid) ");
		sqlQuery.append("JOIN HRB_SOP_WARNING_STEP hsws ON (hsws.warning_stepid = hscs.warning_stepid) ");
		sqlQuery.append("WHERE hscs.officeid= :officeId AND hsws.warning_stepid =");
		sqlQuery.append(warning);
		return sqlQuery.toString();
	}


}
