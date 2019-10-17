package kr.or.nextit;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

public class MemberDAOTest {

	@Test
	public void testSelectMemberList() throws Exception {
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.selectMemberList();
		assertTrue(list.size() == 24);
		assertTrue(list.get(7).getMemId().equals("h001"));
	}

	@Test
	public void testSelectMember() throws Exception {
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.selectMember("p001");
		assertTrue(vo.getMemName().equals("오성순"));
		assertThat(vo.getMemName(), is(not("유성순")));
	}

	@Test
	public void testInsertMember() throws Exception {
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo.setMemId("a002");
		vo.setMemPass("qwer");
		vo.setMemName("홍길동");
		vo.setMemReg01("960101");
		vo.setMemReg02("211323");
		vo.setMemBir(null);
		vo.setMemZip("23051");
		vo.setMemAdd1("대전시 중구");
		vo.setMemAdd2("희영빌딩");
		vo.setMemHometel("042-123-4567");
		vo.setMemComtel("042-789-1234");
		vo.setMemHp("010-5555-8888");
		vo.setMemMail("dklsfja@hoid.kr");
		dao.insertMember(vo);
		assertThat(dao.selectMember(vo.getMemId()).getMemName(), is("홍길동"));
				
		}

	/*
	 * @Test public void testUpdateMember() throws Exception { MemberDAO dao = new
	 * MemberDAO(); MemberVO vo = new MemberVO(); vo.setMemId("a001");
	 * vo.setMemPass("qwer"); vo.setMemName("홍길동"); vo.setMemReg01("960101");
	 * vo.setMemReg02("211323"); vo.setMemBir("960101"); vo.setMemZip("23051");
	 * vo.setMemAdd1("대전시 중구"); vo.setMemAdd2("희영빌딩");
	 * vo.setMemHometel("042-123-4567"); vo.setMemComtel("042-789-1234");
	 * vo.setMemHp("010-5555-8888"); vo.setMemMail("dklsfja@hoid.kr");
	 * dao.updateMember(vo);
	 * assertThat(dao.selectMember(vo.getMemId()).getMemName(), is("홍길동"));
	 * 
	 * }
	 */

	@Test
	public void testDeleteMember() throws Exception {
		MemberDAO dao = new MemberDAO();
		 dao.deleteMember("y001");
	}

}
