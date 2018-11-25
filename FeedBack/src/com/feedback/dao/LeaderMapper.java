package com.feedback.dao;
import java.util.List;
import java.util.Map;

import com.feedback.domain.Leader;
public interface LeaderMapper {
	public List<Leader> queryAll();
	public List<Leader> queryByPage(Map<String,Object> map);
	public void update(Leader leader);
	public void insert(Leader leader);
	public void deleteLeader(String lno);
	public void updateInfo(Map<String,Object> map);
}
