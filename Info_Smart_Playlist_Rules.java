import java.io.DataInputStream;
import java.io.IOException;

public class Info_Smart_Playlist_Rules {
	public static void run(DataInputStream dis, long length) throws IOException{
		byte[] smart_List_Rules_Identifier = new byte[4];
		dis.read(smart_List_Rules_Identifier);
		Util.print("\t\t\t\tsmart list rules identifier:\t"+new String(smart_List_Rules_Identifier, "UTF-8")+"\n");

		int unknown3 = dis.readInt();
		Util.print("\t\t\t\tunknown3:\t"+unknown3+"\n");

		int rulesQuantity = dis.readInt();
		Util.print("\t\t\t\trules quantity:\t"+rulesQuantity+"\n");

		int rulesOperator = dis.readInt();
		Util.print("\t\t\t\trules operator:\t"+rulesOperator+"\n");

		byte[] padding = new byte[120];
		dis.read(padding);
		Util.print("\t\t\t\tpadding:\t");
		Util.printHexBytes(padding);

		runSPLRule_Formats(dis, rulesQuantity);
	}

	public static void runSPLRule_Formats(DataInputStream dis, long times) throws IOException {
		if(times == 0) return;
		SPLRule_Format.run(dis);
		if(times != 1) Util.print("\n");
		runSPLRule_Formats(dis, times-1);
	}
}
