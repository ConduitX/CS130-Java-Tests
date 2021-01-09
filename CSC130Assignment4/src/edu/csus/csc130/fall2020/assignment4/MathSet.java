package edu.csus.csc130.fall2020.assignment4;

import java.util.*;
import java.util.Arrays;

// Hint: use a symbol table provided in JDK and a boolean array. 

public class MathSet<Key> {
	
	public Set<Key> base;
	public Set<Key> uni;
	public Key[] verse;

	
	// create a set
	public MathSet(Key[] universe) {
		
		base = new HashSet<Key>();  // base set
		uni = new HashSet<Key>(Arrays.asList(universe));  //universe set
		verse = universe;  //universe key array

		
	}

	// put key into the set
	public void add(Key key) {
		
		base.add(key);
		
	}

	// return set of keys in the universe that are not in the set
	public MathSet<Key> complement() {

		Iterator<Key> it = uni.iterator();
		
		//remove base set from universe
		while (it.hasNext()) {
			if (base.contains(it.next())) {
				it.remove();
			}
		}
		
		base = uni;   //set the new universe equal to base
		
		uni = new HashSet<Key>(Arrays.asList(verse));  //reset universe
		
		return this;
	}

	// put keys from the given set into this set that are not already there
	public void union(MathSet<Key> set) {

		
		//if the element in the given set isn't in the base set, add it
		for (Key s: set.base) {
			if(!base.contains(s)) {
				base.add(s);
			}
		}
	}

	// remove any keys from this set that are not in the given set
	public void intersection(MathSet<Key> set) {
		
		Iterator<Key> it = base.iterator(); //iterator for this set
		
		//if the element in this set isn't in the given set, remove it
		while (it.hasNext()) {
			if (!set.base.contains(it.next())) {
				it.remove();
			}
		}
	}

	// remove key from the set
	public void delete(Key key) {
		
		base.remove(key);
		
	}

	// is the key in this set?
	public boolean contains(Key key) {

		if (base.contains(key)) {
			return true;
		}
		else {
			return false;
		}
		
	}

	// is the set empty?
	public boolean isEmpty() {

		if (base.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}

	// number of keys in the set
	public int size() {

		return base.size();
		
	}
	
}
