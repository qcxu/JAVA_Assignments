package a3jedi;

public class ExtractedDNAStrand implements DNAStrand {

	private DNAStrand source_strand;
	private String name;
	private int start;
	private int end;
	
	public ExtractedDNAStrand(DNAStrand source_strand, int start, int end, String name) {
		if (source_strand != null && start >= 0 
				&& start < end && end < source_strand.getLength()) {
			this.source_strand = source_strand;
			this.name = name;
			this.start = start;
			this.end = end;
		} else {
			throw new RuntimeException("DNA Strand constructor illegal");
		}
	}

	public ExtractedDNAStrand(DNAStrand source_strand, int start, int end) {
		this(source_strand, start, end, "unnamed");
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = (name == null) ? "unnamed" : name;
	}

	public char getBaseAt(int idx) {
		if (idx >= 0 && idx <= end - start) {
			return this.source_strand.getBaseAt(idx + start);
		} else {
			throw new RuntimeException("Index not valid");
		}
	}

	public int getLength() {
		return end - start + 1;
	}

	public DNAStrand extract(int start, int end) {
		if (start < 0 || start > end 
				|| end >= this.getLength()) {
			throw new RuntimeException("Start/end index not valid");
		} else {
			return this.source_strand.extract(this.start, this.end)
					.extract(start, end);
		}
	}

	public DNAStrand join(DNAStrand tail) {
		if (tail != null) {
			return this.source_strand.extract(this.start, this.end)
					.join(tail);
		} else {
			throw new RuntimeException("tail is null");
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
