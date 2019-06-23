package de.owemo.server.counter;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "counter")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CounterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "counter_name")
    private String name;

    @Basic
    @Column(name = "counter_value")
    private int value;
}
