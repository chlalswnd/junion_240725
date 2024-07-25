package com.boot.Service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.DAO.CardPageDAO;
import com.boot.DAO.ComNoticeDAO;
import com.boot.DAO.CompanyInfoDAO;
import com.boot.DAO.CompanyListPageDAO;
import com.boot.DTO.Standard;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Service("CompanyListPageService")
public class CompanyListPageServiceImpl implements CompanyListPageService{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<CompanyInfoDAO> companyListPage(Standard std) {
		log.info("CompanyListPageServiceImpl");
		
		CompanyListPageDAO dao = sqlSession.getMapper(CompanyListPageDAO.class);
		ArrayList<CompanyInfoDAO> list = dao.companyListPage(std);
		return list;
	}

}
