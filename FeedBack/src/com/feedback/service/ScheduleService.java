package com.feedback.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.feedback.dao.ScheduleMapper;
import com.feedback.domain.Schedule;;

@Service("scheduleService")
@Scope("singleton")
public class ScheduleService {
	@Resource
	private ScheduleMapper scheduleServ;
	@Resource
	private ScheduleMapper scheduleDAO;
	
	public List<Schedule> showCourseInfo(String tino){
		System.out.println("success into showCourseInfo");
		
		Schedule schedule = scheduleDAO.showCname(tino);
		List<Schedule> list = scheduleDAO.showCourseInfo(tino);
		
		
		
		for(int i=0;i<list.size();i++){
			list.get(i).setCname(schedule.getCname());
			System.out.println("得到课程信息为 "+list.get(i).getCname()+" "+list.get(i).getAdd()+"开始"+list.get(i).getStartsection()+"结束"+list.get(i).getEndsection());
		}
		
		//System.out.println("得到星期为"+schedule_2.getDay());
		return list;
	}
}
