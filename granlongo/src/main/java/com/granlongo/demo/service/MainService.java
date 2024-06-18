package com.granlongo.demo.service;
import org.apache.http.HttpHost;

import java.util.List;
import java.util.Optional;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.granlongo.demo.documents.MainDocument;
import com.granlongo.demo.repository.MainRepository;

@Service
public class MainService {
	 private final MongoTemplate mongoTemplate;
	 
	 public MainService(MongoTemplate mongoTemplate) {
	        this.mongoTemplate = mongoTemplate;
	    }
	 
	 
    @Autowired
    private MainRepository mainRepository;

    public MainDocument createDocument(MainDocument mainDocument) {
        return mainRepository.save(mainDocument);
    }

    public MainDocument getDocumentById(String id) {
        return mainRepository.findById(id).orElse(null);
    }

    public List<MainDocument> getAllDocuments() {
        return mainRepository.findAll();
    }

    public MainDocument updateDocument(String id, MainDocument updatedDocument) {
        Optional<MainDocument> optionalDocument = mainRepository.findById(id);

        if (optionalDocument.isPresent()) {
            MainDocument existingDocument = optionalDocument.get();

            if (updatedDocument.getText() != null) {
                existingDocument.setText(updatedDocument.getText());
            }
            if (updatedDocument.getSummary() != null) {
                existingDocument.setSummary(updatedDocument.getSummary());
            }
            if (updatedDocument.getTag() != null) {
                existingDocument.setTag(updatedDocument.getTag());
            }
            if (updatedDocument.getParentId() != null) {
                existingDocument.setParentId(updatedDocument.getParentId());
            }
            // Add other fields similarly

            mainRepository.save(existingDocument);
            return existingDocument;
        } else {
            return null;
        }
    }

    public void deleteDocument(String id) {
        mainRepository.deleteById(id);
    }

    public List<MainDocument> searchDocuments(String text, String summary, String tag) {
        Criteria criteria = new Criteria();

        if (text != null && !text.isEmpty()) {
            criteria = criteria.and("text").regex(text, "i");  // case insensitive
        }
        if (summary != null && !summary.isEmpty()) {
            criteria = criteria.and("summary").regex(summary, "i");  // case insensitive
        }
        if (tag != null && !tag.isEmpty()) {
            criteria = criteria.and("tag").regex(tag, "i");  // case insensitive
        }

        Query query = new Query(criteria);
        return mongoTemplate.find(query, MainDocument.class);
    }
}



