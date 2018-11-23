package com.feedback.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.feedback.dao.FeedbackRecordMapper;
import com.feedback.domain.FeedbackRecord;
import com.feedback.state.FeedbackRecordQueryState;
import com.feedback.util.WebUtil;

@Service
@Scope("singleton")

public class FeedbackRecordService {
	@Resource
	private FeedbackRecordMapper feedbackDAO;
	
	public int getLastPage(FeedbackRecordQueryState state) throws Exception {
		int count = feedbackDAO.queryMaxCount();
		int maxPage = (count + WebUtil.MAX_PAGE_LINES - 1) / WebUtil.MAX_PAGE_LINES;
		int lastPage = (maxPage > 0) ? maxPage - 1 : 0;  
		
        return lastPage;
	}
	
	//学生查看自己的历史反馈
	public List<FeedbackRecord> getMyFeedback(String sNo,FeedbackRecordQueryState state,String page) throws Exception{
		int curPage = state.getCurPage();
		
		switch (page) {
			case "0":
				curPage = 0;
				break;
			case "cur":
				break;
			case "prev":
				if (curPage > 0) curPage--;
				break;
			case "next":
				if (curPage < state.getLastPage()) curPage++;
				break;
			default:
				curPage = state.getLastPage();
				break;
		}
		
		state.setCurPage(curPage);
		Map<String, Object> map = new HashMap<>();
		map.put("startRow", state.getCurPage() * WebUtil.MAX_PAGE_LINES);
		map.put("rowCount", WebUtil.MAX_PAGE_LINES);
		map.put("sno", sNo);

		List<FeedbackRecord> myFeedback = null;
		myFeedback = feedbackDAO.queryFeedbackBySno(map);
		return myFeedback;
	}
	
	public List<FeedbackRecord> getTeacherFeedback(String tNo,FeedbackRecordQueryState state,String page) throws Exception{
		int curPage = state.getCurPage();
		
		switch (page) {
			case "0":
				curPage = 0;
				break;
			case "cur":
				break;
			case "prev":
				if (curPage > 0) curPage--;
				break;
			case "next":
				if (curPage < state.getLastPage()) curPage++;
				break;
			default:
				curPage = state.getLastPage();
				break;
		}
		
		state.setCurPage(curPage);
		Map<String, Object> map = new HashMap<>();
		map.put("startRow", state.getCurPage() * WebUtil.MAX_PAGE_LINES);
		map.put("rowCount", WebUtil.MAX_PAGE_LINES);
		map.put("tno", tNo);
		List<FeedbackRecord> teacherFeedback = null;
		teacherFeedback = feedbackDAO.queryFeedbackByTno(map);
		
		return teacherFeedback;
	}
	
public List<FeedbackRecord> getLeaderFeedback(FeedbackRecordQueryState state,String page) throws Exception{
		
		int curPage = state.getCurPage();
		
		switch (page) {
			case "0":
				curPage = 0;
				break;
			case "cur":
				break;
			case "prev":
				if (curPage > 0) curPage--;
				break;
			case "next":
				if (curPage < state.getLastPage()) curPage++;
				break;
			default:
				curPage = state.getLastPage();
				break;
		}
		
		state.setCurPage(curPage);
		Map<String, Object> map = new HashMap<>();
		map.put("startRow", state.getCurPage() * WebUtil.MAX_PAGE_LINES);
		map.put("rowCount", WebUtil.MAX_PAGE_LINES);
		List<FeedbackRecord> leaderFeedback = null;
		leaderFeedback = feedbackDAO.queryLeaderFeedback(map);
		
		return leaderFeedback;
	}
	
	public List<FeedbackRecord> getAllFeedback(FeedbackRecordQueryState state,String page) throws Exception{
		int curPage = state.getCurPage();
		
		switch (page) {
			case "0":
				curPage = 0;
				break;
			case "cur":
				break;
			case "prev":
				if (curPage > 0) curPage--;
				break;
			case "next":
				if (curPage < state.getLastPage()) curPage++;
				break;
			default:
				curPage = state.getLastPage();
				break;
		}
		state.setCurPage(curPage);
		Map<String, Object> map = new HashMap<>();
		map.put("startRow", state.getCurPage() * WebUtil.MAX_PAGE_LINES);
		map.put("rowCount", WebUtil.MAX_PAGE_LINES);
		List<FeedbackRecord> allFeedback = null;
		allFeedback = feedbackDAO.queryAll(map);
		return allFeedback;
	}
}
