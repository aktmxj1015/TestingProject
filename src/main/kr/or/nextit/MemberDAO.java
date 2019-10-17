package kr.or.nextit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	public List<MemberVO> selectMemberList() throws Exception {
		// 1. DB 드라이버 로딩
		// 2. DB 연결
		// 3. 쿼리 만들기
		// 4. 쿼리 전송
		// 5. 결과 받기
		// 6. 자원 반납

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "oracle");
		PreparedStatement statement = connection.prepareStatement("select * from member ");
		ResultSet resultSet = statement.executeQuery();
		List<MemberVO> list = new ArrayList<MemberVO>();
		while (resultSet.next()) {
			String memId = resultSet.getString("mem_id");
			String memName = resultSet.getString("mem_name");
			String memHp = resultSet.getString("mem_hp");
			String memMail = resultSet.getString("mem_mail");
			list.add(new MemberVO(memId, memName, memHp, memMail));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}

	public MemberVO selectMember(String id) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "oracle");
		PreparedStatement statement = connection.prepareStatement("select * from member where mem_id =?");
		statement.setString(1, id);
		ResultSet resultSet = statement.executeQuery();

		MemberVO vo = null;
		while (resultSet.next()) {
			String memId = resultSet.getString("mem_id");
			String memName = resultSet.getString("mem_name");
			String memHp = resultSet.getString("mem_hp");
			String memMail = resultSet.getString("mem_mail");
			vo = new MemberVO(memId, memName, memHp, memMail);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return vo;
	}

	public void insertMember(MemberVO vo) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "oracle");
		String sql = "insert into member(mem_id, mem_pass, mem_name, mem_regno1, mem_regno2,mem_bir,  mem_zip,mem_add1, mem_add2, mem_hometel, mem_comtel,mem_hp, mem_mail) values(?????????????)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getMemId());
		statement.setString(2, vo.getMemPass());
		statement.setString(3, vo.getMemName());
		statement.setString(4, vo.getMemReg01());
		statement.setString(5, vo.getMemReg02());
		statement.setString(6, vo.getMemBir());
		statement.setString(7, vo.getMemZip());
		statement.setString(8, vo.getMemAdd1());
		statement.setString(9, vo.getMemAdd2());
		statement.setString(10, vo.getMemHometel());
		statement.setString(11, vo.getMemComtel());
		statement.setString(12, vo.getMemHp());
		statement.setString(13, vo.getMemMail());
		statement.executeUpdate();
		
		statement.close();
		connection.close();

	}

	public void updateMember(MemberVO vo) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "oracle");
		String sql = "update member set  mem_pass=?, mem_name=?, mem_regno1=?, mem_regno2=?,mem_bir=?,  mem_zip=?,mem_add1=?, mem_add2=?, mem_hometel=?, mem_comtel=?,mem_hp=?, mem_mail=? where mem_id=? ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(13, vo.getMemId());
		statement.setString(1, vo.getMemPass());
		statement.setString(2, vo.getMemName());
		statement.setString(3, vo.getMemReg01());
		statement.setString(4, vo.getMemReg02());
		statement.setString(5, vo.getMemBir());
		statement.setString(6, vo.getMemZip());
		statement.setString(7, vo.getMemAdd1());
		statement.setString(8, vo.getMemAdd2());
		statement.setString(9, vo.getMemHometel());
		statement.setString(10, vo.getMemComtel());
		statement.setString(11, vo.getMemHp());
		statement.setString(12, vo.getMemMail());
		statement.executeUpdate();
		
		statement.close();
		connection.close();
	}

	public void deleteMember(String id) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "oracle");
		String sql = "delete from member where mem_id=? ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, id);
		statement.executeQuery();
		
		statement.close();
		connection.close();
	}
}
