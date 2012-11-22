import java.io.DataInputStream;
import java.io.IOException;

public class SPLRule_Format {
	public static void run(DataInputStream dis) throws IOException{

		int field = dis.readInt();
		Util.print("\t\t\t\t\tfield:\t\t"+Util.hexInt(field)+"\n");

		int action = dis.readInt();
		Util.print("\t\t\t\t\taction:\t\t"+Util.hexInt(action)+"\n");

		byte[] padding = new byte[44];
		dis.read(padding);
		Util.print("\t\t\t\t\tpadding:\t");
		Util.printHexBytes(padding);

		int length = dis.readInt();
		Util.print("\t\t\t\t\tlength:\t\t"+length+"\n");

		switch(SPLRule_FieldType_Map.correspondTo(field)) {
			case "Non-String": SPLRule_Field_Non_String.run(dis);
		}
	}
}
