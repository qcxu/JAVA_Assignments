package a3adept;

public class StringDNAStrand implements DNAStrand {

	private String bases;
	private String name;
	
	public StringDNAStrand(String base_string, String name) {
		if (base_string != null && base_string.matches("[CGTA]*")) {
			this.bases = base_string;
			this.name = name;
		} else {
			throw new RuntimeException("DNA Strand contains illegal base");
		}
		
	}

	public StringDNAStrand(String strand_string) {
		this(strand_string, "unnamed");
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = (name == null) ? "unnamed" : name;
	}

	@Override
	public char getBaseAt(int idx) {
		if (idx >= 0 && idx < this.getLength()) {
			return this.bases.charAt(idx);
		} else {
			throw new RuntimeException("Index not valid");
		}
		
	}

	@Override
	public int getLength() {
		return this.bases.length();
	}

	@Override
	public DNAStrand extract(int start, int end) {
		if (start >= 0 && start <= end 
				&& end < this.getLength()) {
			DNAStrand extracted_strand = new ExtractedDNAStrand(this, start, end);
			return extracted_strand;
		} else {
			throw new RuntimeException("Start/end index not valid");
		}
		
	}

	@Override
	public DNAStrand join(DNAStrand tail) {
		if (tail == null) {
			throw new RuntimeException("tail is null");
		} else {
			DNAStrand joined_strand = new JoinedDNAStrand(this, tail);
			return joined_strand;
		}
		
	}
	
	
	
}
