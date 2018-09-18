package com.teamproject.club_application.data;

import java.util.ArrayList;

public class PostFrame {
	int commentPage;
    PostView postView;
    ArrayList<CommentView> commentView;
    
    public int getCommentPage() {
		return commentPage;
	}
    public void setCommentPage(int commentPage) {
		this.commentPage = commentPage;
	}
	public PostView getPostView() {
		return postView;
	}
	public void setPostView(PostView postView) {
		this.postView = postView;
	}
	public ArrayList<CommentView> getCommentView() {
		return commentView;
	}
	public void setCommentView(ArrayList<CommentView> commentView) {
		this.commentView = commentView;
	}

    public PostFrame(int commentPage, PostView postView, ArrayList<CommentView> commentView) {
		super();
		this.commentPage = commentPage;
		this.postView = postView;
		this.commentView = commentView;
	}
	public PostFrame() {
		// TODO Auto-generated constructor stub
	}
}
