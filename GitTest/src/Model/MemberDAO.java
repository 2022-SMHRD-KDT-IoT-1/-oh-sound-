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
		}
		catch (Exception e)  {
			e.printStackTrace();
		}
		
	}
	public int join(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession(true);
		int cnt = session.insert("joinService", vo);	
		session.close();
		
		return cnt;
	}
	
	public MemberVO login(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession();		
		MemberVO uvo = session.selectOne("loginService", vo);
		session.close();
		return uvo;
	}
	//^^^^^^^^^^login
	
	public int update(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession(true);	
		int cnt = session.update("updateService", vo);
		session.close();
		return cnt;
	}

	public int delete(String mb_id) {
		SqlSession session = sqlSessionFactory.openSession(true);	
		int cnt = session.delete("deleteService", mb_id);
		session.close();
		return cnt;
	}

	public MemberVO idCheck(String mb_id) {
		SqlSession session = sqlSessionFactory.openSession();		
		MemberVO vo = session.selectOne("idCheck", mb_id);
		session.close();
		return vo;		
	}
}
