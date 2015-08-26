package com.angular.rest.business;

import org.apache.commons.lang3.StringUtils;

import com.angular.dao.StoryManagementDAO;
import com.angular.dao.UserManagementDAO;
import com.angular.rest.helper.StoryManagementRestFullHelper;
import com.angular.rest.vo.StoryDetailRestVO;
import com.angular.vo.StoryDetail;

public class StoryManagementBusinessFacade {

	public boolean saveStory(StoryDetailRestVO uVO) {
		
		StoryManagementRestFullHelper helper = new StoryManagementRestFullHelper();
		
		StoryDetail sDetail = new StoryDetail();
		
		sDetail = helper.prepareStoryVO(uVO);
		
		boolean result=false;
		StoryManagementDAO sDAO = new StoryManagementDAO();
		
		result = sDAO.saveStoryDetail(sDetail);
		
		return result;
	}

	public String getAllStories() {

		String result="";
		StoryManagementDAO sDAO = new StoryManagementDAO();
		
		result = sDAO.getAllStories();
		
		return result;
	}

	public String getStoryDetail(String _id) {
		
		StoryManagementDAO sDAO = new StoryManagementDAO();
		
		String storyDetail = "";
		
		if(null!=_id || StringUtils.isNotEmpty(_id)) {
			
			
			storyDetail = sDAO.getUserDetail(_id);
		}

		return storyDetail;
	
	}

	public boolean saveComments(StoryDetailRestVO storyRestVO) {
		
		StoryManagementRestFullHelper helper = new  StoryManagementRestFullHelper();
		
		StoryDetail sDetail = new StoryDetail();
		sDetail = helper.prepateCommentsObject(storyRestVO);
		
		boolean result=false;
		StoryManagementDAO sDAO = new StoryManagementDAO();
		
		result = sDAO.saveComments(sDetail);
		
		return result;
	}

}
