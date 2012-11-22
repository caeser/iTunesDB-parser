import java.io.DataInputStream;
import java.io.IOException;

public class SongList {
	public static void run(DataInputStream dis) throws IOException{
		byte[] songList = new byte[4];
		dis.read(songList);
		Util.print("\t\tSongList\t"+new String(songList, "UTF-8")+"\n");

		long headLength = Util.readInt(dis);
		Util.print("\t\thead length:\t"+headLength+"\n");

		long songsQuantity = Util.readInt(dis);
		Util.print("\t\tSongs quantity:\t"+songsQuantity+"\n");

		byte[] remain = new byte[(int)(headLength-12)];
		dis.read(remain);
		Util.print("\t\tremain:\t\t");
		Util.printHexBytes(remain);

		runSongs(dis, songsQuantity);
	}

	public static void runSongs(DataInputStream dis, long times) throws IOException {
		if(times == 0) return;
		Song.run(dis);
		runSongs(dis, times-1);
	}
}
