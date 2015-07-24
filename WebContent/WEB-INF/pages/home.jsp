<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<tiles:insertDefinition name="homeLayout">
	<tiles:putAttribute name="body">

		<div class="menuLeft">
			<div>
				<div>
					<img style="width: 102px; height: 120px;" id="profilePicture" alt="Profile Picture"
						src="${user.profilePicutreBase64String}">
				</div>
				<div id="userNameDiv">
					<label>${user.firstName}</label>
				</div>
			</div>
			<div id="profileNameDiv">
				<spring:url value="/editProfile" var="Editurl" htmlEscape="true" />
				<a href="${Editurl}">Edit Profile</a>
				<br>
			</div>
			
			
			<spring:url value="/accountSettings" var="accSett" htmlEscape="true" />
			<a style="color: #000;" href="${accSett}">Account Settings</a><br />
			<spring:url value="/prvcySettings" var="prvcSett" htmlEscape="true" />
			<a style="color: #000;" href="${prvcSett}">Privacy Settings</a>
			<div>
				<h5>FAVORITES</h5>
				<spring:url value="/home" var="home" htmlEscape="true" />
				<a href="${home}" class="newsFeed">News Feed</a><br>
				<spring:url value="/chat" var="chat" htmlEscape="true" />
				<a href="${chat}" class="messages">Messages</a><br>
				<spring:url value="/addimage" var="image" htmlEscape="true" />
				<a href="${image}" class="images">Images</a><br>
			</div>
			<br>
			<div>
				<h5>CONNECT</h5>
				<a href="contacts" class="contacts">My Contacts</a><br>
			</div>
			<br>
			<div>
				<h5>CATEGORIES</h5>

				<spring:url value="/familyUpdates" var="familyUpdates" htmlEscape="true" />
				<a href="${familyUpdates}" class="iconified">Family</a><br>
				<spring:url value="/educationUpdates" var="educationUpdates" htmlEscape="true" /> 
				<a href="${educationUpdates}" class="education">Education</a><br> 
				<spring:url value="/workUpdates" var="workUpdates" htmlEscape="true" /> 
				<a href="${workUpdates}" class="work">Work</a><br>
			</div>
		</div>
		
		<div class="borderDiv"></div>

		<div id="bodyRight">
			<div>
				<div style="border-bottom: 1px solid #000;">
					<img src="resources/images/status.svg"
						style="width: 18px; height: 18px" /> <label>Update Status</label><br>
					<textarea placeholder="What's on your mind ?"
						style="width: 40%; height: 10%;" id="statusUpdateText"
						maxlength="200"></textarea>
					<br> <input onclick="updateStatus()"
						style="margin-top: 3px; margin-bottom: 15px; background-color: #7D110C; color: #e1d8b7; width: 40.6%;"
						type="submit" value="Post"> <br>
				</div>
				<br>
				
				<br> <br>
				<div id="statusUpdateCompleteBlock" style="overflow-y:scroll; width: 100%; height: 500px">

					<c:forEach items="${statusCommentsMap}" var="statusCommentMap">
						<div class="statUpdateDiv">
							<div id="${statusCommentMap.key.status_Update_ID}"
								style="width: 80%; height: 20% x; float: left;">
										<div style="width: 15%; float: left;">
									<img id="profilePicture" alt="Profile Picture"
										src="${statusCommentMap.key.userID.profilePicutreBase64String}">
										</div>

								<div id="${statusCommentMap.key.status_Update_ID}100" style="float: right; width: 85%;">
									<p style="color:#7D110C">${statusCommentMap.key.userID.firstName}</p>
									<br><div style="border: solid 1px black; height: 70px; "> <label>${statusCommentMap.key.statusUpdate} </label></div>
									<br> <br> 
									<a id="likeTag${statusCommentMap.key.status_Update_ID}" href="javaScript:void(0);" onclick="updateLikeComment(this)">
									<c:if test="${statusCommentMap.key.likeOrDislike == 1}">Liked</c:if>
									<c:if test="${(statusCommentMap.key.likeOrDislike == 2) || (statusCommentMap.key.likeOrDislike == 0)}">Like</c:if></a>
									
									 <a id="dislikeTag${statusCommentMap.key.status_Update_ID}" href="javaScript:void(0);" onclick="updateDisLikeComment(this)">
									 <c:if test="${statusCommentMap.key.likeOrDislike == 0}"> Disliked</c:if> 
									 <c:if test="${(statusCommentMap.key.likeOrDislike == 2) || (statusCommentMap.key.likeOrDislike == 1)}"> Dislike </c:if>
									 </a>
									 <div style="border-top: 1px solid black;"><p>Likes ${statusCommentMap.key.likeCount}  DisLikes ${statusCommentMap.key.dislikeCount}</p></div>
									 
									 <br>
									 <p>Comments :</p>
									<c:forEach var="userComment" items="${statusCommentMap.value}">
									<div style="border: 1px solid black;">
										<div>

											<img src="" />
										</div>
										<div class="varclass">
											<p style="color:#7D110C">${userComment.commentorUserID.firstName}</p>
										</div>
										<div>
											<p>${userComment.comment}</p>
										</div>
										</div>
										<br>
									</c:forEach>
									<input type="hidden" value="${statusCommentMap.key.status_Update_ID}"/>
									<div id="${statusCommentMap.key.status_Update_ID}">
									<textarea placeholder="Any Comments ? "	style="width: 40%; height: 40%;"  maxlength="200" ></textarea><br>
									<input type="button" class="commentBtn" value="Post" onclick="updateComment(this)">
									<input type="hidden" value="${user.firstName}"/>
									</div>
									<br>
								</div>

							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>
