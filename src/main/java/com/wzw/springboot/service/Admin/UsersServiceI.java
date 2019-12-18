package com.wzw.springboot.service.Admin;
import com.wzw.springboot.entity.Admin.UsersEntity;

import java.util.List;

public interface UsersServiceI {
	UsersEntity selectById(UsersEntity entity);
	///////////////////////////////////////////////////
	List<UsersEntity> findAll(UsersEntity entity);
	int totalRows(UsersEntity entity);
	
   void update2(UsersEntity entity);
   void onInitPassword(UsersEntity user);
   void userAddAll();
}

