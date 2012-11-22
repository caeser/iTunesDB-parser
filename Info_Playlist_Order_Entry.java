import java.io.DataInputStream;
import java.io.IOException;

public class Info_Playlist_Order_Entry {
	public static void run(DataInputStream dis, long length) throws IOException{

		long position = Util.readInt(dis);
		Util.print("\t\t\t\tposition:\t"+position+"\n");

		byte[] remain = new byte[(int) length - 28];
		dis.read(remain);
		Util.print("\t\t\t\tremain:\t\t");
		Util.printHexBytes(remain);
	}
}
