package Model;

public class NoiseVO {
	
	private int num;
	private double noise_db;
	private int noise_vibration;
	private String noise_date;
	private String mb_id;
	
	public NoiseVO(int num, double noise_db, int noise_vibration, String noise_date, String mb_id) {
		super();
		this.num = num;
		this.noise_db = noise_db;
		this.noise_vibration = noise_vibration;
		this.noise_date = noise_date;
		this.mb_id = mb_id;
	}
	




	public NoiseVO(double noise_db, int noise_vibration) {
		this.noise_db = noise_db;
		this.noise_vibration = noise_vibration;
	}





	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getNoise_db() {
		return noise_db;
	}

	public void setNoise_db(double noise_db) {
		this.noise_db = noise_db;
	}

	public int getNoise_vibration() {
		return noise_vibration;
	}

	public void setNoise_vibration(int noise_vibration) {
		this.noise_vibration = noise_vibration;
	}

	public String getNoise_date() {
		return noise_date;
	}

	public void setNoise_date(String noise_date) {
		this.noise_date = noise_date;
	}

	public String getMb_id() {
		return mb_id;
	}

	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	
}
