package model;

public class Follow {
	private int followId;
	private int followerId;
	private int followeeId;
	private int followStatus;

	public int getFollowId() {
		return followId;
	}

	public void setFollowId(int followId) {
		this.followId = followId;
	}

	public int getFollowerId() {
		return followerId;
	}

	public void setFollowerId(int followerId) {
		this.followerId = followerId;
	}

	public int getFolloweeId() {
		return followeeId;
	}

	public void setFolloweeId(int followeeId) {
		this.followeeId = followeeId;
	}

	public int getFollowStatus() {
		return followStatus;
	}

	public void setFollowStatus(int followStatus) {
		this.followStatus = followStatus;
	}
}