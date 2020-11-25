package com.example.demo.service.impl;

import com.example.demo.model.Group;
import com.example.demo.repository.GroupRepository;
import com.example.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService implements BaseService<Group> {
    @Autowired
    GroupRepository groupRepository;

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group save(Group object) {
        return null;
    }

    @Override
    public Group findById(long id) {
        return null;
    }

    @Override
    public Group remove(long id) {
        return null;
    }
}
