import java.io.DataInputStream;
import java.io.IOException;

public class Album {
	public static void run(DataInputStream dis) throws IOException{
		byte[] album = new byte[4];
		dis.read(album);
		Util.print("\t\t\tAlbum\t\t"+new String(album, "UTF-8")+"\n");

		long headLength = Util.readInt(dis);
		Util.print("\t\t\thead length:\t"+headLength+"\n");

		long length = Util.readInt(dis);
		Util.print("\t\t\tlength:\t\t"+length+"\n");

		long infosQuantity = Util.readInt(dis);
		Util.print("\t\t\tInfos quantity:\t"+infosQuantity+"\n");

		int unknown1 = Util.readShort(dis);
		Util.print("\t\t\t#unknown1:\t"+Util.hexInt(unknown1)+"\n");

		int albumId = Util.readShort(dis);
		Util.print("\t\t\talbumId:\t"+Util.hexInt(albumId)+"\n");

		byte[] unknown2 = new byte[8];
		dis.read(unknown2);
		Util.print("\t\t\tunknown2:\t");
		Util.printHexBytes(unknown2);

		long unknown3 = Util.readInt(dis);
		Util.print("\t\t\tunknown3:\t"+unknown3+"\n");

		byte[] remain = new byte[(int)(headLength-32)];
		dis.read(remain);
		Util.print("\t\t\tremain:\t\t");
		Util.printHexBytes(remain);

		runInfos(dis, infosQuantity);
	}

	public static void runInfos(DataInputStream dis, long times) throws IOException {
		if(times == 0) return;
		Info.run(dis);
		if(times != 1) Util.print("\n");
		runInfos(dis, times-1);
	}
}
