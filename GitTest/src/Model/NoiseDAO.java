package Model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class NoiseDAO {

	private static SqlSessionFactory sqlSessionFactory;

	static {

		try {
			String resource = "Mapper/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int sound(NoiseVO vo) {
		int cnt = 0;

		// 1. SQLSession 만들기
		// 매개변수로 boolean -> autocommit의 사용유무
		if (vo.getNoise_db() >= 45) {
			SqlSession session = sqlSessionFactory.openSession(true);
			cnt = session.insert("max9814", vo);
			session.close();

		}
		return cnt;
		
		
		// insert, delete, update는 이름 똑같음
		// insert("id값", 매개변수)
		// mapper.xml에서 resultType(반환타입)을 정의하지 않아도 자동으로 int로 리턴
		// Select문의 경우 : 1개 -> selectOne("id값", 매개변수), selectList("id값",매개변수)

		// 커밋
		// session.commit();

		// 세션 닫기

	}
	// ===join===
	// =======================================

	public int non(NoiseVO vo) {
		int cnt = 0;
	
		// 1. SQLSession 만들기
		// 매개변수로 boolean -> autocommit의 사용유무
		if(vo.getNoise_vibration()<1023) {
			SqlSession session = sqlSessionFactory.openSession(true);
			cnt = session.insert("max9814", vo);
			session.close();
			
		}
		return cnt;
	}
	
	public List<NoiseVO> selectAllNoise() {

		SqlSession session = sqlSessionFactory.openSession();

		List<NoiseVO> Alist = session.selectList("selectAllNoise");

		session.close();

		return Alist;
	}

	public List<NoiseVO> selectNoise(String mb_id) {

		SqlSession session = sqlSessionFactory.openSession();

		List<NoiseVO> glist = session.selectList("selectNoise", mb_id);

		session.close();

		return glist;

	}
}
