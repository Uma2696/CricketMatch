package com.cricket.uma.CricketDB;

import com.cricket.uma.CricketDB.repositories.CricketRepositories;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Component
@RestController
@RequestMapping("/team")
public class CricketController {
    @Autowired
    private CricketRepositories repository;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Cricket> getAllCricket() {
        System.out.println("here!!!!");
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Cricket getCricketById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

   @RequestMapping(value = "/", method = RequestMethod.POST)
    public Cricket createCricket(@Valid @RequestBody Cricket cricket) {
        System.out.println("hello from create Cricket" + ObjectId.get());
        cricket.set_id(ObjectId.get());
        repository.save(cricket);
        return cricket;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyCricketById(@PathVariable("id") ObjectId id, @Valid @RequestBody Cricket cricket) {
        cricket.set_id(id);
        repository.save(cricket);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCricket(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }

}