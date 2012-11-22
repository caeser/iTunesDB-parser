import java.io.DataInputStream;
import java.io.IOException;

public class Info {
	public static void run(DataInputStream dis) throws IOException{
		byte[] info = new byte[4];
		dis.read(info);
		Util.print("\t\t\t\tInfo\t\t"+new String(info, "UTF-8")+"\n");

		long headLength = Util.readInt(dis);
		Util.print("\t\t\t\thead length:\t"+headLength+"\n");

		long length = Util.readInt(dis);
		Util.print("\t\t\t\tlength:\t\t"+length+"\n");

		long type = Util.readInt(dis);
		Util.print("\t\t\t\ttype:\t\t"+type+"\n");

		long unknown1 = Util.readInt(dis);
		Util.print("\t\t\t\tunknown1:\t"+unknown1+"\n");

		long unknown2 = Util.readInt(dis);
		Util.print("\t\t\t\tunknown2:\t"+unknown2+"\n");

		switch((int) type) {
			case InfoType.Playlist_Column_Definition :
				Info_Playlist_Column_Definition.run(dis, length);
				break;
			case InfoType.Playlist_Order_Entry :
				Info_Playlist_Order_Entry.run(dis, length);
				break;
			case InfoType.Smart_Playlist_Data :
				Info_Smart_Playlist_Data.run(dis, length);
				break;
			case InfoType.Smart_Playlist_Rules :
				Info_Smart_Playlist_Rules.run(dis, length);
				break;
			default :
				Info_String.run(dis);
		}
	}
}
