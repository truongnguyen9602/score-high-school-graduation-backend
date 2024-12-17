package org.truongnc.graduation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;

@Entity(name = "Statistic")
@Table(name = "statistic")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StatisticEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String sbd;
    private String toan;
    private String van;
    private String anh;

    private String ly;
    private String hoa;
    private String sinh;

    private String tbKhtn;

    private String gdcd;
    private String su;
    private String dia;

    private String tbKhxh;
}
