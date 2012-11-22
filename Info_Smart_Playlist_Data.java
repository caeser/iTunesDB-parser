import java.io.DataInputStream;
import java.io.IOException;

public class Info_Smart_Playlist_Data {
	public static void run(DataInputStream dis, long length) throws IOException{

		byte liveUpdate = dis.readByte();
		Util.print("\t\t\t\tlive update?\t"+liveUpdate+"\n");

		byte checkRules = dis.readByte();
		Util.print("\t\t\t\tcheck rules?\t"+checkRules+"\n");

		byte checkLimit = dis.readByte();
		Util.print("\t\t\t\tcheck limit?\t"+checkLimit+"\n");

		byte limitType = dis.readByte();
		Util.print("\t\t\t\tlimit type:\t"+limitType+"\n");

		byte limitSort = dis.readByte();
		Util.print("\t\t\t\tlimit sort:\t"+limitSort+"\n");

		byte[] unknown3 = new byte[3];
		dis.read(unknown3);
		Util.print("\t\t\t\tunknown3:\t");
		Util.printHexBytes(unknown3);

		long limitValue = Util.readInt(dis);
		Util.print("\t\t\t\tlimit value:\t"+limitValue+"\n");

		byte match_Check_Only = dis.readByte();
		Util.print("\t\t\t\tmatch check only:\t"+match_Check_Only+"\n");

		byte reverse_Limit_Sort = dis.readByte();
		Util.print("\t\t\t\treverse limit sort:\t"+reverse_Limit_Sort+"\n");

		byte[] remain = new byte[(int) length - 38];
		dis.read(remain);
		Util.print("\t\t\t\tremain:\t\t");
		Util.printHexBytes(remain);
	}
}
