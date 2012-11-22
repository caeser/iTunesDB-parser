import java.util.Date;
import java.io.DataInputStream;
import java.io.IOException;

public class Playlist {
	public static void run(DataInputStream dis) throws IOException{
		byte[] playlist = new byte[4];
		dis.read(playlist);
		Util.print("\t\t\tPlaylist\t"+new String(playlist, "UTF-8")+"\n");

		long headLength = Util.readInt(dis);
		Util.print("\t\t\thead length:\t"+headLength+"\n");

		long length = Util.readInt(dis);
		Util.print("\t\t\tlength:\t\t"+length+"\n");

		long infos_Before_PlaylistItem_Quantity = Util.readInt(dis);
		Util.print("\t\t\tInfos before PlayListItem quantity:\t"+infos_Before_PlaylistItem_Quantity+"\n");

		long playlistItemsQuantity = Util.readInt(dis);
		Util.print("\t\t\tPlayListItems quantity:\t"+playlistItemsQuantity+"\n");

		byte isMaster = dis.readByte();
		Util.print("\t\t\tis master list?\t"+isMaster+"\n");

		byte[] unknown1 = new byte[3];
		dis.read(unknown1);
		Util.print("\t\t\tunknown1:\t");
		Util.printHexBytes(unknown1);

		long dateCreated = Util.MacToUnixTime((int) Util.readInt(dis))*1000L;
		Util.print("\t\t\tdate created:\t"+new Date(dateCreated)+"\n");

		long persistentPlaylistID = Util.readLong(dis);
		Util.print("\t\t\t永久 id:\t\t"+Util.hexLong(persistentPlaylistID)+"\n");

		long unknown2 = Util.readInt(dis);
		Util.print("\t\t\tunknown2:\t"+unknown2+"\n");

		int infosQuantity = Util.readShort(dis);
		Util.print("\t\t\tInfos (type<50) quantity:\t"+infosQuantity+"\n");

		byte podcastFlag = dis.readByte();
		Util.print("\t\t\tpodcast flag:\t\t"+podcastFlag+"\n");

		byte GroupFlag = dis.readByte();
		Util.print("\t\t\tgroup flag:\t\t"+GroupFlag+"\n");

		long ListSortOrder = Util.readInt(dis);
		Util.print("\t\t\tlist sort order:\t"+ListSortOrder+"\n");

		byte[] remain = new byte[(int) headLength - 48];
		dis.read(remain);
		Util.print("\t\t\tremain:\t\t");
		Util.printHexBytes(remain);

		run_Infos_Before_PlaylistItem(dis, infos_Before_PlaylistItem_Quantity);
		runPlaylistItems(dis, playlistItemsQuantity);
	}

	public static void run_Infos_Before_PlaylistItem(DataInputStream dis, long times) throws IOException {
		if(times == 0) return;
		Info.run(dis);
		Util.print("\n");
		run_Infos_Before_PlaylistItem(dis, times-1);
	}

	public static void runPlaylistItems(DataInputStream dis, long times) throws IOException {
		if(times == 0) return;
		PlaylistItem.run(dis);
		runPlaylistItems(dis, times-1);
	}
}
