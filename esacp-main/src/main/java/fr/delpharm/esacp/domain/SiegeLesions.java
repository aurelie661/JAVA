package fr.delpharm.esacp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A SiegeLesions.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SiegeLesions{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean isAffiche;
    private String label;
    private String value;
    

}
