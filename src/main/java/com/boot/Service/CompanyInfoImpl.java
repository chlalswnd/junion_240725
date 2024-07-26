package com.boot.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.DAO.CompanyAttachDAO;
import com.boot.DAO.CompanyInfoDAO;
import com.boot.DAO.JoinDAO;
import com.boot.DAO.boardBoardDAO;
import com.boot.DTO.ComNoticeDTO;
import com.boot.DTO.CompanyInfoDTO;
import com.boot.DTO.Criteria4;
import com.boot.DTO.JoinDTO;
import com.boot.DTO.boardBoardDTO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service("CompanyInfo")
public class CompanyInfoImpl implements CompanyInfo{

	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<CompanyInfoDTO> comList(Criteria4 cri) {  
		log.info("@# comList list");
		
		CompanyInfoDAO dao = sqlSession.getMapper(CompanyInfoDAO.class); 
		ArrayList<CompanyInfoDTO> list = dao.comList(cri);  // dao값을 배열CompanyInfoDTO 'list' 에 집어넣음
		
		// 스택 리스트 콤마로 나눠서 배열에 담음
		for (int i = 0; i < list.size(); i++) {
			String stackList = list.get(i).getStack_names();
			if (stackList != null && !stackList.isEmpty()) {
	            List<String> stacks = Arrays.asList(stackList.split(","));
	            list.get(i).setStackList(stacks);
	        } else {
	            list.get(i).setStackList(new ArrayList<>()); // 빈 리스트 설정
	        }
		}
		
		return list;
	}
	
	@Override
	public CompanyInfoDTO comInfoByNum(int com_num) {
		CompanyInfoDAO dao = sqlSession.getMapper(CompanyInfoDAO.class); 
		CompanyInfoDTO dto = dao.comInfoByNum(com_num);
		return dto;
	}

	@Override
	public ArrayList<CompanyInfoDTO> comListByNum(String comScrapArrStr) {
		log.info("@# comList list");

		// 쉼표로 구분된 문자열을 정수 리스트로 변환
		List<Integer> comList = Arrays.stream(comScrapArrStr.split(","))
				.map(String::trim)          // 각 문자열의 양쪽 공백 제거
				.map(Integer::parseInt)     // 문자열을 정수로 변환
				.collect(Collectors.toList());
		
		log.info("@# comListByNum comList=>"+comList);
		
		ArrayList<CompanyInfoDTO> list = new ArrayList<>();
		
		CompanyInfoDAO dao = sqlSession.getMapper(CompanyInfoDAO.class); 
		for (int com_num : comList) {
			CompanyInfoDTO dto = dao.comInfoByNum(com_num);
            list.add(dto);
		log.info("@# comListByNum list=>"+list);
     }
				
		return list;
	}
	
	
	
	
	@Override
	public CompanyInfoDTO companyInfo(String email) {//기업 정보 페이지
		log.info("@# CompanyInfoImpl companyInfo");
		
		CompanyInfoDAO dao= sqlSession.getMapper(CompanyInfoDAO.class);
		CompanyInfoDTO dto = dao.companyInfo(email);
		 log.info("@# companyInfo =>"+dto);
		
		return dto;
	}
	
	@Override
	public CompanyInfoDTO InfoMini(String email) {//기업 정보 수정(기본) 뿌릴 내용
		
		CompanyInfoDAO dao= sqlSession.getMapper(CompanyInfoDAO.class);
		CompanyInfoDTO dto = dao.InfoMini(email);
		 log.info("@# company Info =>"+dto);
		
		return dto;
	}
	
	@Override
	public void modify_Info(HashMap<String, String> param) {//기업 기본정보 수정(업데이트)
		log.info("@# CompanyInfoImpl modify");
		
		CompanyInfoDAO dao = sqlSession.getMapper(CompanyInfoDAO.class);
		dao.modify_Info(param);
		
	}
	
	@Override
	public void modify_Detail(HashMap<String, String> param) {//상세정보 수정
		log.info("@# CompanyInfoImpl modify");
		
		CompanyInfoDAO dao = sqlSession.getMapper(CompanyInfoDAO.class);
		dao.modify_Detail(param);
		
	}


	@Override
	public CompanyInfoDTO companyInfoUpdate(String email) {//기업 정보 수정 페이지 이동

		CompanyInfoDAO dao= sqlSession.getMapper(CompanyInfoDAO.class);
		CompanyInfoDTO dto = dao.companyInfoUpdate(email);
		log.info("@# CompanyInfoImpl companyInfoUpdate dto=>"+dto);
		
		return dto;
	}
	
	@Override
	public void modify_Detail(CompanyInfoDTO companyInfoDTO) {
			log.info("@# resumeWrite service impl ==>>");
			
			CompanyInfoDAO dao = sqlSession.getMapper(CompanyInfoDAO.class);
			dao.modify_Detail(companyInfoDTO);
			
			
			// 파일업로드 시작 //
			log.info("@# 보드서비스임플 boardDTO.getAttachList()=>"+companyInfoDTO.getCompanyAttachList());
			CompanyAttachDAO adao = sqlSession.getMapper(CompanyAttachDAO.class);
//			첨부파일 있는지 체크
			if (companyInfoDTO.getCompanyAttachList() == null || companyInfoDTO.getCompanyAttachList().size() == 0) {
				log.info("@# null");
				return;
			}
			
//			첨부파일이 있는 경우 처리  // 첨부파일이 있는 경우에는 그 게시글와 boardNO로 일치하는 위치에 insertFile해준다.
			
			companyInfoDTO.getCompanyAttachList().forEach(attach -> {   // boardDTO에 파일리스트에 반복문 실행, 'attach' 변수? 에 boardDTO 에 있는 getBoardNo를/'attach'에 setBoardNo를 사용하여 담는다
				attach.setCom_email(companyInfoDTO.getCom_email());
				
				adao.comInfoInsertFile(attach); // ('adao.insertFile'(BoardAttachDAO 에 있는 객체?))에 'attach' 정보를 담는다
			});
			// 파일업로드 끝 //
			
		}

/*
	07/25 10:40 민중
*/
	@Override
	public ArrayList<String> getJobList() {
		log.info("@# getJobList");
		CompanyInfoDAO dao = sqlSession.getMapper(CompanyInfoDAO.class);
		ArrayList<String> list = dao.getJobList();
		return list;
	}
	
	@Override
	public ArrayList<String> getStackList() {
		log.info("@# getStackList");
		CompanyInfoDAO dao = sqlSession.getMapper(CompanyInfoDAO.class);
		ArrayList<String> list = dao.getStackList();
		return list;
	}

	@Override
	public ArrayList<String> getLocationList() {
		log.info("@# getLocationList");
		CompanyInfoDAO dao = sqlSession.getMapper(CompanyInfoDAO.class);
		ArrayList<String> list = dao.getLocationList();
		return list;
	}

/*
	07/26 11:50 민중
*/
	@Override
	public int getTotalCount() {
		CompanyInfoDAO dao = sqlSession.getMapper(CompanyInfoDAO.class);
		int total = dao.getTotalCount();
		return total;
	}

}