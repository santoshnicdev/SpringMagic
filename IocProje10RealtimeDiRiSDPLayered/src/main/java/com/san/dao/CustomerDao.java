package com.san.dao;

import java.sql.SQLException;

import com.san.bo.CustomerBo;

public interface CustomerDao {
	public int insert(CustomerBo cbo) throws SQLException ;

}
