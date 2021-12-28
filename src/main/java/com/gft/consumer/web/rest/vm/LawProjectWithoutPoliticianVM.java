package com.gft.consumer.web.rest.vm;

import lombok.*;

import java.io.Serializable;

@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class LawProjectWithoutPoliticianVM implements Serializable {

    private Long id;

    private String number;

    private Integer year;

    private String text;

    private String justification;

    private String lawProjectType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public String getLawProjectType() {
        return lawProjectType;
    }

    public void setLawProjectType(String lawProjectType) {
        this.lawProjectType = lawProjectType;
    }
}
