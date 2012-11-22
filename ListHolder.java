import java.io.DataInputStream;
import java.io.IOException;

public class ListHolder {
	public byte[] listHolder = new byte[4];
	public long headLength;
	public long length;
	public long type;
	public byte[] remain;

	public void run(DataInputStream dis) throws IOException{
		dis.read(this.listHolder);
		Util.print("\tListHolder\t"+new String(this.listHolder, "UTF-8")+"\n");

		this.headLength = Util.readInt(dis);
		Util.print("\thead length:\t"+this.headLength+"\n");

		this.length = Util.readInt(dis);
		Util.print("\tlength:\t\t"+this.length+"\n");

		this.type = Util.readInt(dis);
		Util.print("\ttype:\t\t"+this.type+"\n");

		this.remain = new byte[(int)(headLength-16)];
		dis.read(this.remain);
		Util.print("\tremain:\t\t");
		Util.printHexBytes(this.remain);

		switch((int) this.type) {
			case ListHolderType.Album_List: AlbumList.run(dis);break;
			case ListHolderType.Song_List: SongList.run(dis);break;
			case ListHolderType.Podcast_List: PodcastList.run(dis);break;
			case ListHolderType.Playlist_List: PlaylistList.run(dis);break;
			case ListHolderType.SmartPlaylist_List: SmartPlaylistList.run(dis);break;
		}
	}
}
