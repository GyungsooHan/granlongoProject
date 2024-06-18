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

import com.granlongo.demo.documents.CampaignDetailDocument;
import com.granlongo.demo.repository.CampaignDetailRepository;
import com.granlongo.demo.repository.MainRepository;

@Service
public class ImperatorDetailService {
    @Autowired
    private ImperatorSessionService imperatorSessionService;
    
	 private final MongoTemplate mongoTemplate;
	 
	 public ImperatorDetailService(MongoTemplate mongoTemplate) {
	        this.mongoTemplate = mongoTemplate;
	    }
	 
	 
    @Autowired
    private CampaignDetailRepository campaignDetailRepository;

    public CampaignDetailDocument createDocument(CampaignDetailDocument campaignDocument) {
        return campaignDetailRepository.save(campaignDocument);
    }

    public CampaignDetailDocument getDocumentById(String id) {
        return campaignDetailRepository.findById(id).orElse(null);
    }

    public List<CampaignDetailDocument> getAllDocuments() {
        return campaignDetailRepository.findAll();
    }

    public CampaignDetailDocument updateDocument(String id, CampaignDetailDocument updatedDocument) {
    	 return campaignDetailRepository.save(updatedDocument);
    }

    public void deleteDocument(String id) {
    	campaignDetailRepository.deleteById(id);
    }
}



