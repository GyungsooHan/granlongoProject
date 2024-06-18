package com.granlongo.demo.documents;

import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.RequestMapping;

@Document(collection = "campaignDocument")
public class CampaignDocument {
    @Id
    private String id;
	private String campaign_name;
	private String admin;
	private Date campaign_start;
	private Date campaign_end;
	private String admin_pw;
	private String status;
	 @DBRef
	    private List<CampaignSessionDocument> campaignSessionDocumentList;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCampaign_name() {
		return campaign_name;
	}
	public void setCampaign_name(String campaign_name) {
		this.campaign_name = campaign_name;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public Date getCampaign_start() {
		return campaign_start;
	}
	public void setCampaign_start(Date campaign_start) {
		this.campaign_start = campaign_start;
	}
	public Date getCampaign_end() {
		return campaign_end;
	}
	public void setCampaign_end(Date campaign_end) {
		this.campaign_end = campaign_end;
	}
	public String getAdmin_pw() {
		return admin_pw;
	}
	public void setAdmin_pw(String admin_pw) {
		this.admin_pw = admin_pw;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<CampaignSessionDocument> getCampaignSessionDocumentList() {
		return campaignSessionDocumentList;
	}
	public void setCampaignSessionDocumentList(List<CampaignSessionDocument> campaignSessionDocumentList) {
		this.campaignSessionDocumentList = campaignSessionDocumentList;
	}

    
	

}