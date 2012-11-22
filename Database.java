import java.util.ArrayList;
import java.io.DataInputStream;
import java.io.IOException;

public class Database {
	public static ArrayList<ListHolder> ListHolders = new ArrayList<ListHolder>();
	public static void run(DataInputStream dis) throws IOException {
		byte[] database = new byte[4];
		dis.read(database);
		Util.print("Database\t"+new String(database, "UTF-8")+"\n");

		long headLength = Util.readInt(dis);
		Util.print("head length:\t"+headLength+"\n");

		long length = Util.readInt(dis);
		Util.print("length:\t\t"+length+"\n");

		long unknown1 = Util.readInt(dis);
		Util.print("unknown1:\t"+unknown1+"\n");

		long Version = Util.readInt(dis);
		Util.print("unknown1:\t"+Version+"\n");

		long listHoldersQuantity = Util.readInt(dis);
		Util.print("ListHolders quantity:\t"+listHoldersQuantity+"\n");

		long id = Util.readLong(dis);
		Util.print("id:\t\t"+Util.hexLong(id)+"\n");

		int unknown2 = Util.readShort(dis);
		Util.print("unknown2:\t"+unknown2+"\n");

		byte[] unknown3 = new byte[4];
		dis.read(unknown3);
		Util.print("unknown3:\t");
		Util.printHexBytes(unknown3);

		byte[] unknown4 = new byte[10];
		dis.read(unknown4);
		Util.print("unknown4:\t");
		Util.printHexBytes(unknown4);

		int hash = Util.readShort(dis);
		Util.print("hash:\t\t"+hash+"\n");

		byte[] unknown5 = new byte[20];
		dis.read(unknown5);
		Util.print("unknown5:\t");
		Util.printHexBytes(unknown5);

		byte[] language = new byte[2];
		dis.read(language);
		Util.print("language:\t"+new String(language, "UTF-8")+"\n");

		long libraryPersistentId = Util.readLong(dis);
		Util.print("library永久Id:\t"+Util.hexLong(libraryPersistentId)+"\n");

		long unknown6 = Util.readInt(dis);
		Util.print("unknown6:\t"+unknown6+"\n");

		long unknown7 = Util.readInt(dis);
		Util.print("unknown7:\t"+unknown7+"\n");

		byte[] obscureHash = new byte[20];
		dis.read(obscureHash);
		Util.print("obscure hash:\t");
		Util.printHexBytes(obscureHash);

		long timeZone = Util.readInt(dis);
		Util.print("time zone:\t"+timeZone+"\n");

		int unknown8 = Util.readShort(dis);
		Util.print("unknown8:\t"+unknown8+"\n");

		byte[] iPhoneHash = new byte[46];
		dis.read(iPhoneHash);
		Util.print("iPhone hash:\t");
		Util.printHexBytes(iPhoneHash);

		byte[] remain = new byte[(int)(headLength-160)];
		dis.read(remain);
		Util.print("remain:\t\t");
		Util.printHexBytes(remain);

		runListHolders(dis, (int) listHoldersQuantity);
	}

	public static void runListHolders(DataInputStream dis, int times) throws IOException {
		if(times == 0) return;
		ListHolders.add(new ListHolder());
		ListHolders.get(ListHolders.size()-1).run(dis);
		runListHolders(dis, times-1);
	}

	//public static void write(DataInputStream dis) throws IOException {
}
