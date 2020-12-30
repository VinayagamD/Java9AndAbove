package com.vinaylogics.springboot.springmvccore.services;

import com.vinaylogics.springboot.springmvccore.dtos.PagingMessageDTO;
import com.vinaylogics.springboot.springmvccore.models.Message;

import java.util.List;

public interface GreetingService extends BasicService<Message,Long>{

    String greeting();

    PagingMessageDTO<List<Message>> getPagingMessage(Integer size, Integer pageNumber, Long pageCount);
}
