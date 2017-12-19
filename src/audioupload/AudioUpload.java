package audioupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



/**
 * Servlet implementation class AudioUpload
 */
@WebServlet("/AudioUpload")
@MultipartConfig
public class AudioUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Part audio=   request.getPart("audio");	
		
		
		String path=request.getRealPath(request.getContextPath());
		String audioPath=path+"/audio/";
		InputStream audioInputStream=audio.getInputStream();
		File f=new File(audioPath);
		if(!f.exists())
		{
			System.out.println();
			f.mkdirs();
		}
		
		OutputStream audioOutputStream=new FileOutputStream(new File(f.getAbsolutePath()+"/"+audio.getSubmittedFileName()));
		
		byte[] audioInputArray=new byte[audioInputStream.available()];
		
		audioInputStream.read(audioInputArray);
		
		audioOutputStream.write(audioInputArray);
		
		
		//This just to show the the actual path of audio upload
		System.out.println(audioPath);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
