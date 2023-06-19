package comp_decomp;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.zip.GZIPOutputStream;

	public class compressor {
		public static void method(File file) throws IOException{
			String fileDirectory = file.getParent();
			
			// Reads the input bytes in the file
			FileInputStream fis = new FileInputStream(file);
			
			// Writes in the given file
			FileOutputStream fos = new FileOutputStream(fileDirectory+"/CompressedFile.gz");
			
			// Writes compressed file
			GZIPOutputStream gzip = new GZIPOutputStream(fos);
			
			byte[] buffer = new byte[1024];
			int len;
			
			while((len=fis.read(buffer))!=-1){
				gzip.write(buffer, 0, len);
			}
			gzip.close();
			fis.close();
			fos.close();
		}
		
		public static void main(String[] args) throws IOException{
			File path = new File("");
			method(path);
		}
	}

