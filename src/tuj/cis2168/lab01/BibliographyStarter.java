package tuj.cis2168.lab01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BibliographyStarter {
  public static void main() {
    testPartB();
    testPartC();
  }

  public static void testPartB() {
    ArrayList<Reference> references = getReferenceList();
    Collections.sort(references);
    printBibliography(references);
  }

  public static void testPartC() {
    ArrayList<Reference> references = getReferenceList();

    // Style A
    references.sort(new AuthorYearTitle());
    printBibliography(references);

    // Style B
    references.sort(new YearAuthorTitle());
    printBibliography(references);
  }

  public static ArrayList<Reference> getReferenceList() {
    ArrayList<Reference> references = new ArrayList<Reference>();;
    
    references.add(new Reference(1989, "Wadler", "Theorems for Free!"));
    references.add(new Reference(2001, "Leijen", "Parsec:  Direct Style Monadic Parser Combinators for the Real World"));
    references.add(new Reference(1991, "Meijer", "Functional Programming with Bananas, Lenses, Envelopes, and Barbed Wire"));
    references.add(new Reference(1989, "Peyton Jones", "The Spineless Tagless G-Machine"));
    references.add(new Reference(2014, "Leijen", "Koka: Programming with Row Polymorphic Effect Types"));
    references.add(new Reference(1989, "Wadler", "How to Make Ad-Hoc Polymorphism Less Ad Hoc"));
    references.add(new Reference(1993, "Peyton Jones", "A Short Cut to Deforestation"));
    references.add(new Reference(2003, "Odersky", "A Nominal Theory of Objects with Dependent Types"));
    references.add(new Reference(2007, "Peyton Jones", "Practical type inference for arbitrary-rank types"));
    references.add(new Reference(2001, "Wadler", "Featherweight Java:  A Minimal Core Calculus for Java and GJ"));
    
    return references;
  }

  public static void printBibliography(ArrayList<Reference> references) {
    System.out.println("BIBLIOGRAPHY");
    for(var reference : references) {
      System.out.println(reference);
    }
    System.out.println();
  }
}

class Reference implements Comparable<Reference> {
  public final Integer year;
  public final String authorLastName;
  public final String title;

  Reference(Integer year, String authorLastName, String title) {
    this.year = year;
    this.authorLastName = authorLastName;
    this.title = title;
  }

  @Override
  public String toString() {
    throw new UnsupportedOperationException("Implement Me!");
  }

  @Override
  public int compareTo(Reference other) {
    throw new UnsupportedOperationException("Implement Me!");
  }
}

/// Sorts by author first, then year, and finally title.
class AuthorYearTitle implements Comparator<Reference> {
  @Override
  public int compare(Reference left, Reference right) {
    throw new UnsupportedOperationException("Implement Me!");
  }
}

/// Sorts by year first, then author, and finally title.
class YearAuthorTitle implements Comparator<Reference> {
  @Override
  public int compare(Reference left, Reference right) {
    throw new UnsupportedOperationException("Implement Me!");
  }
}