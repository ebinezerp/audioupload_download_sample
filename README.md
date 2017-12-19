# audioupload_download_sample


This is sample code to upload and download the audio files.


In this some of the important points that you need to remember 

1. Any file upload form should be of method post and should contain the attribute enctype="multipart/form-data"  
  Example: [index](https://github.com/ebinezerp/audioupload_download_sample/blob/master/WebContent/index.jsp)
  
2. As we are uploading the media file the servlet need to be configured as multipart. In the example to config servlet as multpart we are using @MutipartConfig annotation. Kindly refer the serlvet [AudioUpload](https://github.com/ebinezerp/audioupload_download_sample/blob/master/src/audioupload/AudioUpload.java)


3. In the servlet getRealPath() method is used to get the application path insted of hard-disk path. And getContextPath() is used to get the application path in the server.

4. 
