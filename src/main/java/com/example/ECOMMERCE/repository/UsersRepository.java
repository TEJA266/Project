package com.example.ECOMMERCE.repository;

import com.example.ECOMMERCE.entity.Users;
import org.springframework.data.repository.CrudRepository;

import javax.sql.rowset.CachedRowSet;

public interface UsersRepository extends CrudRepository<Users,String> {
}
