package audio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadAudio
 */
@WebServlet("/DownloadAudio")
public class DownloadAudio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("application/force-download");
		//response.setContentLength(arg0);
		
		String audioName=request.getParameter("name");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + audioName + "\"");
		FileInputStream fis=new FileInputStream(request.getRealPath(request.getServletContext().getContextPath())+"/audio/"+audioName);
		
		byte[] audioByteArray=new byte[fis.available()];
		
		
		fis.read(audioByteArray);
		
		OutputStream os=response.getOutputStream();
		fis.read(audioByteArray);
		os.write(audioByteArray);
		
		
		os.close();
		
		
	}

}
