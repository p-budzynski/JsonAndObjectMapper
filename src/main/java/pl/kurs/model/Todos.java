package pl.kurs.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Todos {
    private Long userId;
    private Long id;
    private String title;
    private Boolean completed;

}
