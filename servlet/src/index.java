

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html>"
		+"	<head>"
		+"<title>Add task</title>"
		+"	</head>"
		+"	<body>"
		+"		<form method=\"POST\">"
		+"			<table>"
		+"				<tr>"
		+"					<td>Title:</td>"
		+"					<td><input type=\"text\" name=\"title\" /></td>"
		+"				</tr>"
		+"				<tr>"
		+"					<td>Description:</td>"
		+"					<td><input type=\"text\" name=\"description\" /></td>"
		+"				</tr>"
		+"				<tr>"
		+"					<td>State:</td>"
		+"					<td>"
		+"						<select name=\"state\">"
		+"							<option value=\"BACKLOG\" selected>Backlog</option>"
		+"							<option value=\"TO_DO\">To do</option>"
		+"							<option value=\"IN_PROGRESS\">In progress</option>"
		+"							<option value=\"DONE\">Done</option>"
		+"						</select>"
		+"					</td>"
		+"				</tr>"
		+"				<tr>"
		+"					<td>Category:</td>"
		+"					<td><input type=\"text\" name=\"category\" /></td>"
		+"				</tr>"
		+"				<tr>"
		+"					<td>Priority:</td>"
		+"					<td><input type=\"text\" name=\"priority\" /></td>"
		+"				</tr>"
		+"				<tr>"
		+"					<td>Owner:</td>"
		+"					<td><input type=\"text\" name=\"owner\" /></td>"
		+"				</tr>"
		+"				<tr>"
		+"					<td>Due date:</td>");
		writer.println("					<td><input type=\"text\" name=\"due_date\" value=\""
				+ new Date() + "\"/></td>");
		writer.println("				</tr>"
		+"				<tr>"
		+"					<td colspan=\"2\"><input type=\"submit\" value=\"Add\" /></td>"
		+"				</tr>"
		+"			</table>"
		+"		</form>"
		+"	</body>"
		+"</html>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Task task = new Task();

		task.setTitle(request.getParameter("title"));
		task.setDescription(request.getParameter("description"));
		task.setOwner(request.getParameter("owner"));
		task.setCategory(new Category(request.getParameter("category")));

		SimpleDateFormat formatter = new SimpleDateFormat(
				"EEE MMM d zzz yyyy");
		try {
			task.setDueDate(formatter.parse(request.getParameter("due_date")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			task.setState(State.valueOf(request.getParameter("state")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			task.setPriority(Short.parseShort(request.getParameter("priority")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		task.setCreateDate(new Date());

		Program.dashboard.add(task);

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		//writer.print("<html><body>" + task.toHtml() + "</body></html>");
	}
}
