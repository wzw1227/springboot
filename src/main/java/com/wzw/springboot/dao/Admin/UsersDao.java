package com.wzw.springboot.dao.Admin;
import com.wzw.springboot.entity.Admin.UsersEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersDao {
	UsersEntity selectById(UsersEntity entity);
	////////////////////////////////////
	int count(UsersEntity entity);
	List<UsersEntity> select(UsersEntity entity);
	void insert(UsersEntity entity);
	void update(UsersEntity entity);
	void update1(UsersEntity entity);
	void update2(UsersEntity entity);
}
