package de.dhbw.ravensburg.wp.mymoviedatabase.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class InstaDTO {

    @NotNull
    private long id;

    private String link;

    @Lob
    private byte[] pic;

}
