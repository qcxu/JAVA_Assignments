package a3jedi;

public class Test {
	public static void main(String[] args) {
		char[] array = {'C', 'G', 'T', 'A', 'A'};
		DNAStrand dnas = new CharArrayDNAStrand(array);
		DNAStrand dd = new StringDNAStrand("CGTAATATT", "hi");
		DNAStrand ddd = new StringDNAStrand("TAATATT", "ppp");
		DNAStrand joind = new JoinedDNAStrand(dnas, dd, "hello");
		DNAStrand extra = new ExtractedDNAStrand(dnas, 1, 3, "pp");
//		System.out.println(extra.getName());
//		System.out.println(extra.getBaseAt(2));
//		System.out.println(extra.getLength());
//		System.out.println(extra.extract(0, 1).getBaseAt(1));
//		System.out.println(extra.join(dnas).getBaseAt(5));
		System.out.println(dd.findSubstrand(ddd, 2));
		
	}
}
