package fr.delpharm.esacp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A TypeAction.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TypeAction{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeAction;
    private Boolean isAffiche;

}
