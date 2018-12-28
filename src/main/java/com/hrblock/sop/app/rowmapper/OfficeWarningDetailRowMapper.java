package com.hrblock.sop.app.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import com.hrblock.sop.app.model.WarningStatusDetailsBean;

public class OfficeWarningDetailRowMapper implements RowMapper<WarningStatusDetailsBean>{

	@Override
	public WarningStatusDetailsBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		WarningStatusDetailsBean warningStatusDetailsBean = new WarningStatusDetailsBean();
		SimpleDateFormat mdyFormat = new SimpleDateFormat("MM-dd-yyyy");
		java.util.Date newDate = rs.getTimestamp("dates");
		String dateVal = mdyFormat.format(newDate);
			warningStatusDetailsBean.setDate(dateVal);
			warningStatusDetailsBean.setOmWarningStatus(rs.getString("omWarStatus"));
			if(rs.getString("omStepid")!=null && rs.getString("omStepid").toString().equals("4") ) {
				warningStatusDetailsBean.setException("Yes");
				warningStatusDetailsBean.setExceptionReason(rs.getString("exceptionReason"));
			}else {
				warningStatusDetailsBean.setException("No");
				warningStatusDetailsBean.setExceptionReason("");
			}
			
			warningStatusDetailsBean.setOmStepId(Integer.parseInt(rs.getString("omStepid")));
			warningStatusDetailsBean.setWarningId(Integer.parseInt(rs.getString("warningid")));
			warningStatusDetailsBean.setWarningName(rs.getString("warnings"));
				
		return warningStatusDetailsBean;
	}

}
