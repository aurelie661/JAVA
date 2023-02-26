package fr.delpharm.esacp.service;


import java.util.List;
import java.util.Optional;

public interface IService<T> {
	List<T> findAll();
	Optional<T> findById(Long id);
	T save(T t);
	void deleteById(Long id);
	List<T> findByIsAfficheTrue();
}
