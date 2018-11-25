package com.feedback.state;

import com.feedback.state.PageQueryState;

public class StudentCourseQueryState extends PageQueryState{

	public StudentCourseQueryState() {}
	
	public StudentCourseQueryState(int curPage) {
		setCurPage(curPage);
	}

	@Override
	public String toString() {
		return "StudentCourseQueryState [getLastPage()=" + getLastPage() + ", getCurPage()=" + getCurPage()
				+ "]";
	}
	
	
}
