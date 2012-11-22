import java.io.DataInputStream;
import java.io.IOException;

public class Util {


	//read number
	public static int readShort(DataInputStream dis) throws IOException {
		return unsignShortBE(dis.readShort());
	}

	public static long readInt(DataInputStream dis) throws IOException {
		return unsignIntBE(dis.readInt());
	}

	public static long readLong(DataInputStream dis) throws IOException {
		return longBE(dis.readLong());
	}

	public static float readFloat(DataInputStream dis) throws IOException {
		return floatBE(dis.readInt());
	}

	//reverse number
	public static int unsignShortBE(short shortLE) {
		return Short.reverseBytes(shortLE) & 0xFFFF;
	}

	public static long unsignIntBE(int intLE) {
		return Integer.reverseBytes(intLE) & 0xFFFFFFFFL;
	}

	public static long longBE(long longLE) {
		return Long.reverseBytes(longLE);
	}

	public static float floatBE(int intLE) {
		return Float.intBitsToFloat(Integer.reverseBytes(intLE));
	}

	//print normal string or Hex number;
	public static void printHexBytes(byte[] tokens) {
		for(byte token : reverse(tokens)) {
			print(String.format("%02X", token));
		}
		print("\n");
	}

	//reverse bytes
	public static byte[] reverse(byte[] array) {
		int half = array.length / 2;
		for(int i = 0;i < half;i++) {
			array[i] ^= array[array.length - i - 1];
			array[array.length - i-1] ^= array[i];
			array[i] ^= array[array.length - i - 1];
		}
		return array;
	}

	//print number -> hex
	public static String hexInt(int number) {
		return Integer.toHexString(number).toUpperCase();
	}

	public static String hexLong(long number) {
		return Long.toHexString(number).toUpperCase();
	}

	//more easy to print
	public static void print(String str) {
		System.out.print(str);
	}

	//1904,1908...1968: 17 leap years
	public static int MacToUnixTime(int seconds) {
		return seconds-((1970-1904)*365+17)*86400;
	}
}
