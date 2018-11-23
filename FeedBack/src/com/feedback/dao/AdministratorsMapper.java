package com.feedback.dao;
import java.util.List;

import com.feedback.domain.Administrators;

public interface AdministratorsMapper {
	public List<Administrators> queryAll();
	public void deleteAdm(String admno);
}
