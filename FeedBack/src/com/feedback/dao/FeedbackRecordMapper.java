package com.feedback.dao;

import java.util.List;
import java.util.Map;

import com.feedback.domain.FeedbackRecord;
import com.feedback.state.FeedbackRecordQueryState;

public interface FeedbackRecordMapper {
	
	public int queryMaxCount();
	public int queryMaxCountByLeader();
	public int queryMaxCountByTeacher(String tno);
	public int queryMaxCountBySno(String sno);
	public List<FeedbackRecord> queryFeedbackBySno(Map<String, Object> map);
	public List<FeedbackRecord> queryFeedbackByTno(Map<String, Object> map);
	public List<FeedbackRecord> queryLeaderFeedback(Map<String, Object> map);
	public List<FeedbackRecord> queryAll(Map<String, Object> map);
}
