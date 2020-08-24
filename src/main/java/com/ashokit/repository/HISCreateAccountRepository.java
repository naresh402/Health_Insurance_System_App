package com.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.Entity.HISEntity;

public interface HISCreateAccountRepository extends JpaRepository<HISEntity, Serializable> {

}
