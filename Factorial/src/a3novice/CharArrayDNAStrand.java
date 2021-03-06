package a3novice;

import java.util.Arrays;

public class CharArrayDNAStrand implements DNAStrand {

	private char[] bases;
	private String name;
	
	public CharArrayDNAStrand(char[] base_array, String name) {
		if (isBase(base_array)) {
			this.bases = base_array;
			if (name != null) {
				this.name = name;
			} else {
				this.name = "unnamed";
			}
		} else {
			throw new RuntimeException("DNA Strand contains illegal base");
		}
			
	}
	
	public CharArrayDNAStrand(char[] base_array) {
		this(base_array, "unnamed");
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
			return this.bases[idx];
		} else {
			throw new RuntimeException("Index not valid");
		}
		
	}

	@Override
	public int getLength() {
		return this.bases.length;
	}

	@Override
	public DNAStrand extract(int start, int end) {
		if (start >= 0 && start <= end 
				&& end < this.getLength()) {
			char[] bases = Arrays.copyOfRange(this.bases, start, end+1);
			DNAStrand strand = new CharArrayDNAStrand(bases);
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