package hu.elte.ftdl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TODO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties("family")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @JoinColumn
    @ManyToOne(targetEntity = Family.class)
    private Family family;

    @Column(nullable = false)
    private String task;

    @Column(nullable = false)
    private String owner;

    @Column(nullable = false)
    public Boolean status;

    @Version
    private int version;
    
}