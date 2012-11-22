import java.io.DataInputStream;
import java.io.IOException;

public class SmartPlaylistList {
	public static void run(DataInputStream dis) throws IOException{
		byte[] playlistList = new byte[4];
		dis.read(playlistList);
		Util.print("\t\tSmartPlaylistList\t"+new String(playlistList, "UTF-8")+"\n");

		long headLength = Util.readInt(dis);
		Util.print("\t\thead length:\t"+headLength+"\n");

		long playlistsQuantity = Util.readInt(dis);
		Util.print("\t\tPlaylists quantity:\t"+playlistsQuantity+"\n");

		byte[] remain = new byte[(int)(headLength-12)];
		dis.read(remain);
		Util.print("\t\tremain:\t\t");
		Util.printHexBytes(remain);

		runPlaylists(dis, playlistsQuantity);
	}

	public static void runPlaylists(DataInputStream dis, long times) throws IOException {
		if(times == 0) return;
		Playlist.run(dis);
		runPlaylists(dis, times-1);
	}
}
