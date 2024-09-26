package pl.kurs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

//@NoArgsConstructor - tworzy konstruktor bezparametrowy
@AllArgsConstructor // - tworzy konstruktor z wszystkimi parametrami
@RequiredArgsConstructor // - tworzy konstruktor z polami FINAL
@Getter // - dodaje gettery
@Setter // - dodaje settery
@ToString // - dodaje toString
@EqualsAndHashCode // - generuje hashcode i equals
public class Dog {

    @EqualsAndHashCode.Exclude // - wyklucza pole z equals i hashcode
    @JsonProperty("imie") // Zmiana nazwy pola name na imie w JSON
    private final String name;
    @JsonIgnore // Oznaczenie pola jako ignorowane w JSON
    private String ownerName;

}
