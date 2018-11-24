package com.feedback.dao;
import java.util.List;
import java.util.Map;

import com.feedback.domain.Administrators;

public interface AdministratorsMapper {
	public Administrators showAdmInfo(String admno);
	public void updateAdmInfo(Map<String,Object> map);
	public List<Administrators> queryAll();
	public void deleteAdm(String admno);
	public boolean deleteAdmByAdmno(String admno);
	public int queryManageAdmMaxPageCount(Map<String, Object> map);
	public List<Administrators> queryByPage(Map<String, Object> map);
	public boolean updateAdm(Map<String, String> map);
}
