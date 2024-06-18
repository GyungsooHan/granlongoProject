package com.granlongo.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.granlongo.demo.documents.MainDocument;

@Repository
public interface MainRepository extends MongoRepository<MainDocument, String> {
	  List<MainDocument> findByTextContaining(String name);
}
