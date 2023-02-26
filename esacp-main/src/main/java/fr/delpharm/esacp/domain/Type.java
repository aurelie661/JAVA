package fr.delpharm.esacp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Type{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String origine;
    private String accOrigine; 
    private Boolean isAffiche;
    
    @Transient
    private Long repartitionId;

    @ManyToOne
    @JoinColumn(name="repartitionID", referencedColumnName = "id")
    private Repartition repartition;  
}
