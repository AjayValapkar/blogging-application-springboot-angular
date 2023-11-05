package com.linkmingle.dto;

public class BlogsAction {
	private int likes;
	private int dislike;

	public BlogsAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BlogsAction(int likes, int dislike) {
		super();
		this.likes = likes;
		this.dislike = dislike;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislike() {
		return dislike;
	}

	public void setDislike(int dislike) {
		this.dislike = dislike;
	}

	@Override
	public String toString() {
		return "BlogsAction [likes=" + likes + ", dislike=" + dislike + "]";
	}

}
