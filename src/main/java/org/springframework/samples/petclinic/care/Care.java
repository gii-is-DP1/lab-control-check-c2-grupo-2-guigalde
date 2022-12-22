package org.springframework.samples.petclinic.care;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.persistence.CascadeType;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Care {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotNull
    @Size(min = 3, max=40)
    @Column(unique=true)
    String name;
    @Min(value=1)
    @Max(value=120)
    int careDuration;
    @NotEmpty
    @ManyToMany(cascade = CascadeType.ALL)
    Set<PetType> compatiblePetTypes;
}
