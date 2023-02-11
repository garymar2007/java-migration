package com.linkedin.hsports.services;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name="configuration")
@XmlAccessorType(XmlAccessType.FIELD)
public class RecommendationConfiguration {

	@XmlElement(name="algorigthm")
	private String algorithmName;
	
	@XmlElement(name="licenseKey")
	private String licenseKey;

	@XmlElement(name="recommendationNumber")
	private int recommendationNumber;

	public String getAlgorithmName() {
		return algorithmName;
	}
	
	public String getLicenseKey() {
		return licenseKey;
	}

	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}


	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}

	public int getRecommendationNumber() {
		return recommendationNumber;
	}


	public void setRecommendationNumber(int recommendationNumber) {
		this.recommendationNumber = recommendationNumber;
	}

	@PostConstruct
	public void init() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(RecommendationConfiguration.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		RecommendationConfiguration config = (RecommendationConfiguration) unmarshaller.unmarshal(new File("src/main/resources/configuration.xml"));
		BeanUtils.copyProperties(config,this);
	}
}
