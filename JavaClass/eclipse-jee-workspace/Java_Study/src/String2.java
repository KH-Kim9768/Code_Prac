
public class String2 {

	public static void main(String[] args) {
		StringBuilder strbuf = new StringBuilder("123");
		System.out.println(strbuf.append(45678));
		System.out.println(strbuf.delete(0, 2));
		System.out.println(strbuf.insert(2, "AB"));
		System.out.println(strbuf.reverse());
		System.out.println(strbuf.substring(4,6));
		System.out.println(strbuf.replace(0, 4, "FEDC"));

	}

}
