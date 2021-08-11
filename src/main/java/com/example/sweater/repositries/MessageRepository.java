package com.example.sweater.repositries;

import com.example.sweater.domaine.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface MessageRepository extends CrudRepository<Message, Integer> {
    List<Message> findByTextContainsOrTagContains(String text, String tag);
}
