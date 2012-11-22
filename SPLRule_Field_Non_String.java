import java.io.DataInputStream;
import java.io.IOException;

public class SPLRule_Field_Non_String {
	public static void run(DataInputStream dis) throws IOException{

		long fromValue = dis.readLong();
		Util.print("\t\t\t\t\tfrom value:\t"+Util.hexLong(fromValue)+"\n");

		long fromDate = dis.readLong();
		Util.print("\t\t\t\t\tfrom date:\t"+Util.hexLong(fromDate)+"\n");

		long fromUnits = dis.readLong();
		Util.print("\t\t\t\t\tfrom Units:\t"+Util.hexLong(fromUnits)+"\n");

		long toValue = dis.readLong();
		Util.print("\t\t\t\t\tto value:\t"+Util.hexLong(toValue)+"\n");

		long toDate = dis.readLong();
		Util.print("\t\t\t\t\tto date:\t"+Util.hexLong(toDate)+"\n");

		long toUnits = dis.readLong();
		Util.print("\t\t\t\t\tto units:\t"+Util.hexLong(toUnits)+"\n");

		byte[] unknown4 = new byte[20];
		dis.read(unknown4);
		Util.print("\t\t\t\t\tunknown4:\t");
		Util.printHexBytes(unknown4);
	}
}
