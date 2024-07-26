package com.boot.DAO;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.boot.DTO.Standard;
import com.boot.DTO.Standard2;

@Mapper
public interface CompanyPageDAO {
//	public ArrayList<ComNoticeDAO> cardPageList(Standard std);// 페이징을 위한 메소드
	public ArrayList<CompanyInfoDAO> companyPageList(Standard2 std);// 페이징을 위한 메소드
//	public ArrayList<ComNoticeDAO> cardPageList(CardPageDAO dao);// 페이징을 위한 메소드
}
