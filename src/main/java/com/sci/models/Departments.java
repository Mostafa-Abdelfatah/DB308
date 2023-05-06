package com.sci.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "departments", schema = "hr")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name="departments_gen", sequenceName="hr.departments_seq", allocationSize = 1)

public class Departments implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="departments_gen")
    @Column(name = "department_id")
    private Integer departmentId;
    @Column(name = "department_name")
    private String departmentName;
    @Column(name = "manager_id")
    private Integer managerId;
    @Column(name = "location_id")
    private Integer locationId;
}
