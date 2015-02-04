package a3adept;

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
				|| start >= this.getLength()) {
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
	
	public int findSubstrand(DNAStrand substrand) {
		if (substrand != null) {
			
			for (int i=0; i<this.getLength(); i++) {
				boolean isMatched = true; 
				int j = 0;
				while (isMatched) {
					if (this.getBaseAt(i) == substrand.getBaseAt(j)) {
						if (j < substrand.getLength()-1) {
							j += 1;
							if (i < this.getLength()-1) {
								i += 1;
							} else {
								isMatched = false;
							}	
						} else {
							return i - substrand.getLength() + 1;
						}	
					} else {
						isMatched = false;
					}
				}	
			}
			return -1;
		} else {
			throw new RuntimeException("substrand is null");
		}
	}
	
	public int findSubstrand(DNAStrand substrand, int search_start_position) {
		if (substrand != null && search_start_position >= 0 
				&& search_start_position < this.getLength()) {
			
			for (int i=search_start_position; i<this.getLength(); i++) {
				boolean isMatched = true; 
				int j = 0;
				while (isMatched) {
					if (this.getBaseAt(i) == substrand.getBaseAt(j)) {
						if (j < substrand.getLength()-1) {
							j += 1;
							if (i < this.getLength()-1) {
								i += 1;
							} else {
								isMatched = false;
							}	
						} else {
							return i - substrand.getLength() + 1;
						}	
					} else {
						isMatched = false;
					}
				}	
			}
			return -1;
		} else {
			throw new RuntimeException("substrand is null or search start position illegal");
		}
	}
	
	
}
