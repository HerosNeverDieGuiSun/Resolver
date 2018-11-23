package com.feedback.state;

public class LeaderQueryState {
	private int curPage =0 ;
	private int lastPage = 0;
	public LeaderQueryState(){
		
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	
	
}
