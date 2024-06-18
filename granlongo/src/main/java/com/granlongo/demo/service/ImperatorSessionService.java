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

import com.granlongo.demo.documents.CampaignSessionDocument;
import com.granlongo.demo.repository.CampaignSessionRepository;
import com.granlongo.demo.repository.MainRepository;

@Service
public class ImperatorSessionService {
	 private final MongoTemplate mongoTemplate;
	 
	 public ImperatorSessionService(MongoTemplate mongoTemplate) {
	        this.mongoTemplate = mongoTemplate;
	    }
	 
	 
    @Autowired
    private CampaignSessionRepository campaignSessionRepository;

    public CampaignSessionDocument createDocument(CampaignSessionDocument campaignDocument) {
        return campaignSessionRepository.save(campaignDocument);
    }

    public CampaignSessionDocument getDocumentById(String id) {
        return campaignSessionRepository.findById(id).orElse(null);
    }

    public List<CampaignSessionDocument> getAllDocuments() {
        return campaignSessionRepository.findAll();
    }

    public CampaignSessionDocument updateDocument(String id, CampaignSessionDocument updatedDocument) {
    	return campaignSessionRepository.save(updatedDocument);
    }

    public void deleteDocument(String id) {
    	campaignSessionRepository.deleteById(id);
    }
}



