package com.vinaylogics.springboot.springmvccore.repositories;

import com.vinaylogics.springboot.springmvccore.models.Message;
import com.vinaylogics.springboot.springmvccore.utils.QueryConstant;

public interface MessageRepository extends BaseRepository<Message, Long>, QueryConstant.MessageTable {

}
