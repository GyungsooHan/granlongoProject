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

import com.granlongo.demo.documents.CampaignSessionDocument;
import com.granlongo.demo.documents.CampaignDocument;
import com.granlongo.demo.documents.CampaignSessionDocument;
import com.granlongo.demo.service.ImperatorDetailService;
import com.granlongo.demo.service.ImperatorService;
import com.granlongo.demo.service.ImperatorSessionService;

@RestController
@RequestMapping("/imperator/session")
public class ImperatorSessionController {
    @Autowired
    private ImperatorSessionService sessionService;
    @Autowired
    private ImperatorService campaignService;
	 @Autowired
	 	private PasswordEncoder pwEncoder;

    @PostMapping("/createDocument")
    public ResponseEntity<CampaignSessionDocument> createDocument(@RequestBody CampaignSessionDocument CampaignSessionDocument) {
    	
        CampaignSessionDocument createdDocument = sessionService.createDocument(CampaignSessionDocument);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDocument);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CampaignSessionDocument> getDocumentById(@PathVariable String id) {
        CampaignSessionDocument document = sessionService.getDocumentById(id);
        if (document != null) {
            return ResponseEntity.ok(document);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
     
    @GetMapping("/all")
    public ResponseEntity<List<CampaignSessionDocument>> getAllDocuments() {
        List<CampaignSessionDocument> documents = sessionService.getAllDocuments();
        return ResponseEntity.ok(documents);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampaignSessionDocument> updateDocument(@PathVariable String id, @RequestBody CampaignSessionDocument updatedDocument) {
    	
    	CampaignSessionDocument document = sessionService.updateDocument(id, updatedDocument);
        if (document != null) {
            return ResponseEntity.ok(document);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}