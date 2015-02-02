package a3novice;

public class Test {
	public static void main(String[] args) {
		char[] array = {'C', 'G', 'T', 'A', 'A'};
		DNAStrand dnas = new CharArrayDNAStrand(array);
		DNAStrand dd = new StringDNAStrand("CGTAP");
		System.out.println(dnas.getName());
		System.out.println(dnas.getBaseAt(10));
		System.out.println(dnas.getLength());
		System.out.println(dnas.extract(0, 3).getBaseAt(2));
		System.out.println(dd.join(dnas).getName());
	}
}
