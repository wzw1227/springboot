package com.wzw.springboot.service.Admin;

import com.wzw.springboot.dao.Admin.UsersDao;
import com.wzw.springboot.entity.Admin.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersServiceI {

	@Autowired
	private UsersDao usersDao;

	@Override
	public UsersEntity selectById(UsersEntity entity) {
		return usersDao.selectById(entity);
	}

	///////////////////////////////////////////////////////////////////
	@Override
	public List<UsersEntity> findAll(UsersEntity entity) {
		return null;
	}

	@Override
	public int totalRows(UsersEntity entity) {
		return 0;
	}

	@Override
	public void update2(UsersEntity entity) {

	}

	@Override
	public void onInitPassword(UsersEntity user) {

	}

	@Override
	public void userAddAll() {

	}
}
