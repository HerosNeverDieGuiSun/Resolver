package com.feedback.state;

import com.feedback.state.PageQueryState;

public class FeedbackRecordQueryState extends PageQueryState{

	public FeedbackRecordQueryState() {}
	
	public FeedbackRecordQueryState(int curPage) {
		setCurPage(curPage);
	}

	@Override
	public String toString() {
		return "FeedbackRecordQueryState [getLastPage()=" + getLastPage() + ", getCurPage()=" + getCurPage()
				+ "]";
	}
	
	
}
