package Model;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {

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

	public int join(MemberVO vo) {
		
		// 1. SQLSession 만들기
		// 매개변수로 boolean -> autocommit의 사용유무
		SqlSession session = sqlSessionFactory.openSession(true);
		
		// insert, delete, update는 이름 똑같음
		// insert("id값", 매개변수)
		// mapper.xml에서 resultType(반환타입)을 정의하지 않아도 자동으로 int로 리턴
		// Select문의 경우 : 1개 -> selectOne("id값", 매개변수), selectList("id값",매개변수)
		int cnt = session.insert("joinService", vo);
		
		// 커밋
		// session.commit();
		
		// 세션 닫기
		session.close();
		
		return cnt;
	}
	// ===join===
	
	public MemberVO login(MemberVO vo) {
		 
		// 1. sqlSession 생성
		SqlSession session = sqlSessionFactory.openSession();
		
		// 2. Mapper에 정의해둔 sql문 사용
		MemberVO uvo = session.selectOne("loginService", vo);
	
		// 3. session 닫기
		session.close();
		
		return uvo;
	}
	
	public MemberVO idCheck(String mb_id) {
		SqlSession session = sqlSessionFactory.openSession();
		
		MemberVO vo = session.selectOne("idCheck", mb_id);
		
		session.close();
		
		return vo;
				
	}
}
