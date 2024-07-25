package com.boot.DAO;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.boot.DTO.CompanyInfoDTO;

@Mapper
public interface CompanyInfoDAO {
	public CompanyInfoDTO companyInfo(String email);//기업 정보 페이지
	public CompanyInfoDTO InfoMini(String email);//기업 기본정보 조회 페이지
	public void modify_Info(HashMap<String, String> param);//기업 기본정보 수정
	public CompanyInfoDTO companyInfoUpdate(String com_email);//기업 상세정보 수정 페이지
	public void modify_Detail(HashMap<String, String> param);
	public void modify_Detail(CompanyInfoDTO companyInfoDTO);
	public ArrayList<CompanyInfoDTO> comList();//기업목록
	public ArrayList<CompanyInfoDTO> comListByNum(String comScrapArrStr);//기업목록
	public CompanyInfoDTO comInfoByNum(int com_num);//기업정보조회
	
/*
	07/25 10:40 민중
	드롭다운 db추가
*/
	public ArrayList<String> getJobList(); // 직군/직무 리스트
	
	public ArrayList<String> getStackList(); // 기술 스킬 리스트

	public ArrayList<String> getLocationList(); // 지역 리스트
}  
