package io.devfactory.example.refactoring._13_loop._33_replace_loop_with_pipeline.before;

import java.util.ArrayList;
import java.util.List;

public class Author {

  private final String company;

  private final String twitterHandle;

  public Author(String company, String twitterHandle) {
    this.company = company;
    this.twitterHandle = twitterHandle;
  }

  public static List<String> twitterHandles(List<Author> authors, String company) {
    var result = new ArrayList<String>();
    for (Author a : authors) {
      if (a.company.equals(company)) {
        var handle = a.twitterHandle;
        if (handle != null)
          result.add(handle);
      }
    }
    return result;
  }

}
