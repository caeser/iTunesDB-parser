import java.io.DataInputStream;
import java.io.IOException;

public class AlbumList {
	public static void run(DataInputStream dis) throws IOException{
		byte[] albumList = new byte[4];
		dis.read(albumList);
		Util.print("\t \tAlbumList\t"+new String(albumList, "UTF-8")+"\n");

		long headLength = Util.readInt(dis);
		Util.print("\t\thead length:\t"+headLength+"\n");

		long albumsQuantity = Util.readInt(dis);
		Util.print("\t\tAlbums quantity:\t"+albumsQuantity+"\n");

		byte[] remain = new byte[(int)(headLength-12)];
		dis.read(remain);
		Util.print("\t\tremain:\t\t");
		Util.printHexBytes(remain);

		runAlbums(dis, albumsQuantity);
	}

	public static void runAlbums(DataInputStream dis, long times) throws IOException {
		if(times == 0) return;
		Album.run(dis);
		runAlbums(dis, times-1);
	}
}
