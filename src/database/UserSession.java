package database;

import model.MemberVO;

public class UserSession {
	private static UserSession instance = new UserSession();
	
	private MemberVO memberInfo;
	
	private UserSession() {
		memberInfo  = new MemberVO();
	}
	
	public static UserSession getInstance() {
		if(instance == null) {
			instance = new UserSession();
		}
		return instance;
	}
	
	public void setMember(MemberVO memberInfo) {this.memberInfo = memberInfo;}
	public MemberVO getMember() {
		System.out.println(memberInfo.getId());
		System.out.println(memberInfo.getLoginId());
		System.out.println(memberInfo.getName());
		System.out.println(memberInfo.getNickName());
		System.out.println(memberInfo.getBirthdate());
		return memberInfo;
		}
}
