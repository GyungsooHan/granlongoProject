package com.granlongo.demo.controller;

import java.util.List;

import org.apache.http.HttpHost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.granlongo.demo.documents.MainDocument;
import com.granlongo.demo.service.MainService;

@RestController
@RequestMapping("/granlongo")
public class MainController {
    @Autowired
    private MainService mainService;

    @PostMapping("/createDocument")
    public ResponseEntity<MainDocument> createDocument(@RequestBody MainDocument mainDocument) {
    	
    	if(mainDocument.getParentId()!=null) {
    		MainDocument parentDocument = mainService.getDocumentById(mainDocument.getParentId());
    		if (parentDocument == null) {
    			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }else {
            	mainDocument.setParent(parentDocument);
            }
    	}
        MainDocument createdDocument = mainService.createDocument(mainDocument);
        createdDocument.setMessage("SUCCESS: New Date has been created");
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDocument);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MainDocument> getDocumentById(@PathVariable String id) {
        MainDocument document = mainService.getDocumentById(id);
        if (document != null) {
        	document.setMessage("SUCCESS: Search Successful");
            return ResponseEntity.ok(document);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("HELLO, TEST");
    }
    
    
    @GetMapping("/all")
    public ResponseEntity<List<MainDocument>> getAllDocuments() {
        List<MainDocument> documents = mainService.getAllDocuments();
        return ResponseEntity.ok(documents);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MainDocument> updateDocument(@PathVariable String id, @RequestBody MainDocument updatedDocument) {
    	
    	if(updatedDocument.getParentId()!=null) {
    		MainDocument parentDocument = mainService.getDocumentById(updatedDocument.getParentId());
    		if (parentDocument == null) {
    			updatedDocument.setMessage("ERROR: Wrong ParentId");
    			return ResponseEntity.ok(updatedDocument);
            }else if(!parentDocument.getParentId().equals(updatedDocument.getId())){
            	updatedDocument.setParent(parentDocument);
            }else {
            	updatedDocument.setMessage("ERROR: Child Parent wrong pair");
            	return  ResponseEntity.ok(updatedDocument);
            }
    	}
    	MainDocument document = mainService.updateDocument(id, updatedDocument);
        if (document != null) {
        	document.setMessage("SUCCESS: Update Successful");
            return ResponseEntity.ok(document);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }  
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable String id) {
        mainService.deleteDocument(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<MainDocument>> searchDocuments(
            @RequestParam(required = false) String text,
            @RequestParam(required = false) String summary,
            @RequestParam(required = false) String tag) {
        
        List<MainDocument> documents = mainService.searchDocuments(text, summary, tag);
        return ResponseEntity.ok(documents);
    }
}