package a3novice;

public class StringDNAStrand implements DNAStrand {

	private String bases;
	private String name;
	
	public StringDNAStrand(String base_string, String name) {
		if (base_string.matches("[CGTA]*")) {
			this.bases = base_string;
			if (name != null) {
				this.name = name;
			} else {
				this.name = "unnamed";
			}
			
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
			DNAStrand strand = new StringDNAStrand(this.bases.substring(start, end+1));
			return strand;
		} else {
			throw new RuntimeException("Start/end index not valid");
		}
		
		
	}

	@Override
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
