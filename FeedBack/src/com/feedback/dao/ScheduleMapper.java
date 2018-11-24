package com.feedback.dao;

import java.util.List;

import com.feedback.domain.Schedule;



public interface ScheduleMapper {
	public Schedule showCname(String tino);
	public List<Schedule> showCourseInfo(String tino);
}
