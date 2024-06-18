package com.granlongo.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.granlongo.demo.documents.CampaignDocument;
import com.granlongo.demo.documents.MainDocument;

@Repository
public interface CampaignRepository extends MongoRepository<CampaignDocument, String> {
}
