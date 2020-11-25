package com.example.demo.controller.api;

import com.example.demo.model.Group;
import com.example.demo.service.impl.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ApiGroupController {
    @Autowired
    GroupService groupService;

    @RequestMapping(value = "/groups/", method = RequestMethod.GET)
    public ResponseEntity<List<Group>> listAllCustomers() {
        List<Group> groups = groupService.findAll();
        if (groups == null) {
            return new ResponseEntity<List<Group>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Group>>(groups, HttpStatus.OK);
    }

    @RequestMapping(value = "/groups/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Group> delete(@PathVariable("id") long id) {
        Group group = groupService.remove(id);
        return new ResponseEntity<Group>(group, HttpStatus.OK);
    }

    @RequestMapping(value = "groups/", method = RequestMethod.POST)

    public ResponseEntity<Group> create(@RequestBody Group groups) {
        Group group = groupService.save(groups);
        return new ResponseEntity<Group>(group, HttpStatus.OK);
    }

    @RequestMapping(value = "/groups/{id}", method = RequestMethod.GET)
    public ResponseEntity<Group> getSmartphone(@PathVariable("id") long id) {

        Group group = groupService.findById(id);
        return new ResponseEntity<Group>(group, HttpStatus.OK);
    }

    @RequestMapping(value = "/groups/", method = RequestMethod.PUT)
    public ResponseEntity<Group> update(@RequestBody Group employees) {
        groupService.save(employees);
        return new ResponseEntity<Group>(employees, HttpStatus.OK);
    }
}
