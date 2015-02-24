package a3jedi;

public class Test {
	public static void main(String[] args) {
		char[] array = {'C', 'G', 'T', 'A', 'A'};
		DNAStrand dnas = new CharArrayDNAStrand(array);
		DNAStrand dd = new StringDNAStrand("CGTAATATT", "hi");
		DNAStrand ddd = new StringDNAStrand("AATAT", "ppp");
		DNAStrand joind = new JoinedDNAStrand(dnas, dd, "hello");
		DNAStrand joinagain = new JoinedDNAStrand(joind, ddd);
		DNAStrand extra = new ExtractedDNAStrand(dnas, 1, 3, "pp");
//		//pp
//		System.out.println(extra.getName());
//		//A
//		System.out.println(extra.getBaseAt(2));
//		//3
//		System.out.println(extra.getLength());
//		//T
//		System.out.println(extra.extract(0, 1).getBaseAt(1));
//		//GTACGTAA
//		System.out.println(extra.join(dnas).getBaseAt(5));
//		//7
//		System.out.println(joind.findSubstrand(ddd));
		System.out.println(joinagain.getBaseAt(18));
		
	}
}
