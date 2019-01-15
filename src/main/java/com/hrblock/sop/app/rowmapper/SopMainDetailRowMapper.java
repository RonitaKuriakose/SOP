package com.hrblock.sop.app.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.hrblock.sop.app.model.SopMainDetails;

/**
 * @author Umesh Kumar M
 * @version 1.0
 * @since 1.0 Release Date:
 *        <p>
 *        Revision History:
 * 
 */

public class SopMainDetailRowMapper implements RowMapper<SopMainDetails> {
	
	/*@Autowired
	private SOPUtil soputil;*/
	
	public SopMainDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

		
		String warningName;
		Logger log = Logger.getLogger(this.getClass());
		SimpleDateFormat mdyFormat = new SimpleDateFormat("MM-dd-yyyy");
		SopMainDetails sopMainDetailsBean=null;

		
		try {
			log.info("SopMainDetailRowMapper - Entering the mapper");
			/*if (!rs.next()) {
				throw new SopCustomException("Could not find the list of the Offices for the user ");
			}else*/ 
//			while(rs.next()){
				sopMainDetailsBean = new SopMainDetails();
				if (rs.getString("ACC_ROW_NO") != null) {
					sopMainDetailsBean.setAccRowId(Integer.parseInt(rs.getString("ACC_ROW_NO")));
				} else {
					sopMainDetailsBean.setOfficeId(Integer.parseInt("0"));
				}
				if (rs.getString("MARKET_NM") != null) {
					sopMainDetailsBean.setMarket(rs.getString("MARKET_NM"));
				} else {
					sopMainDetailsBean.setMarket("NA");
				}
				if (rs.getString("REGION_NM") != null) {
					sopMainDetailsBean.setRegion(rs.getString("REGION_NM"));
				} else {
					sopMainDetailsBean.setRegion("NA");
				}
				if (rs.getString("DISTRICT_NM") != null) {
					sopMainDetailsBean.setDistrict(rs.getString("DISTRICT_NM"));
				} else {
					sopMainDetailsBean.setDistrict("NA");
				}
				if (rs.getString("OFFICE_GL_DEPT_ID") != null) {
					sopMainDetailsBean.setOfficeId(Integer.parseInt(rs.getString("OFFICE_GL_DEPT_ID")));
				} else {
					sopMainDetailsBean.setOfficeId(Integer.parseInt("0"));
				}
				if (rs.getString("WARNING_STEP_NM") != null) {
					sopMainDetailsBean.setWarningStepName(rs.getString("WARNING_STEP_NM"));
				} else {
					sopMainDetailsBean.setWarningStepName("NA");
				}
				if (rs.getString("WARNING_STATUS_NM") != null) {
					sopMainDetailsBean.setOmWarningStatusName(rs.getString("WARNING_STATUS_NM"));
				} else {
					sopMainDetailsBean.setOmWarningStatusName("NA");
				}
				
				if (rs.getString("OFFICE_MGR_NM") != null) {
					sopMainDetailsBean.setOmName(rs.getString("OFFICE_MGR_NM"));
				} else {
					sopMainDetailsBean.setOmName("NA");
				}
				if (rs.getString("LAST_UPDATED_TS") != null) {
					java.util.Date newDate = rs.getTimestamp("LAST_UPDATED_TS");
					String dateVal = mdyFormat.format(newDate);
					sopMainDetailsBean.setLastUpdated(dateVal);
				} else {
					sopMainDetailsBean.setLastUpdated("NA");
				}
				if (rs.getString("WARNING_CYCLE_ID") != null) {
					sopMainDetailsBean.setWarningCycleId(Integer.parseInt(rs.getString("WARNING_CYCLE_ID")));
				} else {
					sopMainDetailsBean.setWarningCycleId(Integer.parseInt("0"));
				}
//			}

			
			
			
			//Date parsedDate = mdyFormat.parse(rs.getString("last_update_ts").toString());
			//String dateVal = mdyFormat.format(newDate);
			//sopMainDetailsBean.setLastUpdated(dateVal);

		} catch (Exception e) {
			System.err.print(e);
		}

		
		log.info("SopMainDetailRowMapper - Existing the mapper");
		return sopMainDetailsBean;
	}
}