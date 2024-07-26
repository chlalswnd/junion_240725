package com.boot.Service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.DAO.CardPageDAO;
import com.boot.DAO.ComNoticeDAO;
import com.boot.DAO.CompanyInfoDAO;
import com.boot.DAO.CompanyPageDAO;
import com.boot.DTO.Standard;
import com.boot.DTO.Standard2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("CompanyPageService")
public class CompanyPageServiceImpl implements CompanyPageService{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<CompanyInfoDAO> companyPageList(Standard2 std) {
//	public ArrayList<ComNoticeDAO> cardPageList(CardPageDAO dao) {
		log.info("CompanyPageServiceImpl");
		
		CompanyPageDAO dao = sqlSession.getMapper(CompanyPageDAO.class);
//		CardPageDAO daos = sqlSession.getMapper(CardPageDAO.class);
//		ArrayList <ComNoticeDAO> list = dao.cardPageList(std);
		ArrayList <CompanyInfoDAO> list = dao.companyPageList(std);
//		ArrayList <ComNoticeDAO> list = daos.cardPageList(dao);
		
		return list;
	}

}
