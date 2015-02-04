package a3adept;

import java.util.Arrays;

public class CharArrayDNAStrand implements DNAStrand {

	private char[] bases;
	private String name;
	
	public CharArrayDNAStrand(char[] base_array, String name) {
		if (isBase(base_array)) {
			this.bases = base_array;
			this.name = name;
		} else {
			throw new RuntimeException("DNA Strand contains illegal base");
		}
			
	}
	
	public CharArrayDNAStrand(char[] base_array) {
		this(base_array, "unnamed");
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = (name == null) ? "unnamed" : name;
	}

	public char getBaseAt(int idx) {
		if (idx >= 0 && idx < this.getLength()) {
			return this.bases[idx];
		} else {
			throw new RuntimeException("Index not valid");
		}
		
	}

	public int getLength() {
		return this.bases.length;
	}

	public DNAStrand extract(int start, int end) {
		if (start < 0 || start > end 
				|| start >= this.getLength()) {
			throw new RuntimeException("Start/end index not valid");
		} else {
			char[] bases = Arrays.copyOfRange(this.bases, start, end+1);
			DNAStrand strand = new CharArrayDNAStrand(bases);
			return strand;
		}
	}

	public DNAStrand join(DNAStrand tail) {
		if (tail == null) {
			throw new RuntimeException("tail is null");
		} else {
			char[] bases = new char[this.getLength()+tail.getLength()];
			for (int i=0; i<this.getLength(); i++) {
				bases[i] = this.getBaseAt(i);
			}
			for (int i=0; i<tail.getLength(); i++) {
				bases[i+this.getLength()] = tail.getBaseAt(i);
			}
			DNAStrand strand = new CharArrayDNAStrand(bases);
			return strand;
		}
	}
	
	
	private boolean isBase(char[] base_array) {
		for (int i=0; i<base_array.length; i++) {
			if (base_array[i] != 'C' && base_array[i] != 'G' 
					&& base_array[i] != 'T' && base_array[i] != 'A') {
				return false;
			}
		}
		return true;
	}
	
	
}