package Model;

public class MemberVO {

	private String mb_id;
	private String mb_pw;
	private String mb_dongho;
	private String mb_joindate;

	
	public MemberVO(String mb_id, String mb_pw, String mb_dongho, String mb_joindate) {
		super();
		this.mb_id = mb_id;
		this.mb_pw = mb_pw;
		this.mb_dongho = mb_dongho;
		this.mb_joindate = mb_joindate;

	}

	public MemberVO(String mb_id, String mb_pw, String mb_dongho) {
		this.mb_id = mb_id;
		this.mb_pw = mb_pw;
		this.mb_dongho = mb_dongho;
	}

	public MemberVO(String mb_id, String mb_pw) {
		this.mb_id = mb_id;
		this.mb_pw = mb_pw;
	}

	public String getMb_id() {
		return mb_id;
	}

	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}

	public String getMb_pw() {
		return mb_pw;
	}

	public void setMb_pw(String mb_pw) {
		this.mb_pw = mb_pw;
	}

	public String getMb_dongho() {
		return mb_dongho;
	}

	public void setMb_dongho(String mb_dongho) {
		this.mb_dongho = mb_dongho;
	}

	public String getMb_joindate() {
		return mb_joindate;
	}

	public void setMb_joindate(String mb_joindate) {
		this.mb_joindate = mb_joindate;
	}
	
	
}
