package com.boot.Service;

import java.util.ArrayList;

import com.boot.DAO.CompanyInfoDAO;
import com.boot.DTO.Standard;

public interface CompanyListPageService {
	public ArrayList<CompanyInfoDAO> companyListPage(Standard std);// 페이징을 위한 메소드
}
