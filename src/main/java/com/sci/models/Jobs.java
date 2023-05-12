package com.sci.models;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "jobs", schema = "hr")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@SequenceGenerator(name="departments_gen", sequenceName="hr.departments_seq", allocationSize = 1)
public class Jobs {

    @Id
    @Column(name = "job_id")
    private String jobId;
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "min_salary")
    private Integer minSalary;
    @Column(name = "max_salary")
    private Integer maxSalary;


}
