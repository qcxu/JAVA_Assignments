package a3adept;

public class ExtractedDNAStrand implements DNAStrand {

	private DNAStrand source_strand;
	private String name;
	private int start;
	private int end;
	
	public ExtractedDNAStrand(DNAStrand source_strand, int start, int end, String name) {
		if (source_strand != null && start >= 0 
				&& start <= end && end < source_strand.getLength()) {
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
		if (idx >= 0 && idx < this.end - this.start + 1) {
			return this.source_strand.getBaseAt(this.start + idx);
		} else {
			throw new RuntimeException("Index not valid");
		}
	}

	@Override
	public int getLength() {
		return this.end - this.start + 1;
	}

	@Override
	public DNAStrand extract(int start, int end) {
		if (start >= 0 && start <= end 
				&& end < this.getLength()) {
			return new ExtractedDNAStrand(this, start, end);
		} else {
			throw new RuntimeException("Start/end index not valid");	
		}
	}

	@Override
	public DNAStrand join(DNAStrand tail) {
		if (tail != null) {
			return new JoinedDNAStrand(this, tail);
		} else {
			throw new RuntimeException("tail is null");
		}
	}
	

	
}
