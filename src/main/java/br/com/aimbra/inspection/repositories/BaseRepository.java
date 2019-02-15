package br.com.aimbra.inspection.repositories;

import java.util.List;

public interface BaseRepository<T> {
	List<T> findAll();
	T findById(Long id);
	T create(T t);
	T update(T t);
	T delete(T t);
}
