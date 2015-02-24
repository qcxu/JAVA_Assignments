package a3adept;


public class JoinedDNAStrand implements DNAStrand {

	private DNAStrand head;
	private DNAStrand tail;
	private String name;
	
	public JoinedDNAStrand(DNAStrand head, DNAStrand tail, String name) {
		if (head != null && tail != null) {
			this.head = head;
			this.tail = tail;
			this.name = name;
		} else {
			throw new RuntimeException("DNAStrand is null");
		}
	}

	public JoinedDNAStrand(DNAStrand head, DNAStrand tail) {
		this(head, tail, "unnamed");
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
		if (idx >= 0 && idx < this.head.getLength()) {
			return this.head.getBaseAt(idx);
		} else if (idx >= this.head.getLength() && idx < this.getLength()) {
			return this.tail.getBaseAt(idx - this.head.getLength());
		}
	else {
			throw new RuntimeException("Index not valid");
		}
	}

	@Override
	public int getLength() {
		return this.head.getLength() + this.tail.getLength();
	}

	@Override
	public DNAStrand extract(int start, int end) {
		if (start >= 0 && end < this.getLength() && end >= start) {
			DNAStrand extracted_joined = new ExtractedDNAStrand(this, 
					start, end);
			return extracted_joined;
		}
		else {
			throw new RuntimeException("Start/end index not valid");
		}
	}

	@Override
	public DNAStrand join(DNAStrand tail) {
		if (tail != null) {
			return new JoinedDNAStrand(this, tail);
			//return this.head.join(this.tail).join(tail);
		} else {
			throw new RuntimeException("tail is null");
		}
	}
	
	
}