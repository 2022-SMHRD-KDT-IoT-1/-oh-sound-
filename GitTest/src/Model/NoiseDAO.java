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
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
public int sound(NoiseVO vo) {
		
		// 1. SQLSession �����
		// �Ű������� boolean -> autocommit�� �������
		SqlSession session = sqlSessionFactory.openSession(true);
		
		// insert, delete, update�� �̸� �Ȱ���
		// insert("id��", �Ű�����)
		// mapper.xml���� resultType(��ȯŸ��)�� �������� �ʾƵ� �ڵ����� int�� ����
		// Select���� ��� : 1�� -> selectOne("id��", �Ű�����), selectList("id��",�Ű�����)
		int cnt = session.insert("max9814", vo);
		
		// Ŀ��
		// session.commit();
		
		// ���� �ݱ�
		session.close();
		
		return cnt;
	}
	// ===join===
	// =======================================
	

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
