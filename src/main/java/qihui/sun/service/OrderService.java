package qihui.sun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qihui.sun.mapper.OrderMapper;
import qihui.sun.mapper.UserMapper;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public void select(){
        System.out.println(orderMapper.select());
    }
}
