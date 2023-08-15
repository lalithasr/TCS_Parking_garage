package com.tcs.natd.springhandson.parkinggarage.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "makes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Make {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
}
