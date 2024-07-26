package com.boot.Service;

import java.util.ArrayList;

import com.boot.DAO.CardPageDAO;
import com.boot.DAO.ComNoticeDAO;
import com.boot.DAO.CompanyInfoDAO;
import com.boot.DTO.Standard;
import com.boot.DTO.Standard2;

public interface CompanyPageService {
//	public ArrayList<ComNoticeDAO> cardPageList(Standard std);// 페이징을 위한 메소드
	public ArrayList<CompanyInfoDAO> companyPageList(Standard2 std);// 페이징을 위한 메소드
//	public ArrayList<ComNoticeDAO> cardPageList(CardPageDAO dao);// 페이징을 위한 메소드
}
