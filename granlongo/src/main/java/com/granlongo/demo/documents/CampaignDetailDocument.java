package com.granlongo.demo.documents;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.RequestMapping;

@Document(collection = "campaignDetailDocument")
public class CampaignDetailDocument {
    @Id
    private String id;
    private String player;
    private String country;
    private float avg_tech;    
    private String session_id;
    private int holdings;
    private int cohorts;
    private int population;
    private int manpowerRec;
    private int maxManpower;
    private int income;
    private int gold;
    private float stability;
    private float agressive_expansion;
    private float religious_unity;
    private float tyranny;
    private float war_exhauastion;
    @DBRef
    private CampaignSessionDocument campaignSessionDocument;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public float getAvg_tech() {
		return avg_tech;
	}
	public void setAvg_tech(float avg_tech) {
		this.avg_tech = avg_tech;
	}

	
	public String getSession_id() {
		return session_id;
	}
	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}
	public int getHoldings() {
		return holdings;
	}
	public void setHoldings(int holdings) {
		this.holdings = holdings;
	}
	public int getCohorts() {
		return cohorts;
	}
	public void setCohorts(int cohorts) {
		this.cohorts = cohorts;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public int getManpowerRec() {
		return manpowerRec;
	}
	public void setManpowerRec(int manpowerRec) {
		this.manpowerRec = manpowerRec;
	}
	public int getMaxManpower() {
		return maxManpower;
	}
	public void setMaxManpower(int maxManpower) {
		this.maxManpower = maxManpower;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public float getStability() {
		return stability;
	}
	public void setStability(float stability) {
		this.stability = stability;
	}
	public float getAgressive_expansion() {
		return agressive_expansion;
	}
	public void setAgressive_expansion(float agressive_expansion) {
		this.agressive_expansion = agressive_expansion;
	}
	public float getReligious_unity() {
		return religious_unity;
	}
	public void setReligious_unity(float religious_unity) {
		this.religious_unity = religious_unity;
	}
	public float getTyranny() {
		return tyranny;
	}
	public void setTyranny(float tyranny) {
		this.tyranny = tyranny;
	}
	public float getWar_exhauastion() {
		return war_exhauastion;
	}
	public void setWar_exhauastion(float war_exhauastion) {
		this.war_exhauastion = war_exhauastion;
	}
	public CampaignSessionDocument getCampaignSessionDocument() {
		return campaignSessionDocument;
	}
	public void setCampaignSessionDocument(CampaignSessionDocument campaignSessionDocument) {
		this.campaignSessionDocument = campaignSessionDocument;
	}
	
    

}