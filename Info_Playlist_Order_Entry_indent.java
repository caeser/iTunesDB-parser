import java.io.DataInputStream;
import java.io.IOException;

public class Info_Playlist_Order_Entry_indent {
	public static void run(DataInputStream dis) throws IOException{
		byte[] info = new byte[4];
		dis.read(info);
		Util.print("\t\t\t\t\tInfo\t\t"+new String(info, "UTF-8")+"\n");

		long headLength = Util.readInt(dis);
		Util.print("\t\t\t\t\thead length:\t"+headLength+"\n");

		long length = Util.readInt(dis);
		Util.print("\t\t\t\t\tlength:\t\t"+length+"\n");

		long type = Util.readInt(dis);
		Util.print("\t\t\t\t\ttype:\t\t"+type+"\n");

		long unknown1 = Util.readInt(dis);
		Util.print("\t\t\t\t\tunknown1:\t"+unknown1+"\n");

		long unknown2 = Util.readInt(dis);
		Util.print("\t\t\t\t\tunknown2:\t"+unknown2+"\n");

		long position = Util.readInt(dis);
		Util.print("\t\t\t\t\tposition:\t"+Util.hexLong(position)+"\n");

		byte[] remain = new byte[(int) length - 28];
		dis.read(remain);
		Util.print("\t\t\t\t\tremain:\t\t");
		Util.printHexBytes(remain);
	}
}
