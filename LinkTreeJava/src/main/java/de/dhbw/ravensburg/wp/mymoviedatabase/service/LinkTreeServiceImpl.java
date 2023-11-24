package de.dhbw.ravensburg.wp.mymoviedatabase.service;

import de.dhbw.ravensburg.wp.mymoviedatabase.DTOs.InstaDTO;
import de.dhbw.ravensburg.wp.mymoviedatabase.Mapper.InstaMapper;
import de.dhbw.ravensburg.wp.mymoviedatabase.repository.InstaRepo;
import de.dhbw.ravensburg.wp.mymoviedatabase.model.InstaPic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class LinkTreeServiceImpl implements LinkTreeService{

    InstaRepo instaRepo;

    InstaMapper instaMapper;

    @Autowired
    LinkTreeServiceImpl(InstaRepo instaRepo, InstaMapper instaMapper){
        this.instaRepo = instaRepo;
        this.instaMapper = instaMapper;
    }



    @Override
    public List<InstaDTO> getAllPic() {
        return instaMapper.instaPicsToDTos(instaRepo.findAll());
    }

    @Override
    public InstaDTO getPicById(Long id) {
        return instaMapper.instaPicToDTO(instaRepo.getById(id));
    }

    @Override
    public void removePic(Long id) {

        instaRepo.delete(instaRepo.getById(id));

    }

    @Override
    public InstaDTO addPic(InstaDTO newPic) {
        InstaPic tmp = instaMapper.DTOtoInstaPic(newPic);
        return instaMapper.instaPicToDTO(instaRepo.save(tmp));

    }

    @Override
    public InstaDTO updatePic(InstaDTO updatedPic) {
        if(instaRepo.existsById(updatedPic.getId())){
            InstaPic tmp = instaMapper.DTOtoInstaPic(updatedPic);
            return instaMapper.instaPicToDTO(instaRepo.save(tmp));
        } else{
                throw new EntityNotFoundException("Bild nicht gefunden");
        }
    }
}
