package com.boot.Service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.boot.DTO.ComNoticeAttachDTO;
import com.boot.DTO.ComNoticeDTO;

public interface recentNoticeService {
	public String getRecentNoticeArr(String user_email);// 최근 본 채용공고 목록 배열 가져오기
	public ComNoticeDTO getRecentNotice(int noticeNum);// 최근 본 채용공고 하나씩 가져오기
	public ArrayList<ComNoticeDTO> getRecentNoticeList(String recent_noticeNumArray);// 최근 본 채용공고 목록 가져오기
	
	
	
	
//	public ComNoticeDTO JobPost(int notice_num);//상세 채용공고 정보 가져오기
//	public String comLocation(String com_email);//상세 채용공고-회사 위치 가져오기
//	
//	
//
//    
//	public void registerNotice(ComNoticeDTO comNoticeDTO);
//	
////	파일업로드는 파라미터를 DTO 사용
//	public void registInsertFile(ComNoticeAttachDTO vo);  // 파라미터가 ComNoticeAttachDTO / 파일추가
//	public List<ComNoticeAttachDTO> registGetFileList(int notice_num); // int타입 notice_num파라미터를 list타입 <ComNoticeAttachDTO> getFileList로 사용하려함 / 파일열람
//	public void registDeleteFile(String notice_num);  // notice_num 맞춰서 파일삭제로직 / 파일삭제
//	
//    public List<Integer> getNoticeNums(@Param("com_email") String com_email); //notice_num 배열 가져오기
//    public void updateNoticeNums(@Param("com_email") String com_email, @Param("noticeNums") String noticeNums); //notice_num 배열 업데이트

	
}
