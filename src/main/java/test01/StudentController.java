package test01;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/boad/*")
public class StudentController extends HttpServlet {
	StudentDAO studentDAO;

	public void init() throws ServletException {
		studentDAO = new StudentDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doHandle(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doHandle(request, response);
		
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = "";
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String action = request.getPathInfo();
		System.out.println("action : " + action);
		if(action == null || action.equals("/studentlists")) {
			List studentsList = studentDAO.studentList();
			request.setAttribute("studentsList", studentsList);
			nextPage = "/test/studentlists.jsp";

		} else if(action.equals("/studentlists")) {
			String id = request.getParameter("id");
			String username = request.getParameter("username");
			String univ = request.getParameter("univ");
			String birth = request.getParameter("birth");
			
			StudentVO studentVO = new StudentVO(id, username, univ, birth);
			studentDAO.addstudent(studentVO);
			nextPage = "/boad/studentlists"; // studentlists를 한번 더 해서 url에 표현(안하면 새로고침해야 화면이 전환됨.)
			
		} else if(action.equals("/newstudent")) {
			nextPage = "/test/ViewMember.jsp";
			
		} else {
			List studentsList = studentDAO.studentList();
			request.setAttribute("studentsList", studentsList);
			nextPage= "/test/studentlists.jsp";
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}

}
