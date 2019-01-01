package com.hrblock.sop.app.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import com.hrblock.sop.app.model.SopMainDetails;

public class SopMainDetailRowMapper implements RowMapper<SopMainDetails> {
	   public SopMainDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			
		   String warningName;
		   SimpleDateFormat mdyFormat = new SimpleDateFormat("MM-dd-yyyy");
		   
		   SopMainDetails sopMainDetailsBean = new SopMainDetails();
			sopMainDetailsBean.setMarket(rs.getString("market_nm"));
			sopMainDetailsBean.setRegion(rs.getString("region_nm"));
			sopMainDetailsBean.setDistrict(rs.getString("district_nm"));
			sopMainDetailsBean.setOfficeId(Integer.parseInt(rs.getString("officeid")));
			if(rs.getString("warning_status").toString().equals("0")) {
				warningName="Not On Path";
			}else {
				warningName="On Path";
			}
			sopMainDetailsBean.setOmWarningStatusName(warningName);
			
			
			//Date date=new Date(rs.getString("last_update_ts"));
//			String dtaestr=rs.getString("last_update_ts");
			
			java.util.Date newDate = rs.getTimestamp("last_update_ts");
			
			//				Date parsedDate = mdyFormat.parse(rs.getString("last_update_ts").toString());
							String dateVal = mdyFormat.format(newDate);
							sopMainDetailsBean.setLastUpdated(dateVal);
			
			
		      return sopMainDetailsBean;
		   }
		}