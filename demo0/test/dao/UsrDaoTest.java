package dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import dao.impl.UsrDao;
import entity.Usr;

public class UsrDaoTest {

	@Test
	public void testAdd() {
		fail("Not yet implemented");
		//test
	}

	@Test
	public void testDel() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindClassSerializable() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindString() {
		UsrDao ub = new UsrDao();
		String hql = "from Event";
		List list = ub.find(hql);

		for (int i = 0; i < list.size(); i++) {
			Usr usr = (Usr) list.get(i);
			System.out.println(usr.getName());
		}
	}

	@Test
	public void testFindStringPageResult() {

	}

	@Test
	public void testFindDetachedCriteriaPageResult() {
		fail("Not yet implemented");
	}

	@Test
	public void testExecProc() {
		fail("Not yet implemented");
	}

	
	public static void main(String[] args) {
	new UsrDaoTest().	testFindString();
	}
}
