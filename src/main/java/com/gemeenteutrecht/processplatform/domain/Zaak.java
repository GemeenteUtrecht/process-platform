package com.gemeenteutrecht.processplatform.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public interface Zaak {

    @JsonProperty
    URI url();

    @JsonProperty
    String identificatie();

    @JsonProperty
    String bronorganisatie();

    @JsonProperty
    String omschrijving();

    @JsonProperty
    String toelichting();

    @JsonProperty
    URI zaaktype();

    @JsonProperty
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate registratiedatum();

    @JsonProperty
    String verantwoordelijkeOrganisatie();

    @JsonProperty
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate startdatum();

    @JsonProperty
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate einddatumGepland();

    @JsonProperty
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate uiterlijkeEinddatumAfdoening();

    @JsonProperty
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate publicatiedatum();

    @JsonProperty
    URI communicatiekanaal();

    @JsonProperty
    List<URI> productenOfDiensten();

    @JsonProperty("vertrouwelijkheidaanduiding")
    String vertrouwelijkheidaanduiding();

    @JsonIgnore
    @JsonProperty("betalingsindicatie")
    Betalingsindicatie betalingsindicatie();

    @JsonProperty
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    LocalDateTime laatsteBetaaldatum();

    @JsonIgnore
    Geometrie geometrie();

    @JsonProperty
    Verlenging verlenging();

    @JsonProperty
    Opschorting opschorting();

    @JsonProperty
    URI selectielijstklasse();

    @JsonProperty
    URI hoofdzaak();

    @JsonProperty
    List<URI> relevanteAndereZaken();

    @JsonProperty
    List<Kenmerk> kenmerken();

    @JsonProperty("archiefnominatie")
    ArchiefNominatie archiefNominatie();

    @JsonProperty("archiefstatus")
    ArchiefStatus archiefStatus();

    @JsonProperty("archiefactiedatum")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate archiefActieDatum();
}
