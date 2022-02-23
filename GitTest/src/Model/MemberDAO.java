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
		
		// 1. SQLSession �����
		// �Ű������� boolean -> autocommit�� �������
		SqlSession session = sqlSessionFactory.openSession(true);
		
		// insert, delete, update�� �̸� �Ȱ���
		// insert("id��", �Ű�����)
		// mapper.xml���� resultType(��ȯŸ��)�� �������� �ʾƵ� �ڵ����� int�� ����
		// Select���� ��� : 1�� -> selectOne("id��", �Ű�����), selectList("id��",�Ű�����)
		int cnt = session.insert("joinService", vo);
		
		// Ŀ��
		// session.commit();
		
		// ���� �ݱ�
		session.close();
		
		return cnt;
	}
	// ===join===
	
	public MemberVO login(MemberVO vo) {
		 
		// 1. sqlSession ����
		SqlSession session = sqlSessionFactory.openSession();
		
		// 2. Mapper�� �����ص� sql�� ���
		MemberVO uvo = session.selectOne("loginService", vo);
	
		// 3. session �ݱ�
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
