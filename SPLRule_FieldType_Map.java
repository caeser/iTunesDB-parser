public class SPLRule_FieldType_Map {
	public static String correspondTo(int field) {
		String type = "";
		switch(field) {
			case SPLRule_FieldType.videoKind: type =  "Non-String";
		}
		return type;
	}
}
