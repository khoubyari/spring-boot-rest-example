package com.khoubyari.example.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

/*
 * a simple domain entity doubling as a DTO
 */
@Entity
@Data                                         //For getters,setters,hashcode and toString methods 
@NoArgsConstructor                            //For No argument Constructor
@AllArgsConstructor                           //For All arguments Constructor
@Builder                                      //Implemented Builder Pattern
@Table(name = "hotel")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Hotel {

    @Id
    @GeneratedValue()
    private long id;

    @Column(nullable = false)
    private String name;

    @Column()
    private String description;

    @Column()
    String city;

    @Column()
    private int rating;
}
