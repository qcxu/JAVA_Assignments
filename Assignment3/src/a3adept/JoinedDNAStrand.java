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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = (name == null) ? "unnamed" : name;
	}

	public char getBaseAt(int idx) {
		if (idx >= 0 && idx < this.getLength()) {
			return this.head.join(this.tail).getBaseAt(idx);
		} else {
			throw new RuntimeException("Index not valid");
		}
	}

	public int getLength() {
		return this.head.join(this.tail).getLength();
	}

	public DNAStrand extract(int start, int end) {
		if (start >= 0 && end < this.getLength() && end >= start) {
			DNAStrand extracted_joined = new ExtractedDNAStrand(this.head.join(this.tail), 
					start, end);
			return extracted_joined;
		}
		else {
			throw new RuntimeException("Start/end index not valid");
		}
	}

	public DNAStrand join(DNAStrand tail) {
		if (tail != null) {
			return new JoinedDNAStrand(this.head.join(this.tail), tail);
			//return this.head.join(this.tail).join(tail);
		} else {
			throw new RuntimeException("tail is null");
		}
	}
	
	
}