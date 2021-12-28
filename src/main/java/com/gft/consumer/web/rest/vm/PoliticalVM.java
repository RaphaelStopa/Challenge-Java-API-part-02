package com.gft.consumer.web.rest.vm;

import lombok.*;

import java.io.Serializable;
import java.util.Set;

@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class PoliticalVM implements Serializable {

    private Long id;

    private String name;

    // in thsi context cnat by string, nao importa
    private String electivePositionType;

    private boolean isLeader;

    private Set<LawProjectWithoutPoliticianVM> lawProjects;

    private PoliticalPartyVM politicalParty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElectivePositionType() {
        return electivePositionType;
    }

    public void setElectivePositionType(String electivePositionType) {
        this.electivePositionType = electivePositionType;
    }

    public boolean isLeader() {
        return isLeader;
    }

    public void setLeader(boolean leader) {
        isLeader = leader;
    }


    public Set<LawProjectWithoutPoliticianVM> getLawProjects() {
        return lawProjects;
    }

    public void setLawProjects(Set<LawProjectWithoutPoliticianVM> lawProjects) {
        this.lawProjects = lawProjects;
    }

    public PoliticalPartyVM getPoliticalParty() {
        return politicalParty;
    }

    public void setPoliticalParty(PoliticalPartyVM politicalParty) {
        this.politicalParty = politicalParty;
    }
}
