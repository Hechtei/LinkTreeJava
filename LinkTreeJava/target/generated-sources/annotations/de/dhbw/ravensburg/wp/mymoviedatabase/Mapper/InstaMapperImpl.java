package de.dhbw.ravensburg.wp.mymoviedatabase.Mapper;

import de.dhbw.ravensburg.wp.mymoviedatabase.DTOs.InstaDTO;
import de.dhbw.ravensburg.wp.mymoviedatabase.model.InstaPic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-23T11:15:53+0100",
    comments = "version: 1.4.1.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class InstaMapperImpl implements InstaMapper {

    @Override
    public InstaDTO instaPicToDTO(InstaPic instaPic) {
        if ( instaPic == null ) {
            return null;
        }

        InstaDTO instaDTO = new InstaDTO();

        instaDTO.setId( instaPic.getId() );
        instaDTO.setLink( instaPic.getLink() );
        byte[] pic = instaPic.getPic();
        if ( pic != null ) {
            instaDTO.setPic( Arrays.copyOf( pic, pic.length ) );
        }

        return instaDTO;
    }

    @Override
    public List<InstaDTO> instaPicsToDTos(List<InstaPic> instaPicList) {
        if ( instaPicList == null ) {
            return null;
        }

        List<InstaDTO> list = new ArrayList<InstaDTO>( instaPicList.size() );
        for ( InstaPic instaPic : instaPicList ) {
            list.add( instaPicToDTO( instaPic ) );
        }

        return list;
    }

    @Override
    public InstaPic DTOtoInstaPic(InstaDTO instaDTO) {
        if ( instaDTO == null ) {
            return null;
        }

        InstaPic instaPic = new InstaPic();

        instaPic.setId( instaDTO.getId() );
        instaPic.setLink( instaDTO.getLink() );
        byte[] pic = instaDTO.getPic();
        if ( pic != null ) {
            instaPic.setPic( Arrays.copyOf( pic, pic.length ) );
        }

        return instaPic;
    }

    @Override
    public List<InstaPic> DTOstoInstaPic(List<InstaDTO> instaDTO) {
        if ( instaDTO == null ) {
            return null;
        }

        List<InstaPic> list = new ArrayList<InstaPic>( instaDTO.size() );
        for ( InstaDTO instaDTO1 : instaDTO ) {
            list.add( DTOtoInstaPic( instaDTO1 ) );
        }

        return list;
    }
}
