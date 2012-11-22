import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Main {
	public static void main(String ... args) throws IOException, FileNotFoundException, UnsupportedEncodingException {
		PrintStream out =
			new PrintStream(
				new BufferedOutputStream(
					new FileOutputStream("output.txt", false)
				),
				true,
				"UTF-8"
			);		
		System.setOut(out);

		//read data
		DataInputStream dis =
			new DataInputStream(
				new FileInputStream("iTunesDB")
			);
		Database.run(dis);
		dis.close();
/*
		DataOutputStream dos =
			new DataOutputStream(
				new FileOutputStream("iTunesDB-New")
			);
		Database.write(dis);
		dos.flush();
		dos.close();*/
		Util.print("\ttype:\t\t"+Database.ListHolders.get(0).type+"\n");

		out.close();
	}
}
