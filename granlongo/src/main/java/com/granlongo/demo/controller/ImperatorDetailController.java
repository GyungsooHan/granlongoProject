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
import com.granlongo.demo.documents.CampaignSessionDocument;
import com.granlongo.demo.service.ImperatorDetailService;
import com.granlongo.demo.service.ImperatorSessionService;

@RestController
@RequestMapping("/imperator/session/detail")
public class ImperatorDetailController {
    @Autowired
    private ImperatorDetailService imperatorDetailService;
    @Autowired
    private ImperatorSessionService imperatorSessionService;
	 @Autowired
	 	private PasswordEncoder pwEncoder;

    @PostMapping("/createDocument")
    public ResponseEntity<CampaignDetailDocument> createDocument(@RequestBody CampaignDetailDocument campaignDetailDocument) {
    	CampaignSessionDocument parentDocument = imperatorSessionService.getDocumentById(campaignDetailDocument.getSession_id());
    	campaignDetailDocument.setCampaignSessionDocument(parentDocument);
        CampaignDetailDocument createdDocument = imperatorDetailService.createDocument(campaignDetailDocument);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDocument);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CampaignDetailDocument> getDocumentById(@PathVariable String id) {
        CampaignDetailDocument document = imperatorDetailService.getDocumentById(id);
        if (document != null) {
            return ResponseEntity.ok(document);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<CampaignDetailDocument>> getAllDocuments() {
        List<CampaignDetailDocument> documents = imperatorDetailService.getAllDocuments();
        return ResponseEntity.ok(documents);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampaignDetailDocument> updateDocument(@PathVariable String id, @RequestBody CampaignDetailDocument updatedDocument) {
    	
    	CampaignDetailDocument document = imperatorDetailService.updateDocument(id, updatedDocument);
        if (document != null) {
            return ResponseEntity.ok(document);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }   
    }


}