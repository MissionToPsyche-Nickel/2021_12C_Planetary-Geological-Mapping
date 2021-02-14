package planetarymapping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import planetarymapping.Exception.RecordNotFoundException;
import planetarymapping.Repository.MapRepository;
import planetarymapping.model.Maps;

import java.util.Optional;

@Service
public class MapService {

    @Autowired
    MapRepository mapRepository;

    public Maps getMapById(Long id) throws RecordNotFoundException
    {
        Optional<Maps> map = mapRepository.findById(id);

        if(map.isPresent()) {
            return map.get();
        } else {
            throw new RecordNotFoundException();
        }
    }
}
