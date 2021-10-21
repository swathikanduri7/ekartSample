package com.swaraj.shop.application.config;

import org.drools.core.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.swaraj.shop.utils.CloudFilePathUtils;
import com.swaraj.shop.utils.ImageFilePath;
import com.swaraj.shop.utils.LocalImageFilePathUtils;

@Configuration
public class LocationImageConfig {
	
  @Value("${config.cms.contentUrl}")
  private String contentUrl;
  
  @Value("${config.cms.method}")
  private String method;
  
  @Value("${config.cms.static.path}")
  private String staticPath;

  @Bean
  public ImageFilePath img() {
	  
	if(!StringUtils.isEmpty(method) && !method.equals("default")) {
	    CloudFilePathUtils cloudFilePathUtils = new CloudFilePathUtils();
	    cloudFilePathUtils.setBasePath(contentUrl);
	    return cloudFilePathUtils;

	} else {
	    LocalImageFilePathUtils localImageFilePathUtils = new LocalImageFilePathUtils();
	    localImageFilePathUtils.setBasePath(staticPath);
	    return localImageFilePathUtils;
	}
	  

  }
  
  
}
