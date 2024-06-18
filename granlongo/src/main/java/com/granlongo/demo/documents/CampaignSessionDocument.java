package com.granlongo.demo.documents;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.RequestMapping;

@Document(collection = "campaignSessionDocument")
public class CampaignSessionDocument {
    @Id
    private String id;
    private String date; 
    private String session_name;
    private String status;
    private String campaign_id;
    @DBRef
    private CampaignDocument parentCampaign;
    
    
    
    
	public String getCampaign_id() {
		return campaign_id;
	}
	public void setCampaign_id(String campaign_id) {
		this.campaign_id = campaign_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSession_name() {
		return session_name;
	}
	public void setSession_name(String session_name) {
		this.session_name = session_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CampaignDocument getParentCampaign() {
		return parentCampaign;
	}
	public void setParentCampaign(CampaignDocument parentCampaign) {
		this.parentCampaign = parentCampaign;
	}

    
    

    
    

}