package test01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class StudentDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public StudentDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/servletex");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List studentList() {
		List studentsList = new ArrayList();
		try {
			con = dataFactory.getConnection();
			String query = "select * from membertable order by id";
					System.out.println(query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String username = rs.getString("username");
				String univ = rs.getString("univ");
				String birth = rs.getString("birth");
				
				StudentVO studentVO = new StudentVO(id, username, univ, birth);
				studentsList.add(studentVO);
			}
			rs.close();
			pstmt.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return studentsList;
	}

	public void addstudent(StudentVO m) {
		try {
			con= dataFactory.getConnection();
			String id = m.getId();
			String username = m.getUsername();
			String univ = m.getUniv();
			String birth = m.getBirth();
		
			String query = "insert into membertable(id,username,univ,birth)" + "values(?,?,?,?)";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, username);
			pstmt.setString(3, univ);
			pstmt.setString(4, birth);
			
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
