package com.hrblock.sop.app.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.hrblock.sop.app.model.WarningStatusDetails;
import com.hrblock.sop.app.util.SOPUtil;

/**
 *  @author  Umesh Kumar M
 *  @version     1.0
 *  @since       1.0
 *  Release Date: 
 *  <p>
 *  Revision History: 
 * 
 */ 

public class OfficeWarningDetailRowMapper implements RowMapper<WarningStatusDetails> {

	Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private SOPUtil soputil;
	@Override
	public WarningStatusDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub

		WarningStatusDetails warningStatusDetailsBean = new WarningStatusDetails();
		SimpleDateFormat mdyFormat = new SimpleDateFormat("MM-dd-yyyy");
		 
		// String dateVal = mdyFormat.format(newDate);
		log.info("OfficeWarningDetailRowMapper - Entering the mapper");
	/*	if (rs.next() == false) {
			throw new SQLException("Exception Caught at OfficeWarning Row Mapper ");
		} else {
			while (rs.next()) {*/
				if (rs.getString("dates") != null) {
					java.util.Date newDate = rs.getTimestamp("dates");
					String dateVal = mdyFormat.format(newDate);
					warningStatusDetailsBean.setDate(dateVal);
				} 
				if (rs.getString("omWarStatus") != null) {
					warningStatusDetailsBean.setOmWarningStatus(rs.getString("omWarStatus"));
				}

				if (rs.getString("omStepid") != null && rs.getString("omStepid").toString().equals("4")) {
					warningStatusDetailsBean.setException("Yes");
					warningStatusDetailsBean.setExceptionReason(rs.getString("exceptionReason"));
				} else {
					warningStatusDetailsBean.setException("No");
					warningStatusDetailsBean.setExceptionReason("");
				}

				if (rs.getString("omStepid") != null) {
					warningStatusDetailsBean.setOmStepId(Integer.parseInt(rs.getString("omStepid")));
				} 
				if (rs.getString("warningid") != null) {
					warningStatusDetailsBean.setWarningId(Integer.parseInt(rs.getString("warningid")));
				} 
				if (rs.getString("warnings") != null) {
					warningStatusDetailsBean.setWarningName(rs.getString("warnings"));
				}
				if (rs.getString("warningCycle") != null) {
					warningStatusDetailsBean.setWarningCycleId(Integer.parseInt(rs.getString("warningCycle")));
				} 

			/*}

		}*/
		log.info("OfficeWarningDetailRowMapper - Existing the mapper");
		return warningStatusDetailsBean;
	}

}
