package com.granlongo.demo.controller;

import java.util.List;

import org.apache.http.HttpHost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.granlongo.demo.documents.CampaignDetailDocument;
import com.granlongo.demo.documents.CampaignDocument;
import com.granlongo.demo.documents.CampaignSessionDocument;
import com.granlongo.demo.documents.MainDocument;
import com.granlongo.demo.service.ImperatorService;
import com.granlongo.demo.service.MainService;

@RestController
@RequestMapping("/imperator")
public class ImperatorController {
    @Autowired
    private ImperatorService campaignService;
    
	 @Autowired
	 	private PasswordEncoder pwEncoder;

    @PostMapping("/createDocument")
    public ResponseEntity<CampaignDocument> createDocument(@RequestBody CampaignDocument campaignDocument) {
    	String encded_pw = pwEncoder.encode(campaignDocument.getAdmin_pw());
    	campaignDocument.setAdmin_pw(encded_pw);
    	CampaignDocument createdDocument = campaignService.createDocument(campaignDocument);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDocument);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CampaignDocument> getDocumentById(@PathVariable String id) {
    	CampaignDocument document = campaignService.getDocumentById(id);
    	  List<CampaignSessionDocument> details = campaignService.findDetails(id);
    	  document.setCampaignSessionDocumentList(details);
        return ResponseEntity.ok(document);
    }
    @GetMapping("/")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("HELLO, TEST");
    }
    
    
    @GetMapping("/all")
    public ResponseEntity<List<CampaignDocument>> getAllDocuments() {
        List<CampaignDocument> documents = campaignService.getAllDocuments();
        return ResponseEntity.ok(documents);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampaignDocument> updateDocument(@PathVariable String id, @RequestBody CampaignDocument updatedDocument) {
    	CampaignDocument document = campaignService.updateDocument(id, updatedDocument);
        if (document != null) {
            return ResponseEntity.ok(document);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}