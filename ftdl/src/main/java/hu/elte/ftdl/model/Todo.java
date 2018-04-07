package hu.elte.ftdl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TODO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
    private boolean status;

    @Version
    private int version;
    
}