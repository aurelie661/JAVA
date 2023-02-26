package fr.delpharm.esacp.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.springframework.http.converter.json.JsonbHttpMessageConverter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A TypeRapport.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TypeRapport{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeRapport;
    private Boolean isAffiche;
  
}
