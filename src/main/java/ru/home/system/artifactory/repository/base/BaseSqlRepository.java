package ru.home.system.artifactory.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseSqlRepository<T, ID extends Serializable> extends JpaRepository<T, ID>
{
	void flush();
}