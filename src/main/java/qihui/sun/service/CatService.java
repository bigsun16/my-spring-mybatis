package qihui.sun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qihui.sun.mapper.CatMapper;

@Service
public class CatService {

    @Autowired
    private CatMapper catMapper;

    public void select(){
        System.out.println(catMapper.select());
    }
}
