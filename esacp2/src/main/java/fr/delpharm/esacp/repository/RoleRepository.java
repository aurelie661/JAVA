package fr.delpharm.esacp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.delpharm.esacp.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
