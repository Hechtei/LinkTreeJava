package de.dhbw.ravensburg.wp.mymoviedatabase.Mapper;


import de.dhbw.ravensburg.wp.mymoviedatabase.DTOs.InstaDTO;
import de.dhbw.ravensburg.wp.mymoviedatabase.model.InstaPic;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InstaMapper {

    InstaDTO instaPicToDTO(InstaPic instaPic);

    List<InstaDTO> instaPicsToDTos(List<InstaPic> instaPicList);

    InstaPic DTOtoInstaPic(InstaDTO instaDTO);

    List<InstaPic> DTOstoInstaPic(List<InstaDTO> instaDTO);


}
