package com.angular.rest.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.angular.rest.vo.StoryDetailRestVO;
import com.angular.vo.StoryCommentsVO;
import com.angular.vo.StoryDetail;

public class StoryManagementRestFullHelper {

	public StoryDetail prepareStoryVO(StoryDetailRestVO storyRestVO) {
		// TODO Auto-generated method stub
		
		StoryDetail storyVO = new StoryDetail();
		
		storyVO.setCategory(storyRestVO.category);
		//storyVO.setComments(storyRestVO.comments);
		storyVO.setOwnerName(storyRestVO.ownerName);
		storyVO.setShortDescription(storyRestVO.shortDescription);
		storyVO.setStatus(storyRestVO.status);
		storyVO.setStoryContent(storyRestVO.storyContent);
		storyVO.setStoryName(storyRestVO.storyName);
		//storyVO.setTags(storyRestVO.tags);
		
		return storyVO;
	}

	public StoryDetail prepateCommentsObject(StoryDetailRestVO uVO) {
		
		StoryDetail detailVO = new StoryDetail();
		
		List<StoryCommentsVO> commentsList = new ArrayList<StoryCommentsVO>();
		StoryCommentsVO commentsVO = new StoryCommentsVO();
		
		//add null validations here
		
		detailVO.set_id(uVO._id);
		//commentsVO.set_id(uVO.comments.get_id());
		commentsVO.setComments(uVO.comments[0].getComments());
		commentsVO.setCommentedUser(uVO.comments[0].getCommentedUser());
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date today = Calendar.getInstance().getTime();
		String todayDate = df.format(today);
		
		commentsVO.setCommentedDate(todayDate);
		
		commentsList.add(commentsVO);
		detailVO.setComments(commentsList);
	
		return detailVO;
	}

}
