import java.io.DataInputStream;
import java.io.IOException;

public class Column_Definition {
	public static void run(DataInputStream dis) throws IOException{

		Util.print("\t\t\t\t\tColumn Definition\n");

		int id = Util.readShort(dis);
		Util.print("\t\t\t\t\tid:\t\t"+Util.hexInt(id)+"\n");

		int width = Util.readShort(dis);
		Util.print("\t\t\t\t\twidth:\t\t"+width+"\n");

		long sortDirection = Util.readInt(dis);
		Util.print("\t\t\t\t\tsort direction:\t"+sortDirection+"\n");

		long unknown1 = Util.readInt(dis);
		Util.print("\t\t\t\t\tunknown1:\t"+unknown1+"\n");

		long unknown2 = Util.readInt(dis);
		Util.print("\t\t\t\t\tunknown2:\t"+unknown2+"\n");
	}
}
