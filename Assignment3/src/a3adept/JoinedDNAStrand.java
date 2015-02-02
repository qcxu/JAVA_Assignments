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
		if (idx >= 0 && idx < this.head.getLength()) {
			return this.head.getBaseAt(idx);
		} else if (idx >= this.head.getLength() && idx < this.getLength()) {
			return this.tail.getBaseAt(idx-this.head.getLength());
		} else {
			throw new RuntimeException("Index not valid");
		}
	}

	public int getLength() {
		return this.head.getLength() + this.tail.getLength();
	}

	public DNAStrand extract(int start, int end) {
		if (start >= 0 && end < this.head.getLength() 
				&& end >= start && end < this.head.getLength()) {
			return this.head.extract(start, end);
		} else if (start >= 0 && start <= this.head.getLength()
				&& end > this.head.getLength() && end < this.getLength()) {
			return this.head.extract(start, this.head.getLength()-1)
					.join(tail.extract(0, end - this.head.getLength()));
		} else if (start >= this.head.getLength() && end >= start 
				&& end < this.getLength()) {
			return this.tail.extract(start - this.head.getLength(), end - this.head.getLength());
		}
		else {
			throw new RuntimeException("Start/end index not valid");
		}
	}

	public DNAStrand join(DNAStrand tail) {
		if (tail != null) {
			return this.head.join(this.tail).join(tail);
		} else {
			throw new RuntimeException("tail is null");
		}
	}
}