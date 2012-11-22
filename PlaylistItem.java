import java.util.Date;
import java.io.DataInputStream;
import java.io.IOException;

public class PlaylistItem {
	public static void run(DataInputStream dis) throws IOException{
		byte[] info = new byte[4];
		dis.read(info);
		Util.print("\t\t\t\tPlaylistItem\t"+new String(info, "UTF-8")+"\n");

		long headLength = Util.readInt(dis);
		Util.print("\t\t\t\thead length:\t"+headLength+"\n");

		long length = Util.readInt(dis);
		Util.print("\t\t\t\tlength:\t\t"+length+"\n");

		long infosQuantity = Util.readInt(dis);
		Util.print("\t\t\t\tinfos quantity:\t"+infosQuantity+"\n");

		int podcastGroupingFlag = Util.readShort(dis);
		Util.print("\t\t\t\tpodcast grouping flag:\t"+podcastGroupingFlag+"\n");

		byte unknown1 = dis.readByte();
		Util.print("\t\t\t\tunknown1:\t"+unknown1+"\n");

		byte unknown2 = dis.readByte();
		Util.print("\t\t\t\tunknown2:\t"+unknown2+"\n");

		long groupId = Util.readInt(dis);
		Util.print("\t\t\t\tgroup id:\t"+Util.hexLong(groupId)+"\n");

		long songId = Util.readInt(dis);
		Util.print("\t\t\t\tsong id:\t"+Util.hexLong(songId)+"\n");

		long dateAdded = Util.MacToUnixTime((int) Util.readInt(dis))*1000L;
		Util.print("\t\t\t\tdate added:\t"+new Date(dateAdded)+"\n");

		long podcast_Grouping_Reference = Util.readInt(dis);
		Util.print("\t\t\t\tpodcast grouping reference:\t"+Util.hexLong(podcast_Grouping_Reference)+"\n");

		long unknown3 = Util.readInt(dis);
		Util.print("\t\t\t\tunknown3:\t"+unknown3+"\n");

		long unknown4 = Util.readInt(dis);
		Util.print("\t\t\t\tunknown4:\t"+unknown4+"\n");

		long unknown5 = Util.readLong(dis);
		Util.print("\t\t\t\tunknown5:\t"+Util.hexLong(unknown5)+"\n");

		byte[] remain = new byte[(int) headLength - 52];
		dis.read(remain);
		Util.print("\t\t\t\tremain:\t\t");
		Util.printHexBytes(remain);

		runInfos(dis, infosQuantity);
	}

	public static void runInfos(DataInputStream dis, long times) throws IOException {
		if(times == 0) return;
		Info_Playlist_Order_Entry_indent.run(dis);
		runInfos(dis, times-1);
	}
}
