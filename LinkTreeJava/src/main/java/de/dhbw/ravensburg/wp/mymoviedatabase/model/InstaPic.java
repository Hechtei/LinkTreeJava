package de.dhbw.ravensburg.wp.mymoviedatabase.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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


    public void setPic(byte[] pic) {
        this.pic = pic;
    }


    public byte[] getPic() {
        return pic;
    }


    public InstaPic(String link) {
        this.link = link;
    }
}
