package br.ufc.demo1.pubs;

import br.ufc.demo1.author.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by emerson on 18/07/17.
 */
@RestController
@RequestMapping("/pubs")
public class PubsController {

    @Autowired
    private PubsServiceImpl pubsService;

    //retorna todas as publicações
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Pubs>> getAllPubs(){
        Iterable<Pubs> pubs = pubsService.findAll();
        return new ResponseEntity<Iterable<Pubs>>(pubs, HttpStatus.OK);
    }

    //cria uma publicação
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Pubs> createPub(@RequestBody Pubs pub, UriComponentsBuilder ucBuilder){
        pubsService.save(pub);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/pubs/{id}").buildAndExpand(pub.getId()).toUri());
        return new ResponseEntity<Pubs>(headers, HttpStatus.CREATED);
    }

    //atualiza uma publicação por id
    @RequestMapping(value = "/pub/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updatePub(@PathVariable Integer id, @RequestBody Pubs pub){
        Pubs existingPub = pubsService.getById(id);
        if(existingPub == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{
            existingPub.setNamePub(pub.getNamePub());
            existingPub.setContentPub(pub.getContentPub());
            existingPub.setAuthorPub(pub.getAuthorPub());
            pubsService.save(pub);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

    }

    //retorna publicação por id
    @RequestMapping(value = "/pub/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pubs> getPub(@PathVariable("id") Integer id){
        Pubs pub = pubsService.getById(id);
        if(pub == null){
            return new ResponseEntity<Pubs>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Pubs>(pub, HttpStatus.OK);
        }
    }

    //delete publicação por id
    @RequestMapping(value = "/pub/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePub(@PathVariable("id") Integer id){
        Pubs pub = pubsService.getById(id);
        if(pub == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{
            pubsService.delete(id);
            return new ResponseEntity<Void>(HttpStatus.GONE);
        }
    }

}
