package de.dhbw.ravensburg.wp.mymoviedatabase.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class InstaPic {

    @Id
    @GeneratedValue
    private long id;

    private String link;

    @Lob
    private byte[] pic;


}
