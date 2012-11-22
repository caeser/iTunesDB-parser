import java.util.Date;
import java.io.DataInputStream;
import java.io.IOException;

public class Song {
	public static void run(DataInputStream dis) throws IOException{
		byte[] song = new byte[4];
		dis.read(song);
		Util.print("\t\t\tSong\t\t"+new String(song, "UTF-8")+"\n");

		long headLength = Util.readInt(dis);
		Util.print("\t\t\thead length:\t"+headLength+"\n");

		long length = Util.readInt(dis);
		Util.print("\t\t\tlength:\t\t"+length+"\n");

		long infosQuantity = Util.readInt(dis);
		Util.print("\t\t\tInfos quantity:\t"+infosQuantity+"\n");

		long songId = Util.readInt(dis);
		Util.print("\t\t\tsongId:\t\t"+Util.hexLong(songId)+"\n");

		long visible = Util.readInt(dis);
		Util.print("\t\t\tvisible:\t"+visible+"\n");

		byte[] fileType1 = new byte[4];
		dis.read(fileType1);
		Util.print("\t\t\tfile type1:\t"+new String(Util.reverse(fileType1), "UTF-8")+"\n");

		byte type1 = dis.readByte();
		Util.print("\t\t\ttype1:\t\t"+type1+"\n");

		byte type2 = dis.readByte();
		Util.print("\t\t\ttype2:\t\t"+type2+"\n");

		byte compilationFlag = dis.readByte();
		Util.print("\t\t\tcompilationFlag:"+compilationFlag+"\n");

		byte stars = dis.readByte();
		Util.print("\t\t\tstars:\t\t"+stars+"\n");

		long lastModified = Util.MacToUnixTime((int) Util.readInt(dis))*1000L;
		Util.print("\t\t\tlast modified:\t"+new Date(lastModified)+"\n");

		long size = Util.readInt(dis);
		Util.print("\t\t\tsize:\t\t"+size+"\n");

		long musicLength = Util.readInt(dis);
		Util.print("\t\t\tmusic length:\t"+musicLength+"\n");

		long no = Util.readInt(dis);
		Util.print("\t\t\tno.\t\t"+no+"\n");

		long songsQuantity = Util.readInt(dis);
		Util.print("\t\t\tsongs quantity:\t"+songsQuantity+"\n");

		long year = Util.readInt(dis);
		Util.print("\t\t\tyear:\t\t"+year+"\n");

		long bitrate = Util.readInt(dis);
		Util.print("\t\t\tbitrate:\t"+bitrate+"\n");

		long sampleRate1 = Util.readInt(dis)/0x10000L;
		Util.print("\t\t\tsample rate1:\t"+sampleRate1+"\n");

		long volume = Util.readInt(dis);
		Util.print("\t\t\tvolume:\t\t"+volume+"\n");

		long startTime = Util.readInt(dis);
		Util.print("\t\t\tstart time:\t"+startTime+"\n");

		long stopTime = Util.readInt(dis);
		Util.print("\t\t\tstop time:\t"+stopTime+"\n");

		long soundCheck = Util.readInt(dis);
		Util.print("\t\t\tsound check:\t"+soundCheck+"\n");

		long playCount1 = Util.readInt(dis);
		Util.print("\t\t\tplay count1:\t"+playCount1+"\n");

		long playCount2 = Util.readInt(dis);
		Util.print("\t\t\tplay count2:\t"+playCount2+"\n");

		long lastPlayed = Util.readInt(dis);
		Util.print("\t\t\tlast played:\t"+lastPlayed+"\n");

		long discNumber = Util.readInt(dis);
		Util.print("\t\t\tdisc number:\t"+discNumber+"\n");

		long totalDiscs = Util.readInt(dis);
		Util.print("\t\t\ttotal discs:\t"+totalDiscs+"\n");

		long userId = Util.readInt(dis);
		Util.print("\t\t\tuser id:\t"+userId+"\n");

		long dateAdded = Util.MacToUnixTime((int) Util.readInt(dis))*1000L;
		Util.print("\t\t\tdate added:\t"+new Date(dateAdded)+"\n");

		long bookmarkTime = Util.readInt(dis);
		Util.print("\t\t\tbookmark time:\t"+bookmarkTime+"\n");

		long databaseId1 = dis.readLong();
		Util.print("\t\t\tdatabase id1:\t"+Util.hexLong(databaseId1)+"\n");

		byte checked = dis.readByte();
		Util.print("\t\t\tchecked:\t"+checked+"\n");

		byte adoptionRating = dis.readByte();
		Util.print("\t\t\tadoption rating:"+adoptionRating+"\n");

		int BPM = Util.readShort(dis);
		Util.print("\t\t\tBPM:\t\t"+BPM+"\n");

		int artworkCount = Util.readShort(dis);
		Util.print("\t\t\tartwork count:\t"+artworkCount+"\n");

		byte[] unknown1 = new byte[2];
		dis.read(unknown1);
		Util.print("\t\t\tunknown1:\t");
		Util.printHexBytes(unknown1);

		long artworkSize = dis.readInt();
		Util.print("\t\t\tartwork size:\t"+artworkSize+"\n");

		long unknown2 = Util.readInt(dis);
		Util.print("\t\t\tunknown2:\t"+unknown2+"\n");

		float sampleRate2 = Util.readFloat(dis);
		Util.print("\t\t\tsample rate2:\t"+sampleRate2+"\n");

		long dateReleased = Util.readInt(dis);
		Util.print("\t\t\tdate released:\t"+dateReleased+"\n");

		byte[] fileType2 = new byte[2];
		dis.read(fileType2);
		Util.print("\t\t\tfile type2:\t");
		Util.printHexBytes(fileType2);

		int explicitFlag = Util.readShort(dis);
		Util.print("\t\t\texplicit flag:\t"+explicitFlag+"\n");

		long DRM = Util.readInt(dis);
		Util.print("\t\t\tDRM:\t\t"+DRM+"\n");

		long unknown3 = Util.readInt(dis);
		Util.print("\t\t\tunknown3:\t"+unknown3+"\n");

		long skipCount = Util.readInt(dis);
		Util.print("\t\t\tskip count:\t"+skipCount+"\n");

		long lastSkipped = Util.readInt(dis);
		Util.print("\t\t\tlast skipped:\t"+lastSkipped+"\n");

		byte hasArtwork = dis.readByte();
		Util.print("\t\t\thas artwork?\t"+hasArtwork+"\n");

		byte skip = dis.readByte();
		Util.print("\t\t\tskip?\t\t"+skip+"\n");

		byte playback = dis.readByte();
		Util.print("\t\t\tplayback?\t"+playback+"\n");

		byte podcastFlag = dis.readByte();
		Util.print("\t\t\tpodcast flag:\t"+podcastFlag+"\n");

		long databaseId2 = dis.readLong();
		Util.print("\t\t\tdatabase id2:\t"+Util.hexLong(databaseId2)+"\n");

		byte lyricsFlag = dis.readByte();
		Util.print("\t\t\tlyrics flag:\t"+lyricsFlag+"\n");

		byte movieFileFlag = dis.readByte();
		Util.print("\t\t\tmovie file flag:"+movieFileFlag+"\n");

		byte playedMark = dis.readByte();
		Util.print("\t\t\tplayed mark:\t"+playedMark+"\n");

		byte unknown4 = dis.readByte();
		Util.print("\t\t\tunknown4:\t"+unknown4+"\n");

		long unknown5 = Util.readInt(dis);
		Util.print("\t\t\tunknown5:\t"+unknown5+"\n");

		long pregap = Util.readInt(dis);
		Util.print("\t\t\tpregap:\t\t"+pregap+"\n");

		long sampleCount = Util.readLong(dis);
		Util.print("\t\t\tsample count:\t"+sampleCount+"\n");

		long unknown6 = Util.readInt(dis);
		Util.print("\t\t\tunknown6:\t"+unknown6+"\n");

		long postgap = Util.readInt(dis);
		Util.print("\t\t\tpostgap:\t"+postgap+"\n");

		long unknown7 = Util.readInt(dis);
		Util.print("\t\t\tunknown7:\t"+unknown7+"\n");

		long mediaType = Util.readInt(dis);
		Util.print("\t\t\tmedia type:\t"+Util.hexLong(mediaType)+"\n");

		long seasonNumber = Util.readInt(dis);
		Util.print("\t\t\tseason number:\t"+seasonNumber+"\n");

		long episodeNumber = Util.readInt(dis);
		Util.print("\t\t\tepisode number:\t"+episodeNumber+"\n");

		long protectedFile = Util.readInt(dis);
		Util.print("\t\t\tprotected file:\t"+protectedFile+"\n");

		long unknown8 = Util.readInt(dis);
		Util.print("\t\t\tunknown8:\t"+unknown8+"\n");

		long unknown9 = Util.readInt(dis);
		Util.print("\t\t\tunknown9:\t"+unknown9+"\n");

		long unknown10 = Util.readInt(dis);
		Util.print("\t\t\tunknown10:\t"+unknown10+"\n");

		long unknown11 = Util.readInt(dis);
		Util.print("\t\t\tunknown11:\t"+unknown11+"\n");

		long unknown12 = Util.readInt(dis);
		Util.print("\t\t\tunknown12:\t"+unknown12+"\n");

		long unknown13 = Util.readInt(dis);
		Util.print("\t\t\tunknown13:\t"+unknown13+"\n");

		long gaplessData = Util.readInt(dis);
		Util.print("\t\t\tgaplessData:\t"+gaplessData+"\n");

		long unknown14 = Util.readInt(dis);
		Util.print("\t\t\tunknown14:\t"+unknown14+"\n");

		long gaplessSong = Util.readShort(dis);
		Util.print("\t\t\tgapless song:\t"+gaplessSong+"\n");

		long gaplessAlbum = Util.readShort(dis);
		Util.print("\t\t\tgapless album:\t"+gaplessAlbum+"\n");

		byte[] unknown15 = new byte[20];
		dis.read(unknown15);
		Util.print("\t\t\tunknown15:\t");
		Util.printHexBytes(unknown15);

		long unknown16 = Util.readInt(dis);
		Util.print("\t\t\tunknown16:\t"+unknown16+"\n");

		long unknown17 = Util.readInt(dis);
		Util.print("\t\t\tunknown17:\t"+unknown17+"\n");

		long unknown18 = Util.readInt(dis);
		Util.print("\t\t\t#unknown18:\t"+Util.hexLong(unknown18)+"\n");

		long unknown19 = Util.readInt(dis);
		Util.print("\t\t\tunknown19:\t"+unknown19+"\n");

		long unknown20 = Util.readShort(dis);
		Util.print("\t\t\tunknown20:\t"+unknown20+"\n");

		long albumId = Util.readShort(dis);
		Util.print("\t\t\talbum id:\t"+albumId+"\n");

		byte[] unknown21 = new byte[52];
		dis.read(unknown21);
		Util.print("\t\t\tunknown21:\t");
		Util.printHexBytes(unknown21);

		long artistLink = Util.readInt(dis);
		Util.print("\t\t\tartist link:\t"+artistLink+"\n");

		byte[] unknown22 = new byte[124];
		dis.read(unknown22);
		Util.print("\t\t\tunknown22:\t");
		Util.printHexBytes(unknown22);

		long artistId = Util.readInt(dis);
		Util.print("\t\t\tartist id:\t"+Util.hexLong(artistId)+"\n");

		byte[] unknown23 = new byte[16];
		dis.read(unknown23);
		Util.print("\t\t\tunknown23:\t");
		Util.printHexBytes(unknown23);

		long specialId = Util.readInt(dis);
		Util.print("\t\t\tspecial id:\t"+Util.hexLong(specialId)+"\n");

		byte[] remain = new byte[(int) headLength - 504];
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
