package a3novice;

public class StringDNAStrand implements DNAStrand {

	private String bases;
	private String name;
	
	public StringDNAStrand(String base_string, String name) {
		if (base_string.matches("[CGTA]*")) {
			this.bases = base_string;
			this.name = name;
		} else {
			throw new RuntimeException("DNA Strand contains illegal base");
		}
		
	}

	public StringDNAStrand(String strand_string) {
		this(strand_string, "unnamed");
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = (name == null) ? "unnamed" : name;
	}

	public char getBaseAt(int idx) {
		if (idx >= 0 && idx < this.getLength()) {
			return this.bases.charAt(idx);
		} else {
			throw new RuntimeException("Index not valid");
		}
		
	}

	public int getLength() {
		return this.bases.length();
	}

	public DNAStrand extract(int start, int end) {
		if (start < 0 || start > end 
				|| end >= this.getLength()) {
			throw new RuntimeException("Start/end index not valid");
		} else {
			DNAStrand strand = new StringDNAStrand(this.bases.substring(start, end+1));
			return strand;
		}
		
	}

	public DNAStrand join(DNAStrand tail) {
		if (tail == null) {
			throw new RuntimeException("tail is null");
		} else {
			String bases = this.bases;
			for (int i=0; i<tail.getLength(); i++) {
				bases = bases + tail.getBaseAt(i);
			}
			DNAStrand strand = new StringDNAStrand(bases);
			return strand;
		}
		
	}
	
	
}
