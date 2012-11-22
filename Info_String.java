import java.io.DataInputStream;
import java.io.IOException;

public class Info_String {
	public static void run(DataInputStream dis) throws IOException{

		long position = Util.readInt(dis);
		Util.print("\t\t\t\tposition:\t"+position+"\n");

		long contentLength = Util.readInt(dis);
		Util.print("\t\t\t\tcontent length:\t"+contentLength+"\n");

		long unknown3 = Util.readInt(dis);
		Util.print("\t\t\t\tunknown3:\t"+unknown3+"\n");

		long unknown4 = Util.readInt(dis);
		Util.print("\t\t\t\tunknown4:\t"+unknown4+"\n");

		byte[] content = new byte[(int) contentLength];
		dis.read(content);
		Util.print("\t\t\t\tcontent:\t"+new String(content, "UTF-16LE")+"\n");
	}
}
