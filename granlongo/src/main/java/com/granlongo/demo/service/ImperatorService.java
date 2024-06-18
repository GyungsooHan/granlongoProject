package com.granlongo.demo.service;
import org.apache.http.HttpHost;

import java.util.Date;
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

import com.granlongo.demo.documents.CampaignDetailDocument;
import com.granlongo.demo.documents.CampaignDocument;
import com.granlongo.demo.documents.CampaignSessionDocument;
import com.granlongo.demo.documents.MainDocument;
import com.granlongo.demo.repository.CampaignRepository;
import com.granlongo.demo.repository.MainRepository;

@Service
public class ImperatorService {
	 private final MongoTemplate mongoTemplate;
	 
	 public ImperatorService(MongoTemplate mongoTemplate) {
	        this.mongoTemplate = mongoTemplate;
	    }
	 
	 
    @Autowired
    private CampaignRepository campaignRepository;

    public CampaignDocument createDocument(CampaignDocument campaignDocument) {
        return campaignRepository.save(campaignDocument);
    }

    public CampaignDocument getDocumentById(String id) {
        return campaignRepository.findById(id).orElse(null);
    }

    public List<CampaignDocument> getAllDocuments() {
        return campaignRepository.findAll();
    }

    public CampaignDocument updateDocument(String id, CampaignDocument updatedCampaignDocument) {
        return campaignRepository.save(updatedCampaignDocument);
    }

    public void deleteDocument(String id) {
    	campaignRepository.deleteById(id);
    }
    
    public List<CampaignSessionDocument> findDetails(String campaign_id) {
        Criteria criteria = new Criteria();
        Query query = new Query(criteria);
        return mongoTemplate.find(query, CampaignSessionDocument.class);
    }

}



