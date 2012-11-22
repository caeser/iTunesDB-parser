import java.io.DataInputStream;
import java.io.IOException;

public class Info_Playlist_Column_Definition {
	public static void run(DataInputStream dis, long length) throws IOException{

		long unknown3 = Util.readInt(dis);
		Util.print("\t\t\t\tunknown3:\t"+unknown3+"\n");

		long unknown4 = Util.readLong(dis);
		Util.print("\t\t\t\tunknown4:\t"+unknown4+"\n");

		long unknown5 = Util.readInt(dis);
		Util.print("\t\t\t\tunknown5:\t"+unknown5+"\n");

		int unknown6 = Util.readShort(dis);
		Util.print("\t\t\t\tunknown6:\t"+unknown6+"\n");

		int unknown7 = Util.readShort(dis);
		Util.print("\t\t\t\tunknown7:\t"+unknown7+"\n");

		long sortType = Util.readInt(dis);
		Util.print("\t\t\t\tsort type:\t"+sortType+"\n");

		long columnsQuantity = Util.readInt(dis);
		Util.print("\t\t\t\tcolumns Quantity:\t"+columnsQuantity+"\n");

		int unknown8 = Util.readShort(dis);
		Util.print("\t\t\t\tunknown8:\t"+unknown8+"\n");

		int unknown9 = Util.readShort(dis);
		Util.print("\t\t\t\tunknown9:\t"+unknown9+"\n");

		runColumn_Definitions(dis, columnsQuantity);

		long columnSize = 16;
		byte[] remain = new byte[(int)(length - 56L - columnsQuantity * columnSize)];
		dis.read(remain);
		Util.print("\t\t\t\tremain:\t\t");
		Util.printHexBytes(remain);
	}

	public static void runColumn_Definitions(DataInputStream dis, long times) throws IOException {
		if(times == 0) return;
		Column_Definition.run(dis);
		if(times != 1) Util.print("\n");
		runColumn_Definitions(dis, times-1);
	}
}
