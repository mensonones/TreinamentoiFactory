package br.ufc.demo1.pubs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by emerson on 18/07/17.
 */
@Service
public class PubsServiceImpl implements PubsService {

    @Autowired
    private PubsRepository pubsRepository;

    @Override
    public Pubs save(Pubs pub) {
        return pubsRepository.save(pub);
    }

    @Override
    public Pubs getById(Integer id) {
        return pubsRepository.findOne(id);
    }

    @Override
    public Iterable<Pubs> findAll() {
        return pubsRepository.findAll();
    }

    @Override
    public Boolean delete(Integer id) {
        pubsRepository.delete(id);
        return true;
    }
}
